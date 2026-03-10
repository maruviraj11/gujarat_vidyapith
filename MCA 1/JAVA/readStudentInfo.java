import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readStudentInfo {

    public static void main(String[] args) {
        String fileName = "student11.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                // Split using tab
                String[] data = line.split("\t");

                if (data.length != 5) {
                    System.out.println("Invalid record: " + line);
                    continue;
                }

                int roll = Integer.parseInt(data[0]);
                String name = data[1];

                int m1 = Integer.parseInt(data[2]);
                int m2 = Integer.parseInt(data[3]);
                int m3 = Integer.parseInt(data[4]);

                double percentage = (m1 + m2 + m3) / 3.0;

                System.out.println("Roll: " + roll +
                                   ", Name: " + name +
                                   ", Percentage: " + percentage);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
        
    }
    
}
