public class GardienTele extends Gardien implements Teleportable{
    private Grille grille;

    public GardienTele(int quant,Grille grille){
        super(quant);
        this.grille=grille;
    }
    public void seDeplacerTele() throws DeplacementIncorrectException, InterruptedException, CoordonneesIncorrectesException, CaseNonPleineException{
        int x = (int)(Math.random()*(grille.nbLignes));
        int y = (int)(Math.random()*(grille.nbColonnes));
        if(this.getX()!=-1){
            grille.videCase(this.getX(), this.getY()); // on enleve le gardien avant la teleportation
            grille.setCase(x, y, this); // on le met dans la nouvelle case
        }else{
            while(!grille.caseEstVide(x, y)){ //Si la case est rempli on change les coordonnées
                    x = (int)(Math.random()*(grille.nbLignes));
                    y = (int)(Math.random()*(grille.nbColonnes));
            }
            grille.setCase(x, y, this);
        }
        
    }
}
