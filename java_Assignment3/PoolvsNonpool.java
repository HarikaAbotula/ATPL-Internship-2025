//Use == and equals() to compare s1, s2, s3 and explain what happens. 

public class PoolvsNonpool {
    public static void main(String[] args) {
        String s1="Java"; //literal store in stringpool
        String s2="Java"; //s2 also referenced to s1 in stringpool
        String s3 = new String("Java"); //object stored in heap
        System.out.println(s1==s2); //true,s1 and s2 referenced to same address
        System.out.println(s2==s3); //false,s2  and s3 referenced to diff addrss
        System.out.println(s3==s1); //false,s1  and s3 referenced to diff addrss
        System.out.println(s1.equals(s2)); // content of s1 and s2 is same,true
        System.out.println(s2.equals(s3)); //content of s2 and s3 is same,true
        System.out.println(s3.equals(s1)); //content of s1 and s3 is same,true
    }
}
