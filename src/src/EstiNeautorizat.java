package src;

public class EstiNeautorizat extends RuntimeException{
    public EstiNeautorizat(){

        super("Nu esti autorizat pentru aceasta materie");
    }
}