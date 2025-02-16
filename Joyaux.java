//Ali El Boukili 21210507
//BADR BENHAMMOU 21207429
public abstract class Joyaux extends Contenu{
    protected int prix;

    public Joyaux(String type, int quant){
        super(type,quant);
    }
    public String toString(){
        return " Joyaux de type "+type;
    }
    public int getPrix(){
        return prix;
    }
}
