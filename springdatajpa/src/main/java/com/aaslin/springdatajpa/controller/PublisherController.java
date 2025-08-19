package com.aaslin.springdatajpa.controller;

import com.aaslin.springdatajpa.entity.Publisher;
import com.aaslin.springdatajpa.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired private PublisherService publisherService;

    @PostMapping
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable Long id,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String location) {
        return publisherService.updatePublisher(id, name, location);
    }

    @DeleteMapping("/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "Publisher deleted: " + id;
    }
}

