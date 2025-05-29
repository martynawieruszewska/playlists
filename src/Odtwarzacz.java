import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Odtwarzacz {

    private HashMap<String, Playlista> lista;
    private Scanner sc;

    public Odtwarzacz() {
        lista = new HashMap<>();

		try {
			lista.put("rock", new Playlista("rock"));
        	lista.put("pop", new Playlista("pop"));
			init();
		} catch(Exception e)

        sc = new Scanner(System.in);

        init();
    }

    private void init() {
		lista.get("rock").dodajUtwor(new Utwor("Smoke on the Water", "Deep Purple", 1972));
		lista.get("rock").dodajUtwor(new Utwor("Child in Time", "Deep Purple", 1970));
		lista.get("rock").dodajUtwor(new Utwor("Fortunate Son", "CCR", 1969));
		lista.get("rock").dodajUtwor(new Utwor("Have You Ever Seen The Rain?", "CCR", 1970));
		lista.get("rock").dodajUtwor(new Utwor("Fear of the Dark", "Iron Maiden", 1992));
		lista.get("rock").dodajUtwor(new Utwor("Aces High", "Iron Maiden", 1984));
		lista.get("rock").dodajUtwor(new Utwor("The Trooper", "Iron Maiden", 1983));
		
		lista.get("pop").dodajUtwor(new Utwor("Tylko z Tobą Chcę Być Sobą", "Łukasz Zagrobelny", 2014));
		lista.get("pop").dodajUtwor(new Utwor("Love Me Like You Do", "Ellie Goulding", 2014));
		lista.get("pop").dodajUtwor(new Utwor("Jutro", "LemON", 2014));
		lista.get("pop").dodajUtwor(new Utwor("Cool Kids", "Echosmith", 2013));
		lista.get("pop").dodajUtwor(new Utwor("Perdoname (feat. Adrian Delgado & DyCy)", "Deorro", 2014));
		lista.get("pop").dodajUtwor(new Utwor("What are you waiting for", "Nickelback", 2014));
		lista.get("pop").dodajUtwor(new Utwor("Lips Are Movin'", "Meghan Trainor", 2015));
		lista.get("pop").dodajUtwor(new Utwor("Kalejdoskop szczęścia", "Andrzej Piaseczny", 2015));
	}

	public void wlacz() {
		Playlista p, p1, p2;
		while (true) {
			 System.out.println("Co chcesz zrobić? Wybierz opcję:");
			 System.out.println("\t  (0) wyświetlić wszystkie playlisty");
			 System.out.println("\t  (1) dodać nową playlistę");
			 System.out.println("\t  (2) wyświetlić nową playlistę");
			 System.out.println("\t  (3) posortować playlistę");
			 System.out.println("\t  (4)  usunąć playlistę");
			 System.out.println("\t  (5) dodać nowy utwór");
			 System.out.println("\t  (6) przenieść utwór");
			 System.out.println("\t  (7) skopiować utwór");
			 System.out.println("\t  (8) skasować utwór");
			 System.out.println("\t  (9) wyłączyć odtwarzacz");
			 System.out.println("\t  (10) zapis do pliku");
			 System.out.println("\t  (11) odczyt pliku");
			byte option = sc.nextByte();
			sc.nextLine();

			switch(option) {
				case 0:
					for(String nazwa : lista.keySet()) {
						System.out.println(nazwa);
					}
					break;
				case 1:
					System.out.println("Podaj nazwę playlisty");
					String nazwa = sc.nextLine();
					p = new Playlista(nazwa);
					lista.put(nazwa, p);
					System.out.println("Dodano nową playlistę: " + nazwa);
					break;
				case 2:
					p = wybierzPlayliste();
					if(p != null) {
						p.wyswietlUtwory();
					}
					break;
				case 3:
					p = wybierzPlayliste();
					if(p != null) {
						p.posortujUtwory();
						System.out.println("Posortowano playlistę");
						p.wyswietlUtwory();
					}
					break;
				case 4:
					p = wybierzPlayliste();
					if( p!= null){
						lista.remove(p.getNazwa());
						System.out.println("Usunięto playlistę: " + p.getNazwa);
					}
					break;
				case 5:
					p = wybierzPlayliste();
					if(p != null) {
						System.out.println("Podaj tytuł");
						String t = sc.nextLine();
						System.out.println("Podaj wykonwacę");
						String w = sc.nextLine();
						System.out.println("Podaj rok wydania");
						int r = sc.nextInt();
						
						Utwor u = new Utwor(t, w, r);
						p.podajUtwor(u);
						System.out.println("Dodano utwór: " + u);
						p.wyswietllUtwory();

					}

					break;
				case 6:
					System.out.println("wskaz playlistę źródłową");
					p1 = wybierzPlayliste();
					System.out.println("Wskaz playlistę docelową");
					p2 = wybierzPlayliste();
					if(p1 != null && p2 != null) {
						p1.wyswietlUtwory();
						System.out.println("Który utwór chcesz przenieść?");
						byte numer = sc.nextByte();
						Utwor u = p1.usunUtwor(numer);
						if (u != null) {
							p2.dodajUtwor(u);
							System.out.println("Przeniesiono utwor: " + u);
						}
					}
					break;
				case 7:
					System.out.println("wskaz playlistę źródłową");
					p1 = wybierzPlayliste();
					System.out.println("Wskaz playlistę docelową");
					p2 = wybierzPlayliste();
					if(p1 != null && p2 != null) {
						p1.wyswietlUtwory();
						System.out.println("Który utwór chcesz skopiować?");
						byte numer = sc.nextByte();
						Utwor u = p1.pobierzUtwor(numer);
						if (u != null) {
							p2.dodajUtwor(u);
							System.out.println("Skopiowano utwor: " + u);
					break;
				case 8:
					p = wybierzPlayliste();
					if(p != null) {
						p.wyswietlUtwory();
						System.out.println("Który utwór chcesz usunąć?");
						byte index = sc.nextByte();
						Utwor u = p.usunUtwor(index);
						System.out.println("Usunięto utwór: " + u);
					}
					break;
				case 9:
					return;
				case 10:
					p = wybierzPlayliste();
					System.out.println("Podaj plik docelowy");
					String nazwa_pliku = sc.nextLine();
					p.saveToFile(new File(nazwa_pliku));
					break;
				case 11:
					System.out.println("Podaj plik zródłowy");
					String plik_zrodlowy = sc.nextLine();
					p = Playlista.readFromFile(new File(plik_zrodlowy));
					lista.put(p.getNazwa(), p);
					break;
				default:
					System.err.println("Nie ma takiej opcji!");
					break;

			}
		}
	}

	public Playlista wybierzPlayliste() {
		System.out.println("Której playlisty chcesz uzyc?");
		for (String nazwa : lista.keySet()) {
			System.out.println("\t(" + nazwa + ")");
		}
		Strin wybor = sc.nextLine();
		return lista.get(wybor);
	}


    public static void main(String[] args) {
		Odtwarzacz o = new Odtwarzacz();
		o.wlacz();
		System.out.println("KONIEC");

    }
    
}
