public sealed class Account permits SavingsAccount {
	
	private final String nameOwner;
	private final String emailOwner;
	private final String numberId;
	private double balance;
	
	private static int currentId = 1;
	
	//construtor
	
	public Account(String nameOwner, String emailOwner) {
		this.nameOwner = nameOwner;
		this.emailOwner = emailOwner;
		this.numberId = "000" + currentId++;
	}
	
	//Método para depósito
	
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Não há crédito para depositar");
		} 
		balance += amount;
	}
	
	//Método para saque
	
	public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
        } else {
        throw new IllegalArgumentException("Saque inválido ou sem saldo suficiente");
        }
	}
	
	//Método para transferência
	
	public void transfer(Account destinationAccount, double amount) {
		if (destinationAccount == null) {
			throw new IllegalArgumentException("É necessário informar uma conta");
		} if (amount < 0 ) {
			throw new IllegalArgumentException("É necessário ter saldo positivo");
		} 
		withdraw(amount);
		destinationAccount.deposit(amount);
	}
	
	//Exibição formatada ao usuário
	
	@Override
	public String toString() {
		DecimalFormat dc = new DecimalFormat("#.00");
		return "Nome do titular: " + nameOwner + 
				", E-mail do títular: " + emailOwner + ", Id do títular:  " + numberId + ", Saldo na conta: " + dc.format(balance);
	}
