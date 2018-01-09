package com.andersen.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "price", unique = true, nullable = false)
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "manufacture_id", nullable = false)
    private Manufacture manufacture;

    @Override
    public String toString() {
        return name + ", price - " + price + ", manufacture - " + manufacture.getName();
    }
}
