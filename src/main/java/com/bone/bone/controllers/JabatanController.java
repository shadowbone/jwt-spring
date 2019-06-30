package com.bone.bone.controllers;

import com.bone.bone.common.DocoHelpers;
import com.bone.bone.exception.ResourceNotFoundException;
import com.bone.bone.models.Jabatan;
import com.bone.bone.payload.JabatanRequest;
import com.bone.bone.repository.JabatanRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/jabatan")
public class JabatanController {
    @Autowired
    private JabatanRepository repoJabatan;

    @GetMapping(value = "/list")
    public JsonNode get() {
        Iterable<Jabatan> data = repoJabatan.findAll();
        Map body = new HashMap<>();
        body.put("data",data);
        return DocoHelpers.response(body,200);
    }

    @PostMapping(value = "/save")
    public JsonNode post (@Valid @RequestBody JabatanRequest request) {
        Jabatan pegawai = new Jabatan(
                request.getNama()
        );
        repoJabatan.save(pegawai);
        Map body = new HashMap<>();
        body.put("message","Data Jabatan berhasil disimpan.");
        return DocoHelpers.response(body,200);
    }

    @PutMapping(value = "/save")
    public JsonNode put(@RequestParam(name = "id") Long Id, @Valid @RequestBody JabatanRequest request) {
        Jabatan getData = repoJabatan.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Id Tidak Valid", "id", Id));
        getData.setNama(request.getNama());
        Jabatan updateJabatan = repoJabatan.save(getData);
        Map body = new HashMap<>();
        body.put("data_update",updateJabatan);
        return DocoHelpers.response(body,200);
    }

    @DeleteMapping(value = "/delete")
    public JsonNode delete(@RequestParam(name = "id") Long Id) {
        repoJabatan.softDelete(Id);
        Map body = new HashMap<>();
        body.put("message","Data Jabatan berhasil dihapus.");
        return DocoHelpers.response(body,200);
    }
}
