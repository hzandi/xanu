package com.kurdestan.xanu.modules.agency;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.house.House;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;


@Data
public class AgencyDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private String address;

    @ApiModelProperty(required = true, hidden = false)
    private Point<G2D> location;

    @ApiModelProperty(required = true, hidden = false)
    private String image;

    @ApiModelProperty(required = true, hidden = false)
    private String slogan;

    @ApiModelProperty(required = false, hidden = true)
    private List<House> properties;

}
