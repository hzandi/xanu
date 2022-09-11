package com.kurdestan.xanu.region;

import com.kurdestan.xanu.city.City;
import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.property.Property;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "tbl_regions")
@Data
public class Region extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "polygon")
    private Polygon polygon;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
    private List<Property> properties;
}
