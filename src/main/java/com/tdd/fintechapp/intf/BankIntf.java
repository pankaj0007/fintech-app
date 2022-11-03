package com.tdd.fintechapp.intf;

import com.tdd.fintechapp.model.Consumer;
import com.tdd.fintechapp.model.Organisation;

public interface BankIntf {

    public Long openCommercialAccount(Organisation organisation, int pin, double startingDeposit);
    public Long openComsumerAccount(Consumer consumer, int pin, double startingDeposit);
    public boolean authenticate(Long accountNumber, int pin);
    public double getBalance(Long accountNumber);
    public void credit(Long acccountNumber, double amount);
    public void debit(Long accountNumber, double amount);

}
