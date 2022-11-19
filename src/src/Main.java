package src;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Admin admin = new Admin("Adminul","admin@gmail.com");
        admin.generateFileUser(admin);
        Contabil contabil = new Contabil("Contabilul ","contabil@gmail.com");
        admin.generateFileUser(contabil);
        Elev popescu = new Elev("Popescu","popescu@gmail.com",false, tipInvatamnat.INVATAMNAT_GIMNAZIAL);
        Elev ionescu = new Elev("Ionescu","ionescu@gmail.com",true, tipInvatamnat.INVATAMNAT_GIMNAZIAL);
        admin.generateFileUser(popescu);
        admin.generateFileUser(ionescu);
        Profesor profesor = new Profesor("Ionescu","ionescu@gmail.com");

        admin.generateFileUser(profesor);
        Parinte parinte = new Parinte("Parinte popescu ","popescuparinte@gmail.com");

        Scoala generala3 = new Scoala("Generala 3 ");
        Materie materie = new Materie(Discipline.ROMANA);

        popescu.getMaterie().add(materie);
        List<Discipline> discipline= new ArrayList<>();
        discipline.add(Discipline.ROMANA);

        generala3.addUserToList(admin);
        generala3.addUserToList(contabil);
        generala3.addUserToList(popescu);
        generala3.addUserToList(profesor);
        generala3.addUserToList(parinte);
        generala3.addUserToList(ionescu);
        admin.genereazaParolaPentruUser(contabil.getUsername(),generala3);
        admin.genereazaParolaPentruUser(popescu.getUsername(),generala3);
        admin.genereazaParolaPentruUser(profesor.getUsername(),generala3);
        admin.genereazaParolaPentruUser(parinte.getUsername(),generala3);
        admin.genereazaParolaPentruUser(ionescu.getUsername(),generala3);
        admin.genereazaFisierListaMembri(generala3);
        profesor.setMateriePredata(materie);
        System.out.println("Numele materiei predate ale profesorului este "  +profesor.getMateriePredata());

        System.out.println("----------------------");

         popescu.adaugaMaterie2(discipline, Discipline.ROMANA);


        profesor.setNumeleMateriei(Discipline.ROMANA);

        profesor.adaugaNote(Note.NOTA_5, Discipline.ROMANA,popescu);

        parinte.adaugaCopil(popescu);
        System.out.println("----------------------");
        parinte.veziMediile(popescu,materie);

        List<Profesor> profesori = new ArrayList<>();
        profesori.add(profesor);

        profesor.setSalariu(3000);

        contabil.genereazaListaSalarii(profesori);

        contabil.bursaElev(popescu);
        popescu.setClase(Clase.CLASA_4);
        ionescu.setClase(Clase.CLASA_9);
        popescu.setTipInvatamnat(tipInvatamnat.INVATAMNAT_GIMNAZIAL);
        popescu.setAreBursa(true);
        contabil.raportAnual(generala3);


        Profesor profesor1 = new Profesor("Ionescu","ionescu@gmail.com", Discipline.ROMANA,materie,"04353532", Clase.CLASA_4);
        profesor1.fiserNumeEleviClasaLaCarePreda(Clase.CLASA_4,popescu);

        parinte.veziProfesorCopil(profesor1, Clase.CLASA_4);


    }
}




















