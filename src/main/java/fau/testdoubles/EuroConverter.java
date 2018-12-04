package fau.testdoubles;

public class EuroConverter {
	private RateProvider provider;

	public EuroConverter(RateProvider provider) {
		this.provider = provider;
	}

	public double euroAmount(double amount, String curr) {
		double exchangeRate = 0;
		try {
			exchangeRate = provider.getRate(curr, "EUR");
		} catch (IllegalArgumentException e) {
			exchangeRate = 0.0;
		}
		return amount * exchangeRate;
	}
}