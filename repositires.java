package com.truthcheck.repository;

import com.truthcheck.model.Myth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MythRepository extends JpaRepository<Myth, Long> {
    
    List<Myth> findByCategory(String category);
    
    List<Myth> findByIsFeaturedTrue();
    
    @Query("SELECT m FROM Myth m WHERE m.mythTitle LIKE %?1% OR m.mythContent LIKE %?1%")
    List<Myth> searchByKeyword(String keyword);
    
    List<Myth> findAllByOrderByCreatedAtDesc();
}
