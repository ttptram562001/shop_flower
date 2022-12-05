package com.example.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Footwear")
public class Footwear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String design;

    private String image;

    private int price;

    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_type")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Type type;

    public Footwear(String name, String design, String image, int price, String description) {
        this.name = name;
        this.design = design;
        this.image = image;
        this.price = price;
        this.description = description;
    }
}
