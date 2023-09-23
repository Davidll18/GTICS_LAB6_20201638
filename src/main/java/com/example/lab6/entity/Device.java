package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceid")
    private int id;

    @Column(nullable = false)
    private String devicename;

    @Column(nullable = false)
    private String devicetype;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String serialnumber;

    @Column(nullable = false)
    private int siteid;
}
