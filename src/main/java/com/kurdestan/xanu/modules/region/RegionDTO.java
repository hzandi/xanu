package com.kurdestan.xanu.modules.region;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.city.City;
import com.kurdestan.xanu.modules.property.Property;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class RegionDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private List<Point<G2D>> polygon;

    @ApiModelProperty(required = true, hidden = false)
    private City city;

    @ApiModelProperty(required = false, hidden = true)
    private List<Property> properties;

}
