package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BatTest {
	private static final Logger log = LogManager.getLogger(BatTest.class);

	public static void main(String[] args) throws IOException {
		String path = "D:/test.txt";

		log.info(path);

		StringBuffer strBuf = new StringBuffer();
		strBuf.append(args[0]);
		strBuf.append("1234");
		strBuf.append("\n");
		strBuf.append("中文國繁");

		log.info(strBuf);

		BufferedWriter output = new BufferedWriter(new FileWriter(new File(path)));
		output.write(strBuf.toString());

		output.flush();
		output.close();
		log.info(output == null);
	}
}
