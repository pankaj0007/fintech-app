package com.tdd.fintechapp.intf;

public abstract class AccountHolderIntf {

    private int idNumber;

    public AccountHolderIntf(int idNumber){
        this.idNumber= idNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }
}
