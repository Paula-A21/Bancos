package dominio;

public class Cuenta {
	
	protected double balance;

	public Cuenta(double balance) {
		super();
		this.balance = balance;
	}
	
	public boolean deposita(double cantidad){
		balance += cantidad;
		return true;
	}
	
	public void retira(double cantidad) throws ExcepcionSobregiro {
		
		if (balance < cantidad) {
			
			throw new ExcepcionSobregiro(balance - cantidad,
					"Fondos insuficientes");
		}
		
		balance = balance - cantidad;
	}
	
	public void deposita(boolean cantidad){
	
	}
	
	public void retira(boolean cantidad){
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
