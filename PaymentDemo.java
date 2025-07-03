//Create a Payment class with method processPayment(). Override it in CreditCardPayment, UPIPayment, etc., to show different outputs.
class Payment {
    void processPayment() {
        System.out.println("Payment processing");
    }
}
class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Processing credit card payment");
    }
}
class UPIPayment extends Payment {
    void processPayment() {
        System.out.println("Processing UPI payment");
    }
}
public class PaymentDemo {
    public static void main(String[] args) {
        Payment p1 = new Payment();
        Payment p2 = new CreditCardPayment();
        Payment p3 = new UPIPayment();

        p1.processPayment(); 
        p2.processPayment();  
        p3.processPayment(); 
    }
}