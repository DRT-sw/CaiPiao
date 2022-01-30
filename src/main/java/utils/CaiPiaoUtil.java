package utils;

import java.util.ArrayList;
import java.util.List;

public class CaiPiaoUtil {

	/**
	 * 将爬取到的String信息转换成list集合 String ==> List<Integer>
	 * 
	 * @param targetString
	 * @return
	 */
	public static List<Integer> getIntArray(String targetString) {
		String[] split = targetString.split(",");
		List<Integer> target = new ArrayList<Integer>();
		try {
			for (int i = 0; i < split.length; i++) {
				target.add(Integer.valueOf(split[i].strip()));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return target;
	}

	/**
	 * 将爬取到的String信息转换成Array数组 String ==> int[]
	 * 
	 * @param targetString
	 * @return
	 */
	public static int[] getIntArray2(String targetString) {
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
	public static int[] getIntArray3(String targetString) {
		targetString=targetString.trim();
		String[] split = targetString.split(" ");
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
