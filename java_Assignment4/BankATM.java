import java.util.Scanner;
public class BankATM {
   double bal;
    public void deposit(int amt){
        if(amt>0){
        bal+=amt;
        System.out.println("Deposited Amount: "+amt);
        }
        else{
            System.out.println("Enter valid deposit Amount");
        }
    }

     public void withdraw(int wAmt) throws InsufficientBalanceException {
        if (wAmt <= 0) {
            System.out.println("Invalid withdrawal amount,Enter valid amount");
        }

        else if( wAmt > bal) {
            throw new InsufficientBalanceException("Insufficient balance. Current balance: " + bal);
        }

        bal -= wAmt;
        System.out.println("Withdrawn:Rs. " + wAmt);
    }

    public double getBalance() {
        return bal;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        BankATM atm = new BankATM();
         while (true) {
            System.out.println("\n    ATM Actions   ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount:Rs. ");
                    int depositAmount = sc.nextInt();
                    atm.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount:Rs. ");
                    int withdrawAmount = sc.nextInt();
                    try {
                        atm.withdraw(withdrawAmount);
                    } catch (InsufficientBalanceException e) {
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
        }
    }
}

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException (String msg){
        super(msg);
    }
}