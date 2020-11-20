
public class Rental {

	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		this._movie = movie;
		this._daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int getDaysRented() {
		return _daysRented;
	}
	
	// 위임 메서드
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	
	// 위임 메서드
	public int getFrequentRenterPotins() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
