package ru.geekbrains.thirdLesson.domein;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private long id;
    private String title;
    private int cost;

}



