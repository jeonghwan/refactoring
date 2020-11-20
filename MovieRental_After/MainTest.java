import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	private Customer _customer;
	
	@Before
	public void setup() {
		_customer = new Customer("홍길동");
		_customer.addRental(new Rental(new Movie("영화1", Movie.REGULAR), 1));
		_customer.addRental(new Rental(new Movie("영화2", Movie.NEW_RELEASE), 2));
		_customer.addRental(new Rental(new Movie("영화3", Movie.CHILDRENS), 1));
	}
	
	@Test
	public void testStatement() {
		assertEquals("홍길동 고객님의 대여 기록\n" + 
				     "	영화1	2.0\n" + 
				     "	영화2	6.0\n" + 
				     "	영화3	1.5\n" + 
				     "누적 대여료: 9.5\n" + 
				     "적립 포인트: 4", 
				     _customer.statement());
	}
}
