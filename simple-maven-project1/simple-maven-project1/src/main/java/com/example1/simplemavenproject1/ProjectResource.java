package com.example1.simplemavenproject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_maven_project.App;

@RestController
public class ProjectResource {

    @Autowired
    private App app;

    @GetMapping("/resources/{n}")
    public Integer getAll(@PathVariable Integer n) {
    	return app.getFactorial(n);
    }
    
}