//
//    Admin admin = new Admin("Adminul", "filip@gmail.com");
//    Contabil contabil = new Contabil("Contabil", "abc@gmail.com");
//    Elev popescu = new Elev("POPESCU", "filipioan_29@gmail.com");
//    Elev vasile = new Elev("Vasile", "filipioan_30@gmail.com");
//    Scoala generala3 = new Scoala("SAM");
//
//
//    Profesor profesor = new Profesor("Meterciuc", "filipVasile_34@gmail.com");
//    Profesor profesor1 = new Profesor("Meterciuc1 ", "filipVasile_34@gmail.com");
//    Profesor profesor2 = new Profesor("Meterciuc2 ", "filipVasile_34@gmail.com");
//    Profesor profesor3 = new Profesor("Meterciuc3 ", "filipVasile_34@gmail.com");
//
//
//    //Lista clase
//    List<Clase> claseLista= new ArrayList<>();
//        claseLista.add(Clase.CLASA_0);
//        claseLista.add(Clase.CLASA_1);
//        claseLista.add(Clase.CLASA_2);
//        claseLista.add(Clase.CLASA_3);
//        claseLista.add(Clase.CLASA_4);
//
//    //Popescu il setez in calsa a a4
//        profesor.setClasePreda(claseLista);
//        popescu.setClase(Clase.CLASA_4);
//
//
//    // obiectul tata
//    Parinte tata = new Parinte("Tata", "filipioan_30@gmail.com");
//
//    // generez fisiere pentru admin contabil
//
//        admin.generateFileUser(admin);
//    //  admin.generateFileUser(popescu);
//        admin.generateFileUser(profesor);
//    //   admin.stergeFisier(popescu);
//
//
//    // adaug pe admin , contabil , popescu , vasile la scoala 3
//
//        generala3.addUserToList(admin);
//        generala3.addUserToList(popescu);
//        generala3.addUserToList(profesor);
//        generala3.addUserToList(tata);
//
//        generala3.addUserToList(profesor1);
//        generala3.addUserToList(profesor2);
//        generala3.addUserToList(profesor3);
//
//        admin.genereazaParolaPentruUser(admin.getUsername(),generala3);
//        admin.genereazaParolaPentruUser(popescu.getUsername(),generala3);
//        admin.genereazaParolaPentruUser(profesor.getUsername(),generala3);
//        admin.genereazaParolaPentruUser(tata.getUsername(),generala3);
//    // metoda sterge fisier
//        admin.stergeFisier(popescu);
//    // generez fisier lista membrii
//        admin.genereazaFisierListaMembri(generala3);
//    String tema= "NUMERE PARE ";
////        String tema2= "NUMERE IMPARE ";
//
//    // adaug materia ca si obiect
//    Materie romanaMaterie = new Materie(Discipline.ROMANA);
//
//    Materie matematicaMaterie = new Materie(Discipline.MATEMATICA);
//
//    // materia romana o adaug la lista de materii a lui popescu
//        popescu.getMaterie().add(romanaMaterie);
//    // materia matematica o adaug la lista de materii a lui popescu
//        popescu.getMaterie().add(matematicaMaterie);
//    // incarca tema la disciplina romana a lui popescu
//        popescu.incarcaTema(Discipline.ROMANA,tema,tema);
//
//    // profesorului ii setez materia preda
//        profesor.setMateriePredata(romanaMaterie);
//        profesor1.setMateriePredata(romanaMaterie);
//        profesor2.setMateriePredata(romanaMaterie);
//        profesor3.setMateriePredata(romanaMaterie);
//
//    List<Discipline> discipline= new ArrayList<>();
//        discipline.add(Discipline.ROMANA);
//
//    List<Profesor> profesori= new ArrayList<>(); admin.generateFileUser(contabilul);
//        profesori.add(profesor1);
//        profesori.add(profesor2);
//        profesori.add(profesor3);
//
//        profesor.setSalariu(3000);
//        profesor1.setSalariu(5000);
//        profesor2.setSalariu(34000);
//        profesor3.setSalariu(2000);
//        contabil.genereazaListaSalarii(profesori);
//
////        contabil.genereazaListaSalarii(profesori,profesor1);
////        contabil.genereazaListaSalarii(profesori,profesor2);
////        System.out.println(profesori);
////        System.out.println();
////        System.out.println();
////        System.out.println();
////        System.out.println(generala3);
//
//
//
//
////        popescu.incarcaTema(Discipline.ROMANA,tema,tema);
////        popescu.incarcaTema(Discipline.MATEMATICA,tema2,tema2);
////        List<Discipline> discipline = new ArrayList<>();
////        discipline.add(Discipline.ROMANA);
////        discipline.add(Discipline.MATEMATICA);
//        tata.adaugaCopil(popescu);
//
//        profesor.setNumeleMateriei(Discipline.MATEMATICA);
//
//        popescu.adaugaMaterie2(discipline, Discipline.ROMANA);
//        popescu.adaugaMaterie2(discipline, Discipline.MATEMATICA);
//
//
//        profesor.adaugaNote(Note.NOTA_5,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_6,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_4,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_3,Discipline.MATEMATICA,popescu);
//
//        for(Materie materiePopescu:popescu.getListaMaterii())
//    {
//        System.out.println(materiePopescu.getNumeleMateriei());
//    }
//
//        tata.veziMediile(popescu,matematicaMaterie);
//
//
//    Contabil contabil2=new Contabil("contabil2","contabil2@gmail.com");
//    Elev perniu=new Elev("perniu","perniu@gmail.com",true,tipInvatamnat.INVATAMNAT_LICEAL);
//        contabil2.bursaElev(perniu);
//
//        vasile.setClase(Clase.CLASA_4);
//        perniu.setClase(Clase.CLASA_9);
//        profesor.fiserNumeEleviClasaLaCarePreda(Clase.CLASA_4,popescu);
//        profesor.fiserNumeEleviClasaLaCarePreda(Clase.CLASA_9,perniu);
//    Materie germanaMaterie = new Materie(Discipline.GERMANA);
//    Profesor profesor4=new Profesor("marian","marian@gmail.com",Discipline.GERMANA,germanaMaterie,"0747037306",Clase.CLASA_9);
//        profesor4.setMateriePredata(germanaMaterie);
//        profesor4.adaugaClasa(Clase.CLASA_9);
//    // prof.adaugaClasa(Clase.CLASA_4);
//    Parinte parinte=new Parinte("parinte","parinte@gmail.com");
//        parinte.veziProfesorCopil(profesor4,Clase.CLASA_9);
//
//
//}


















////////////////////////////////////////////////////////////////////////////

