import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Playlista {
	int ileUtworow;
	String nazwa;
	ArrayList<Utwor> listaUtworow;
	
	public Playlista(String nazwa, int dlugosc) {
		name = nazwa;
		ileUtworow = 0;
		listaUtworow = new String[dlugosc];
	}
	
	public void dodajUtwor(String nazwaUtworu) {
		if(nazwaUtworu==null || nazwaUtworu.trim().isEmpty()) {
			System.out.println("Nie mozesz dodac pustego utworu");
			return;
		}
		if (ileUtworow >= listaUtworow.length) {
			System.out.println("Nie mozesz dodac więcej utworów");
			return;
		}
		listaUtworow[ileUtworow++] = nazwaUtworu;
	}

	public String usunUtwor(int indeksUtworu) {
		if (indeksUtworu < 1 || indeksUtworu > ileUtworow) {
			System.out.println("Nie ma takiego utworu");
			return null;
		}
		String nazwaUtworu = listaUtworow[indeksUtworu - 1];
		listaUtworow[indeksUtworu - 1] = null;

		for(int i = indeksUtworu - 1; i < ileUtworow - 1; i++) {
			listaUtworow[i] = listaUtworow[i + 1];
		}

	listaUtworow[ileUtworow - 1] = null;
	ileUtworow--;

	return nazwaUtworu;
	}
	
	public String pobierzUtwor(int indeksUtworu) {
		if (indeksUtworu < 1 || indeksUtworu > ileUtworow) {
			System.out.println("Nie ma takiego utworu");
			return null;
		}
		return listaUtworow[indeksUtworu - 1];		
	}
	
	public void wyswietlUtwory() {
		if(ileUtworow == 0) {
			System.out.println("Nie ma utworów na tej playliście");
			return;
		}
		System.out.println(this.name + " lista utworów:");
		for(int i = 0; i < ileUtworow; i++) {
			System.out.println((i+1) + ". " + listaUtworow[i]);
		}
	}

	public void posorujUtwory() {
		Arrays.sort(listaUtworow, w);
	}
	
	public String getNazwa(){
		return nazwa;
	}

	public void saveToFile() throws Eception {
		BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
		bfw.write(this.getNazwa());
		bfw.newLine();
		for(Utwor u : listaUtworow) {
			bfw.write(u.serialize());
			bfw.newLine();
		}
		bfw.close();
	}
	public static Playlista readFromFile(file F) throws Exception {
		BufferedReader bfr = new BufferedReader(new FileReader(F));
		String line;
		Playlista p = null;
		while((line = bfr.readLine()) != null) {
			if(p == null) {
				p = new Playlista(line);
			} else {
				p.dodajUtwor(Utwor.deserialize(line)); 
			}
		}
		bfr.close();
		return p;

	}
}