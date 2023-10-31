import java.io.File;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File file = new File( "C:\\Users\\alumnat\\Desktop\\files\\elyoya.txt");

        ArrayList<Client> clients = Client.readClientsFromFile(file);

    }
}