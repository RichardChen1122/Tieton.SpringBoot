package com.siemens.kpiscriptengine.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class EntityBase {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "createdAt", insertable = true, updatable = false)
    private Date createdAt;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "updatedAt", insertable = false, updatable = true)
    private Date updatedAt;
    @Column(name = "updatedBy")
    private String updatedBy;

    public EntityBase() {
        this.setCreatedAt(Calendar.getInstance().getTime());
        this.setUpdatedAt(this.getCreatedAt());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}