import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<>();
	
	public Customer(String _name) {
		this._name = _name;
	}

	public String getName() {
		return _name;
	}
	
	public void addRental(Rental rental) {
		_rentals.add(rental);
	}
	
	public String statement() {
		String result = getName() + " 고객님의 대여 기록\n";
		
		for (Rental each : _rentals) {
			// 이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle() + "\t" +
				String.valueOf(each.getCharge()) + "\n";
		}
		
		// 푸터 행 추가
		result += "누적 대여료: " + String.valueOf(getTotalAmount()) + "\n";
		result += "적립 포인트: " + String.valueOf(getTotalFrequentRenterPoints());
		return result;
	}
	
	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : _rentals) {
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}
	
	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : _rentals) {
			frequentRenterPoints += each.getFrequentRenterPotins();
		}
		return frequentRenterPoints;
	}
}
