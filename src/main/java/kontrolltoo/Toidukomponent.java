package kontrolltoo;
public class Toidukomponent{
	double kogus;
	Toiduaine toidukomp;
	
	public Toidukomponent(Toiduaine toidukomp, double kogus){
		this.toidukomp = toidukomp;
		this.kogus = kogus;
	}
	
	
	public double ToidukomponendiRasv(){
		return kogus*toidukomp.rasv/100;
	}
	public double ToidukomponendiValk(){
		return kogus*toidukomp.valk/100;
	}
	public double ToidukomponendiSüsivesik(){
		return kogus*toidukomp.süsivesik/100;
	}
}