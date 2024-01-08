import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        
        String inputFilePath = "F:\\Swarnim\\Internship Projects\\Edu\\inventory\\src\\input.txt";
        String outputFilePath = "F:\\Swarnim\\Internship Projects\\Edu\\inventory\\src\\output.txt";

        try {            
            int sum = calculateSum(readFile(inputFilePath));            
            writeFile(outputFilePath, "Sum = " + sum);
            System.out.println("Number sum calculation successful.");

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static int calculateSum(String inputData) {
        String[] numbers = inputData.trim().split("\\s+"); 
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            return content.toString();
        }
    }

    private static void writeFile(String filePath, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        }
    }
}
