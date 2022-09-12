package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.modules.client_property.ClientProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String name;

    @ApiModelProperty(required = true, hidden = false)
    private String username;

    @ApiModelProperty(required = true, hidden = false)
    private String email;

    @ApiModelProperty(required = false, hidden = true)
    private String password;

    @ApiModelProperty(required = true, hidden = false)
    private String phone;

    @ApiModelProperty(required = false, hidden = false)
    private List<ClientProperty> savedProperty;
}