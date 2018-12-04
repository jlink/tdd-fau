package fau.junit5;

public class Euro {
	private final double amount;

	public Euro(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must not be negative");
		}
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public Euro plus(Euro addend) {
		return new Euro(amount + addend.amount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Euro euro = (Euro) o;

		return Double.compare(euro.amount, amount) == 0;
	}

	@Override
	public int hashCode() {
		long temp = Double.doubleToLongBits(amount);
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return String.format("EUR %s", amount);
	}
}
