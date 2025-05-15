public class Book {
    private String title;
    private int price;

    public Book (String t, int p) {
        title = t;
        price = p;
    }

    public String toString() {
        return title + " [" + price + " zł]";
    }
}

