package com.bone.bone.models;

import com.bone.bone.models.audit.DocoAudit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table
@Getter
@Setter
public class AppModel extends DocoAudit<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String message;

}
