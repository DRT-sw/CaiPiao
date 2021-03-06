package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.BigLottoBall;
import entity.DoubleColorBall;

/**
 * Created by yy on 2017/10/16. 获取彩票开奖信息工具类 1、获取传入期号之后开奖的双色球数据 2、获取全部双色球的开奖数据
 * 3、获取传入期号之后大乐透的开奖数据 4、获取全部大乐透开奖信息数据
 */
public class GetLottery {
	// 大乐透请求url
	private static String bigUrl = "http://datachart.500.com/dlt/history/newinc/history.php?limit=10000&sort=0";
	// 双色球请求url
	private static String douUrl = "http://datachart.500.com/ssq/history/newinc/history.php?limit=100000&sort=0";
	// 匹配开奖正则
	private static String listRegex = "--><(.*?)<\\/tr>";
	// 匹配开奖明细正则
	private static String infoRegex = ">[,\\d-]+?<";

	/**
	 * 获取全部双色球的开奖信息数据
	 * 
	 * @return list对象
	 * @throws Exception
	 */
	public static List<DoubleColorBall> getAllDCB() throws Exception {
		List<DoubleColorBall> list = new ArrayList<DoubleColorBall>();
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.douUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			// 创建对象
			list.add(new DoubleColorBall(infoData));
		}
		return list;

	}

	/**
	 * 根据传进来的的开奖期号获取这个开奖期号自后的开奖信息
	 * 
	 * @param period_Id 开奖期号
	 * @return List对象
	 * @throws Exception
	 */
	public static List<DoubleColorBall> getBeforeDCB(int period_Id) throws Exception {
		List<DoubleColorBall> list = new ArrayList<DoubleColorBall>();
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.douUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			// 要是获取的期号小于或者等于传进来的期号则跳出
			if (Integer.parseInt(infoData.get(0)) <= period_Id) {
				break;
			} else {
				// 创建对象
				list.add(new DoubleColorBall(infoData));
			}
		}
		return list;
	}

	/**
	 * 获取全部大乐透的开奖信息
	 * 
	 * @return List对象
	 * @throws Exception
	 */
	public static List<BigLottoBall> getAllBLB() throws Exception {
		List<BigLottoBall> list = new ArrayList<BigLottoBall>();
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.bigUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			// 创建对象
			list.add(new BigLottoBall(infoData));
		}
		return list;

	}

	/**
	 * 根据传入的期号来获取这个期号之前的开奖信息
	 * 
	 * @param period_Id 开奖期号
	 * @return
	 * @throws Exception
	 */
	public static List<BigLottoBall> getBeforeBLB(int period_Id) throws Exception {
		List<BigLottoBall> list = new ArrayList<BigLottoBall>();
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.bigUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			// 要是获取的期号小于或者等于传进来的期号则跳出
			list.add(new BigLottoBall(infoData));
			break;
		}
		return list;
	}

	/**
	 * 获取最新的大乐透开奖信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public static BigLottoBall getNewOneMasage() throws Exception {
		BigLottoBall bigLottoBall = null;
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.bigUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			bigLottoBall = new BigLottoBall(infoData);
			break;
		}
		return bigLottoBall;
	}
	
	/**
	 * 获取最新的双色球开奖信息
	 * 
	 * @return list对象
	 * @throws Exception
	 */
	public static DoubleColorBall getNewOneMasage2() throws Exception {
		DoubleColorBall doubleColorBall = null;
		// 获取url信息
		String data = GetUrlData.getString(GetLottery.douUrl);

		Pattern pattern = Pattern.compile(GetLottery.listRegex);
		Matcher matcher = pattern.matcher(data);
		// 遍历获取的数据
		while (matcher.find()) {
			String info = matcher.group();
			List<String> infoData = new ArrayList<String>();
			Pattern patternInfo = Pattern.compile(GetLottery.infoRegex);
			Matcher matcherInfo = patternInfo.matcher(info);
			// 获取具体的数据
			while (matcherInfo.find()) {
				infoData.add(matcherInfo.group().replaceAll(">|<|,", ""));
			}
			doubleColorBall = new DoubleColorBall(infoData);
			break;
		}
		return doubleColorBall;

	}
}