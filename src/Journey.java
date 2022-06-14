
public class Journey {

	private int id;
	private String where;
	private String to;
	private String when;
	private int bus_id;
	private Bus bus;
	
	public Journey(int id, String where, String to, String when, Bus bus) {
		this.id = id;
		this.where = where;
		this.to = to;
		this.when = when;
		this.setBus(bus);
	}
	
	public Journey(int id, String where, String to, String when, int bus_id) {
		this.id = id;
		this.where = where;
		this.to = to;
		this.when = when;
		this.bus_id = bus_id;
	}
	public Journey() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
