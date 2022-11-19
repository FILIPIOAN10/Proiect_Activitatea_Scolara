package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parinte extends User {
    public Parinte(String fullName, String email) {
        super(fullName, email);
    }

    @Override
    public String getClassUser() {
        return "Parinte";
    }


    public String nrTel;
    public String adresa;
    public int varsta;
    Profesor profesor;

    Elev elev;

    //lista elevi pentru care e parinte
    SimpleDateFormat formatFrom = new SimpleDateFormat("yyyy-MM-dd");

    public List<Elev> elevi = new ArrayList<>();

    public String ocupatia;

    public List<Elev> getElevi() {
        return elevi;
    }

    public void setElevi(List<Elev> elevi) {
        this.elevi = elevi;
    }

    public Parinte(String fullName, String email, String nrTel, String adresa, int varsta, SimpleDateFormat formatFrom, String ocupatia) {
        super(fullName, email);
        this.nrTel = nrTel;
        this.adresa = adresa;
        this.varsta = varsta;
        this.formatFrom = formatFrom;
        this.ocupatia = ocupatia;

    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public SimpleDateFormat getFormatFrom() {
        return formatFrom;
    }

    public void setFormatFrom(SimpleDateFormat formatFrom) {
        this.formatFrom = formatFrom;
    }

    public String getOcupatia() {
        return ocupatia;
    }

    public void setOcupatia(String ocupatia) {
        this.ocupatia = ocupatia;
    }


    public void veziMediile(Elev elev, Materie materie) { //verific daca parola este ok


        // parintele sa vada media la copil

        if (this.getPassword() == null) {
            throw new EroareParola();
        }
        // verific daca parintele are ca elev elevul
        // verific daca elevul este in lista de elevi
        if (!elevi.contains(elev)) {
            throw new EstiNeautorizat();
        }

        elev.calculeazaMediaMaterie(materie);
    }


    //
    public void adaugaCopil(Elev elev) {
        elevi.add(elev);
        System.out.println("Am adaugat elevul " +elev.getFullName());
    }


    public void veziProfesorCopil(Profesor profesor, Clase clase) {

        try {

            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\ClasaProfesor\\" + profesor.getFullName() + profesor.getMateriePredata() + profesor.getNumarTelefon() + ".txt");


            file.createNewFile();

            FileWriter pw = new FileWriter(file.getAbsoluteFile());

            BufferedWriter bf = new BufferedWriter(pw);

            bf.write(profesor.getFullName() + " " + profesor.getNumeleMateriei() + " " + profesor.getNumarTelefon());

            bf.close();

            System.out.println(" S-a creat fisierul cu elevii din clasa la care preda profesorul ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

