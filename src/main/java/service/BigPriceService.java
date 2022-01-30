package service;

import java.util.List;

import utils.CaiPiaoUtil;

public class BigPriceService extends BaseService {

	/**
	 * 单试
	 * 
	 * @return
	 */
	public String BigMonery() {

		// 获取自己的下注信息
		List<int[]> myBigMsg = getMesMap().get("Big");

		// 获取开奖信息
		String targetBigRedString = "";
		String targetBigBlueString = "";
		try {
			System.out.println(GetLottery.getNewOneMasage());
			System.out.println();
			targetBigRedString = GetLottery.getNewOneMasage().getRedNumber();
			targetBigBlueString = GetLottery.getNewOneMasage().getBlueNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 判断中奖信息
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < myBigMsg.size(); i++) {
			int[] temper = myBigMsg.get(i);
			msg.append("第" + (i + 1) + "注：" + onePrice(temper, targetBigRedString, targetBigBlueString) + "\n");
		}

		return msg.toString();
	}

	/**
	 * 复试
	 * 
	 * @return
	 */
	public String FBigMonery() {

		// 获取自己的下注信息
		List<int[]> myFBigMsg = getFMesMap().get("FBig");

		// 获取开奖信息
		String targetBigRedString = "";
		String targetBigBlueString = "";
		try {
			System.out.println(GetLottery.getNewOneMasage());
			System.out.println();
			targetBigRedString = GetLottery.getNewOneMasage().getRedNumber();
			targetBigBlueString = GetLottery.getNewOneMasage().getBlueNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 判断中奖信息
		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < myFBigMsg.size(); i++) {
			int[] temper = myFBigMsg.get(i);
			msg.append(FonePrice(temper, targetBigRedString, targetBigBlueString) + "\n");
		}

		return msg.toString();
	}

	/**
	 * 判断单注的中奖信息
	 * 
	 * @param temper
	 * @param targetBigRedString
	 * @param targetBigBlueString
	 * @return 中奖信息
	 */
	private String onePrice(int[] temper, String targetBigRedString, String targetBigBlueString) {
		int RedCount = 0, BlueCount = 0;

		List<Integer> targetBigRed = CaiPiaoUtil.getIntArray(targetBigRedString);
		List<Integer> targetBigBlue = CaiPiaoUtil.getIntArray(targetBigBlueString);

		for (int j = 0; j < targetBigRed.size(); j++) {
			if (targetBigRed.contains(temper[j])) {
				RedCount++;
			}
		}
		for (int j = 0; j < targetBigBlue.size(); j++) {
			if (targetBigBlue.contains(temper[j + 5])) {
				BlueCount++;
			}
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("本期红球中" + RedCount + "个，蓝球中" + BlueCount + "个。\n");

		if (RedCount == 5 && BlueCount == 2) {
			buffer.append("我叼你妈的  终于等到这一天了 头奖 头奖 ！！！！！！！！！！！！！！！！！！");
			firstPrice();
		} else if (RedCount == 5 && BlueCount == 1) {
			buffer.append("我叼他妈的竟然不是头奖 啊 ！！！！算了 二等奖也不错 大几十万吧！");
			secondPrice();
		} else if (RedCount == 5 && BlueCount == 0) {
			buffer.append("10000 一万块钱！！");
			System.err.println("10000 一万块钱！！");
		} else if (RedCount == 4 && BlueCount == 2) {
			buffer.append("3000 三千块钱！");
			System.err.println("3000 三千块钱！");
		} else if (RedCount == 4 && BlueCount == 1) {
			buffer.append("300 三百块钱");
			System.err.println("300 三百块钱");
		} else if (RedCount == 3 && BlueCount == 2) {
			buffer.append("200 两百块钱");
			System.err.println("200 两百块钱");
		} else if (RedCount == 4 && BlueCount == 0) {
			buffer.append("100 一百块钱");
			System.err.println("100 一百块钱");
		} else if ((RedCount == 3 && BlueCount == 1) || (RedCount == 2 && BlueCount == 2)) {
			buffer.append("15 十五块钱");
			System.err.println("15 十五块钱");
		} else if ((RedCount == 3 && BlueCount == 0) || (RedCount == 2 && BlueCount == 1)
				|| (RedCount == 1 && BlueCount == 2) || (RedCount == 0 && BlueCount == 2)) {
			buffer.append("5 五块钱");
			System.err.println("5 五块钱");
		} else {
			buffer.append("一毛钱每中！");
		}

		buffer.append("\n==============================================");
		return buffer.toString();
	}
	
	private String FonePrice(int[] temper, String targetBigRedString, String targetBigBlueString) {
		int RedCount = 0, BlueCount = 0;
		
		List<Integer> targetBigRed = CaiPiaoUtil.getIntArray(targetBigRedString);
		List<Integer> targetBigBlue = CaiPiaoUtil.getIntArray(targetBigBlueString);
		
		for (int j = 0; j < targetBigRed.size(); j++) {
			if (targetBigRed.contains(temper[j])) {
				RedCount++;
			}
		}
		for (int j = 0; j < targetBigBlue.size(); j++) {
			if (targetBigBlue.contains(temper[j + 5])) {
				BlueCount++;
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("本期红球中" + RedCount + "个，蓝球中" + BlueCount + "个。\n");
		
		if (RedCount == 5 && BlueCount == 2) {
			buffer.append("我叼你妈的  终于等到这一天了 头奖 头奖 ！！！！！！！！！！！！！！！！！！");
			System.err.println("我叼你妈的  终于等到这一天了 头奖 头奖 ！！！！！！！！！！！！！！！！！！");
		} else if (RedCount == 5 && BlueCount == 1) {
			buffer.append("我叼他妈的竟然不是头奖 啊 ！！！！算了 二等奖也不错 大几十万吧！");
			System.err.println("我叼他妈的竟然不是头奖 啊 ！！！！算了 二等奖也不错 大几十万吧！");
		} else if (RedCount == 5 && BlueCount == 0) {
			buffer.append("10000 一万块钱！！");
			System.err.println("10000 一万块钱！！");
		} else if (RedCount == 4 && BlueCount == 2) {
			buffer.append("3000 三千块钱！");
			System.err.println("3000 三千块钱！");
		} else if (RedCount == 4 && BlueCount == 1) {
			buffer.append("300 三百块钱");
			System.err.println("300 三百块钱");
		} else if (RedCount == 3 && BlueCount == 2) {
			buffer.append("200 两百块钱");
			System.err.println("200 两百块钱");
		} else if (RedCount == 4 && BlueCount == 0) {
			buffer.append("100 一百块钱");
			System.err.println("100 一百块钱");
		} else if ((RedCount == 3 && BlueCount == 1) || (RedCount == 2 && BlueCount == 2)) {
			buffer.append("15 十五块钱");
			System.err.println("15 十五块钱");
		} else if ((RedCount == 3 && BlueCount == 0) || (RedCount == 2 && BlueCount == 1)
				|| (RedCount == 1 && BlueCount == 2) || (RedCount == 0 && BlueCount == 2)) {
			buffer.append("5 五块钱");
			System.err.println("5 五块钱");
		} else {
			buffer.append("一毛钱每中！");
		}
		
		buffer.append("\n==============================================");
		return buffer.toString();
	}

}
