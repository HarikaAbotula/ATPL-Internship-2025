package com.aaslin.springdatajpa.service;

import com.aaslin.springdatajpa.entity.Publisher;
import com.aaslin.springdatajpa.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class PublisherService {

    @Autowired private PublisherRepository publisherRepository;

    public Publisher createPublisher(Publisher p) { return publisherRepository.save(p); }

    public List<Publisher> getAllPublishers() { return publisherRepository.findAll(); }

    public Publisher updatePublisher(Long id, String name, String location) {
        Optional<Publisher> opt = publisherRepository.findById(id);
        if (opt.isPresent()) {
            Publisher p = opt.get();
            if (name != null) p.setName(name);
            if (location != null) p.setLocation(location);
            return publisherRepository.save(p);
        } else {
            throw new RuntimeException("Publisher not found: " + id);
        }
    }

    public void deletePublisher(Long id) { publisherRepository.deleteById(id); }
}

