package com;

import java.io.File;
import java.io.FileInputStream;

import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;

public class Zip {

	public static void main(String[] args) {
		System.out.print("Enter the ZIP file path: ");
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String filePath = scanner.nextLine();

		System.out.print("Enter the password: ");
		String password = scanner.nextLine();

		if (verifyZipPassword(filePath, password)) {
			System.out.println("Correct password!");
		} else {
			System.out.println("Incorrect password!");
		}
	}

	public static boolean verifyZipPassword(String filePath, String password) {
		try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File(filePath)),
				password.toCharArray())) {
			LocalFileHeader localFileHeader;
			byte[] buffer = new byte[4096];

			while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
				// Just read the content to see if the password is valid
				while (zipInputStream.read(buffer) != -1) {
				}
				break; // We only need to verify with the first entry
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
