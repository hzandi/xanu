package com.kurdestan.xanu.modules.client_property;

import com.kurdestan.xanu.modules.client.Client;
import com.kurdestan.xanu.modules.property.Property;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClientPropertyDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Client client;

    @ApiModelProperty(required = true, hidden = false)
    private Property property;
}
