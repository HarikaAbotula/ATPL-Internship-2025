// Create a Display class that overloads show() to print integers, strings, and arrays.
public class DisplayOverload{
    public void show(int a,int b){
       System.out.println(a+","+b);
    }
    public void show(String a,String b){
       System.out.println(a+","+b);
    }
    public void show(int[]arr){
        System.out.print("Displaying Integer Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        DisplayOverload obj = new DisplayOverload();
        obj.show(2,3);
        obj.show("HI","HELLO");
        int[] arr = {10, 20, 30};
        obj.show(arr);
    }
}