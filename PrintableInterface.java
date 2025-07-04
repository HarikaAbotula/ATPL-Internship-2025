//Create an interface Printable and implement it in classes Document, Image, and Invoice.
interface Printable{
    void print();
    static int a=10;
}
class Document implements Printable{
    public void print(){
        System.out.println("Printing Document");
    }
}
class Image implements Printable{
    public void print(){
        System.out.println("Printing Image");
    }
}
class Invoice implements Printable{
    public void print(){
        System.out.println("Printing Invoice");
    }
}
public class PrintableInterface{
    public static void main(String args[]){
        Document doc=new Document();
        Image img=new Image();
        Invoice inv=new Invoice();
        doc.print();
        img.print();
        inv.print();
        System.out.println(Document.a);
    }
}