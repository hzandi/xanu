package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.modules.client_property.ClientProperty;
import com.kurdestan.xanu.common.BaseEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_clients")
@Data
public class Client extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientProperty> savedProperty;

}