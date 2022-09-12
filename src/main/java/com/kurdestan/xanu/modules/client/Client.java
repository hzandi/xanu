package com.kurdestan.xanu.modules.client;

import com.kurdestan.xanu.common.BaseEntity;
import com.kurdestan.xanu.modules.client_property.ClientProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_clients")
@Data
public class Client extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientProperty> savedProperty;

}