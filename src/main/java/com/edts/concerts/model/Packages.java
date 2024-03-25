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
@Table(name = "master_packages")
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "price")
    private Double price;

    @Column(name = "quota")
    private Long quota;

    @Column(name = "facility")
    private String facility;

    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @Column(name = "additional_info", columnDefinition = "TEXT")
    private String additional_info;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

}
