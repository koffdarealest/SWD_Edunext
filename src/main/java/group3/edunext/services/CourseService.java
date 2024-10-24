/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3.edunext.services;

import group3.edunext.models.*;
import group3.edunext.repositories.ICourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
 public class CourseService {
    @Autowired
    ICourseRepository courseRepo;
    
    public  List<Course> getAllCourses(){
        
        return courseRepo.getAllCourses();
    }
    
    public static void main(String[] args) {
        CourseService sv = new CourseService();
        System.out.println(sv.getAllCourses().size());
    }
}


