package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document("issue")
public class Issue {
    @Id
    private String id;
    private String description;
    private int severity;
    private String assignee;

    public Issue(String description, int severity, String assignee) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.severity = severity;
        this.assignee = assignee;
    }
}
