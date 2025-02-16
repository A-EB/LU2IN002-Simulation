//Ali El Boukili 21210507
//BADR BENHAMMOU 21207429

public class Agent5{
    private int x=-1,y=-1;
    private int TailleSac, nbJoyaux = 0;
    private Joyaux[] Sac;
    private static int cptjoy=0;
    private Grille grille;

    public Agent5(Grille grille,int TailleSac){
            this.TailleSac=TailleSac;
            Sac= new Joyaux[TailleSac];
            this.grille=grille;
    }

    public String toString(){
        return "Agent 5 en position ("+x+","+y+"), fortune : "+fortune()+"\nContenu du sac :\n"+Sac;
    }

    public void seDeplacer(int x,int y) throws CoordonneesIncorrectesException,CaseNonPleineException,DeplacementIncorrectException{
        if (!grille.sontValides(x, y)){
            throw new DeplacementIncorrectException("Il est sorti");
        }
        this.x=x;
        this.y=y;
        System.out.println("L'agent 5 se deplace en ("+x+","+y+") sans force") ;
        Contenu c = grille.getCase(x, y);
        if(!grille.caseEstVide(x, y)){
            if(c instanceof Joyaux  ){
                nbJoyaux += c.getQuantite();
                if (nbJoyaux<TailleSac){
                    while(cptjoy<nbJoyaux){
                        Sac[cptjoy] = (Joyaux) (c);
                        cptjoy++;
                    }
                    grille.videCase(x,y);
                    System.out.println(c.type+" de quantité "+c.getQuantite()+" ajouté au sac !");
                }else
                    System.out.println("Le sac est plein");
            }if (c.type == "Gardien"){
                for(int i = 0; i < cptjoy; i++){
                    Sac[i] = null;
                }
                cptjoy = 0;
                System.out.println("Agent a perdu son loot");
            }
            System.out.println("fortune : "+fortune()+"$");
        }
    }

    public void seDeplacer(int x,int y,int f) throws CoordonneesIncorrectesException,CaseNonPleineException,DeplacementIncorrectException{
        if (!grille.sontValides(x, y)){
            throw new DeplacementIncorrectException("Il est sorti");
        }
        this.x=x;
        this.y=y;
        System.out.println("L'agent 5 se deplace en ("+x+","+y+") avec une force = "+f) ;
        Contenu c = grille.getCase(x, y);
        if(!grille.caseEstVide(x, y)){
            if(c instanceof Joyaux){
                nbJoyaux += c.getQuantite();
                if (nbJoyaux < TailleSac){
                    System.out.println(c.type+" de quantité "+c.getQuantite()+" ajouté au sac !");
                    while(cptjoy<nbJoyaux){
                        Sac[cptjoy] = (Joyaux) (c);
                        cptjoy++;
                    }
                    grille.videCase(x,y);
                }else
                    System.out.println("Le sac est plein");
            }if (c.type == "Gardien"){
                Gardien gar = (Gardien)(c);
                if (gar.getHp() > f){
                    for(int i = 0; i < cptjoy; i++){
                        Sac[i] = null;
                    }
                    cptjoy = 0;
                    gar.setHp(gar.getHp()-f);
                    System.out.println("Agent a perdu son loot");
                } else{
                    gar.setHp(0);
                    grille.videCase(x, y);
                    System.out.println("Gardien assommé");
                }
            }
            System.out.println("fortune : "+fortune()+"$");
        }
    }

    public int fortune(){
        int res=0;
        for (int i=0; i<Sac.length; i++){
            if(Sac[i]!=null)
                res+=Sac[i].getPrix();
        }
        return res;
    }

    public void contenuSac(){
        System.out.println("Contenu du Sac :");
        for(int i=0;i<cptjoy;i++){
            System.out.print(Sac[i].toString()+" | ");
        }
        System.out.println("\n");
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getNbjoy(){
        return cptjoy;
    }
}
