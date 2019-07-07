package com.bone.models.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {
                "created_by",
                "created_date",
                "last_modified_by",
                "modified_count",
                "last_modified_date",
                "is_deleted",
                "deleted_by",
                "deleted_date"
        },
        allowGetters = false
)

public abstract class DocoAudit<I>  {

    @CreatedBy
    private I created_by;

    @CreatedDate
    private Instant created_date;

    @LastModifiedBy
    private I  last_modified_by;

    private Integer modified_count;

    @LastModifiedDate
    private Instant last_modified_date;

    @Column
    private Boolean is_deleted;

    private I deleted_by;

    private String deleted_date;

    public I getCreated_by() {
        return created_by;
    }

    public void setCreated_by(I created_by) {
        this.created_by = created_by;
    }

    public Instant getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Instant created_date) {
        this.created_date = created_date;
    }

    public I getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(I last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

    public Integer getModified_count() {
        return modified_count;
    }


    public Instant getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Instant last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public I getDeleted_by() {
        return deleted_by;
    }

    public void setDeleted_by(I deleted_by) {
        this.deleted_by = deleted_by;
    }

    public String getDeleted_date() {
        return deleted_date;
    }

    public void setDeleted_date(String deleted_date) {
        this.deleted_date = deleted_date;
    }

    @PrePersist
    public void prePersist() {
        modified_count = 0;
        last_modified_by = null;
        last_modified_date = null;
        is_deleted = false;
    }

    @PreUpdate
    public void preUpdate() {
        modified_count++;
    }

}
