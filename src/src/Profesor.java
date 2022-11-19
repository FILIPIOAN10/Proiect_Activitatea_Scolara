package src;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor extends User {


    enum TipProfesor {
        SCOALA_PRIMARA("Primara"),
        SCOALA_GIMNAZIALA("Gimnaziala"),
        LICEU("Liceu");

        private String tipProfesor;

        private TipProfesor(String tipProfesor) {
            this.tipProfesor = tipProfesor;
        }
    }

        // ii profesor la romana
    private Discipline numeleMateriei;

    private Materie materiePredata;

    public void setMateriePredata(Materie materiePredata) {
        this.materiePredata = materiePredata;
    }

    private int numarTotalOre;
    private double salariu;
    private String dataAnagajarii;
    private List<Clase> clasePreda = new ArrayList<>();
    private String numarTelefon;

    private Elev elev;

    private Clase clase;

    public List<Clase> getClasePreda() {
        return clasePreda;
    }

    public void setClasePreda(List<Clase> clasePreda) {
        this.clasePreda = clasePreda;
    }

    public Profesor(String fullName, String email) {
        super(fullName, email);

           }

    public Discipline getNumeleMateriei() {
        return numeleMateriei;
    }

    public void setNumeleMateriei(Discipline numeleMateriei) {
        this.numeleMateriei = numeleMateriei;
    }

    public Materie getMateriePredata() {
        return materiePredata;
    }

    public int getNumarTotalOre() {
        return numarTotalOre;
    }

    public void setNumarTotalOre(int numarTotalOre) {
        this.numarTotalOre = numarTotalOre;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getDataAnagajarii() {
        return dataAnagajarii;
    }

    public void setDataAnagajarii(String dataAnagajarii) {
        this.dataAnagajarii = dataAnagajarii;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }


    public Profesor(String fullName, String email, Discipline numeleMateriei, Materie materiePredata, String numarTelefon, Clase clase) {
        super(fullName, email);
        this.numeleMateriei = numeleMateriei;
        this.materiePredata = materiePredata;
        this.numarTelefon = numarTelefon;
        this.clase = clase;
    }

    public Elev getElev() {
        return elev;
    }

    public void setElev(Elev elev) {
        this.elev = elev;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String getClassUser() {
        return "Profesor  ";
    }


    // metoda in care  profesorul da o nota pentru o disciplina la un elev
    public void adaugaNote(Note nota, Discipline materia, Elev elev) {
        // verifica daca parola este ok
        if (this.getPassword() == null) {
            throw new EroareParola();
        }
        //      verifica daca profesorul vrea sa dea o nota la materia pe care o preda
        if (!numeleMateriei.equals(materia)) {
            throw new EstiNeautorizat();
        } else {   // am luat elevul din materie e campion frate :)

            // iterez prin lista de materii ale elevului
            for (Materie materiaCorespunzatoare : elev.getMaterie()) {
                // verific daca materia corespunzatoare e in lista materiilor elevului
                    // daca materia profesorului este aceiasi cu materia elevlui adaug 4 (nota ioan)



                 if (materiaCorespunzatoare.getNumeleMateriei().equals(materia)) {
                                    // daca materia profesorului este aceiasi cu materia elevlui adaug 4 (nota ioan)
                                    materiaCorespunzatoare.getNotele().add(nota);
                                }
            }
        }
    }
    //}

    // metoda pentru a genera un fisier cu numele tuturor elevilor

         // pentru o anumita clasa de la scoala ... scot doar elevii
    public void genereazaFisierNumeElevi(Scoala scoala, Clase clasa) {

        // trebuie sa vad daca profesorul preda la clasa respectiva
        // daca nu preda arunc eroare este neautorizat
        // verific daca clasele la care preda contine si clasa la care vreau sa generez utilizator
        // profesorul are o lista de clase la care preda daca clasa e in lista sau nu
         if(!clasePreda.contains(clasa))
         {
             throw new EstiNeautorizat();
         }

         StringBuilder numeElevi= new StringBuilder();
         // iau lista de useri din clasa scoala
        for (User userulCurent : scoala.getListaUseri()) {
            // scot doar lista cu elevi
            // if
            // sintaxa primita
            // interez prin toata lista de useri si iau doar elevii
            if (userulCurent instanceof Elev) {
                Elev elevCurent = (Elev) userulCurent;

                // trebuie sa verific daca elevul respectiv este in clasa care generez lista
                // clasa este o proprietate a elevului curent


                if (elevCurent.getClase().equals(clasa)) {

                    // aici am adaugat numele de elevi in stringBuilder
                    numeElevi.append(elevCurent.getFullName() + "\n");
                }

            }
        }


            System.out.println(numeElevi);
            try {
                File file = new File("C:\\Users\\Filip\\Desktop\\Fisiere create\\Lista elevi_" +clasa+ ".txt");


                file.createNewFile();

                FileWriter pw = new FileWriter(file.getAbsoluteFile());

                BufferedWriter bf = new BufferedWriter(pw);

                // ia nume elevi il transforma in string si dupa il scrie
                bf.write(numeElevi.toString());

                bf.close();

                System.out.println(" S-a creat fisierul de catre profesor cu numele elevilor ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    // adaug o clasa in lista de clase la care preda
    public void adaugaClasa(Clase clasa)
    {
        clasePreda.add(clasa);
    }

    public void genereazaListaPreda(Scoala scoala, Clase clase)
    {
        StringBuilder numeStudent = new StringBuilder();
        int counter=0;
        // trec prin toti useri
        // iterez prin lista de membri din scoala
        for (User user: scoala.getListaUseri())
        {
             //daca userul este student
            //
            if(user instanceof Elev)
            {
                //
                Elev elev= (Elev) user;
                // daca elevul este in clasa in care preda profesorul
                if(elev.getClase().equals(clase))
                {
                    counter++;
                    numeStudent.append(" Nr  " +counter+ " " +elev.getFullName() + "\n");
                }
            }
        }

        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\EleviFisier\\Lista.txt");
            file.createNewFile();
            FileWriter pw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bf = new BufferedWriter(pw);
            bf.write(numeStudent.toString());
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void fiserNumeEleviClasaLaCarePreda(Clase clase,Elev elev)
    {

        try {

            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\ListaEleviClasa\\ "+clase+".txt");


            file.createNewFile();

            FileWriter pw = new FileWriter(file.getAbsoluteFile());

            BufferedWriter bf = new BufferedWriter(pw);


            bf.write(elev.getFullName().toString());
            bf.close();

            System.out.println(" S-a creat fisierul cu elevii din clasa la care preda profesorul ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
