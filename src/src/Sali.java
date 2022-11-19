package src;

public enum Sali {
    SALA_1("LABORATOR CHIMIE"),
    SALA_2("LABORATOR FIZICA"),
    SALA_3("SPORT"),
    SALA_4("LABORATOR BIOLOGIE"),
    SALA_5("PATOLOGIE");
    private String numeSala;
    Sali(String numeSala) {
        this.numeSala=numeSala;

    }
}
