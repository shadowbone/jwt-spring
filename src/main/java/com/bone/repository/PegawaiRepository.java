package com.bone.repository;

import com.bone.core.SoftDelete;
import com.bone.models.Pegawai;
import org.springframework.stereotype.Repository;

@Repository
@SoftDelete
public interface PegawaiRepository extends  DocoRepository<Pegawai,Long> {

}
