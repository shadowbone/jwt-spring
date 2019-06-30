package com.bone.bone.controllers;

import com.bone.bone.common.DocoHelpers;
import com.bone.bone.exception.ResourceNotFoundException;
import com.bone.bone.models.Pegawai;
import com.bone.bone.payload.PegawaiRequest;
import com.bone.bone.repository.PegawaiRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pegawai")
public class PegawaiController {

    @Autowired
    private PegawaiRepository repoPegawai;

    @GetMapping(value = "/list")
    public JsonNode get() {
        Iterable<Pegawai> data = repoPegawai.findAll();
        Map body = new HashMap<>();
        body.put("data",data);
        return DocoHelpers.response(body,200);
    }

    @PostMapping(value = "/save")
    public JsonNode post (@Valid @RequestBody PegawaiRequest request) {
        Pegawai pegawai = new Pegawai(
                request.getNama(),
                request.getNo_ktp(),
                request.getAlamat()
        );
        repoPegawai.save(pegawai);
        Map body = new HashMap<>();
        body.put("message","Data Pegawai berhasil disimpan.");
        return DocoHelpers.response(body,200);
    }

    @PutMapping(value = "/save")
    public JsonNode put(@RequestParam(name = "id") Long Id, @Valid @RequestBody PegawaiRequest request) {
        Pegawai getData = repoPegawai.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Id Tidak Valid", "id", Id));
        getData.setNama(request.getNama());
        getData.setNo_ktp(request.getNo_ktp());
        getData.setAlamat(request.getAlamat());
        Pegawai updatePegawai = repoPegawai.save(getData);
        Map body = new HashMap<>();
        body.put("data_update",updatePegawai);
        return DocoHelpers.response(body,200);
    }

    @DeleteMapping(value = "/delete")
    public JsonNode delete(@RequestParam(name = "id") Long Id) {
        repoPegawai.softDelete(Id);
        Map body = new HashMap<>();
        body.put("message","Data Pegawai berhasil dihapus.");
        return DocoHelpers.response(body,200);
    }
}
