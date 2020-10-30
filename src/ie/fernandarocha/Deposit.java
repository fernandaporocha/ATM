package ie.fernandarocha;

public class Deposit extends Transaction{
	
	private double amount;
	private Keypad keypad;
	private DepositSlot depositSlot;
	private final static int CANCELED = 0;
	
	public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
		
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	}
	
	@Override
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		
		amount = promptForDepositoAmount();
		
		if (amount != CANCELED) {
			screen.displayMessage("\nPlease insert a deposit envelop containing ");
			screen.displayEuroAmount(amount);
			screen.displayMessageLine(".");
			
			boolean envelopeReceived = depositSlot.isEnvelopeReceived();
			
			if(envelopeReceived) {
				screen.displayMessageLine("\nYour envelope has been received." +
						"\nNOTE: The money just depoisted will not be available until "
						+ "we verify the amount of any enclosed cash and your checks clear.");
				bankDatabase.credit(getAccountNumber(), amount);
			}else {
				screen.displayMessageLine("\nYou did not insert and envelope," +
						"so the ATM has canceled your transaction.");
			}
		}else {
			screen.displayMessageLine("\nCanceling transaction");
		}
	}

	private double promptForDepositoAmount() {
		Screen screen = getScreen();
		screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");
		int input = keypad.getInput();
		
		if(input == CANCELED)
			return CANCELED;
		else
			return (double) input/100;
	}

}
