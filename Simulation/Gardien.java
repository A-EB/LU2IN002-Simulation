//Ali El Boukili 21210507
//BADR BENHAMMOU 21207429
public class Gardien extends Contenu{
    private int hp;

    public Gardien(int quant){
        super("Gardien",quant);
        hp = 200;
    }
    public String toString(){
        return "Gardien : "+super.toString()+", hp : "+hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp(){
        return hp;
    }
}