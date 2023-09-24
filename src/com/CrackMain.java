package com;

import java.util.Scanner;

public class CrackMain {
	static boolean keep = true;

	public static void main(String[] args) {
//		System.out.println("--------------------------------------------------------");
//		System.out.println("暴力破解壓縮檔");
//		System.out.println("本程式只適用於Windwos");
//		System.out.println("可破解RAR5, RAR4, Zip及傳統Zip檔");
//		System.out.println("--------------------------------------------------------");
//		System.out.println("請依下列提示步驟操作");
//		System.out.println();

		// 輸入壓縮檔路徑並驗證
//		System.out.println("請輸入壓縮檔案的絕對路徑(ex:C:/File/Doc/abc.rar or C\\File\\Doc\\abc.rar)");
//		System.out.print("壓縮檔路徑：");
		Scanner scanner = new Scanner(System.in);
//		String filePath = scanner.next();

//		while(!CheckInput.existFile(filePath)) {
//			System.out.println();
//			System.out.println("檔案不存在，請檢查輸入的路徑");
//			System.out.println("請重新輸入壓縮檔案的絕對路徑(ex:C:/File/Doc/abc.rar");
//			System.out.print("壓縮檔路徑：");
//			filePath = scanner.next();
//		}
//		System.out.println();
//		System.out.println("壓縮檔驗證成功!!!");
//		System.out.println();

		// 輸入密碼範圍並驗證
//		System.out.println("請輸入密碼可能的字元範例，例：ABCabc123");
//		System.out.println("程式會拆解上面的字元，去測試所有組合。");
//		System.out.println("注意，輸入愈多破解時間愈久");
//		System.out.print("請輸入字元範例(最少1碼)：");
//		String passRange = scanner.next();
//
//		while (!CheckInput.checkPass(passRange)) {
//			System.out.println();
//			System.out.println("密碼字元範例輸入錯誤，請至少輸入一碼");
//			System.out.println("請輸入密碼可能的字元範例，例：ABCabc123");
//			System.out.println("程式會拆解上面的字元，測試各種組合。");
//			System.out.println("注意，輸入愈多破解時間愈久");
//			System.out.print("請輸入字元範例(最少1碼)：");
//			passRange = scanner.next();
//		}
//		
//		System.out.println();
//		System.out.println("密碼範圍輸入成功!!!");
//		System.out.println();
//		
//		System.out.println("passRange =" + passRange);
//		System.out.println("passRange length=" + passRange.length());
		
		// 輸入密碼位元
		System.out.println("請輸入密碼可能最多的位數");
		System.out.println("例如輸入5，程式會從1位開始測，一直測試到5位數");
		System.out.println("注意，輸入愈多破解時間愈久");
		System.out.print("請輸入密碼可能最多的位數(只能輸入數字，最少1位)：");
		String passSize = scanner.next();
		while (!CheckInput.checkPassSize(passSize)) {
			System.out.println();
			System.out.println("密碼位數輸入錯誤，請重新檢查");
			System.out.println("請輸入密碼可能最多的位數");
			System.out.println("例如輸入5，程式會從1位開始測，一直測試到5位數");
			System.out.println("注意，輸入愈多破解時間愈久");
			System.out.print("請輸入密碼可能最多的位數(只能輸入數字，最少1位)：");
			passSize = scanner.next();
		}
	}
}
