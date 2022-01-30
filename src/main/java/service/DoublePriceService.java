package service;

import java.util.List;

import utils.CaiPiaoUtil;

public class DoublePriceService extends BaseService {

	public String doubleMonery() {

		// 获取自己的下注信息
		List<int[]> myDoubleMsg = getMesMap().get("Double");

		// 获取开奖信息
		String targetDoubleRedString = "";
		int targetDoubleBlue = 0;
		try {
			System.out.println(GetLottery.getNewOneMasage2());
			System.out.println();
			targetDoubleRedString = GetLottery.getNewOneMasage2().getRedNumber();
			targetDoubleBlue = GetLottery.getNewOneMasage2().getBlueBall_One();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 判断中奖信息
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < myDoubleMsg.size(); i++) {
			int[] temper = myDoubleMsg.get(i);
			msg.append("第" + (i + 1) + "注：" + onePrice(temper, targetDoubleRedString, targetDoubleBlue) + "\n");
		}

		return msg.toString();
	}

	/**
	 * 判断单注的中奖信息
	 * 
	 * @param temper
	 * @param targetDoubleRedString
	 * @param targetDoubleBlue
	 * @return 中奖信息
	 */
	private String onePrice(int[] temper, String targetDoubleRedString, int targetDoubleBlue) {
		int RedCount = 0, BlueCount = 0;

		List<Integer> targetDoubleRed = CaiPiaoUtil.getIntArray(targetDoubleRedString);

		for (int j = 0; j < targetDoubleRed.size(); j++) {
			if (targetDoubleRed.contains(temper[j])) {
				RedCount++;
			}
		}
		if (targetDoubleBlue == temper[6]) {
			BlueCount++;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("本期红球中" + RedCount + "个，蓝球中" + BlueCount + "个。\n");

		if (RedCount == 6 && BlueCount == 1) {
			buffer.append("我叼你妈的  终于等到这一天了 头奖 头奖 ！！！！！！！！！！！！！！！！！！");
			firstPrice();
		} else if (RedCount == 6 && BlueCount == 0) {
			buffer.append("我叼他妈的竟然不是头奖 啊 ！！！！算了 二等奖也不错 大几十万吧！");
			secondPrice();
		} else if (RedCount == 5 && BlueCount == 1) {
			buffer.append("3000 三千块钱！");
			System.err.println("3000 三千块钱！");
		} else if ((RedCount == 5 && BlueCount == 0) || (RedCount == 4 && BlueCount == 1)) {
			buffer.append("200  两百块钱！");
			System.err.println("200  两百块钱！");
		} else if ((RedCount == 4 && BlueCount == 0) || (RedCount == 3 && BlueCount == 1)) {
			buffer.append("10  十块钱 ");
			System.err.println("10  十块钱");
		} else if ((RedCount == 2 && BlueCount == 1) || (RedCount == 1 && BlueCount == 1)
				|| (RedCount == 0 && BlueCount == 1)) {
			buffer.append("5  五块钱");
			System.err.println("5  五块钱");
		} else {
			buffer.append("一毛钱每中！");
		}

		buffer.append("\n==============================================");
		return buffer.toString();
	}

}
