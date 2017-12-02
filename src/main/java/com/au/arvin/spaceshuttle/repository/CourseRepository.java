package com.au.arvin.spaceshuttle.repository;

import com.au.arvin.spaceshuttle.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Collection<Course> findByName(@Param("name") String name);
}
