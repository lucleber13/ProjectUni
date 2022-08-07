package com.cbcode.projectmentoria.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1, initialValue = 1)
public abstract class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    private Long id;
    @NotBlank(message = "Model must be entered!")
    @NotNull(message = "Model must be entered!")
    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Size(max = 10, message = "The registration number should not be greater than 10 characters.")
    @NotBlank(message = "Register number must be entered!")
    @NotNull(message = "Register number must be entered!")
    @Column(nullable = false)
    private String regNumber;
    @NotBlank(message = "Register number must be entered!")
    @NotNull(message = "Register number must be entered!")
    @Column(nullable = false)
    private int keysNumber;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users",
    nullable = false,
    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
    name = "user_fk"))
    private User users;

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

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
