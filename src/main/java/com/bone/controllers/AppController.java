package com.bone.controllers;

import com.bone.common.DocoController;
import com.bone.common.DocoHelpers;
import com.bone.models.AppModel;
import com.bone.repository.AppService;
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
    public  JsonNode post(@RequestBody Map<String, String> body) {
        AppModel app = new AppModel();
        app.setMessage(body.get("message"));
        service.save(app);
        Map rest = new HashMap();
        rest.put("messages","Data Berhasil dibuat");
        return DocoHelpers.response(rest,201);
    }
}