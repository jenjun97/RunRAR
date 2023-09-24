package com;

import java.io.IOException;

public interface CompressionInterface {
	boolean verifyPassword(String filePath, String pw)  throws IOException, InterruptedException;
}
