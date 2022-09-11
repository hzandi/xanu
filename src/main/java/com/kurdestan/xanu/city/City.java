package com.kurdestan.xanu.city;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.region.Region;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_cities")
@Data
public class City extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.ALL)
    private List<Region> regions;
}
