package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.property.Property;
import com.kurdestan.xanu.modules.region.Region;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl_agencies")
@Data
public class Agency extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "location")
    private Point<G2D> location;

    @Column(name = "image")
    private String image;

    @Column(name = "slogan")
    private String slogan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Property> properties;

}
