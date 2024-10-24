/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.edunext.controllers;

import group3.edunext.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author admin
 */

    @Controller
    @RequestMapping("/course")
public class CourseController {
    
    
    @Autowired
    CourseService courseService;
    
    @GetMapping("/mycourse")
    public String Index(Model model){
        model.addAttribute("courseList",courseService.getAllCourses());
        
        return "MyCourse";
    }
}
