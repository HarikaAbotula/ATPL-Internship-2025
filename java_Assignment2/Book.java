public class Book{
    String title;
    String author;
    double price;
    public Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public double calculateDiscount(double discountPercent){
        if(discountPercent < 0 || discountPercent > 100){
            System.out.println("Discount percentage must be in between 0 to 100");
        }
        double discountAmt=(this.price*discountPercent)/100.0;
       return this.price-discountAmt;
    }
    public static void main(String args[]){
        Book b1=new Book("Harry potter","Jk Rowling",1500.00);
        double finalPrice=b1.calculateDiscount(10);
        System.out.println("Final price OF BOOK1 after applying discount: "+finalPrice);

        Book b2=new Book("Java Programming","XYZ",3450.00);
        double finalPrice2=b1.calculateDiscount(25);
        System.out.println("Final price OF BOOK2 after applying discount: "+finalPrice2);
    }

}
