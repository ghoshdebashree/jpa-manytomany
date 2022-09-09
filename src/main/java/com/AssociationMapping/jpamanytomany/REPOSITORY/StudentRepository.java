package com.AssociationMapping.jpamanytomany.REPOSITORY;

import com.AssociationMapping.jpamanytomany.ENTITY.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContaining(String name);
}
