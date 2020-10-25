package ie.fernandarocha;

public class Withdrawal extends Transaction{
	
	private double amount;
	
	private Screen screen;
	private Keypad keypad;
	private CashDispenser cashDispenser;
	private BankDatabase bankDatabase;
	
	public Withdrawal() {}
	
	@Override
	public void execute() {}

}
