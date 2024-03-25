package com.edts.concerts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "master_concert")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "schedule")
    private Date schedule;

    @Column(name = "location")
    private String location;

    @Column(name = "location_url")
    private String location_url;

    @Column(name = "info", columnDefinition = "text")
    private String info;

    @Column(name = "additional_info", columnDefinition = "text")
    private String additional_info;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "ticket_purchase_start")
    private LocalDateTime ticketPurchaseStart;

    @Column(name = "ticket_purchase_end")
    private LocalDateTime ticketPurchaseEnd;

    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "concert_packages",
            joinColumns = @JoinColumn(
                    name = "concert_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "package_id", referencedColumnName = "id"))
    private Collection<Packages> packages;

}
