package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FenXi extends BaseService {

	public static void main(String[] args) {
		System.out.println(readTxtFile("D:\\shuangseqiu.txt").toString());

	}

	public static List<int[]> readTxtFile(String filePath) {
		List<int[]> insertData = new ArrayList<int[]>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					insertData.add(getIntArray(lineTxt));
					break;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}finally {
			return insertData;
		}

	}

	public static int[] getIntArray(String targetString) {
		String[] split = targetString.split(",");
		int[] target = new int[split.length];
		try {
			for (int i = 0; i < split.length; i++) {
				target[i] = Integer.valueOf(split[i].strip());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return target;
	}

}
