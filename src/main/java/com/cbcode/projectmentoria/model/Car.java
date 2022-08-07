package com.cbcode.projectmentoria.model;

import javax.persistence.ConstraintMode;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String model;

    private String color;

    private String regNumber;

    private int keysNumber;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user",
    nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
    name = "user_fk"))
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public int getKeysNumber() {
        return keysNumber;
    }

    public void setKeysNumber(int keysNumber) {
        this.keysNumber = keysNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
