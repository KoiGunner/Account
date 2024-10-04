public class Account {
    private final String name;
    private final int number;
    private double balance;

    public Account(String name, int number, double balance){
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    /* Método para depósito do valor */

    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("O valor precisa ser positivo");
        } else {
            balance += amount;
        }
    }

    /* Método para saque do valor */

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
        } else {
        throw new IllegalArgumentException("Saque inválido ou sem saldo suficiente");
        }
    }

    /* Método para transferência de valor */

    public void transfer(double amount, Account transferAccount){
        if(transferAccount == null){
            throw new IllegalArgumentException("Não há como efetuar, a conta é nula");
        } if (amount <= 0 ){
            throw new IllegalArgumentException("O valor precisa ser positivo");
        }
        withdraw(amount);
        transferAccount.deposit(amount);
    }

    /* Método para impressão dos atributos */

    public String toString(){
        return String.format("{name: %s, number: %d, balance: 2.%f}", name, number, balance);
    }
