package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route",catalog = "BusDriverManagement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "distance",nullable = false)
    private int distance;

    @Column(name="stoppoint")
    private int stopPoint;


}
