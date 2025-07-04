import java.util.*;
public class InsertEle{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> arr=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            arr.add(val);
        }
        System.out.println(arr);
        int pos=sc.nextInt();
        int ele=sc.nextInt();
        if (pos >= 0 && pos<=arr.size()){
            arr.add(pos,ele);
             System.out.println("New array after insertion: " +arr);
        } else {
            System.out.println("Invalid position, Must be between 0 and " + arr.size());
        }
    }
}
    
        
