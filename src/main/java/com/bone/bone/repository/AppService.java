package com.bone.bone.repository;

import com.bone.bone.models.AppModel;
import org.springframework.stereotype.Repository;

@Repository
public interface AppService extends DocoRepository<AppModel, Integer> {

}
