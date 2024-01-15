package businessBuergeramt;

import java.util.ArrayList;

public class Buergeramt {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float geoeffnetVon;
    private float geoeffnetBis;
    // Strasse und Hausnummer des Buergeramtes
    private String strasseHNr;
    // Dienstleistungen des Buergeramtes
    private ArrayList<String> dienstleistungen;

    public Buergeramt(String name, float geoeffnetVon, float geoeffnetBis,
    	String strasseHNr, String[] dienstleistungen){
    	
    	if(dienstleistungen == null) {
    		throw new IllegalArgumentException();
    	}
    	
   		this.name = name;
  	    this.geoeffnetVon = geoeffnetVon;
   	    this.geoeffnetBis = geoeffnetBis;
   	    this.strasseHNr = strasseHNr;
   	    this.dienstleistungen = arrayToList(dienstleistungen);
    }
    
    public ArrayList<String> arrayToList(String[] arr) {
    	ArrayList<String> aList = new ArrayList<String>();
    	for(int i = 0; i < arr.length; i++) {
    		aList.add(arr[i]);
    	}
    	return aList;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGeoeffnetVon() {
		return geoeffnetVon;
	}

	public void setGeoeffnetVon(float geoeffnetVon) {
		this.geoeffnetVon = geoeffnetVon;
	}

	public float getGeoeffnetBis() {
		return geoeffnetBis;
	}

	public void setGeoeffnetBis(float geoeffnetBis) {
		this.geoeffnetBis = geoeffnetBis;
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public ArrayList<String> getDienstleistungen() {
		return dienstleistungen;
	}

	public void setDienstleistungen(ArrayList<String> dienstleistungen) {
		this.dienstleistungen = dienstleistungen;
	}
	
	public String getDienstleistungenAlsString(char trenner) {
		String ergebnis = "";

		for(String d : dienstleistungen) {
			ergebnis = ergebnis + d + trenner; 
		}
		return ergebnis;
	}
	
	public String gibBuergeramtZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getGeoeffnetVon() + trenner
  		    + this.getGeoeffnetBis() + trenner
  		    + this.getStrasseHNr() + trenner + "\n"
  		    + this.getDienstleistungenAlsString(trenner) + "\n";
  	}
}

