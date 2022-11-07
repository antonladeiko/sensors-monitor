package com.labinvent.serversensorsmonitor.model.entity;

import com.labinvent.serversensorsmonitor.model.enums.Role;
import com.labinvent.serversensorsmonitor.model.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Status status;

}
