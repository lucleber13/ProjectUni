package com.cbcode.projectmentoria.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "car_sold")
@PrimaryKeyJoinColumn(name = "id")
public class CarSold extends Car {

    private static final long serialVersionUID = 1L;

    private boolean bodyProtection;

    private boolean polishMachine;

    private boolean interiorWashing;

    private String addComments;

    public boolean isBodyProtection() {
        return bodyProtection;
    }

    public void setBodyProtection(boolean bodyProtection) {
        this.bodyProtection = bodyProtection;
    }

    public boolean isPolishMachine() {
        return polishMachine;
    }

    public void setPolishMachine(boolean polishMachine) {
        this.polishMachine = polishMachine;
    }

    public boolean isInteriorWashing() {
        return interiorWashing;
    }

    public void setInteriorWashing(boolean interiorWashing) {
        this.interiorWashing = interiorWashing;
    }

    public String getAddComments() {
        return addComments;
    }

    public void setAddComments(String addComments) {
        this.addComments = addComments;
    }
}
