
public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer("홍길동");
		customer.addRental(new Rental(new Movie("영화1", Movie.REGULAR), 1));
		customer.addRental(new Rental(new Movie("영화2", Movie.NEW_RELEASE), 2));
		customer.addRental(new Rental(new Movie("영화3", Movie.CHILDRENS), 1));
		System.out.println(customer.statement());

	}

}
