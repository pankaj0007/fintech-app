package com.tdd.fintechapp.model;

import com.tdd.fintechapp.intf.AccountHolderIntf;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "consumer")
public class Consumer extends AccountHolderIntf {
    private String firstName;
    private String lastName;
    private int taxId;

    public Consumer(int idNumber) {
        super(idNumber);
    }

    public Consumer(int idNumber, String firstName, String lastName, int taxId) {
        super(idNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxId = taxId;
    }
}
