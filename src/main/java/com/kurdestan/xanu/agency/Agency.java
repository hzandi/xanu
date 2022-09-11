package com.kurdestan.xanu.agency;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.image.Image;
import com.kurdestan.xanu.property.Property;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tbl_agencies")
@Data
public class Agency extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "slogan")
    private String slogan;

    @Column(name = "address")
    private String address;

    @Column(name = "location")
    private Point<G2D> location;

    @Column(name = "image")
    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Property> properties;

}
