package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "driver",catalog ="BusDriverManagement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
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


}
