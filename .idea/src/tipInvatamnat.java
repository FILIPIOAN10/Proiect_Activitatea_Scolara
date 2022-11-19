public enum tipInvatamnat {
    INVATAMNAT_PRIMAR("CLAS 0 -- CLASA 4"),
    INVATAMNAT_GIMNAZIAL("CLASA 5 -- CLASA 8"),
    INVATAMNAT_LICEAL("CLASA 9 --CLASA 12");

    private String descriere;

    tipInvatamnat(String descriere)
    {
        this.descriere=descriere;
    }
}
