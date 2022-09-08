package com.kurdestan.xanu.image;

import com.kurdestan.xanu.agency.Agency;
import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.property.Property;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_images")
@Data
public class Image extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @OneToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

}


