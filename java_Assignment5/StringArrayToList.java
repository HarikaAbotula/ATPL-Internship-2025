import java.util.*;
public class StringArrayToList {

	public static void main(String[] args) {
		String stringArr[]= {"apple","banana","mango"};
		System.out.println("String Array: "+Arrays.toString(stringArr));
		
		List<String> list= Arrays.asList(stringArr); 
		System.out.println("String Array converted to List: "+list);
		
		//list.add("hi"); we cannot add elements into the list(Arrays.asList())
		list.set(1, "hello"); //but we can modify
		System.out.println("List after performaing actions: "+list);
		System.out.println("String Array: "+Arrays.toString(stringArr));
		
		//List.of() available in java 9 , it cannot be modified becoz it is immutable,fixed size 
		// List<String> arrayList = List.of(stringArr);
		// System.out.println(arrayList);
		// arrayList.add("kiwi");
		// arrayList.set(1, "grapes");
		// System.out.println(arrayList);
	}

}
