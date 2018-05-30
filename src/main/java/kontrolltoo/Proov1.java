package kontrolltoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

public class Proov1{
	public static void main(String[]args) throws Exception{
		Toiduaine ta1 = new Toiduaine("Kartul", 50, 20, 30);
		System.out.println(ta1);
		Toidukomponent tk1 = new Toidukomponent(ta1, 100);
		double tekst = tk1.ToidukomponendiRasv();
		System.out.println("Rasva kogus on "+tekst+"g");
		Toiduaine ta2 = new Toiduaine("Sibul", 50, 50, 50);
		System.out.println(ta2);
		
		System.getProperties().put("server.port", 40328);
        SpringApplication.run(andmebaas.class, args);
	}
}