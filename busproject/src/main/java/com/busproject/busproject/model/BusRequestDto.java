package com.busproject.busproject.model;

import com.busproject.busproject.Entity.BusStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusRequestDto {

    private int busId;

    private String name;

    private String type;

    private String number;

    private BusStatus busStatus;

}
