package com.kurdestan.xanu.modules.client_house;

import com.kurdestan.xanu.modules.client.Client;
import com.kurdestan.xanu.modules.house.House;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;

@Data
public class ClientHouseDTO {

    @ApiModelHouse(required = true, hidden = false)
    private Client client;

    @ApiModelHouse(required = true, hidden = false)
    private House house;
}
