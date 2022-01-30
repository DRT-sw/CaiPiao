package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SuiJi {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			System.out.println("第" + (i + 1) + "注  大乐透  ：  " + getSHD());
		}

		System.out.println("==================");

		for (int i = 0; i < 5; i++) {
			System.out.println("第" + (i + 1) + "注  双色球 ：  " + getSHS());
		}

	}

	private static String getSHS() {

		List<Integer> shuang = new ArrayList<Integer>();

		shuang = getListOfSort(6, 33);

		shuang.addAll(getListOfSort(1, 16));

		return shuang.toString();
	}

	private static String getSHD() {

		List<Integer> shuang = new ArrayList<Integer>();

		shuang = getListOfSort(5, 35);

		shuang.addAll(getListOfSort(2, 12));

		return shuang.toString();
	}

	/**
	 * 获取n个0-max的整数不重复并排序
	 * 
	 * @param n   个数
	 * @param max 最大值
	 * @return
	 */
	private static List<Integer> getListOfSort(int n, int max) {
		List<Integer> shuang = new ArrayList<Integer>();
		Random r = new Random();

		for (int i = 0; i < n; i++) {
			int a = r.nextInt(max) + 1;
			if (shuang.contains(a)) {
				i--;
			} else {
				shuang.add(a);
			}
		}
		Collections.sort(shuang);

		return shuang;
	}
}
