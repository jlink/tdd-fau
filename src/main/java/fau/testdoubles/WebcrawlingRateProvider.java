package fau.testdoubles;

import java.util.*;

public class WebcrawlingRateProvider implements RateProvider {
	@Override
	public double getRate(String fromCurrency, String toCurrency) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Math.round(new Random().nextDouble() * 100) / 10.0;
	}
}
