package com.labinvent.serversensorsmonitor.model.entity;

import com.labinvent.serversensorsmonitor.model.enums.Type;
import com.labinvent.serversensorsmonitor.model.enums.Unit;
import com.labinvent.serversensorsmonitor.web.constant.WebConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "monitors")
@AllArgsConstructor
@NoArgsConstructor
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30, message = WebConstant.ENUMERATING_CHARACTERS_MESSAGE)
    private String name;

    @NotBlank(message = WebConstant.BLANK_FIELD_MESSAGE)
    @Size(max = 15, message = WebConstant.ENUMERATING_CHARACTERS_MESSAGE)
    private String model;

    @Column(name = "range_from")
    private int rangeFrom;

    @Column(name = "range_to")
    private int rangeTo;

    @Column(name = "monitor_type")
    private Type type;

    private Unit unit;

    @Size(max = 40, message = WebConstant.ENUMERATING_CHARACTERS_MESSAGE)
    private String location;

    @Size(max = 200, message = WebConstant.ENUMERATING_CHARACTERS_MESSAGE)
    private String description;

}
