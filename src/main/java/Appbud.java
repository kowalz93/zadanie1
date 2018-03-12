import java.io.*;
import java.util.Scanner;

/**
 * Created by Marcin on 04.10.2017.
 */

public class Appbud {

    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        //    new Appbud().run(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));

        Appbud appbud = new Appbud(); // można też w taki sposób
        appbud.run(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));

        //  BufferdReader -Operacje na strumieniu stają się buforowane. W większości przypadków skutkuje to znaczącym
        // wzrostem efektywności. Zamiast wykonywać wiele drobnych operacji na strumieniu, np. wiele razy
        // odczytywać/zapisywać z pliku dyskowego małe porcje danych. Dekorator odczytuje większą porcję na
        // zapas lub zapamiętuje dane, które mają być wysłane do strumienia dopóki nie uzbiera się ich
        // dostateczna ilość. Jeżeli dane powinny być wysłane do strumienia niezwłocznie, niezależnie od tego,
        // czy bufor jest pełen czy nie,można to wymusić wywołując metodę flush(). Zazwyczaj bufor jest opróżniany
        // również w momencie wywołania metody close().
    }

    public void run(BufferedReader in, PrintWriter out) throws IOException {
//         // musze przetestować BufferedReader in, PrintWriter out
//

        out.println("Hej zaczynamy. Podaj plik do zczytania. ");
        System.out.println("asda");

        try{
            String read = in.readLine();
            FileReaderHelper fileReaderHelper = new FileReaderHelper();
            String readedFile = fileReaderHelper.readFileContentFromClasspath(read);
            String fileWithoutSpaces = fileReaderHelper.deleteFileWhiteSpaces(readedFile);
            out.println(readedFile);
            out.println(fileWithoutSpaces);
        }catch(Exception e){
            //obsluga gdy uzytkownik wpisze zly typ
            e.printStackTrace();
        }
        System.out.println();

    }




    public void sum(int a, int b, PrintWriter out) {
        out.println(a+b);
    }
}
