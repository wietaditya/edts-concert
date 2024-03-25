package com.edts.concerts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visitors")
public class Visitors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;


    @Column(name = "title")
    private String title;


    @Column(name = "name")
    private String name;


    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "id_card_number")
    private String idCardNumber;

}
