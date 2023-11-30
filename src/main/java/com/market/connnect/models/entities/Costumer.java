package com.market.connnect.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(name = "birth_day")
    private LocalDate birthday;
    @Column(name = "address")
    private String address;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite_products",
            joinColumns = @JoinColumn(
                    name = "costumer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id")
    )
    private Set<Product> favoriteProducts = new HashSet<>();

    @OneToMany
    private Set<Order> orders = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite_vendors",
            joinColumns = @JoinColumn(
                    name = "costumer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "vendor_id", referencedColumnName = "id")
    )
    private Set<Vendor> favoriteVendors = new HashSet<>();

    @OneToMany
    private Set<Review> reviews = new HashSet<>();
}
