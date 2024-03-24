package com.turkcell.rentacar.entities.concretes;

import com.turkcell.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cars")
public class Car extends BaseEntity {

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "plate")
    private String plate;

    @Column(name = "state")
    private int state;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    List<Maintenance> maintenances;


}
