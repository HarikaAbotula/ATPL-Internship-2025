import java.util.*;
public class FreqCount{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> inpArr=new ArrayList<>();
         ArrayList<Integer> freqArr=new ArrayList<>();
         int n=sc.nextInt();
         for(int i=0;i<n;i++){
            inpArr.add(sc.nextInt());
         }
         for(int i=0;i<inpArr.size();i++){
            int ele=inpArr.get(i);
            if(!freqArr.contains(ele)){
                int count=0;
                for(int j = 0; j < inpArr.size(); j++) {
                    if (inpArr.get(j).equals(ele)) {
                        count++;
                    }
                }
                freqArr.add(ele);
                System.out.println(ele + " occurs " + count + " times");
            }
         }
    }
}