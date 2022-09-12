package com.kurdestan.xanu.modules.client_property;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.client.Client;
import com.kurdestan.xanu.modules.property.Property;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "tbl_client_property")
@Entity
public class ClientProperty extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
