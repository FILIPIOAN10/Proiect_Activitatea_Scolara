package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Scoala {
    String numeleScolii;

    //o lista de sali de clasa cu numarul aferent
    //(ex: Sala1 cu descrierea Laborator Chimie, Sala2 cu descrierea Laborator Fizica,
    //Sala3 cu descrierea Sala Sport etc.),
    public List<Sali> sali = new LinkedList<>();

    //o lista de discipine care se predau in
    //scoala respectiva (ex: Romana, Biologie, Matematica, Germana, Japponeza,
    //etc.)
    public List<Discipline> discipline= new LinkedList<>();

    //va avea ca si membri toti useri pe care ii
    //vom vrea, indiferent de tipul userului,
    public List<User> listaUseri= new LinkedList<>();
    private List<Profesor> listaProfesor= new ArrayList<>();

    public List<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public List<User> getListaUseri() {
        return listaUseri;
    }
    public void addUserToList(User user) {
        listaUseri.add(user);
    }
    public Scoala(String numeleScolii) {
        this.numeleScolii = numeleScolii;
    }
    public  List<Clase>componentaClasa=new ArrayList<>();

    @Override
    public String toString() {
        return "Scoala{" +
                "listaUseri=" + listaUseri +
                '}';
    }
}
