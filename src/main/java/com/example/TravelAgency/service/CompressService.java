package com.example.TravelAgency.service;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
@Service
public class CompressService {
    @Autowired
    private PostService postService;

    private final Path root = Paths.get("src/main/resources/static/pictures");

    // Compress images older than one month daily
    @Scheduled(cron = "0 17 14 * * *")
    public void compressOldImages() {
        File[] files = root.toFile().listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().endsWith("_compressed.jpg")) {
                    try {
                        BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                        LocalDateTime fileCreationDate = LocalDateTime.ofInstant(
                                attributes.creationTime().toInstant(), ZoneId.systemDefault()
                        );

                        if (fileCreationDate.isBefore(LocalDateTime.now().minusHours(1))) {
                            compressImage(file);
                        }
                        postService.updateCompressedUrls();
                    } catch (IOException e) {
                        System.err.println("Failed to access file attributes for: " + file.getName());
                    }
                }
            }
        }

    }

    private void compressImage(File file) throws IOException {
        // Define the output file path with "_compressed" suffix
        String compressedFilePath = file.getParent() + File.separator +
                file.getName().replace(".jpg", "_compressed.jpg");

        File compressedFile = new File(compressedFilePath);

        // Compress the image to 80% quality
        Thumbnails.of(file)
                .scale(1)
                .outputQuality(0.8)
                .toFile(compressedFile);

        System.out.println("Compressed image: " + compressedFile.getName());
    }
}

