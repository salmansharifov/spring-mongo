package com.example.demo.controller;

import com.example.demo.domain.Issue;
import com.example.demo.service.IssueService;
import org.bson.Document;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService service;

    public IssueController(IssueService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Iterable<Issue> getAllIssues() {
        return service.listIssues();
    }

    @GetMapping("/{id}")
    public Optional<Issue> getIssue(@PathVariable String id) {
        return service.getIssue(id);
    }

    @PostMapping
    public Issue save(@RequestBody Issue issue) {
        return service.save(issue);
    }

    @PostMapping("/hand")
    public void addByHand(@RequestBody Document document) {
        System.out.println(document);
        System.out.println("tst " + document);
        System.out.println("tst " + document);
        service.addByHand(document);
    }
}
