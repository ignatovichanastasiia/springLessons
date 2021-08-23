package ru.geek.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @NonNull
    @Column (name = "title")
    private String title;
    @NonNull
    @Column (name = "cost")
    private int cost;

    public Product() {
    }

    public Product(@NonNull String title, @NonNull int cost) {
        this.title = title;
        this.cost = cost;
    }
}