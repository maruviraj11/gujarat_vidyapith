import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p15 {
    public static void main(String[] args) {
        String fileName = "virajmaru.txt";
        String line;

        try {
           
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            System.out.println("Roll No\tName\tMarks1\tMarks2\tMarks3\tPercentage");
           

            while ((line = br.readLine()) != null) {
                
                String[] data = line.split("\\t");

                if (data.length == 5) { 
                    int roll = Integer.parseInt(data[0]);
                    String name = data[1];
                    int m1 = Integer.parseInt(data[2]);
                    int m2 = Integer.parseInt(data[3]);
                    int m3 = Integer.parseInt(data[4]);

                 
                    double percentage = (m1 + m2 + m3) / 3.0;

                
                    System.out.printf("%d\t%s\t%d\t%d\t%d\t%.2f%%\n",
                            roll, name, m1, m2, m3, percentage);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(" Invalid data format in file.");
        }
    }
}
