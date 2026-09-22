package com.truthcheck.service;

import com.truthcheck.model.News;
import com.truthcheck.repository.NewsRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    
    private final NewsRepository newsRepository;
    
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    
    public List<News> getAllNews() {
        return newsRepository.findAllByOrderByPublishedAtDesc();
    }
    
    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id).map(news -> {
            news.setViewCount(news.getViewCount() + 1);
            return newsRepository.save(news);
        });
    }
    
    public List<News> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }
    
    public List<News> getVerifiedNews() {
        return newsRepository.findByIsVerifiedTrue();
    }
    
    public List<News> searchNews(String keyword) {
        return newsRepository.searchByKeyword(keyword);
    }
    
    public News createNews(News news) {
        news.setPublishedAt(LocalDateTime.now());
        news.setUpdatedAt(LocalDateTime.now());
        return newsRepository.save(news);
    }
    
    public News updateNews(Long id, News newsDetails) {
        return newsRepository.findById(id).map(news -> {
            news.setTitle(newsDetails.getTitle());
            news.setContent(newsDetails.getContent());
            news.setExcerpt(newsDetails.getExcerpt());
            news.setCategory(newsDetails.getCategory());
            news.setAuthor(newsDetails.getAuthor());
            news.setSourceUrl(newsDetails.getSourceUrl());
            news.setIsVerified(newsDetails.getIsVerified());
            news.setRelatedMythIds(newsDetails.getRelatedMythIds());
            news.setUpdatedAt(LocalDateTime.now());
            return newsRepository.save(news);
        }).orElseThrow(() -> new RuntimeException("News not found"));
    }
    
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
