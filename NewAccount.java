package Account;

import java.util.Objects;

public abstract class NewAccount {
    private final String nameOwner;
    private final String cpf;
    private double balance;

    public Account(String nameOwner, String cpf){
        this.nameOwner =  nameOwner;
        this.cpf = cpf;
    }

    public double getBalance() { return balance; }

    public String getCpf() {
        return cpf;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void withdraw(double amount){
        if (balance <= 0 || balance < amount){
            throw new IllegalArgumentException("No funds to retrieve");
        } else {
            balance -= amount;
        }
    }

    public void deposit(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("No funds to deposit");
        } else {
            balance += amount;
        }
    }

    public void transfer(Account transferAccount, double amount){
        if (transferAccount == null){
            throw new IllegalArgumentException("No Account to transference");
        } else if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else{
            withdraw(amount);
            transferAccount.deposit(amount);
        }
    }

    @Override
    public String toString(){
        return "Name: " + nameOwner + ", CPF: " + cpf + ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return cpf.equals(account.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
