import java.util.HashMap;

public class Library {

    public static void main(String[] args) {
        HashMap<String, Book>biblioteka;
        biblioteka = new HashMap<>();

        Book b1 = new Book("Makroekonomia", 44);
        Book b2 = new Book("Programowanie 1", 22);
        Book b3 = new Book("Władca Pierścieni", 77);

        biblioteka.put("moja ulubiona ksiązka", b1);
        biblioteka.put("inna ksiązka", b2);
        biblioteka.put("najlepsza ksiązka", b3);

        Book b = biblioteka.get("moja ulubiona ksiązka");
        System.out.println("moja ulubiona ksiązka to: " + b);

        System.out.println("zawartość biblioteki:");
        for (String klucz : biblioteka.keySet()) {
            Book someBook = biblioteka.get(klucz);
            System.out.println(klucz + " => " + someBook);
        }
    }

}