package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.github.junrar.exception.RarException;

public class CrackRAR {
	static boolean keep = true;

	public static void main(String[] args) throws RarException, IOException, InterruptedException {
		String rarFile = "D:/test.rar";
		String UnRar = "C:\\Program Files\\WinRAR\\UnRAR.exe";

//		String[] nums = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".split("");
		String[] nums = "abcdefghijklmnopqrstuvwxyz".split("");
		int leng = 3;

		// 預設要放幾位
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < leng; i++) {
			numList.add(-1);
		}

		// 預設跑到最後一個數(最大值時)
		List<Integer> maxList = new ArrayList<Integer>();
		for (int i = 0; i < leng; i++) {
			maxList.add(nums.length - 1);
		}

		// 執行
		while (keep) {
			numList = add(numList, maxList, nums.length);
			String pw = getPW(numList, nums);
			boolean correct = isPasswordCorrect(rarFile, pw, UnRar);

			if (correct) {
				System.out.println("成功解開壓縮檔，密碼為 [" + pw + "]");
				System.out.println("程式終止");
				keep = false;
			} else {
				System.out.println("測試密碼 [" + pw + "] 錯誤");
			}
		}

	}

	// 驗證密碼
	static boolean isPasswordCorrect(String rarFile, String password, String UnRar)
			throws RarException, IOException, InterruptedException {
		String command = UnRar + " t -p" + password + " " + rarFile;

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

	// 取得密碼
	static String getPW(List<Integer> numList, String[] nums) {
		// 預設密碼
		String pw = "";

		// 將陣列轉變成字串，由後面開始
		for (int i = numList.size() - 1; i > -1; i--) {
			int num = numList.get(i);
			if (num >= 0) {
				pw = pw + nums[num];
			}
		}
		return pw;
	}

	// 加1
	static List<Integer> add(List<Integer> numList, List<Integer> maxList, int max) {

		// 第一位+1
		numList.set(0, numList.get(0) + 1);

		// 迴圈判斷進位
		for (int i = 0; i < numList.size(); i++) {

			if (numList.get(i) == max) {
				numList.set(i + 1, numList.get(i + 1) + 1);
				numList.set(i, 0);
			}
		}

		// 如果已經達節最大值，keep設false
		if (numList.equals(maxList)) {
			keep = false;
		}

		return numList;
	}
}
