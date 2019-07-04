package com.bone.controllers;

import com.bone.models.AppModel;
import com.bone.repository.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlController {

    @Autowired
    private AppService service;

    @GetMapping(path = "/sql")
    public Iterable<AppModel> get() {
        return service.findAll();
    }

    @PostMapping("/sql")
    public String post() {
        return "ahay";
    }
}
