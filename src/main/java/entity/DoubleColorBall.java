package entity;

import java.util.List;

/**
 * Created by yy on 2017/9/26. 双色球开奖信息表实体类
 */
public class DoubleColorBall {

	private int Period_Id;// 期号
	private int RedBall_One;// 红球1
	private int RedBall_Tow;// 红球2
	private int RedBall_Three;// 红球3
	private int RedBall_Four;// 红球4
	private int RedBall_Fives;// 红球5
	private int RedBall_Six;// 红球6
	private int BlueBall_One;// 蓝球1
	private long Prize_Pool_Bonus;// 奖池奖金
	private int First_Prize_Number;// 一等奖注数
	private int First_Prize_Bonus;// 一等奖奖金
	private int Second_Prize_Number;// 二等奖注数
	private int Second_Prize_Bonus;// 二等奖奖金
	private int Total_Bet_Amount;// 总投注额
	private String Lottery_Date;// 开奖日期

	public DoubleColorBall() {
	}

	// 接收正则返回的数据
	public DoubleColorBall(List<String> infoData) {
		if (infoData.size() == 15) {
			this.Period_Id = Integer.parseInt(infoData.get(0));
			this.RedBall_One = Integer.parseInt(infoData.get(1));
			this.RedBall_Tow = Integer.parseInt(infoData.get(2));
			this.RedBall_Three = Integer.parseInt(infoData.get(3));
			this.RedBall_Four = Integer.parseInt(infoData.get(4));
			this.RedBall_Fives = Integer.parseInt(infoData.get(5));
			this.RedBall_Six = Integer.parseInt(infoData.get(6));
			this.BlueBall_One = Integer.parseInt(infoData.get(7));
			this.Prize_Pool_Bonus = Long.parseLong(infoData.get(8));
			this.First_Prize_Number = Integer.parseInt(infoData.get(9));
			this.First_Prize_Bonus = Integer.parseInt(infoData.get(10));
			this.Second_Prize_Number = Integer.parseInt(infoData.get(11));
			this.Second_Prize_Bonus = Integer.parseInt(infoData.get(12));
			this.Total_Bet_Amount = Integer.parseInt(infoData.get(13));
			this.Lottery_Date = infoData.get(14);
		}
	}

	public int getPeriod_Id() {
		return Period_Id;
	}

	public void setPeriod_Id(int period_Id) {
		Period_Id = period_Id;
	}

	public int getRedBall_One() {
		return RedBall_One;
	}

	public void setRedBall_One(int redBall_One) {
		RedBall_One = redBall_One;
	}

	public int getRedBall_Tow() {
		return RedBall_Tow;
	}

	public void setRedBall_Tow(int redBall_Tow) {
		RedBall_Tow = redBall_Tow;
	}

	public int getRedBall_Three() {
		return RedBall_Three;
	}

	public void setRedBall_Three(int redBall_Three) {
		RedBall_Three = redBall_Three;
	}

	public int getRedBall_Four() {
		return RedBall_Four;
	}

	public void setRedBall_Four(int redBall_Four) {
		RedBall_Four = redBall_Four;
	}

	public int getRedBall_Fives() {
		return RedBall_Fives;
	}

	public void setRedBall_Fives(int redBall_Fives) {
		RedBall_Fives = redBall_Fives;
	}

	public int getRedBall_Six() {
		return RedBall_Six;
	}

	public void setRedBall_Six(int redBall_Six) {
		RedBall_Six = redBall_Six;
	}

	public int getBlueBall_One() {
		return BlueBall_One;
	}

	public void setBlueBall_One(int blueBall_One) {
		BlueBall_One = blueBall_One;
	}

	public long getPrize_Pool_Bonus() {
		return Prize_Pool_Bonus;
	}

	public void setPrize_Pool_Bonus(long prize_Pool_Bonus) {
		Prize_Pool_Bonus = prize_Pool_Bonus;
	}

	public int getFirst_Prize_Number() {
		return First_Prize_Number;
	}

	public void setFirst_Prize_Number(int first_Prize_Number) {
		First_Prize_Number = first_Prize_Number;
	}

	public int getFirst_Prize_Bonus() {
		return First_Prize_Bonus;
	}

	public void setFirst_Prize_Bonus(int first_Prize_Bonus) {
		First_Prize_Bonus = first_Prize_Bonus;
	}

	public int getSecond_Prize_Number() {
		return Second_Prize_Number;
	}

	public void setSecond_Prize_Number(int second_Prize_Number) {
		Second_Prize_Number = second_Prize_Number;
	}

	public int getSecond_Prize_Bonus() {
		return Second_Prize_Bonus;
	}

	public void setSecond_Prize_Bonus(int second_Prize_Bonus) {
		Second_Prize_Bonus = second_Prize_Bonus;
	}

	public int getTotal_Bet_Amount() {
		return Total_Bet_Amount;
	}

	public void setTotal_Bet_Amount(int total_Bet_Amount) {
		Total_Bet_Amount = total_Bet_Amount;
	}

	public String getLottery_Date() {
		return Lottery_Date;
	}

	public void setLottery_Date(String lottery_Date) {
		Lottery_Date = lottery_Date;
	}

	public String getRedNumber() {
		return RedBall_One + ", " + RedBall_Tow + ", " + RedBall_Three + ", " + RedBall_Four + ", " + RedBall_Fives
				+ ", " + RedBall_Six;
	}

	@Override
	public String toString() {
		return "双色球第" + Period_Id + "期" + "：【" + RedBall_One + "," + RedBall_Tow + ", " + RedBall_Three + ","
				+ RedBall_Four + ", " + RedBall_Fives + ", " + RedBall_Six + "：：" + BlueBall_One + "】, 奖池奖金："
				+ Prize_Pool_Bonus + ", 头奖" + First_Prize_Number + "注" + ", 头奖奖金" + First_Prize_Bonus + ", 二等奖"
				+ Second_Prize_Number + "注" + ", 二等奖奖金" + Second_Prize_Bonus + ", 开奖日期" + Lottery_Date;
	}
}