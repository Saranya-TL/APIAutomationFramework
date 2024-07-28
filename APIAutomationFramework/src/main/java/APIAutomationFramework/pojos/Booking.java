package APIAutomationFramework.pojos;

public class Booking {

	
	private String firstName;
	private String lastName;
	private Integer totalPrice;

	private Boolean depositPaid;

	private BookingDates bookingdates;
	private String additionalNeeds;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(Boolean depositPaid) {
		this.depositPaid = depositPaid;
	}
	
	public BookingDates getBookingDates() {
		return bookingdates;
	}

	public void setBookingDates(BookingDates bookingDates){
			this.bookingdates = bookingDates;
	}

	public String getAdditionalNeeds() {
		return additionalNeeds;
	}

	public void setAdditionalNeeds(String additionalNeeds) {
		this.additionalNeeds = additionalNeeds;
	}	
		
		@Override
		public String toString() {
			return "Booking{" +
	                "firstname='" + firstName + '\'' +
	                ", lastname='" + lastName + '\'' +
	                ", totalprice=" + totalPrice +
	                ", depositpaid=" + depositPaid +
	                ", bookingdates=" + bookingdates +
	                ", additionalneeds='" + additionalNeeds + '\'' +
	                '}';
		}
	

}
