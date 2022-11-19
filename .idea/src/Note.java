public enum Note {
    NOTA_1(1),
    NOTA_2(2),
    NOTA_3(3),
    NOTA_4(4),
    NOTA_5(5),
    NOTA_6(6),
    NOTA_7(7),
    NOTA_8(8),
    NOTA_9(9),
    NOTA_10(10);

    private  int value;
    private Note(int value)
    {
        this.value=value;
    }

    public  int getValue()
    {
        return  value;
    }
}
