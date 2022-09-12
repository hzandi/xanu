package com.kurdestan.xanu.modules.property;

import com.kurdestan.xanu.modules.agency.Agency;
import com.kurdestan.xanu.modules.client_property.ClientProperty;
import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.image.Image;
import com.kurdestan.xanu.modules.region.Region;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbl_properties")
@Data
public class Property extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "area")
    private Integer area;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "parking")
    private Integer parking;

    @Column(name = "has_balcony")
    private Boolean hasBalcony;

    @Column(name = "has_warehouse")
    private Boolean hasWarehouse;

    @Column(name = "address")
    private String address;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "mortgage_price")
    private BigDecimal mortgagePrice;

    @Column(name = "rent_price")
    private BigDecimal rentPrice;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PropertyType type;

    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
    private List<ClientProperty> savedProperty;

}