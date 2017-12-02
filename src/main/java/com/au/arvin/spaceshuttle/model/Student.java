package com.au.arvin.spaceshuttle.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("student")
public class Student extends User {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "class_student", joinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))

    private Set<Class> classes;

    public Student() {
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
}
