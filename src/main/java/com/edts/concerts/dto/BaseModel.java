package com.edts.concerts.dto;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "IS_DELETED", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

}
