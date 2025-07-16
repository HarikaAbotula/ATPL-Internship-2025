public class BankATM{
    private double balance;

    public BankATM(double balance){
        this.balance=balance;
    }

    public void deposit(double amount) {
        if(amount>0){
         this.balance+=amount;
         System.out.println("Amout deposited:  "+ amount + " ,"+" new balance: "+this.balance);
        }
        else{
            System.out.println("Deposit amt must be positive");
        }
    }

    public void withdraw(double withdrawedAmount) throws InsufficientBalanceException{
       
        if (withdrawedAmount <= 0) {
            System.out.println("Invalid withdrawal amount,Enter valid amount");
        }
        else if( withdrawedAmount > this.balance) {
            throw new InsufficientBalanceException("Unable perform action due to insufficient balance. Current balance: " + this.balance);
        }
        else{
        this.balance -= withdrawedAmount;
        System.out.println("Withdrawn:Rs. " + withdrawedAmount + " ;Amount after withdrawn: "+this.balance);
        }
    }

    public double checkBalance(){
        return this.balance;
    }

    public static void main(String args[]){
        BankATM accountA=new BankATM(120.00);
        accountA.deposit(50.00);

        BankATM accountB = new BankATM(10.00);
       
        try{
        accountB.withdraw(-9.00);
        }
        catch(InsufficientBalanceException e){
            System.out.println("Exception occured: "+e.getMessage());
        }

        System.out.println("Final amt of bank accountA:"+ accountA.checkBalance());
        System.out.println("Final amt of bank accountB:"+ accountB.checkBalance());
    }
}
class InsufficientBalanceException extends Exception{
    super(message);
}