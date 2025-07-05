//Compare a == b, b == c, a == c and explain how intern() works
//When intern() is invoked on a String object:
//If an identical string exists in the String Constant Pool, a reference to the existing string object is returned.
//If not, the current String object is added to the pool and a reference to it is returned.
public class Interning {
    public static void main(String[] args) {
        String a = new String("Hello"); //stored in heap 
        String b= a.intern(); // adding b to the string pool with unique addr,becoz it doesnot present in the pool already.
        String c= "Hello"; // referenced to b obj as "hello" alredy present in String pool
        System.out.println(a==b); //false,diff addresses(heap,string pool)
        System.out.println(b==c); //true,referenced to same obj in stingpool
        System.out.println(a==c);//false,diff addresses(heap,string pool)
    }
}
