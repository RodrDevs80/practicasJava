package com.sertec.JSB.entityR.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "prod_sequence",
            sequenceName = "prod_sequence",
            allocationSize = 1,
            initialValue = 564
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prod_sequence")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "price")
    Double price;
}
