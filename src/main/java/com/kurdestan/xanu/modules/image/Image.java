package com.kurdestan.xanu.modules.image;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.house.House;
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

    @NotNull
    @Column(name = "order_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderIndex;

    @NotNull
    @Column(name = "is_preview")
    private Boolean isPreview;

    @ManyToOne
    @JoinColumn(name = "House_id")
    private House house;

}


