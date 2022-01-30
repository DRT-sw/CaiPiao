package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.CaiPiaoUtil;

public class BaseService {

	/**
	 * 获取所有的下注信息
	 * 
	 * @return
	 */
	public Map<String, List<int[]>> getMesMap() {
		Map<String, List<int[]>> map = new HashMap<String, List<int[]>>();
		List<int[]> bigList = getFileMessage("/BigMsg.txt");
		List<int[]> doubleList = getFileMessage("/DoubleMsg.txt");
		map.put("Big", bigList);
		map.put("Double", doubleList);
		return map;
	}

	/**
	 * 获取所有的下注信息 复试
	 * 
	 * @return
	 */
	public Map<String, List<int[]>> getFMesMap() {
		Map<String, List<int[]>> map = new HashMap<String, List<int[]>>();
		List<int[]> bigList = getFileMessage("/BigMsg2.txt");
		List<int[]> doubleList = getFileMessage("/DoubleMsg2.txt");
		map.put("FBig", bigList);
		map.put("FDouble", doubleList);
		return map;
	}

	/**
	 * 从resource目录下获取表格数据
	 * 
	 * @return
	 */
	@SuppressWarnings("finally")
	public List<int[]> getFileMessage(String path) {
		List<int[]> insertData = new ArrayList<int[]>();
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			InputStream in = this.getClass().getResourceAsStream(path);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String str = "";
			while ((str = br.readLine()) != null) {
				insertData.add(CaiPiaoUtil.getIntArray2(str));
			}
		} catch (FileNotFoundException e) {
			System.err.println("找不到指定文件");
		} catch (IOException e) {
			System.err.println("读取文件失败");
		} finally {
			try {
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return insertData;
		}
	}
	
	public void firstPrice() {
		System.err.println("中头奖了");
	}
	public void secondPrice() {
		System.err.println("中二等奖了");
	}

}
