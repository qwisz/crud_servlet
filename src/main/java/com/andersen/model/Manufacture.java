package com.andersen.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "manufactures")
public class Manufacture implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacture")
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder strProd = new StringBuilder("[");

        for (Product product: products) {
            strProd.append(product.getName()).append(" ");
        }
        strProd.deleteCharAt(strProd.length() - 1);
        strProd.append("]");

        return name + " has products " + strProd.toString();
    }
}
