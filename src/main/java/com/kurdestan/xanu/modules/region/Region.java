package com.kurdestan.xanu.modules.region;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.city.City;
import com.kurdestan.xanu.modules.property.Property;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_regions")
@Data
public class Region extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ElementCollection
    @Column(name = "polygon")
    private List<Point<G2D>> polygon;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
    private List<Property> properties;
}
