import java.util.Scanner;
public class BankATM {
    private double balance;
    
    BankATM(double balance){
    this.balance=balance;
    }
    
    public void deposit(int amount){
        if(amount>0){
            this.balance+=amount;
        System.out.println("Deposited Amount: "+amount);
        }
        else{
            System.out.println("Enter valid deposit Amount");
        }
    }

     public void withdraw(int withdrawAmount) throws InsufficientBalanceException {
       
        if (withdrawAmount <= 0) {
            System.out.println("Invalid withdrawal amount,Enter valid amount");
        }

        else if( withdrawAmount > this.balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current balance: " + this.balance);
        }

        this.balance -= withdrawAmount;
        System.out.println("Withdrawn:Rs. " + withdrawAmount);
    }

    public double getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        BankATM atm = new BankATM(1000);
         while (true) {
            System.out.println("\n    ATM Actions   ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount:Rs. ");
                    int depositAmount = scanner.nextInt();
                    atm.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount:Rs. ");
                    int withdrawAmount = scanner.nextInt();
                    try {
                        atm.withdraw(withdrawAmount);
                    } 
                    catch (InsufficientBalanceException e) {
                        System.out.println("Exception: " +e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Current Balance:Rs. " + atm.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            scanner.close();
        }
    }
}

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException (String msg){
        super(msg);
    }
}