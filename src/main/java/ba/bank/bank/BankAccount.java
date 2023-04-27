package ba.bank.bank;

import java.io.Serializable;
import java.util.List;

public class BankAccount extends AbstractBankAccount implements Serializable {

    private String accountNumber;
    private Double amount;
    private String owner;

    public BankAccount() {
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return accountNumber + " : " + owner + " : " + amount;
    }
}
