package com.homeservices.homeservices.model;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nemanja on 9/30/2017.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String city;
    private BigDecimal pricePerHour;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_authority",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();
}
