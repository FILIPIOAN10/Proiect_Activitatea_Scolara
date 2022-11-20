package src;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.regex.Pattern;

// Adrian modifications

public class Admin extends User {
    // constructorul adminului
    public Admin(String fullName, String email) {
        super(fullName, email);
        // setez parola
        this.setPassword(Diverse.generatePassword());
        // generez fisierul
        this.generateFileAdmin();
    }

    @Override
    public String getClassUser() {
        return "Admin ";
    }

    //Metoda pentru a genera fisieru
    public void generateFileAdmin() {
        //generez
        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\" +getFullName() + ".txt");

            if (!file.exists()) {

                file.createNewFile();
            }
            FileWriter pw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(pw);
            bf.write("Parola este " + this.getPassword());
            bf.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void generateFileUser(User user) {

        //generez
        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\UseriCreati\\ " +user.getFullName() + ".txt");

            if (!file.exists()) {

                file.createNewFile();
            }
            FileWriter pw = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(pw);
            bf.write("Parola este " + this.getPassword());

            bf.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metoda pentru a genera parola de user  primeste String-ul de username  si obiectul scoala
    //- Userul Admin o sa poata reseta parole, asta inseamna ca o sa primeasca
    //numele de utilizator pentru care trebuie sa reseteze parola si o sa inlocuiasca
    //vechea parola in fisierul userului corespunzator.

    // generez parola pentru userul adaugat
    public void genereazaParolaPentruUser(String username, Scoala scoala) {
        boolean useFound = false;
        //iterez prin lista de useri
        for (User currentUser : scoala.getListaUseri()) {
            // daca userul(string name ) se afla in scoala
            if (currentUser.getUsername().equals(username)) {
                useFound = true;
                // daca userul curent nu are parola sa o genereze
                if (currentUser.getPassword() == null) {
                    String password = Diverse.generatePassword();
                    currentUser.setPassword(password);
                     //generez fisierul cu parola
                    try {
                        File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\UseriCreati\\ " + currentUser.getFullName() + ".txt");
                        if (!file.exists()) {

                            file.createNewFile();
                        }
                        FileWriter pw = new FileWriter(file);
                        BufferedWriter bf = new BufferedWriter(pw);

                        bf.write("Parola este F" + this.getPassword());
                        bf.close();
                        System.out.println("Done");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } else {
                    System.out.println("Userul are o parola nu putem reseta parola ");
                }

            }
            if (!useFound) {
                System.out.println("Nu am gasit user ");
            }
        }
    }

    // metoda pentru a genera fisier lista membri
    public void genereazaFisierListaMembri(Scoala scoala) {
        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\ListaMembri\\ListaMembriiScoala.txt");
            file.createNewFile();
            FileWriter pw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bf = new BufferedWriter(pw);
            StringBuilder text = new StringBuilder();

                  // sa fie pana la ultimul
            for (int i =1; i <scoala.listaUseri.size()+1; i++) {
             // sa adaugam timpul de utilizator
                text.append("Nr. " + i + " " +scoala.listaUseri.get(i-1).getFullName()+ " " +scoala.listaUseri.get(i-1).getClassUser() + "\n" );

            }
            bf.write(text.toString());
//
            // am adaugat lista de useri in fisier
            bf.close();
            System.out.println("S-a creeat fisierul cu lista de membrii ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //- Userul Admin ca putea sterge pe baza numelui de utizator orice membru
    //din lista de membrii din cadrul scolii, asta inseamna ca va sterge si fisierul
    //generat cu parola contului aferent, daca exista
    // metoda pentru  sterge user
    public boolean deleteUser(String username, Scoala scoala) {

        for (User userulCurent : scoala.getListaUseri()) {
            /// iteram prin lista de useri de  la scoala
            if (userulCurent.getUsername().equals(username)) {
                scoala.getListaUseri().remove(userulCurent);
                File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\" + getFullName() + ".txt"
                        + userulCurent.getFullName() + ".txt");
                return file.delete();
            }
        }
        System.out.println("This user was not found in the usersList from this school");
        return false;
    }
    // metoda pentru a sterge fisier

//- Userul Admin ca putea sterge pe baza numelui de utizator orice membru
//din lista de membrii din cadrul scolii, asta inseamna ca va sterge si fisierul
//generat cu parola contului aferent, daca exista

    public void stergeFisier(User user) {
        File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\" + user.getFullName() + ".txt");
        file.delete();
    }


}
