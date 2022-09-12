package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.modules.client_house.ClientHouse;
import io.swagger.annotations.ApiModelHouse;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {

    @ApiModelHouse(required = true, hidden = false)
    private String name;

    @ApiModelHouse(required = true, hidden = false)
    private String username;

    @ApiModelHouse(required = true, hidden = false)
    private String email;

    @ApiModelHouse(required = false, hidden = true)
    private String password;

    @ApiModelHouse(required = true, hidden = false)
    private String phone;

    @ApiModelHouse(required = false, hidden = false)
    private List<ClientHouse> savedHouse;
}
