import java.util.Arrays;

public class Playlista {
	String name;
	String[] listaUtworow;
	int ileUtworow;
	
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
		Arrays.sort(listaUtworow, 0, ileUtworow);
	}
	
	public String getNazwa(){
		return name;
	}
}