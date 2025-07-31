import java.io.*;
import java.util.Scanner;

public class FileUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose operation:\n1-Write\n2-Read\n3-Modify\n4-Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    String writeFile = sc.nextLine();
                    System.out.println("Enter text to write (type 'EOF' on a new line to finish):");
                    StringBuilder contentBuilder = new StringBuilder();
                    String line;
                    while (!(line = sc.nextLine()).equals("EOF")) {
                        contentBuilder.append(line).append("\n");
                    }
                    writeToFile(writeFile, contentBuilder.toString());
                    break;

                case 2:
                    System.out.print("Enter file name: ");
                    String readFile = sc.nextLine();
                    readFromFile(readFile);
                    break;

                case 3:
                    System.out.print("Enter file name: ");
                    String modifyFile = sc.nextLine();
                    System.out.print("Enter new content to append: ");
                    String newContent = sc.nextLine();
                    modifyFile(modifyFile, newContent);
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void modifyFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + content);
            writer.close();
            System.out.println("File modified (appended) successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
