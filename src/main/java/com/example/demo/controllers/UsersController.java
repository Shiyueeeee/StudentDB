package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Student;
import com.example.demo.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsersController {  
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/students/view")
    public String getAllUsers(Model model){
        System.out.println("Getting all students");
        // get all users from database
        List<Student> students = userRepo.findAll();
        // end of database call
        model.addAttribute("us", students);
        return "students/showAll";
    }

    @PostMapping("/students/add")
    public String addUser(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        System.out.println("ADD student");
        String newName = newstudent.get("name");
        float newWeight = Float.parseFloat(newstudent.get("weight"));
        float newHeight = Float.parseFloat(newstudent.get("height"));
        String newHairColor = newstudent.get("hairColor");
        float newGpa = Float.parseFloat(newstudent.get("gpa"));
        String newGender = newstudent.get("gender");
        int newYearOfBirth = Integer.parseInt(newstudent.get("yearOfBirth"));
        userRepo.save(new Student(newName,newWeight, newHeight, newHairColor, newGpa, newGender, newYearOfBirth));
        response.setStatus(201);
        return "students/addedUser";
    }
    @PostMapping("/students/delete")
    public String deletStudent(@RequestParam Map<String, String> target, HttpServletResponse response){
        System.out.println("Delete student");
        String targetName = target.get("name");
        System.out.println(targetName);
        int tar = findByName(targetName);
        System.out.println(tar);
        if(tar!=-1){
            userRepo.deleteById(tar);
        }else{
            return "students/notFound";
        }
        response.setStatus(201);
        return "students/deleted";
    }
    @PostMapping("/students/modify")
    public String modifyStudent(@RequestParam Map<String, String> target, HttpServletResponse response){
        System.out.println("Modify student");
        String targetName = target.get("name");
        float newWeight = Float.parseFloat(target.get("weight"));
        float newHeight = Float.parseFloat(target.get("height"));
        String newHairColor = target.get("hairColor");
        float newGpa = Float.parseFloat(target.get("gpa"));
        String newGender = target.get("gender");
        int newYearOfBirth = Integer.parseInt(target.get("yearOfBirth"));
        System.out.println(targetName);
        int tar = findByName(targetName);
        System.out.println(tar);
        if(tar!=-1){
            Student temp = new Student(targetName,newWeight, newHeight, newHairColor, newGpa, newGender, newYearOfBirth);
            temp.setSid(tar);
            userRepo.deleteById(tar);
            userRepo.save(temp);
        }else{
            return "students/notFound";
        }
        response.setStatus(201);
        return "students/modified";
    }
    private int findByName(String name){
        List<Student> l = userRepo.findAll();
        for(Student s : l){
            System.out.println(s.getName());
            if(s.getName().equals(name)){
                return s.getSid();
            }
        }
        return -1;
    }
}
