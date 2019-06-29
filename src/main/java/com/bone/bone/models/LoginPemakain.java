package com.bone.bone.models;

import com.bone.bone.models.audit.DateAudit;

import javax.persistence.Id;

public class LoginPemakain extends DateAudit {

    @Id
    private Long loginpemakai_id;
    private Long pegawai_id;
    private Long pasien_id;
    private String nama_pemakai;
    private String katakunci_pemakai;
    private Boolean statuslogin;
    private String photouser;
    private Long ruangan_aktifitas;
    private String link_aktifitas;
    private String additional_data;
}
