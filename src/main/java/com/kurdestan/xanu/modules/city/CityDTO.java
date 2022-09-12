package com.kurdestan.xanu.modules.city;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.region.Region;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;

import java.util.List;


@Data
public class CityDTO extends BaseDTO {

    @ApiModelHouse(required = true, hidden = false)
    private String name;

    @ApiModelHouse(required = true, hidden = false)
    private List<Region> regions;

}
