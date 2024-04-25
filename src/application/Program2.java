package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);
        File[] files = path.listFiles(File::isFile);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath + "\\files.txt", true))) {
            bw.write("FILES: \n");
            bw.newLine();
            System.out.println("FILES: ");
            for (File file : files) {
                bw.write(file.getName());
                bw.newLine();
                System.out.println(file);
            }
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
