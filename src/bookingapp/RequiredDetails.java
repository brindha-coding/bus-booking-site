package bookingapp;

public class RequiredDetails {

	int bookingId;
	String name;
	int age;
	String gender;
	String fromLocation;
	String destination;
	String bookingStatus;
	
	
	public RequiredDetails(int bookingId, String name, int age, String gender, String fromLocation, String destination,
			String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fromLocation = fromLocation;
		this.destination = destination;
		this.bookingStatus = bookingStatus;
	}

	public RequiredDetails() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "RequiredDetails [bookingId=" + bookingId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", fromLocation=" + fromLocation + ", destination=" + destination + ", bookingStatus=" + bookingStatus
				+ "]";
	}

	public RequiredDetails(String name, int age, String gender, String fromLocation, String destination,
			String bookingStatus) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fromLocation = fromLocation;
		this.destination = destination;
		this.bookingStatus = bookingStatus;
	}
	
	
	
	
	
	
	
}
