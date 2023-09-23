package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	
//	public static void main(String[] args) {
//		File file = new File("C:\\Program Files\\WinRAR\\UnRAR.exe");
//		System.out.println(file.getName());
//	}
	
	public static void main(String[] args) throws IOException {
		String mainPath = "C:/";

		// 找到程式資料夾
		List<String> programList = searchDir(mainPath, "Program Files", new ArrayList<String>());

		// 從程式資料中，找到有rar名稱的資料夾
		List<String> rarList = new ArrayList<String>();
		for (String path : programList) {
			rarList = searchDir(path, "WinRAR", rarList);
		}

		// 從資料夾中找出指定的檔案路徑
		for (String path : rarList) {
			String name = searchFile(path, "UnRAR.exe");
			System.out.println(name);
		}

	}

	// 搜尋指定名稱的資料夾
	private static List<String> searchDir(String path, String name, List<String> pathList) {

		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isDirectory() && file.getName().indexOf(name) >= 0) {
				pathList.add(file.getPath());
			}
		}
		return pathList;
	}

	// 搜尋指定檔名的檔案
	private static String searchFile(String path, String name) {
		String targetPath = null;
		File[] files = new File(path).listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				targetPath = searchFile(file.getPath(), name);
			} else if (file.isFile() && file.getName().indexOf(name) >= 0) {
				return file.getPath();
			}
		}
		return targetPath;
	}
}
