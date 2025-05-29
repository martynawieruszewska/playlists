import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class FileSaver {
    public static void main(String[] args) {
        String nazwa_pliku = "plik.txt";

    try {
        FileWriter zapisywacz = new FileWriter(nazwa_pliku);
        BufferedWriter bufor = new BufferedWriter(zapisywacz);

        bufor.write("tekst");
        bufor.newLine();
        bufor.write("drugi tekst");
        bufor.write("trzeci tekst");

        bufor.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
   }
}