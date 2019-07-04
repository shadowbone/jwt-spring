package com.bone.models;

import com.bone.models.audit.DocoAudit;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "m_jabatan")
@Where(clause = "is_deleted=false")
public class Jabatan extends DocoAudit<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;

    @NotBlank
    private String nama;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Jabatan()
    {
        super();
    }

    public Jabatan(String nama) {
        this.nama = nama;
    }
}
