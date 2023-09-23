package com;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CheckRAR54 {
	
	public static void main(String[] args) throws IOException {
		String rar5 = "D:/test5.rar";
		String rar4 = "D:/test4.rar";
		
		System.out.println(checkRarVersion(rar5));
		System.out.println(checkRarVersion(rar4));
	}

	public static String checkRarVersion(String filePath) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            byte[] signature = new byte[7];
            file.readFully(signature);

            // Check for RAR5 signature
            if (signature[0] == (byte) 'R' && signature[1] == (byte) 'a' && signature[2] == (byte) 'r' && 
                signature[3] == (byte) '!' && signature[4] == (byte) 0x1A && signature[5] == (byte) 0x07 && 
                signature[6] == (byte) 0x01) {
                return "RAR5";
            }

            // Check for RAR4 signature
            if (signature[0] == (byte) 'R' && signature[1] == (byte) 'a' && signature[2] == (byte) 'r' && 
                signature[3] == (byte) '!' && signature[4] == (byte) 0x1A && signature[5] == (byte) 0x07 && 
                signature[6] == (byte) 0x00) {
                return "RAR4";
            }
        }

        return "Unknown";
    }
}
