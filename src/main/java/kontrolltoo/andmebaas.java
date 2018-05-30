package kontrolltoo;
import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class andmebaas{
	@RequestMapping("/lisamine")
    String lisamine(String a, double b, double c, double d)  throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_rootkris?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO toiduaine VALUES(?, ?, ?, ?)");
		st.setString(1, a);
		st.setDouble(2, b);
		st.setDouble(3, c);
		st.setDouble(4, d);
		st.executeUpdate();
		return "Andmebaasi on lisatud toiduaine: "+a+" Valk: "+b+" Rasv: "+c+" Süsivesik: "+d;
		
    }
	
	
	
	@RequestMapping("/kustutamine")
	String kustutamine(String nimetus)  throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_rootkris?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("DELETE FROM toiduaine WHERE nimetus=?");
		st.setString(1, nimetus);
		st.executeUpdate();
		return "Andmebaasist on eemaldatud toiduaine nimega: "+nimetus;
	}
	
	@RequestMapping("/vaataAndmeid")
    String vaata(String nimetus)  throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_rootkris?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("SELECT FROM toiduaine WHERE nimetus=?");
		st.setString(1, nimetus);
		ResultSet rs = st.executeQuery();
		return "Andmebaasist toiduaine nimega "+nimetus+" andmed: Valk: "+rs.getDouble("valk")+" Rasv: "+rs.getDouble("rasv")+" Süsivesik: "+rs.getDouble("süsivesik");
	}
	
	@RequestMapping("/otsiRasvaj2rgi")
	String otsiRasv(double a, double b)  throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_rootkris?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("SELECT FROM toiduaine WHERE rasv BETWEEN ? AND ?");
		st.setDouble(1, a);
		st.setDouble(2, b);
		ResultSet rs = st.executeQuery();
		String tekst = " ";
		while (rs.next()){
			tekst+= rs.getString("nimetus");
		}
		return tekst;
	}
}
	