package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "divisiondetail")
@Data
@NoArgsConstructor

public class DivisionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false)
    private Division division;

    @OneToOne()
    @JoinColumn(name = "route_id",nullable = false)
    private Route route;

    @Column(name = "num_turn")
    private int numTurn;

    public DivisionDetail(Division division, Route route, int numTurn) {
        this.division = division;
        this.route = route;
        this.numTurn = numTurn;
    }

    @Override
    public String toString() {
        return "DivisionDetail{" +
                "id=" + id +
                ", division=" + division +
                ", route=" + route +
                ", numTurn=" + numTurn +
                '}';
    }
}
