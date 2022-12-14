package com.cbcode.projectmentoria.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.ConstraintMode;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1, initialValue = 1)
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;


    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_stock_id", nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "car_stock_fk"))
    private Car carStoke;

    public Car getCarStoke() {
        return carStoke;
    }

    public void setCarStoke(Car carStoke) {
        this.carStoke = carStoke;
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_sold_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "car_sold_id_fk"))
    private Car carSold;

    public Car getCarSold() {
        return carSold;
    }

    public void setCarSold(Car carSold) {
        this.carSold = carSold;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_access",
        uniqueConstraints = @UniqueConstraint(columnNames = {"users_id", "access_id"},
            name = "unique_access_user"),

            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", table = "users",
            unique = false, foreignKey = @ForeignKey(name = "users_fk", value = ConstraintMode.CONSTRAINT)),

    inverseJoinColumns = @JoinColumn(name = "access_id",
            unique = false, referencedColumnName = "id", table = "access",
            foreignKey = @ForeignKey(name = "access_fk", value = ConstraintMode.CONSTRAINT)))
    private List<Access> access;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Access> getAccess() {
        return access;
    }

    public void setAccess(List<Access> access) {
        this.access = access;
    }

    // Authorities is the access, that's means role ADMIN, MANAGER
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.access;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
