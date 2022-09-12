package com.kurdestan.xanu.modules.client_house;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.client.Client;
import com.kurdestan.xanu.modules.house.House;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "tbl_client_House")
@Entity
public class ClientHouse extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "House_id")
    private House house;

}
