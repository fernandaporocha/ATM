package ie.fernandarocha;

public class Account {
	private int accountNumber;
	private int pin;
	private double availableBalance;
	private double totalBalance;
	
	public Account() {
		
	}
	
	public boolean validatePIN() {
		return false;
	}
	
	public double getAvailableBalance() {
		return 0.0;
	}
	
	public double getTotaBalance() {
		return 0.0;
	}
	
	public void credit() {}
	
	public void debit() {}
}
