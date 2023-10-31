import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Client {
    private String name;
    private String surname;
    private int age;
    private int phoneNumber;
    private String email;

    public Client(){}

    public Client(String name, String surname, int age, int phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private void printInfo(){
        System.out.print(
                "Nom: " + getName() + "\n" +
                "Cognom: " + getSurname() + "\n" +
                "Edat: " + getAge() + "\n" +
                "Teléfon: " + getPhoneNumber() + "\n" +
                "Email: " + getEmail()
        );
    }

    public static ArrayList<Client> readClientsFromFile(File file) {
        ArrayList<Client> result = new ArrayList<>();
        Client client = new Client();
        try (FileReader fileReader = new FileReader(file)) {
            StringBuilder lineMark = new StringBuilder();
            StringBuilder lineProp = new StringBuilder();
            boolean readingMark = true;
            int charValue;

            while ((charValue = fileReader.read()) != -1) {
                char c = (char) charValue;

                if (c == '['){
                    readingMark = true;
                } else if (c == ']') {
                    readingMark = false;
                    lineMark.append(c);
                } else {
                    lineProp.append(c);
                }

                if (readingMark){
                    lineMark.append(c);
                    continue;
                }

                if (c == '\n'){
                    if (lineMark.toString().equals("[INICI_FITXER]"))
                    {
                        lineMark.setLength(0);
                    }
                    lineProp.setLength(0);
                    readingMark = false;
                    continue;
                }

                switch (lineMark.toString()){
                    case "[INICI_FITXER]":
                        System.out.println("Inicio de lectura");
                        break;
                    case "[NOM]":
                        client.setName(lineProp.toString());
                        lineMark.setLength(0);
                        lineProp.setLength(0);
                        break;
                    case "[COGNOM]":
                        client.setName(lineProp.toString());
                        lineMark.setLength(0);
                        lineProp.setLength(0);
                        break;
                    case "[EDAT]":
                        client.setName(lineProp.toString());
                        lineMark.setLength(0);
                        lineProp.setLength(0);
                        break;
                    case "[TELÈFON]":
                        client.setName(lineProp.toString());
                        lineMark.setLength(0);
                        lineProp.setLength(0);
                        break;
                    case "[EMAIL]":
                        client.setName(lineProp.toString());
                        lineMark.setLength(0);
                        lineProp.setLength(0);
                        result.add(client);
                        break;
                    case "[FI_FITXER]":
                        return result;
                    default:

                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
