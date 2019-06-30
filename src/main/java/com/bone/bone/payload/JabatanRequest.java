package com.bone.bone.payload;

import javax.validation.constraints.NotBlank;

public class JabatanRequest {
    @NotBlank
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
