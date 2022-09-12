package com.kurdestan.xanu.modules.image;

import com.kurdestan.xanu.modules.property.Property;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ImageDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private Integer orderIndex;

    @ApiModelProperty(required = true, hidden = false)
    private Boolean isPreview;

    @ApiModelProperty(required = true, hidden = false)
    private Property property;

}
