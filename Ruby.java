public class Ruby extends Joyaux{

    public Ruby(String type, int quant){
        super(type,quant);
        this.prix=(int)(Math.random()*(2001)+500);
    }
    public String toString(){
        return super.toString();
    }
}
