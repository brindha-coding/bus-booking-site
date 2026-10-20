package bookingapp;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static Scanner scanner=new Scanner(System.in);
	public static BookingDB ds= new BookingDB();
	public static void menu() {
		
		System.out.println("Bus Booking App.");
		System.out.println("1.Book Now.");
		System.out.println("2.Change Name.");
		System.out.println("3.Show all bookings");
		System.out.println("4.Modify from & to place");
		System.out.println("5.Search by id");
		System.out.println("6.Exit");
		System.out.println("choose option");
	}
//	public static String genderMenu() {
//	
//		return gender;
//	}
//	public static String payment() {
//		
//		return status;
//
//	}
	public static void bookNow() throws ClassNotFoundException, SQLException {
		scanner.nextLine();
		System.out.println("Enter you name:");
		String name = scanner.nextLine();
		System.out.println("Enter your age:");
		int age = scanner.nextInt();
		System.out.println("Choose Gender:");
		System.out.println("1.Male");
		System.out.println("2.Female");
		int ch=scanner.nextInt();
		String gender = null;
		switch(ch) {
		case 1 -> gender ="Male";
		case 2 -> gender="Female";
		default ->scanner.close();
		}
		scanner.nextLine();
		System.out.println("Enter you are from:");
		String from=scanner.nextLine();
		System.out.println("enter your destination:");
		String to=scanner.nextLine();
		System.out.println("please confirm the booking");
		System.out.println("Choose your option");
		System.out.println("1.Pay now");
		System.out.println("2.cancel");
		int ch1=scanner.nextInt();
		String status = null;
		switch(ch1) {
		case 1 -> status="Confimed";
		case 2 -> status="Failed";
		default -> scanner.close();
		}
		if(status=="Confimed") {
			System.out.println("Booking confirmed");
		}
		else {
			System.out.println("Booking Failed");
		}
		RequiredDetails rd = new RequiredDetails(name, age, gender, from, to, status);
		ds.insertData(rd);
		
	}
	public static void changeName() throws ClassNotFoundException, SQLException {
		int id;
		System.out.println("enter your booking Id:");
		id=scanner.nextInt();
		System.out.println("Enter New Name:");
		String name=scanner.nextLine();
		RequiredDetails rd=new RequiredDetails();
		rd.setName(name);
		rd.setBookingId(id);
		ds.changeName(rd);
	}
	public static void showAll() throws ClassNotFoundException, SQLException {
		ds.getAllBooking();
	}
	public static void modify() throws ClassNotFoundException, SQLException {
		
		int id;
		System.out.println("enter your booking Id:");
		id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter New place:");
		String from=scanner.nextLine();
		System.out.println("Enter New destination:");
		String to=scanner.nextLine();
		RequiredDetails rd=new RequiredDetails();
		rd.setFromLocation(from);
		rd.setDestination(to);
		rd.setBookingId(id);
		ds.placeChange(rd);
	}
	
	public static void searchById() throws ClassNotFoundException, SQLException {
		int id;
		System.out.println("enter your booking Id:");
		id=scanner.nextInt();
		RequiredDetails rd=ds.getById(id);
		printDetails(rd);
		
	}
	public static void printDetails(RequiredDetails rd) {
		System.out.println("Booking Id :"+rd.getBookingId());
		System.out.println("Name :"+ rd.getName());
		System.out.println("Age"+rd.getAge());
		System.out.println("Gender"+rd.getGender());
		System.out.println("From"+rd.getFromLocation());
		System.out.println("Destination:"+rd.getDestination());
		System.out.println("Booking status:"+rd.getBookingStatus());
		

	}	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	
		
		while(true) {
			menu();
			int choice=scanner.nextInt();
			switch(choice) {
			case 1 ->bookNow();
			case 2 ->changeName();
			case 3 ->showAll();
			case 4 ->modify();
			case 5 ->searchById();
			case 6 ->{
				scanner.close();
				System.out.println("Exiting app");
				return;
			}
			default -> System.out.println("invalid input");
			}
		}

	}

}
