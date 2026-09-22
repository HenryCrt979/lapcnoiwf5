package com.truthcheck.repository;

import com.truthcheck.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    
    List<News> findByCategory(String category);
    
    List<News> findByIsVerifiedTrue();
    
    @Query("SELECT n FROM News n WHERE n.title LIKE %?1% OR n.content LIKE %?1%")
    List<News> searchByKeyword(String keyword);
    
    List<News> findAllByOrderByPublishedAtDesc();
}
