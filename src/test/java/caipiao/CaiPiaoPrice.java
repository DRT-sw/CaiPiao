package caipiao;

import org.junit.Test;

import service.BigPriceService;
import service.DoublePriceService;

public class CaiPiaoPrice {

	@Test
	public void BigPrice() {
		BigPriceService bigPriceService = new BigPriceService();
		String monery = bigPriceService.BigMonery();
		System.out.println(monery);
	}

	@Test
	public void DoublePrice() {
		DoublePriceService doublePriceService = new DoublePriceService();
		String monery = doublePriceService.doubleMonery();
		System.out.println(monery);
	}

}
