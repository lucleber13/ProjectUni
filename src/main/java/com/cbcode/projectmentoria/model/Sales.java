package com.cbcode.projectmentoria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sales")
@SequenceGenerator(name = "seq_sales", sequenceName = "seq_sales", allocationSize = 1, initialValue = 1)
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sales")
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDateOut;

    @Column(nullable = false)
    private String addComments;

    @JsonIgnore
    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_stock", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "car_stock_id_fk"))
    private Car carStock;

    @JsonIgnore
    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_sold", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "car_sold_id_fk"))
    private Car carSold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDueDateOut() {
        return dueDateOut;
    }

    public void setDueDateOut(Date dueDateOut) {
        this.dueDateOut = dueDateOut;
    }

    public String getAddComments() {
        return addComments;
    }

    public void setAddComments(String addComments) {
        this.addComments = addComments;
    }

    public Car getCarStock() {
        return carStock;
    }

    public void setCarStock(Car carStock) {
        this.carStock = carStock;
    }

    public Car getCarSold() {
        return carSold;
    }

    public void setCarSold(Car carSold) {
        this.carSold = carSold;
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
        Sales other = (Sales) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
