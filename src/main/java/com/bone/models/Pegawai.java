package com.bone.models;

import com.bone.models.audit.DocoAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "m_pegawai")
//@Where(clause = "is_deleted=false")
public class Pegawai  extends DocoAudit<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank
    private String nama;

    @NotBlank
    private String no_ktp;

    private String alamat;

    public Pegawai() {
        super();
    }

    public Pegawai(String nama, String no_ktp, String alamat) {
        this.nama = nama;
        this.no_ktp = no_ktp;
        this.alamat = alamat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
