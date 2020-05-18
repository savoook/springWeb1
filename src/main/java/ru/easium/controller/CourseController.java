package ru.easium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.easium.domain.Course;
import ru.easium.domain.Teacher;
import ru.easium.service.CourseService;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService service;

    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public String allCourses(Model model) {
        List<Course> courses = service.findAllCourses();
        model.addAttribute("courses", courses);
        return "/jsp/courses";
    }

    @RequestMapping(path = "/courses/{courseName}")
    public String getCourseTeachers(@PathVariable String courseName, Model model) {
        List<Teacher> teachers = service.getTeacherByCourseName(courseName);
        model.addAttribute("teachers", teachers);
        return "/jsp/teachers";
    }
}
