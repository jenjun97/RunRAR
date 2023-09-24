package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrackService {
	// 壓縮檔路徑
	private String filePath = null;

	// 密碼字元範圍
	private String[] passRangeAry = null;

	// 密碼位數
	private int passSize = 0;

	private String unrarPath = System.getProperty("user.dir") + File.separator + "OtherProgram" + File.separator
			+ "UnRAR.exe";

	// 建構子
	CrackService(String filePath, String passRange, int passSize) {
		this.filePath = filePath;
		// 將字串解成陣列
		this.passRangeAry = passRange.split("");
		this.passSize = passSize;
	}

	// 執行破解
	void action() throws IOException, InterruptedException {
		// 預設要放幾位
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < this.passSize; i++) {
			numList.add(-1);
		}

		// 預設跑到最後一個數(最大值時)
		List<Integer> maxList = new ArrayList<Integer>();
		for (int i = 0; i < this.passSize; i++) {
			maxList.add(passRangeAry.length - 1);
		}

		// 判斷壓縮檔類型，以新增解壓縮物件
		CompressionInterface compress = null;
		if (filePath.toUpperCase().endsWith(".ZIP")) {
			compress = new Zip();
		} else if (CheckRAR54.checkRarVersion(filePath).equals("RAR5")) {
			compress = new Rar5(unrarPath);
		} else if (CheckRAR54.checkRarVersion(filePath).equals("RAR4")) {
			compress = new Rar4(unrarPath);
		} else {
			System.out.println("無法判斷壓縮檔類型，請洽程式人員");
			return;
		}

		// 執行
		while (keep) {
			numList = add(numList, maxList, passRangeAry.length);
			String pw = getPW(numList, passRangeAry);
			boolean correct = compress.verifyPassword(filePath, pw);

			if (correct) {
				System.out.println("成功解開壓縮檔，密碼為 [" + pw + "]");
				System.out.println("程式終止");
				keep = false;
			} else {
				System.out.println("測試密碼 [" + pw + "] 錯誤");
			}
		}

	}

	static boolean keep = true;

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
