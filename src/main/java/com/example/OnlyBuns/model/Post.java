package com.example.OnlyBuns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_path")
    private String image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  // Dodajem vezu za lokaciju. Stavila sam one to one jer 1 post moze da ima 1 lokaciju
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @CreationTimestamp  // Automatski setuje vrijeme kreiranja posta
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "likes", nullable = false)
    private int likes;

}
