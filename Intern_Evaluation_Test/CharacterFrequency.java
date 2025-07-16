import java.util.*;
public class CharacterFrequency{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string=scanner.nextLine().toLowerCase();
		
		Map<Character,Integer> characterCount = new HashMap<>();
		
		for(char character : string.toCharArray()) {
			characterCount.put(character, characterCount.getOrDefault(character,0)+1);
		}

		System.out.println("Character count of the given string");
		for(Map.Entry<Character,Integer> entry : characterCount.entrySet()) {
			System.out.println(entry.getKey()+ " : "+ entry.getValue());
		}
		scanner.close();
	}
}
