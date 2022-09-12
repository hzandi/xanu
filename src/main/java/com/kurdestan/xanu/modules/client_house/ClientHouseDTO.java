package com.kurdestan.xanu.modules.client_house;

import com.kurdestan.xanu.common.BaseDTO;
import com.kurdestan.xanu.modules.client.Client;
import com.kurdestan.xanu.modules.house.House;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientHouseDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Client client;

    @ApiModelProperty(required = true, hidden = false)
    private House house;
}
