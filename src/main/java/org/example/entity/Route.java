package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route",catalog = "BusDriverManagement")
@Data
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "distance",nullable = false)
    private int distance;

    @Column(name="stoppoint")
    private int stopPoint;

    public Route(int distance, int stopPoint) {
        this.distance = distance;
        this.stopPoint = stopPoint;
    }
}
