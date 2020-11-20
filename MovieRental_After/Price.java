
public abstract class Price {
	public static final Price REGULAR = new RegularPrice();
	public static final Price NEW_RELEASE = new NewReleasePrice();
	public static final Price CHILDRENS = new ChildrensPrice();

	public abstract int getPriceCode();
	public abstract double getCharge(int daysRented);
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
	
}
