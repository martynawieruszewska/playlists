public class ZarzadzaniePlaylistami {

	public static void main(String[] args) {
		
		Playlista rock = new Playlista("Rock", 15);
		Playlista pop = new Playlista("Pop");
		
		rock.wyswietlUtowry();
        pop.usunUtwor(4);
        rock.pobierzUtwor(3);

        rock.dodajUtwor("");

        rock.dodajUtwor("Smoke on the water");
        rock.dodajUtwor("Have you ever seen the rain?");
        rock.dodajUtwor("Fortunate Son");

        pop.dodajUtwor("Jutro");
        pop.dodajUtwor("Kalejdoskop Szczęścia");
        pop.dodajUtwor("What are you waiting for?");

        rock.wyswietlUtowry();
        pop.wyswietlUtowry();

        String utwor = pop.usunUtwor(2);
        System.out.println("usunięto: " + utwor);
        pop.wyswietlUtowry();
        pop.dodajUtwor(utwor);
        pop.wyswietlUtowry();

        rock.posortujUtwory();
        rock.wyswietlUtowry();

        rock.dodajUtwor(pop.pobierzUtwor(2));
        rock.wyswietlUtowry();
		
	}

}
