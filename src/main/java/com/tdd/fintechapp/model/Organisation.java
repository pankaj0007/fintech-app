package com.tdd.fintechapp.model;

import com.tdd.fintechapp.intf.AccountHolderIntf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organisation  extends AccountHolderIntf {

    private String organisationName;
    private int taxId;

    public Organisation(int indNumber) {
        super(indNumber);
    }

    public Organisation(int indNumber, String organisationName) {
        super(indNumber);
        this.organisationName = organisationName;
    }


}
