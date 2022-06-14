package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "driver",catalog ="BusDriverManagement")
@Data
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNum")
    private String phoneNum;

    @Column(name = "levels")
    private String level;

    public Driver(String name, String address, String phoneNum, String level) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.level = level;
    }

}
