package com.cbcode.projectmentoria.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_car", sequenceName = "seq_car", allocationSize = 1, initialValue = 1)
public abstract class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_car")
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
    @OneToMany(mappedBy = "carStock", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sales> salesStock = new ArrayList<Sales>();

    public List<Sales> getSalesStock() {
        return salesStock;
    }

    public void setSalesStock(List<Sales> salesStock) {
        this.salesStock = salesStock;
    }

    @OneToMany(mappedBy = "carSold", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sales> salesSold = new ArrayList<Sales>();

    public List<Sales> getSalesSold() {
        return salesSold;
    }

    public void setSalesSold(List<Sales> salesSold) {
        this.salesSold = salesSold;
    }


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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
