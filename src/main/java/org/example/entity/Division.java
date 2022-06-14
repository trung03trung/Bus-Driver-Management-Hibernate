package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
@Data
@NoArgsConstructor

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "driver_id",nullable = false)
    private Driver driver;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<DivisionDetail> divisionDetails;

    public Division(List<DivisionDetail> divisionDetails,Driver driver) {
        this.divisionDetails = divisionDetails;
        this.driver=driver;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", divisionDetails=" + divisionDetails +
                '}';
    }
}
