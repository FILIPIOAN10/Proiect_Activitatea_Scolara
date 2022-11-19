import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Contabil extends User{
    Profesor prof;
    private String numarTelefon,emailAlternativ;
    private boolean esteMulticontabil,esteExpert;
    tipInvatamnat tipInvatamnat;
    public int sumaBursa;

    public void setSumaBursa(int sumaBursa) {
        this.sumaBursa = sumaBursa;
    }

    private List<Profesor> listaProfesor= new ArrayList<>();
    private List<Elev> listaElevi = new ArrayList<>();
    public Contabil(String fullName,String email) {
        super(fullName,email);
    }

    public boolean isEsteExpert() {
        return esteExpert;
    }

    public void setEsteExpert(boolean esteExpert) {
        this.esteExpert = esteExpert;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getEmailAlternativ() {
        return emailAlternativ;
    }

    public void setEmailAlternativ(String emailAlternativ) {
        this.emailAlternativ = emailAlternativ;
    }

    public boolean isEsteMulticontabil() {
        return esteMulticontabil;
    }

    public void setEsteMulticontabil(boolean esteMulticontabil) {
        this.esteMulticontabil = esteMulticontabil;
    }
    public void genereazaListaSalarii(List<Profesor> profesorului) {

        try {

            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\ListaSalarii\\Salarii.txt");
            file.createNewFile();
            FileWriter pw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bf = new BufferedWriter(pw);
            StringBuilder text = new StringBuilder();

            int salariuAnul=0;
                for (int j=1; j<13;j++)
                { text.append(Month.of(j) +"\n");
                    for (int i =0; i <profesorului.size(); i++) {
                        salariuAnul+=profesorului.get(i).getSalariu();
                        text.append(profesorului.get(i).getClassUser() +profesorului.get(i).getMateriePredata()+ " "+profesorului.get(i).getFullName() + " - " +profesorului.get(i).getSalariu() +"\n");


                    }
                }

            bf.write(text.toString()+ "\n"
                    +"Total anual - "+salariuAnul);
//
            // am adaugat lista de useri in fisier
            bf.close();
            System.out.println("S-a creeat fisierul cu lista de membrii ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getClassUser() {
        return "Contabil";
    }

    void bursaElev(Elev elev)
    {
        if(elev.isAreBursa()==true) {
            if (this.tipInvatamnat == tipInvatamnat.INVATAMNAT_PRIMAR) {

                sumaBursa = sumaBursa + 300;
                System.out.println("elevul: "+elev.getFullName()+" are bursa: "+sumaBursa+"lei");

            } else if (this.tipInvatamnat == tipInvatamnat.INVATAMNAT_GIMNAZIAL) {
                sumaBursa = 0;

                sumaBursa = sumaBursa + 500;
                System.out.println("elevul: "+elev.getFullName()+" are bursa: "+sumaBursa+"lei");

            } else {
                sumaBursa = 0;
                sumaBursa = sumaBursa + 800;
                System.out.println("elevul: "+elev.getFullName()+" are bursa: "+sumaBursa+"lei");


            }
        }

        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\Elevi\\BursaElevi\\" +elev.getFullName()+ ".txt");


            file.createNewFile();

            FileWriter pw = new FileWriter(file.getAbsoluteFile());

            BufferedWriter bf = new BufferedWriter(pw);
            bf.write("Elevul "+elev.getTipInvatamnat() + " " +elev.getFullName()+" are bursa:"+sumaBursa+" lei");

            bf.close();

            System.out.println(" S-a creat fisierul cu burse ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // iterez prin toti userii  , iau doar elevii , pentru elev verific daca are bursa si apoi  tipul de invatamant si dupa aloci suma respectiva
    public void raportAnual(Scoala scoala)
    {

        List<Elev> eleviPrimari= new ArrayList<>();

        List<Elev> eleviGimnazial= new ArrayList<>();

        List<Elev> eleviLiceal= new ArrayList<>();

        for (User user: scoala.getListaUseri())
        {
            // daca user e un obiect de tip elev
            if( user instanceof Elev && ((Elev) user).isAreBursa())
            {
                // transform utilizator curent din user in elev
                Elev elevulCurent=(Elev) (user);

                if(elevulCurent.getTipInvatamnat()== tipInvatamnat.INVATAMNAT_PRIMAR)
                {
                    eleviPrimari.add(elevulCurent);
                }
                if(elevulCurent.getTipInvatamnat()== tipInvatamnat.INVATAMNAT_GIMNAZIAL)
                {
                    eleviGimnazial.add(elevulCurent);
                }
                if(elevulCurent.getTipInvatamnat()== tipInvatamnat.INVATAMNAT_LICEAL)
                {
                   eleviLiceal.add(elevulCurent);
                }
            }

        }
            int bursaEleviiPrimari=0;

            int bursaEleviiGimnaziali=0;

            int bursaEleviiLiceali=0;

            int sumaTotala=0;

            StringBuilder sb = new StringBuilder();
            if(eleviPrimari.size()>0)
            {
                 bursaEleviiPrimari=300*eleviPrimari.size();

                 sb.append("Elevi clase primare :" +"\n");
                 for(Elev elev:eleviPrimari)
                 {
                     sb.append(elev.getFullName()+ "\n");
                 }
                 sb.append("Total burse clase primare" +bursaEleviiPrimari +"\n");

            }
            if(eleviGimnazial.size()>0)
            {
                bursaEleviiGimnaziali=500*eleviGimnazial.size();
                sb.append("Elevi clase gimnaziale :" +"\n");
                for(Elev elev:eleviGimnazial)
                {
                    sb.append(elev.getFullName()+ "\n");
                }
                sb.append("Total burse clase Gimnaziale "+bursaEleviiGimnaziali+"\n");

            }
            if(eleviLiceal.size()>0)
            {
                bursaEleviiLiceali=800*eleviLiceal.size();
                sb.append("Elevi clase Liceal :" +"\n");
                for(Elev elev:eleviLiceal)
                {
                    sb.append(elev.getFullName()+ "\n");
                }
                sb.append("Total burse clase Liceale "+bursaEleviiLiceali+"\n");
            }
            sumaTotala=bursaEleviiPrimari+bursaEleviiGimnaziali+bursaEleviiLiceali;


        try {
            File file = new File("C:\\Javaprojects\\algoritmi\\Proiect\\src\\FisiereCreate\\Elevi\\BursaElevi.txt");


            file.createNewFile();

            FileWriter pw = new FileWriter(file.getAbsoluteFile());

            BufferedWriter bf = new BufferedWriter(pw);
            bf.write(sb.toString());

            bf.close();

            System.out.println(" S-a creat fisierul cu burse ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}