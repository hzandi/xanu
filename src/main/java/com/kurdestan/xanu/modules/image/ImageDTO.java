package com.kurdestan.xanu.modules.image;

import com.kurdestan.xanu.modules.house.House;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;


@Data
public class ImageDTO {

    @ApiModelHouse(required = true, hidden = false)
    private String name;

    @ApiModelHouse(required = true, hidden = false)
    private Integer orderIndex;

    @ApiModelHouse(required = true, hidden = false)
    private Boolean isPreview;

    @ApiModelHouse(required = true, hidden = false)
    private House house;

}
