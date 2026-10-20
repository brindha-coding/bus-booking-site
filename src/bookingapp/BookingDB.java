package bookingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDB {
	String host="jdbc:mysql://localhost:3306/BusBooking";
	String user="NewUser";
	String password="1234567890";
	Connection connection;
	public void insertData(RequiredDetails rd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		PreparedStatement pr=connection
				.prepareStatement("insert into busBookingApp (name,age,gender,fromLocation,destinaton,bookingStatus)"
				+"values(?,?,?,?,?,?)");
		pr.setString(1, rd.getName());
		pr.setInt(2, rd.getAge());
		pr.setString(3, rd.getGender());
		pr.setString(4, rd.getFromLocation());
		pr.setString(5, rd.getDestination());
		pr.setString(6, rd.getBookingStatus());
		pr.execute();		
	}
	
	public void changeName(RequiredDetails rd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		PreparedStatement pr = connection.prepareStatement
				("update busBookingApp set name=? where bookingId = ?");
		pr.setString(1, rd.getName());
		pr.setInt(2, rd.getBookingId());
		pr.execute();
	}
	
	public List<RequiredDetails> getAllBooking() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		Statement st = connection.createStatement();
		ResultSet result = st.executeQuery("select * from busBookingApp");
		List<RequiredDetails> list=new ArrayList<RequiredDetails>();
		while(result.next()) {
			RequiredDetails rd= new RequiredDetails();
			rd.setBookingId(result.getInt("bookingId"));
			rd.setName(result.getString("name"));
			rd.setAge(result.getInt("age"));
			rd.setGender(result.getString("gender"));
			rd.setFromLocation(result.getString("fromLocation"));
			rd.setDestination(result.getString("destinaton"));
			rd.setBookingStatus(result.getString("bookingStatus"));
			list.add(rd);	
			
			
		}
		
		System.out.println(list);
		return list;
		
		
	}
	
	
	public void placeChange(RequiredDetails rd) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		PreparedStatement pr = connection.prepareStatement
				("update busBookingApp set fromLocation=?, destinaton = ? where bookingId = ?");
		pr.setString(1, rd.getFromLocation());
		pr.setString(2, rd.getDestination());
		pr.setInt(3, rd.getBookingId());
		pr.execute();
	}
	
	public void status(RequiredDetails rd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		PreparedStatement pr=connection.prepareStatement
				("update busBookingApp set bookingStatus = ? where bookingId = ?");
		pr.setString(1, rd.getBookingStatus());
		pr.setInt(2, rd.getBookingId());
		pr.execute();		
	}
	
	public RequiredDetails getById(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(host,user,password);
		PreparedStatement pr=connection.prepareStatement
				("select * from busBookingApp where bookingId = ?");
		pr.setInt(1, id);
		ResultSet rs= pr.executeQuery();
		rs.next();
		rs.getInt("bookingId");
		rs.getString("name");
		rs.getInt("age");
		rs.getString("gender");
		rs.getString("fromLocation");
		rs.getString("destinaton");
		rs.getString("bookingStatus");
		
		return new RequiredDetails(
				rs.getInt("bookingId"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getString("gender"),
				rs.getString("fromLocation"),
				rs.getString("destinaton"),
				rs.getString("bookingStatus")
				);
		
	}
	
	
	
	
	
	
	
	
	
	

}
