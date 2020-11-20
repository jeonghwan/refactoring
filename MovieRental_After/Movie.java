
public class Movie {

	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;
	
	private String _title;
	
	private int _priceCode;
	private Price _price;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		this.setPriceCode(priceCode);
	}

	public String getTitle() {
		return _title;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			_price = Price.REGULAR;
			break;
		case NEW_RELEASE:
			_price = Price.NEW_RELEASE;
			break;
		case CHILDRENS:
			_price = Price.CHILDRENS;
			break;
		default:
			throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
		}
	}
	
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}
	
}
