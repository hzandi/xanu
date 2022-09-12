package com.kurdestan.xanu.modules.property;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.agency.Agency;
import com.kurdestan.xanu.modules.client_property.ClientProperty;
import com.kurdestan.xanu.modules.image.Image;
import com.kurdestan.xanu.modules.region.Region;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.math.BigDecimal;
import java.util.List;


@Data
public class PropertyDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)
    private Integer area;

    @ApiModelProperty(required = true, hidden = false)
    private Integer roomNumber;

    @ApiModelProperty(required = true, hidden = false)
    private Integer floor;

    @ApiModelProperty(required = true, hidden = false)
    private Integer parking;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean hasBalcony;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean hasWarehouse;

    @ApiModelProperty(required = true, hidden = false)
    private String address;

    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal salePrice;

    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal mortgagePrice;

    @ApiModelProperty(required = true, hidden = false)
    private BigDecimal rentPrice;

    @ApiModelProperty(required = true, hidden = false)
    private PropertyType type;

    @ApiModelProperty(required = true, hidden = false)
    private Point<G2D> location;

    @ApiModelProperty(required = true, hidden = false)
    private Agency agency;

    @ApiModelProperty(required = true, hidden = false)
    private Region region;

    @ApiModelProperty(required = true, hidden = false)
    private List<Image> images;

    @ApiModelProperty(required = false, hidden = true)
    private List<ClientProperty> savedProperty;

}
