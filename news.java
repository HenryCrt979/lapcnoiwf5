package com.truthcheck.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @Column(columnDefinition = "TEXT")
    private String excerpt;
    
    @Column(nullable = false)
    private String category; // Politics, Elections, Policy, etc.
    
    @Column(nullable = false)
    private String author;
    
    @Column(columnDefinition = "TEXT")
    private String sourceUrl;
    
    @Column(nullable = false)
    private Boolean isVerified = false;
    
    @Column(columnDefinition = "TEXT")
    private String relatedMythIds; // Comma-separated myth IDs
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime publishedAt = LocalDateTime.now();
    
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    
    @Column(nullable = false)
    private Integer viewCount = 0;
}
