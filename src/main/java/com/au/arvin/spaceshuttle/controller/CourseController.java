package com.au.arvin.spaceshuttle.controller;

import com.au.arvin.spaceshuttle.model.Course;
import com.au.arvin.spaceshuttle.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public Set<Course> list() {

        /*
        String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS).getHeaderValue();
        response.addHeader("Cache-Control", headerValue);
        */

        //return CourseMockData.getAllCourses();

        return new HashSet<Course>(courseRepository.findAll());
    }

    @RequestMapping(value = "courses", method = RequestMethod.POST)
    public Course create(@RequestBody Course course) {
        //return CourseMockData.createCourse(course);
        return courseRepository.save(course);
    }

    @RequestMapping(value = "courses/{id}", method = RequestMethod.GET)
    public Course get(@PathVariable Long id) {
        //return CourseMockData.getCourse(id);

        return courseRepository.findOne(id);
    }

    @RequestMapping(value = "courses/{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        //return CourseMockData.updateCourse(id, course);
        course.setId(id);
        return courseRepository.save(course);
    }

    @RequestMapping(value = "courses/{id}", method = RequestMethod.DELETE)
    public Course delete(@PathVariable Long id) {
        // return CourseMockData.deleteCourse(id);
        Course course = courseRepository.findOne(id);
        courseRepository.delete(course);
        return course;
    }

    @GetMapping(value = "courses", params = "name")
    public Collection<Course> get(@RequestParam String name) {
        return Collections.EMPTY_LIST;
//        return courseRepository.iwanttoFindByName1(name);
    }
}
