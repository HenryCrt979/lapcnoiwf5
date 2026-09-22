package com.truthcheck.service;

import com.truthcheck.model.Resource;
import com.truthcheck.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    
    private final ResourceRepository resourceRepository;
    
    public ResourceService
