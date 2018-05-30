package kontrolltoo;
public class Toiduaine{
	String nimetus;
	double valk;
	double rasv;
	double süsivesik;
	double protsentKokku;
	
	public Toiduaine(String nimetus, double valk, double rasv, double süsivesik){
		
		protsentKokku = valk + rasv + süsivesik;
		if(protsentKokku>100){
		System.out.println("Protsent kokku ei saa ületada 100% Muuda toiduaine kogust.");
		protsentKokku = 0;
		}else{
			this.nimetus = nimetus;
			this.valk = valk;
			this.rasv = rasv;
			this.süsivesik = süsivesik;
		}
		
	}
	
	    @Override
    public String toString(){
        return nimetus+", "+" Valk: "+valk+" % "+" Rasv:  "+rasv+" % "+" Süsivesik: "+süsivesik+" % "+" ProtsentKokku "+protsentKokku+" % ";
    }
	
}