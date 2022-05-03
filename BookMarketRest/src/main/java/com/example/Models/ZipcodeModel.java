package com.example.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name="zipcode")
public class ZipcodeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private CityModel cityModel;

    public ZipcodeModel(String name, CityModel cityModel) {
        this.name = name;
        this.cityModel = cityModel;
    }
}
