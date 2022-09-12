package com.kurdestan.xanu.modules.house;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.agency.Agency;
import com.kurdestan.xanu.modules.client_house.ClientHouse;
import com.kurdestan.xanu.modules.image.Image;
import com.kurdestan.xanu.modules.region.Region;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.math.BigDecimal;
import java.util.List;


@Data
public class HouseDTO extends BaseDTO {

    @ApiModelHouse(required = true, hidden = false)
    private String title;

    @ApiModelHouse(required = true, hidden = false)
    private Integer area;

    @ApiModelHouse(required = true, hidden = false)
    private Integer roomNumber;

    @ApiModelHouse(required = true, hidden = false)
    private Integer floor;

    @ApiModelHouse(required = true, hidden = false)
    private Integer parking;

    @ApiModelHouse(required = true, hidden = false)
    private Boolean hasBalcony;

    @ApiModelHouse(required = true, hidden = false)
    private Boolean hasWarehouse;

    @ApiModelHouse(required = true, hidden = false)
    private String address;

    @ApiModelHouse(required = true, hidden = false)
    private BigDecimal salePrice;

    @ApiModelHouse(required = true, hidden = false)
    private BigDecimal mortgagePrice;

    @ApiModelHouse(required = true, hidden = false)
    private BigDecimal rentPrice;

    @ApiModelHouse(required = true, hidden = false)
    private HouseType type;

    @ApiModelHouse(required = true, hidden = false)
    private Point<G2D> location;

    @ApiModelHouse(required = true, hidden = false)
    private Agency agency;

    @ApiModelHouse(required = true, hidden = false)
    private Region region;

    @ApiModelHouse(required = true, hidden = false)
    private List<Image> images;

    @ApiModelHouse(required = false, hidden = true)
    private List<ClientHouse> savedHouse;

}
