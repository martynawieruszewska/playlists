import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Playlista {
	//prywatne atrybuty nazwy playlisty i listy utwor�w (na razie ka�dy utw�r to tekst - tytu� utworu);
	private String nazwa;
	private List<String> utwory;
	
	//konstruktor umo�liwiaj�cy podanie nazwy playlisty,	
	public Playlista(String nazwa) {
		super();
		this.nazwa = nazwa;
		utwory = new LinkedList<String>();
	}
	
	//dodawanie utwor�w do playlisty (z odpowiednim komunikatem w przypadku pr�by dodania utworu o pustej nazwie)
	public void dodajUtwor(String utwor) {
		if(utwor==null || utwor.trim().equals("")) {
			System.err.println("Nazwa utworu nie mo�e by� pusta");
		}else {
			utwory.add(utwor);
		}
	}
	
	//pobieranie nazwy wskazanego utworu z listy -- utw�r wskazujemy podaj�c jego numer na li�cie;
	public String podajNazweUtworu(int numer) {
		return utwory.get(numer-1);		
	}
	
	//wy�wietlanie na konsoli zawarto�ci listy (z odpowiednim komunikatem w przypadku gdy lista jest pusta);
	public void wyswietlPlayliste() {
		if(utwory.size()==0) {
			System.out.println("Playlista "+nazwa+" jest pusta!");
		}else {
			System.out.println("------"+nazwa+"------");
			for(int i = 0; i<utwory.size();i++) {
				System.out.println((i+1)+". "+utwory.get(i));
			}			 
		}
	}
	
	//kasowanie wybranego utworu z listy -- utw�r wskazujemy podaj�c jego numer na li�cie; 
	public void usunUtwor(int numer) {
		utwory.remove(numer-1);
	}	
	
	//alfabetyczne sortowanie utwor�w na liscie.
	public void sortuj() {
		Collections.sort(utwory);
	}	

	public Strin getNazwa //  dokonczyc????
}