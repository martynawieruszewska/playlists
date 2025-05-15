
public class ZarzadzaniePlaylistami {

	public static void main(String[] args) {
		
		//utworzy� dwa obiekty playlist (o nazwach np. Rock i Pop),
		Playlista rock = new Playlista("Rock");
		Playlista pop = new Playlista("Pop");
		
		//doda� co najmniej klika utwor�w do ka�dej z playlist,
		rock.dodajUtwor("Show must go on");
		rock.dodajUtwor("Moskau");
		rock.dodajUtwor("Innuendo");
		
		pop.dodajUtwor("Thriller");
		pop.dodajUtwor("Lucky");
		pop.dodajUtwor("Roar");
		
		//wy�wietli� zawarto�� obu playlist,
		rock.wyswietlPlayliste();
		pop.wyswietlPlayliste();
		
		//posortowa� zawarto�� obu playlist,
		rock.sortuj();
		pop.sortuj();
		
		//ponownie wy�wietli� zawarto�� obu playlist,
		rock.wyswietlPlayliste();
		pop.wyswietlPlayliste();
		
		//usun�� wybrany utw�r z jednej z playlist,
		pop.usunUtwor(2);
		
		//wy�wietli� zawarto�� zmienionej playlisty,
		pop.wyswietlPlayliste();
		
		//kopiowa� wybrany utw�r z jednej playlisty do drugiej,
		pop.dodajUtwor(rock.podajNazweUtworu(1));
		
		//wy�wietli� zawarto�� zmienionej playlisty,
		pop.wyswietlPlayliste();
		
		//posortowa� zmienion� playlist� i zn�w wy�wietli� jej zawasto��.
		pop.sortuj();
		pop.wyswietlPlayliste();
		
	}

}
