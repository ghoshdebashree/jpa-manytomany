package com.AssociationMapping.jpamanytomany.ENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COURSE_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Student> students;

}
