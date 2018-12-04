package fau.testdoubles;

public class DatabaseRateProvider implements RateProvider {
	@Override
	public double getRate(String fromCurrency, String toCurrency) {
		return 1.42;
	}
}
