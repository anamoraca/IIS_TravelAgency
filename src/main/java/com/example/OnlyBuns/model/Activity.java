    package com.example.OnlyBuns.model;
    
    
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    
    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import java.time.LocalDateTime;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Activities")
    public class Activity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name = "name", nullable = false)
        @NotBlank(message = "Name is required")
        private String name;
    
        @Column(name = "description", nullable = false)
        private String description;
    
        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private Status status;
    
        @Column(name = "minCapacity", nullable = false)
        private int minCapacity;
        
        @Column(name = "maxCapacity", nullable = false)
        private int maxCapacity;
    
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @Column(name = "isPetFriendly", nullable = false)
        private boolean isPetFriendly;

        @Column(name = "isFamilyFriendly", nullable = false)
        private boolean isFamilyFriendly;

        @Enumerated(EnumType.STRING)
        @Column(name = "targetAgeGroup", nullable = false)
        private ActivityAgeGroup targetAgeGroup;

        @Column(name = "isOutdoor", nullable = false)
        private boolean isOutdoor;

        @Column(name = "isAdventure", nullable = false)
        private boolean isAdventure;

        @Enumerated(EnumType.STRING)
        @Column(name = "season", nullable = false)
        private Season season;

        @Column(name = "difficulty")
        private Integer difficulty;  // nullable int

        @Column(name = "price", nullable = false)
        private double price;

        @Column(name = "lengthInMin", nullable = false)
        private double lengthInMin;

        @Column(name = "publishedTime", nullable = false)
        private LocalDateTime publishedTime;

        @Column(name = "archiveTime")
        private LocalDateTime archiveTime;  // nullable datetime

        @Column(name = "isPremiumOption", nullable = false)
        private boolean isPremiumOption;

        @Column(name = "value", nullable = false)
        private float value;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "arrangement_id", nullable = false)
        private Arrangement arrangement;
    }
