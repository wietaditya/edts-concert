package com.edts.concerts.model;

import com.edts.concerts.dto.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "username")
    private String username;

    @Column(name = "package_id")
    private Long packageId;

    @Column(name = "concert_id")
    private Long concertId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "status_description")
    private String statusDescription;

    @Column(name = "payment_deadline")
    private Date paymentDeadline;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_visitors",
            joinColumns = @JoinColumn(
                    name = "order_id", referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "visitor_id", referencedColumnName = "id"))
    private Collection<Visitors> visitors;

}
