package com.tdd.fintechapp.intf;

import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public abstract class AccountHolderIntf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNumber;

    public AccountHolderIntf(int idNumber){
        this.idNumber= idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
