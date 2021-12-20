package ru.geekbrains.thirdLesson.domein;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "title")
    private String title;

    @Column (name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    public Product(String title, int cost, Long category) {
//        this.title = title;
//        this.cost = cost;
//    }
}


