import java.io.*;

public class TableFormatting {
    public static void main(String[] args) {
       
        String[] names = {"John sonnnnn", "Nancy wheeler", "Steve", "Dong Lee Smith tuhuh"};
        int[] ages = {21, 22, 20, 23};
        String[] departments = {"CSE", "ECE", "IT", "ME"};
        double[] gpas = {8.45, 9.12, 7.80, 9.00};

        // Step 1: Find the longest name length (including "Name" headercol)
        int maxNameLength = "Name".length();
        for (String name : names) {
            if (name.length() > maxNameLength) {
                maxNameLength = name.length();
            }
        }

        // Step 2: Create format string using maxNameLength, Add 2 spaces padding for better spacing
        String format = "%-" + (maxNameLength + 2) + "s %-5s %-12s %-5s%n";

        try {
            PrintWriter writer = new PrintWriter("studentstable.txt");

            writer.printf(format, "Name", "Age", "Department", "GPA");

            for (int i = 0; i < names.length; i++) {
                writer.printf("%-" + (maxNameLength + 2) + "s %-5d %-12s %-5.2f%n",
                        names[i], ages[i], departments[i], gpas[i]);
            }

            writer.close();
            System.out.println(" Student details written to 'studentsTable.txt'.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
