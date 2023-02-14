package com.fullstack.backend.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Column(name = "nom", nullable = false, length = 32)
    private String nom;
    @Column(name = "description")
    private String description;
    @CreatedDate
    @Column(name = "creationData", nullable = false, updatable = false)
    private Date creationData;
    @LastModifiedDate
    @Column(name = "lastModifiedData")
    @JsonIgnore
    private Instant lastModifiedData;
    @Column(name = "urlPhoto")
    private String urlPhoto;

}

