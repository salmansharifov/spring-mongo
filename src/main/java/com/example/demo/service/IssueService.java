package com.example.demo.service;

import com.example.demo.config.AbstractMongoClient;
import com.example.demo.domain.Issue;
import com.example.demo.repository.IssueRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class IssueService extends AbstractMongoClient {

    private final String ISSUE_DATABASE = "issue";
    private final IssueRepository repository;
    private final MongoCollection<Document> issueCollection = database.getCollection(ISSUE_DATABASE);

    public IssueService(MongoClient client, @Value("${spring.data.mongodb.database}") String db, IssueRepository repository) {
        super(db, client);
        this.repository = repository;
    }

    public Iterable<Issue> listIssues() {
        return repository.findAll();
    }

    public Issue save(Issue issue) {
        return repository.save(issue);
    }

    public Optional<Issue> getIssue(String id) {
        return repository.findById(id);
    }

    public void addByHand(Document document) {
        issueCollection.insertOne(document);
    }
}
