import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Elev   extends  User {

    private char gen;
    private int varsta;
    private String dataNasterii,adresaCompleta;
    private Clase clase;
    private boolean areBursa;
    private tipInvatamnat tipInvatamnat;
    private Set<Materie> listaMaterii = new HashSet<>();
    private List<Discipline> listaDiscipline  = new ArrayList<>();

    public Set<Materie> getListaMaterii() {
        return listaMaterii;
    }

    public Elev(String fullName, String email) {
        super(fullName, email);
    }


    public Elev(String fullName, String email, boolean areBursa, tipInvatamnat tipInvatamnat) {
        super(fullName, email);
        this.areBursa = areBursa;
        this.tipInvatamnat = tipInvatamnat;
    }


    @Override
    public String getClassUser() {
        return "Elev ";
    }


    public void setGen(char gen) {
        this.gen = gen;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setAdresaCompleta(String adresaCompleta) {
        this.adresaCompleta = adresaCompleta;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
        validateJavaDate(dataNasterii);
    }


    public boolean isAreBursa() {
        return areBursa;
    }

    public void setAreBursa(boolean areBursa) {
        this.areBursa = areBursa;

    }
    public tipInvatamnat getTipInvatamnat() {
        return tipInvatamnat;
    }

    public void setTipInvatamnat(tipInvatamnat tipInvatamnat) {
        this.tipInvatamnat = tipInvatamnat;
    }


    public static String validateJavaDate(String strDate) {
        // vedem daca data este nula sau nu
        if (strDate.trim().equals("")) {
            System.out.println("Este nula");
        }
        // data  nu este nuula
        else {

            // setam formatul de data preferat
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd");
            sdfrmt.setLenient(false);

            // testam tipul de foramt

            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            }
            /* Date format is invalid */
            //tipul de format este invalid aruncam exceptie
            catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
            }
            /* Return true if date format is valid */
        }
        return strDate;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Set<Materie> getMaterie() {
        return listaMaterii;
    }

    public void setMaterie(Set<Materie> materie) {
        this.listaMaterii = materie;
    }


    //metoda pentru a incarca tema in functie de disciplina , numele temei si tema
    public boolean incarcaTema(Discipline discipline, String numetema, String tema) {
        //verifica daca parola este nula
        if (this.getPassword() == null) {
            throw new EroareParola();
        } else {
            //metoda pentru a vedea daca contine disciplina
            if (!contineDisciplina(discipline)) {
                System.out.println("Elevul nu urmeaza aceasta clasa . Nu poate fi adaugat ");
                return false;
            } else {
                try {
                    File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\Elevi\\ " +this.getFullName() + " homework " + discipline+".txt");
                    //   file.mkdir();
                    // File file1 = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\Elevi" + numetema+ ".txt");
                    file.createNewFile();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
                    bufferedWriter.write(numetema);
                    bufferedWriter.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                for (Materie materie: listaMaterii)
                {
                    if(materie.getNumeleMateriei().equals(discipline))
                    {
                        materie.getHomework().add(numetema);
                    }
                }
                return true;
            }
        }
    }

    //metoda pentru a verifica daca contine disciplina
    public boolean contineDisciplina(Discipline discipline) {
        for(Materie materie: listaMaterii)
        {
            if(materie.getNumeleMateriei().equals(discipline))
            {
                return true;
            }
        }
        return false;
    }

    // metoda pentru a adauga materia
    public boolean adaugaMaterie(Materie materie) {
        if(getPassword()== null)
        {
            throw  new EroareParola();
        }
        else
        {
            return this.listaMaterii.add(materie);
        }
    }

    // metoda pentru a incarca tema in functie
    //
    public void calculeazaMediaMaterie(Materie materia)
    {
        // iterez prin materie
        double media=0.0;
        int suma=0;
        if(listaMaterii.contains(materia))
        {
            // iau note dintr-o singura materie
            for (Note nota : materia.getNotele())
            {
                // am adaugat n
                suma+=nota.getValue();
            }
            // calculez media

            media=(double)suma/materia.getNotele().size();

        }

        System.out.println(" Media este " +media);
    }


//    public void calculeazaMediaAnuala(Materie materii)
//    {
//        double media=0.0;
//        int suma=0;
//        if(listaMaterii.contains(materia))
//        {
//            // iau note dintr-o singura materie
//            for (Discipline nota:materia.getNotele())
//            {
//                // am adaugat n
//                suma+=nota.getValue();
//            }
//            // calculez media
//            media=(double)suma/materia.getNotele().size();
//
//        }
//        System.out.println(" Media este" +media);
//    }


    public void adaugaMaterie2(List<Discipline> listaDiscipline,Discipline discipline)
    {

        listaDiscipline.add(discipline);
        System.out.println("Am adaugat " +discipline );

    }

    public void tipInvatamantElev(Clase clase) {
        if (this.clase == Clase.CLASA_0 || this.clase == Clase.CLASA_1 || this.clase == Clase.CLASA_2 || this.clase == Clase.CLASA_3 || this.clase == Clase.CLASA_4) {
            tipInvatamnat = tipInvatamnat.INVATAMNAT_PRIMAR;
            System.out.println("elevul este in scoala primara");
        }
        if (this.clase == Clase.CLASA_5 || this.clase == Clase.CLASA_6 || this.clase == Clase.CLASA_7 || this.clase == Clase.CLASA_8) {
            tipInvatamnat = tipInvatamnat.INVATAMNAT_GIMNAZIAL;
            System.out.println("elevul este in scoala gimnaziala");
        }
        if (this.clase == Clase.CLASA_9 || this.clase == Clase.CLASA_10 || this.clase == Clase.CLASA_11 || this.clase == Clase.CLASA_12) {
            tipInvatamnat = tipInvatamnat.INVATAMNAT_LICEAL;
            System.out.println("elevul este in liceu");
        }
    }



}
