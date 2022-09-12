package com.kurdestan.xanu.common;

import io.swagger.annotations.ApiModelHouse;
import lombok.Data;

import java.util.Date;


@Data
public class BaseDTO {

    @ApiModelHouse(required = false,hidden = true)
    private Long id;

    @ApiModelHouse(required = false,hidden = true)
    private Integer version;

    @ApiModelHouse(required = false,hidden = true)
    private Date createdDate;

    @ApiModelHouse(required = false,hidden = true)
    private String createdBy;

    @ApiModelHouse(required = false,hidden = true)
    private Date lastModifiedDate;

    @ApiModelHouse(required = false,hidden = true)
    private String lastModifiedBy;

}
