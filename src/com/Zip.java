package com;

import java.io.File;
import java.io.FileInputStream;

import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;

public class Zip implements CompressionInterface {
	@Override
	public boolean verifyPassword(String filePath, String password) {
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
