package edu.cs3220.midterm.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Answer> answers;

    // Getters, setters, constructors
}
