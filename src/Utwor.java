package pl.poznan.ue.kti.pki.player;

public class Utwor implements Comparable<Utwor>{
	private String tytul;
	private String wykonawca;
	private int rokWydania;
	
	public Utwor(String tytul, String wykonawca, int rokWydania) {
		this.tytul = tytul;
		this.wykonawca = wykonawca;
		this.rokWydania = rokWydania;
	}

	public String getTytul() {
		return tytul;
	}

	public String getWykonawca() {
		return wykonawca;
	}

	public int getRokWydania() {
		return rokWydania;
	}

	@Override
	public String toString() {
		return getTytul() + " ("
                + getWykonawca() + ") ["
                + getRokWydania() + "]";
    	}

	@Override
	public int compareTo(Utwor o) {
		Utwor u = (Utwor) o;
        return this.getTytul().compareTo(u.getTytul());
	}

    public String serialize() {
        return getTytul()+"|"+getWykonawca()+"|"+getRokWydania();
    }

    public static Utwor deserialize(String line) {
        String[] tb = line.split("\\|");
        Utwor u = new Utwor(tb[0], tb[1], Integer.parseInt(tb[2]));
        return u;
    }
}