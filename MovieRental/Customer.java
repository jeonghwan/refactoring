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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = getName() + " 고객님의 대여 기록\n";
		for (Rental each : _rentals) {
			double thisAmount = 0;
			
			// 비디오 종류별 대여료 계산
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2) 
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			
			// 적립 포인트를 1 포인트 증가
			frequentRenterPoints++;
			
			// 최신물을 2일 이상 대여하면 보너스 포인트 지급
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					each.getDaysRented() > 1)
				frequentRenterPoints++;
			
			// 이번에 대여하는 비디오 정보와 대여료를 출력
			result += "\t" + each.getMovie().getTitle() + "\t" +
				String.valueOf(thisAmount) + "\n";
			
			// 현재까지 누적된 총 대여료
			totalAmount += thisAmount;
		}
		
		// 푸터 행 추가
		result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
		result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
		return result;
	}
	
}
