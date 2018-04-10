package BTCexchange.BTCexchange;

import java.util.TimerTask;

import org.testng.annotations.Test;

import BTCexchange.PageObjects.BTCUtil;

/**
 * BTC Exchange to USD
 */
public class BtcPriceChecker extends TimerTask  {

	private static BTCUtil util = new BTCUtil();
	
    @Override
    public void run() {
    	util.completeTask();
    }

	@Test
	public void priceCheckerTest()  {
		util.openURL();
		util.priceCheckerTask();
	}
}
