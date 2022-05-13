package com.example.bookmarketrest.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
