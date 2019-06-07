package com.bone.bone.controllers;

import com.bone.bone.common.DocoController;
import com.bone.bone.common.DocoHelpers;
import com.bone.bone.models.AppModel;
import com.bone.bone.repository.AppService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController extends DocoController {

    @Autowired
    private AppService service;

    @GetMapping(path = "/")
    public JsonNode get() {
        Pageable limit = PageRequest.of(0,10);
        Page<AppModel> data = service.findAll(limit);
        Map body = new HashMap();
        body.put("data",data.getContent());
        return DocoHelpers.response(body,201);
    }

    @PostMapping(value = "/")
    public  String post(@RequestBody Map<String, String> body) {
        AppModel app = new AppModel();
        app.setMessage(body.get("message"));
        service.save(app);
        return  "sukses";
    }
}