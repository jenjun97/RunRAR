package com;

import java.io.File;

public class CheckInput {

	// 檢查檔案是否存在
	static boolean existFile(String filePath) {
		boolean exist = false;
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			return true;
		}
		return exist;
	}

	// 檢查密碼
	static boolean checkPass(String passRange) {
		if (passRange != null && passRange.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 檢查密碼長度
	static boolean checkPassSize(String passSize) {

		int size = 0;
		try {
			size = Integer.valueOf(passSize);
		} catch (NumberFormatException e) {
			return false;
		}

		if (size < 1) {
			return false;
		}

		return true;

	}
}
