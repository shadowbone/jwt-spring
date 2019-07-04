package com.bone.repository;

import com.bone.models.AppModel;
import org.springframework.stereotype.Repository;

@Repository
public interface AppService extends DocoRepository<AppModel, Integer> {

}
