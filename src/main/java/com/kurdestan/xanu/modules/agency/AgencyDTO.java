package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.house.House;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;


@Data
public class AgencyDTO extends BaseDTO {

    @ApiModelHouse(required = true, hidden = false)
    private String name;

    @ApiModelHouse(required = true, hidden = false)
    private String address;

    @ApiModelHouse(required = true, hidden = false)
    private Point<G2D> location;

    @ApiModelHouse(required = true, hidden = false)
    private String image;

    @ApiModelHouse(required = true, hidden = false)
    private String slogan;

    @ApiModelHouse(required = false, hidden = true)
    private List<House> properties;

}
