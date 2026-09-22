package com.truthcheck.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resources")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resource {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false)
    private String type; // PDF, Link, Video, Guide
    
    @Column(nullable = false)
    private String url;
    
    @Column(nullable = false)
    private String category; // Fact-checking, Media Literacy, Voting, etc.
    
    @Column(nullable = false)
    private Boolean isExternal = true;
    
    @Column(nullable = false)
    private Integer downloadCount = 0;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
