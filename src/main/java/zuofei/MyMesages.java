package zuofei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMesages {
	{
		bigList.add(a1);
		bigList.add(b1);
		bigList.add(c1);
		bigList.add(d1);
		bigList.add(e1);

		doubleList.add(a2);
		doubleList.add(b2);
		doubleList.add(c2);
		doubleList.add(d2);
		doubleList.add(e2);
	}

	// 大乐透
	private static List<int[]> bigList = new ArrayList<int[]>();

	private static int[] a1 = new int[] { 4, 25, 28, 20, 29, 6, 3 };
	private static int[] b1 = new int[] { 4, 25, 3, 4, 5, 6, 7 };
	private static int[] c1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
	private static int[] d1 = new int[] { 4, 25, 28, 29, 35, 6, 7 };
	private static int[] e1 = new int[] { 8, 13, 19, 4, 5, 6, 7 };

	// 双色球
	private static List<int[]> doubleList = new ArrayList<int[]>();

	private static int[] a2 = new int[] { 1, 2, 10, 4, 5, 6, 7 };
	private static int[] b2 = new int[] { 1, 2, 10, 12, 5, 6, 7 };
	private static int[] c2 = new int[] { 2, 10, 12, 15, 24, 27, 7 };
	private static int[] d2 = new int[] { 1, 2, 3, 4, 5, 6, 8 };
	private static int[] e2 = new int[] { 1, 2, 10, 12, 15, 6, 8 };

	public Map<String, List<int[]>> getMyMesange() {
		Map<String, List<int[]>> map = new HashMap<String, List<int[]>>();
		map.put("Big", this.bigList);
		map.put("Double", this.doubleList);
		return map;
	}
}
