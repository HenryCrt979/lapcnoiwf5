package com.truthcheck.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "myths")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Myth {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mythTitle;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mythContent;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String reality;
    
    @Column(columnDefinition = "TEXT")
    private String explanation;
    
    @Column(nullable = false)
    private String category; // Political party, Policy, Fact-check, etc.
    
    @Column(nullable = false)
    private Integer confidenceScore; // 1-100 (how verified)
    
    @Column(columnDefinition = "TEXT")
    private String sources; // Comma-separated sources
    
    @Column(nullable = false)
    private Boolean isFeatured = false;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
