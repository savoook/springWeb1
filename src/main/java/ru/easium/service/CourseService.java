package ru.easium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easium.domain.Course;
import ru.easium.domain.Teacher;
import ru.easium.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public Course findById(int id) {
        return repository.findById(id).get();
    }

    public List<Course> findAllCourses() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public void saveCourse(Course course) {
        repository.save(course);
    }
    public List<Teacher> getTeacherByCourseName(String courseName){
        List<Course> courses=repository.findAllByName(courseName);
        return courses.stream().map(c -> c.getTeacher()).collect(Collectors.toList());
    }

}

