package BTCexchange.PageObjects;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BTCexchange.BTCexchange.BtcPriceChecker;

public class BTCUtil {

	protected static WebDriver driver;
	private static long TOTAL_TASK_RUN_TIME = 30000; //30secs
	private static int TOTAL_BTC = 10;
	private static long TASK_TIME_INTERVAL = 10000; //10secs


	//Page Objects
	By bitCount = By.cssSelector("#gaugeField");
	By cryptType = By.xpath("//*[@id=\"unitASym\"]");
	By bitValue = By.xpath("//*[@id=\"numField\"]");
	By currencyType = By.xpath("//*[@id=\"unitBSym\"]");

	public WebElement bitCount() {
		return driver.findElement(bitCount);
	}

	public WebElement cryptType() {
		return driver.findElement(cryptType);
	}

	public WebElement bitValue() {
		return driver.findElement(bitValue);
	}

	public WebElement currencyType() {
		return driver.findElement(currencyType);
	}

	public void openURL() {
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://preev.com/");
	}

	public void bitCountValue() {
		String value = bitCount().getAttribute("textContent");
		System.out.println(value + " " + cryptType().getText() + " = " + bitVlaueUSD() + "on "+new Date());
	}
	
	private Float btcAmountCalc(int btcCount) {
		
		Float btcPrice = new Float(bitValue().getAttribute("value").replaceAll(",", ""));
		
		return btcPrice * btcCount;
	}

	public String bitVlaueUSD() {
		String usd = driver.getTitle();
		String[] con = usd.split("[·]");
		return con[0];
	}
	
	public void priceCheckerTask() {
		TimerTask timerTask = new BtcPriceChecker();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1000);//Specifying the delay and period of task to be run
        System.out.println("BTC Price Checker started");
        System.out.println("=========================");
        //cancel after sometime
        try {
            Thread.sleep(TOTAL_TASK_RUN_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("===========================");
        System.out.println("BTC Price Checker completed");
        System.out.println("\n");
        System.out.println("===========================");
        System.out.println("10 BTC Value = " +btcAmountCalc(TOTAL_BTC) );
        System.out.println("===========================");

	}
	
	public void completeTask() {
        try {
        	bitCountValue();
            //assuming it takes 10 secs to complete the task
            Thread.sleep(TASK_TIME_INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
