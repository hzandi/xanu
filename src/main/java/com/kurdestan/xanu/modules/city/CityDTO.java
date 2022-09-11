package com.kurdestan.xanu.modules.city;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.region.Region;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private List<Region> regions;

}
