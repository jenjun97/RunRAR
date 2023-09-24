package com;

import java.io.IOException;

public class CrackRAR4 {
	static boolean keep = true;

	public static void main(String[] args)  {
		
		System.out.print("Enter the file path: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String filePath = scanner.nextLine();

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        if (verifyRarPassword(filePath, password)) {
            System.out.println("Correct password!");
        } else {
            System.out.println("Incorrect password!");
        }
	}
	
	public static boolean verifyRarPassword(String filePath, String password) {
        String unrarPath = "C:\\Users\\jun\\Desktop\\LearnJava\\eclipse-workspace\\RunRAR\\lib\\UnRAR.exe"; // Change this to the path where your UnRAR.exe is located
        String[] command = {unrarPath, "t", "-p" + password, filePath};

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            process.waitFor();

            return process.exitValue() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
