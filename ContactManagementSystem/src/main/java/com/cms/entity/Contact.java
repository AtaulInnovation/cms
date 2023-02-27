package com.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "active",columnDefinition = "BOOLEAN")
    private Boolean active = true;

    @Column(name = "created", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated",updatable = true)
    private Date updated;

    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
