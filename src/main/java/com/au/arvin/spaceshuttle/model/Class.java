package com.au.arvin.spaceshuttle.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 30)
    private String name;
    @ManyToMany(mappedBy = "classes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Student> students;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
