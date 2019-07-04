package com.bone.payload;

import javax.validation.constraints.NotBlank;

public class PegawaiRequest {
    @NotBlank
    private String nama;

    @NotBlank
    private String no_ktp;

    private String alamat;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
