package com;

import java.io.IOException;

public class Rar4 implements CompressionInterface {
	// unrar.exe位置
	String unrarPath = null;

	// 建構子
	public Rar4(String unrarPath) {
		this.unrarPath = unrarPath;
	}

	@Override
	public boolean verifyPassword(String filePath, String password) {
		// this to
		String[] command = { this.unrarPath, "t", "-p" + password, filePath };

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
