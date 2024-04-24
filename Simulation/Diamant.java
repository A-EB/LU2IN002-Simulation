public class Diamant extends Joyaux{

    public Diamant(String type, int quant){
        super(type,quant);
        this.prix=(int)(Math.random()*(2501)+2500);
    }
    public String toString(){
        return super.toString();
    }
}
