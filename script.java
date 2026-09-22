package com.truthcheck.service;

import com.truthcheck.model.Myth;
import com.truthcheck.repository.MythRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MythService {
    
    private final MythRepository mythRepository;
    
    public MythService(MythRepository mythRepository) {
        this.mythRepository = mythRepository;
    }
    
    public List<Myth> getAllMyths() {
        return mythRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public Optional<Myth> getMythById(Long id) {
        return mythRepository.findById(id);
    }
    
    public List<Myth> getMythsByCategory(String category) {
        return mythRepository.findByCategory(category);
    }
    
    public List<Myth> getFeaturedMyths() {
        return mythRepository.findByIsFeaturedTrue();
    }
    
    public List<Myth> searchMyths(String keyword) {
        return mythRepository.searchByKeyword(keyword);
    }
    
    public Myth createMyth(Myth myth) {
        myth.setCreatedAt(LocalDateTime.now());
        myth.setUpdatedAt(LocalDateTime.now());
        return mythRepository.save(myth);
    }
    
    public Myth updateMyth(Long id, Myth mythDetails) {
        return mythRepository.findById(id).map(myth -> {
            myth.setMythTitle(mythDetails.getMythTitle());
            myth.setMythContent(mythDetails.getMythContent());
            myth.setReality(mythDetails.getReality());
            myth.setExplanation(mythDetails.getExplanation());
            myth.setCategory(mythDetails.getCategory());
            myth.setConfidenceScore(mythDetails.getConfidenceScore());
            myth.setSources(mythDetails.getSources());
            myth.setIsFeatured(mythDetails.getIsFeatured());
            myth.setUpdatedAt(LocalDateTime.now());
            return mythRepository.save(myth);
        }).orElseThrow(() -> new RuntimeException("Myth not found"));
    }
    
    public void deleteMyth(Long id) {
        mythRepository.deleteById(id);
    }
}
