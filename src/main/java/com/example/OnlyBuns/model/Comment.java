package com.example.OnlyBuns.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @CreationTimestamp  // Automatski setuje vrijeme kreiranja komentara
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @ManyToOne(fetch = FetchType.EAGER) // Vise komentara moze pripadati 1 korisniku
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER) // Vise komentara moze pripadati 1 korisniku
    @JoinColumn(name = "post_id")
    private Post post;

}
