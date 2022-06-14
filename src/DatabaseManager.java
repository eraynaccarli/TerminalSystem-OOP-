import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {
	private Connection connection;
	public DatabaseManager() throws SQLException, ClassNotFoundException {
	
		this.connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/terminal_system","root", "eray123");
	}
	public Connection getConnection() {
		return connection;
	}
	
	public boolean addCompany(String name,String founder) throws SQLException {
		String query = "INSERT INTO company (name,founder) VALUES(?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, founder);
		int  addedRecordCount = ps.executeUpdate();
		if(addedRecordCount > 0) {
			return true;
		}
		return false;
		
	}
	
	
	public ArrayList<Company> getAllCompany() throws SQLException{
		ArrayList<Company> companys = new ArrayList<Company>();
		String query = "SELECT * FROM COMPANY";
		Statement st  = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String founder = rs.getString("founder");
		Company c = new Company(id,name,founder);
		companys.add(c);
		}
		return companys;
	}
	
	public boolean addDriver(String name,String surname,int age, int company_id) throws SQLException {
		String query = "INSERT INTO driver (name,surname,age,company_id) VALUES(?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, surname);
		ps.setInt(3, age);
		ps.setInt(4, company_id);
		int  addedRecordCount = ps.executeUpdate();
		if(addedRecordCount > 0) {
			return true;
		}
		return false;
		
	}
	
	public ArrayList<Driver> getAllDriver() throws SQLException{
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		String query = "SELECT * FROM driver";
		Statement st  = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		int age = rs.getInt("age");
		int company_id = rs.getInt("company_id");
		Driver d = new Driver(id,name,surname,age,company_id);
		drivers.add(d);
		}
		return drivers;
	}
	
	public boolean addBus(String name,int capacity,int company_id, int driver_id) throws SQLException {
		String query = "INSERT INTO bus (name,capacity,company_id,driver_id) VALUES(?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, capacity);
		ps.setInt(3, company_id);
		ps.setInt(4, driver_id);
		int  addedRecordCount = ps.executeUpdate();
		if(addedRecordCount > 0) {
			return true;
		}
		return false;
		
	}
	
	public ArrayList<Bus> getAllBus() throws SQLException{
		ArrayList<Bus> buses = new ArrayList<Bus>();
		String query = "SELECT * FROM bus";
		Statement st  = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int capacity = rs.getInt("capacity");
		int company_id = rs.getInt("company_id");
		int driver_id = rs.getInt("driver_id");
		Bus b = new Bus(id,name,capacity,company_id,driver_id);
		buses.add(b);
		}
		return buses;
	}
	
	
	public boolean addJourney(String where,String to,String move, int bus_id) throws SQLException {
		String query = "INSERT INTO journey (nerden,nereye,nezaman,bus_id) VALUES(?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, where);
		ps.setString(2, to);
		ps.setString(3, move);
		ps.setInt(4, bus_id);
		int  addedRecordCount = ps.executeUpdate();
		if(addedRecordCount > 0) {
			return true;
		}
		return false;
		
	}
	
	
	public ArrayList<Journey> getAllJourney() throws SQLException{
		ArrayList<Journey> journeys = new ArrayList<Journey>();
		String query = "SELECT * FROM journey";
		Statement st  = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("id");
		String where = rs.getString("nerden");
		String to = rs.getString("nereye");
		String when = rs.getString("nezaman");
		int bus_id = rs.getInt("bus_id");
		Journey j = new Journey(id,where,to,when,bus_id);
		journeys.add(j);
		}
		return journeys;
	}
	public Journey getJourneyWithBusInfo(int journey_id) throws SQLException {
		String query = "SELECT * FROM journey WHERE id = " + "INNER JOIN bus ON bus.id = journey.bus_id";
		Statement s = this.connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		int id = rs.getInt("id");
		String where = rs.getString("nerden");
		String to = rs.getString("nereye");
		String when = rs.getString("nezaman");
		int bus_id = rs.getInt("bus_id");
		Journey j = new Journey(id,where,to,when,bus_id);
	
		int busId = rs.getInt("id");
		String busName = rs.getString("name");
		int capacity = rs.getInt("capacity");
		int company_id = rs.getInt("company_id");
		int driver_id = rs.getInt("driver_id");
		Bus b = new Bus(busId,busName,capacity,company_id,driver_id);
		j.setBus(b);
		return j;
	}
	public int getJourneyTicketCount(int journey_id) throws SQLException {
		String query = "SELECT COUNT(*) as ticket_count FROM journey WHERE id = " + journey_id + " INNER JOIN bus ON bus.id = journey.bus_id";
		Statement s = this.connection.createStatement();
		ResultSet rs = s.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	
	
	public boolean addPassenger(String name,String surname,String gender, int journey_id) throws SQLException {
		String query = "INSERT INTO passenger (name,surname,gender,journey_id) VALUES(?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, surname);
		ps.setString(3, gender);
		ps.setInt(4, journey_id);
		int  addedRecordCount = ps.executeUpdate();
		if(addedRecordCount > 0) {
			return true;
		}
		return false;
		
	}
	
	public ArrayList<Passenger> getAllPassenger() throws SQLException{
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		String query = "SELECT * FROM passenger";
		Statement st  = this.connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String gender = rs.getString("gender");
		int journey_id = rs.getInt("journey_id");
		Passenger p = new Passenger(id,name,surname,gender,journey_id);
		passengers.add(p);
		}
		return passengers;
	}
	
	
	
	public void getTicketInfo() throws SQLException{
		String query = "SELECT p.name,p.surname,j.nerden,j.nereye,j.nezaman,b.name as bus,c.name as company  FROM"
				+ " journey j INNER JOIN passenger p ON j.id = p.journey_id"
				+ "			INNER JOIN bus b ON b.id = j.bus_id"
				+ "            INNER JOIN company c ON c.id = b.company_id";
		PreparedStatement st  =  this.connection.prepareStatement(query);
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
		String passengerName = rs.getString(1);
		String passengerSurname = rs.getString(2);
		String where = rs.getString(3);
		String to = rs.getString(4);
		String when = rs.getString(5);
		String busName = rs.getString(6);
		String companyName = rs.getString(7);
		System.out.println("Yolcu adi: " + passengerName + " Yolcu Soyadi: " + passengerSurname + " Nereden: " + where + " Nereye: " + to + " Tarih: " + when + " Otobus markasi: " + busName + " Sirket ismi: " + companyName);
		}

	}
	
}
