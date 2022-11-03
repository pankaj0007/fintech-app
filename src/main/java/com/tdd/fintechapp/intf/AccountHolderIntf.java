package com.tdd.fintechapp.intf;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AccountHolderIntf {

    @Id
    private int idNumber;

    public AccountHolderIntf(int idNumber){
        this.idNumber= idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
