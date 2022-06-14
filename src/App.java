import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		DatabaseManager dbManager = new DatabaseManager();
		Scanner sc = new Scanner(System.in);
		 while(true) {
	         	
         	 System.out.println("Hoþgeldiniz\r\n"
         	 		+ "----------------------------------\r\n"
         	 		+ "\r\n"
         	 		+ "Firma Eklemek için 1'e basýnýz\r\n"
         	 		+ "Otobüs Eklemek için 2'ye basýnýz\r\n"
         	 		+ "Þöfor Eklemek için 3'e basýnýz\r\n"
         	 		+ "Sefer Eklemek için 4'e basýnýz\r\n"
         	 		+ "Bilet Almak için 5'e basýnýz\r\n"
         	 		+ "Daha önce alýnan biletleri listelemek için 6'ya basýnýz\r\n"
         	 		+ "Çýkmak için 7'ya basýnýz\r\n"
         	 		+ "\r\n"
         	 		+ "----------------------------------");
         	 String input = sc.nextLine();
         	 if(input.equals("1")) {
         		 System.out.println("Firma adi: ");
         		 String companyName = sc.nextLine();
         		 System.out.println("Kurucu adi: ");
         		 String founderName = sc.nextLine();
         		 boolean isSuccess =  dbManager.addCompany(companyName, founderName);
         		 if(isSuccess) {
         			 System.out.println("Firma eklendi.");
         		 }
         		 else {
         			 System.out.println("HATA..Firma EKLENMEDI.");
         		 }
         		
         	 }
         	 
         	 
         	 if(input.equals("2")) {
         		 System.out.println("Firmalar: ");
         		 ArrayList<Company>companys = dbManager.getAllCompany();
         		 for(Company c : companys) {
         			 System.out.println("id: " + c.getId() + " name: " + c.getName() + " founder: " + c.getFounder());
         		 }
         		 System.out.println("Firma id giriniz: ");
         		 String companyIdInput = sc.nextLine();
         		 int companyId = Integer.parseInt(companyIdInput);
         		 
         		 System.out.println("Soforler: ");
         		 ArrayList<Driver>drivers = dbManager.getAllDriver();
         		 for(Driver d : drivers) {
         			 System.out.println("id: " + d.getId() + " name: " + d.getName() + " surname: " + d.getSurname() + " age: " + d.getAge());
         		 }
         		 System.out.println("Sofor id giriniz: ");
         		 String driverIdInput = sc.nextLine();
         		 int driverId = Integer.parseInt(driverIdInput);
         		 
         		 System.out.println("Otobus markasi giriniz: ");
         		 String busName = sc.nextLine();
         		 
         		 System.out.println("Otobus kapasitesi giriniz: ");
         		 String capacityInput = sc.nextLine();
         		 int busCapacity = Integer.parseInt(capacityInput);
         		 
         		 boolean isSuccess =  dbManager.addBus(busName, busCapacity,companyId,driverId);
         		 if(isSuccess) {
         			 System.out.println("Otobus eklendi.");
         		 }
         		 else {
         			 System.out.println("HATA..Otobus EKLENMEDI.");
         		 }

         	 }
         	 
  
         	 
         	 if(input.equals("3")) {
         		 System.out.println("Firmalar: ");
         		 ArrayList<Company>companys = dbManager.getAllCompany();
         		 for(Company c : companys) {
         			 System.out.println("id: " + c.getId() + " name: " + c.getName() + " founder: " + c.getFounder());
         		 }
         		 System.out.println("Firma id giriniz: ");
         		 String companyIdInput = sc.nextLine();
         		 int companyId = Integer.parseInt(companyIdInput);
         		 
         		 System.out.println("Sofor adi giriniz: ");
         		 String driverName = sc.nextLine();
         		 
         		 System.out.println("Soforun soyadini giriniz: ");
         		 String driverSurname = sc.nextLine();
         		 
         		 System.out.println("Sofor YAS giriniz: ");
         		 String driverAgeInput = sc.nextLine();
         		 int  driverAge = Integer.parseInt(driverAgeInput);
         		 
         		 boolean isSuccess =  dbManager.addDriver(driverName, driverSurname,driverAge,companyId);
         		 if(isSuccess) {
         			 System.out.println("Sofor eklendi.");
         		 }
         		 else {
         			 System.out.println("HATA..Sofor EKLENMEDI.");
         		 }
         		          		 
         	 }
         	 
         	 
         	if(input.equals("4")) {
         		System.out.println("Otobusler: ");
        		 ArrayList<Bus>buses = dbManager.getAllBus();
        		 for(Bus b : buses) {
        			 System.out.println("id: " + b.getId() + " name: " + b.getName());
        		 }
        		 System.out.println("Otobus id giriniz: ");
        		 String busIdInput = sc.nextLine();
        		 int busId = Integer.parseInt(busIdInput);
         		
        		 System.out.println("Nerden: ");
        		 String where = sc.nextLine();
        		 
        		 System.out.println("Nereye: ");
        		 String to = sc.nextLine();
        		 
        		 System.out.println("Hareket tarihi: ");
        		 String move = sc.nextLine();
        		 
        		 boolean isSuccess =  dbManager.addJourney(where,to,move,busId);
         		 if(isSuccess) {
         			 System.out.println("Sefer eklendi.");
         		 }
         		 else {
         			 System.out.println("HATA..Sefer EKLENMEDI.");
         		 }
        		 
         	}
         	
         if(input.equals("5")) {
        	 
        	 System.out.println("Seferler: ");
     		 ArrayList<Journey>journeys = dbManager.getAllJourney();
     		 for(Journey j : journeys) {
     			 System.out.println("id: " + j.getId() + " nerden: " + j.getWhere() + " nereye: " + j.getTo() + " ne zaman: " + j.getWhen());
     		 }
     		 System.out.println("Sefer id giriniz: ");
     		 String journeyIdInput = sc.nextLine();
     		 int journeyId = Integer.parseInt(journeyIdInput);
     		 
     		 System.out.println("adinizi giriniz: ");
     		 String passengerName = sc.nextLine();
     		 
     		 System.out.println("soyadinizi giriniz: ");
     		 String passengerSurname = sc.nextLine();
     		 
     		 System.out.println("cinsiyet giriniz: ");
     		 String passengerGender = sc.nextLine();
        	 Journey journeyDetail = dbManager.getJourneyWithBusInfo(journeyId);
     		 int ticketCount =  dbManager.getJourneyTicketCount(journeyId);
        			if(ticketCount == journeyDetail.getBus().getCapacity()) {
        				System.out.println("Otobus DOLU !!!!");
        			}
        			else {
        				 boolean isSuccess =  dbManager.addPassenger(passengerName,passengerSurname,passengerGender,journeyId);
        	     		 if(isSuccess) {
        	     			 System.out.println("bilet alindi IYI YOLCULUKLAR...");
        	     		 }
        	     		 else {
        	     			 System.out.println("HATA..bilet alinamadi...");
        	     		 }
        			}
     		
        	 
         }
         
         
        if(input.equals("6")) {
        dbManager.getTicketInfo();
        }
        
        
        if(input.equals("7")) {
        	System.out.println("Sistemden cikiliyor...");
        	System.exit(0);
        }
		
	}

}
}
