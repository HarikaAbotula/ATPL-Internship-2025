//Design a BankAccount class with deposit, withdraw, and checkBalance methods. Track multiple account objects and simulate basic operations.

public class BankAccount{
    public double bal;
   public BankAccount(double bal){
    this.bal=bal;
   }
    public void deposit(double amt){
        if(amt>0){
         this.bal+=amt;
         System.out.println("Amout deposited:  "+ amt + " "+" new balance: "+this.bal);
        }
        else{
            System.out.println("Deposit amt must be positive");
        }
    }

    public void withdraw(double amt){
        if(this.bal<amt){
            System.out.println("Unable to withdraw,your currrent balance amt : "+this.bal);
        }
         else{
            this.bal-=amt;
            System.out.println("Withdrawed amt:  "+ amt+" "+"new balance: "+this.bal);
        }
    }

    public double checkBalance(){
        return this.bal;
    }

    public static void main(String args[]){
        BankAccount ba1=new BankAccount(100.00);
        ba1.deposit(50.00);

        BankAccount ba2 = new BankAccount(900.00);
        ba2.withdraw(160.00);
        System.out.println("Final amt of bank account2:"+ ba2.checkBalance());
    }
}