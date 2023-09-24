package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rar5 implements CompressionInterface {
	// unrar.exe位置
	String unrarPath = null;

	// 建構子
	public Rar5(String unrarPath) {
		this.unrarPath = unrarPath;
	}

	@Override
	public boolean verifyPassword(String filePath, String pw) throws IOException, InterruptedException {
		String command = this.unrarPath + " t -p" + pw + " " + filePath;

		Process process = new ProcessBuilder(command.split(" ")).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuffer strBuf = new StringBuffer();
		String line;
		while ((line = reader.readLine()) != null) {
			strBuf.append(line);
		}
		process.waitFor();

		if (strBuf.toString().indexOf("100%") >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