//    //Lista clase
//    List<Clase> claseLista= new ArrayList<>();
//        claseLista.add(Clase.CLASA_0);
//                claseLista.add(Clase.CLASA_1);
//                claseLista.add(Clase.CLASA_2);
//                claseLista.add(Clase.CLASA_3);
//                claseLista.add(Clase.CLASA_4);
//
//                //Popescu il setez in calsa a a4
//
//                profesor.setClasePreda(claseLista);
//                popescu.setClase(Clase.CLASA_4);
//                vasile.setClase(Clase.CLASA_4);
//
//
//
//                // obiectul tata
//                Parinte tata = new Parinte("Tata", "filipioan_30@gmail.com");
//
//                // generez fisiere pentru admin contabil
//
//                admin.generateFileUser(admin);
//                //  admin.generateFileUser(popescu);
//                admin.generateFileUser(profesor);
//                //   admin.stergeFisier(popescu);
//
//
//                // adaug pe admin , contabil , popescu , vasile la scoala 3
//
//                generala3.addUserToList(admin);
//                generala3.addUserToList(popescu);
//                generala3.addUserToList(profesor);
//                generala3.addUserToList(tata);
//
//                generala3.addUserToList(profesor1);
//                generala3.addUserToList(profesor2);
//                generala3.addUserToList(profesor3);
//
//                admin.genereazaParolaPentruUser(admin.getUsername(),generala3);
//                admin.genereazaParolaPentruUser(popescu.getUsername(),generala3);
//                admin.genereazaParolaPentruUser(profesor.getUsername(),generala3);
//                admin.genereazaParolaPentruUser(tata.getUsername(),generala3);
//                // metoda sterge fisier
//                admin.stergeFisier(popescu);
//                // generez fisier lista membrii
//                admin.genereazaFisierListaMembri(generala3);
//                String tema= "NUMERE PARE ";
////        String tema2= "NUMERE IMPARE ";
//
//                // adaug materia ca si obiect
//                Materie romanaMaterie = new Materie(Discipline.ROMANA);
//
//
//
//
//                Materie matematicaMaterie = new Materie(Discipline.MATEMATICA);
//
//                // materia romana o adaug la lista de materii a lui popescu
//                popescu.getMaterie().add(romanaMaterie);
//                // materia matematica o adaug la lista de materii a lui popescu
//                popescu.getMaterie().add(matematicaMaterie);
//                // incarca tema la disciplina romana a lui popescu
//                popescu.incarcaTema(Discipline.ROMANA,tema,tema);
//
//                // profesorului ii setez materia preda
//                profesor.setMateriePredata(romanaMaterie);
//                profesor1.setMateriePredata(romanaMaterie);
//                profesor2.setMateriePredata(romanaMaterie);
//                profesor3.setMateriePredata(romanaMaterie);
//
//                List<Discipline> discipline= new ArrayList<>();
//        discipline.add(Discipline.ROMANA);
//
//
//        // Lista profesori
//        List<Profesor> profesori= new ArrayList<>();
//        profesori.add(profesor);
//        profesori.add(profesor1);
//        profesori.add(profesor2);
//        profesori.add(profesor3);
//
//        profesor.setSalariu(3000);
//        profesor1.setSalariu(5000);
//        profesor2.setSalariu(34000);
//        profesor3.setSalariu(2000);
//
//        profesor.setSalariu(4000);
//        profesor1.setSalariu(9000);
//        profesor2.setSalariu(94000);
//        profesor3.setSalariu(9000);
//
//        contabil.genereazaListaSalarii(profesori);
//
//
//        tata.adaugaCopil(popescu);
//
//        profesor.setNumeleMateriei(Discipline.MATEMATICA);
//
//        popescu.adaugaMaterie2(discipline, Discipline.ROMANA);
//        vasile.adaugaMaterie2(discipline, Discipline.ROMANA);
//        popescu.adaugaMaterie2(discipline, Discipline.MATEMATICA);
//        vasile.adaugaMaterie2(discipline, Discipline.MATEMATICA);
//
//
//        profesor.adaugaNote(Note.NOTA_5,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_6,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_4,Discipline.MATEMATICA,popescu);
//        profesor.adaugaNote(Note.NOTA_3,Discipline.MATEMATICA,popescu);
//
//        for(Materie materiePopescu:popescu.getListaMaterii())
//        {
//        System.out.println(materiePopescu.getNumeleMateriei());
//        }
//
//        tata.veziMediile(popescu,matematicaMaterie);
//
//
//        profesor.adaugaClasa(Clase.CLASA_4);
//
//        popescu.setClase(Clase.CLASA_4);
//
//        vasile.setClase(Clase.CLASA_4);
//
//        profesor.setMateriePredata(romanaMaterie);
//        popescu.adaugaMaterie(romanaMaterie);
//        vasile.adaugaMaterie(romanaMaterie);
//        admin.genereazaParolaPentruUser(vasile.getUsername(),generala3);
//        profesor.genereazaListaPreda(generala3,Clase.CLASA_4);
