public class Opale extends Joyaux{

    public Opale(String type, int quant){
        super(type,quant);
        this.prix=(int)(Math.random()*(501));
    }
    public String toString(){
        return super.toString();
    }
}
