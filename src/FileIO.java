import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {}

    /* Method for creating a file */
    static void createFile(String fileName){
        try {
            File file = new File(fileName+".txt");
            if (file.createNewFile())
                System.out.println("File created at: "+file.getAbsolutePath());
            else
                System.out.println("File already exists.");
        }catch (IOException e){
            System.out.println("Ann error occurred.");
            e.printStackTrace();
        }
    }

    /* Method for writing to a file */
    static void writeToFile(File file, String message){
        try {
            FileWriter fw = new FileWriter(file.getName());
            fw.write(message);
            fw.close();
            System.out.println("Success!");
        } catch(IOException e){
            System.out.println("An error occurred while writing to the file.");
        }
    }

    /* Method for reading from a file */
    static void readDataFromFile(File file){
        try {
            Scanner scanner = new Scanner(file.getName());
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /* Method for deleting a file */
    static void deleteFile(File file){
        if (file.delete()){
            System.out.println("Deletd "+file.getName());
        }else
            System.out.println("Failed to delete file.");
    }
}
