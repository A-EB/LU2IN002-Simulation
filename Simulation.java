//Ali El Boukili 21210507
//BADR BENHAMMOU 21207429
public class Simulation {
    private Grille grille;
    private Agent5 agent;
    private Contenu [] TabCont;
    private GardienTele [] TabGard; // Ajout d'un tableau de GardienTele
    private int nbGard = 7; // Ajout d'une variable pour le nombre de gardiens
    private int cptgar=0;

    public Simulation(int tailleSac,int m, int nbl, int nbc) throws CoordonneesIncorrectesException{
       grille = new Grille(nbl,nbc);
       agent = new Agent5(grille, tailleSac);
       TabCont = new Contenu[m];
       TabGard = new GardienTele[nbGard]; // Initialisation du tableau de GardienTele avec la variable nbGard
        for(int i=0;i<TabCont.length;i++){
            int x = (int)(Math.random()*(grille.nbLignes));
            int y = (int)(Math.random()*(grille.nbColonnes));
            if(Math.random()<0.8){
                if(Math.random()<0.1){
                    Joyaux j = new Diamant("Diamant",(int)(Math.random()*10+1));
                    grille.setCase(x,y,j);
                }if(Math.random()<0.3){
                    Joyaux j = new Ruby("Ruby",(int)(Math.random()*10+1));
                    grille.setCase(x,y,j);
                }if(Math.random()<0.6){
                    Joyaux j = new Opale("Opale",(int)(Math.random()*10+1));
                    grille.setCase(x,y,j);
                }
            }
        }
        int x = (int)(Math.random()*(grille.nbLignes));
        int y = (int)(Math.random()*(grille.nbColonnes));
        TabGard[0] = new GardienTele(1,grille); 
        cptgar++;
        grille.setCase(x,y,TabGard[0]);
        // Ajout d'une boucle for pour créer les gardiens
        for(int i=1;i<TabGard.length;i++){
            if(Math.random() < 0.5){
                x = (int)(Math.random()*(grille.nbLignes));
                y = (int)(Math.random()*(grille.nbColonnes));
                TabGard[cptgar] = new GardienTele(1,grille);
                grille.setCase(x,y,TabGard[cptgar]); // Placement du GardienTele sur la grille
                cptgar++;
            }else{
                x = (int)(Math.random()*(grille.nbLignes));
                y = (int)(Math.random()*(grille.nbColonnes));
                Gardien g = new Gardien(1); 
                grille.setCase(x,y,g); //Placement du gardien normale sur la grille
            }
        }
       
    }

    public String toString(){
        return grille+"\n"+agent;
    }

    public void lancer(int nbEtapes) throws DeplacementIncorrectException, InterruptedException, CoordonneesIncorrectesException, CaseNonPleineException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        grille.affiche(7);

        Thread.sleep(5000);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        //Premier deplacement de l'agent dans la grille
        if (Math.random() < 0.3){
            agent.seDeplacer(0, 0);
            if(agent.getNbjoy() != 0 )
                agent.contenuSac();
        }
        else{
            int force = (int)(Math.random()*(91)+10);
            int cpt=0;
            for(int i=0;i<cptgar;i++){ // Parcours du tableau de GardienTele
                if(Math.random()<((double)force/100.0)){
                    TabGard[i].seDeplacerTele(); // Déplacement de chaque GardienTele
                    //System.out.println("Gardien "+i+" deplacé ! ("+TabGard[i].getX()+" , "+TabGard[i].getY()+")"); Affichage plus detaillé du déplacement//
                    cpt++;
                }
            }
            System.out.println(cpt+" Gardiens se sont téléporter !");
            agent.seDeplacer(0, 0, force);
            if(agent.getNbjoy() != 0 )
                agent.contenuSac();
        }
        for (int i=0; i<nbEtapes; i++){
            grille.affiche(7);
            Thread.sleep(5000);
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            int xagent = agent.getX(), yagent = agent.getY();
            int xnew  = (int)(Math.random()*(3)+(xagent-1));
            int ynew = (int)(Math.random()*(3)+(yagent-1));

            try{
                if (Math.random() < 0.3){
                    agent.seDeplacer(xnew, ynew);
                    if(agent.getNbjoy() != 0 )
                        agent.contenuSac();
                } else{
                    int force = (int)(Math.random()*(91)+10);
                    int cptj=0;
                    for(int j=0;j<cptgar;j++){
                        if(Math.random()<((double)force/100.0)){
                            TabGard[j].seDeplacerTele(); 
                            //System.out.println("Gardien "+j+" deplacé ! ("+TabGard[j].getX()+" , "+TabGard[j].getY()+")"); Affichage plus détaillé pour les gardiens//
                            cptj++;
                        }
                    }
                    System.out.println(cptj+" Gardiens se sont téléporter !");
                    agent.seDeplacer(xnew, ynew, force);
                    if(agent.getNbjoy() != 0 )
                        agent.contenuSac();
                }
            }catch(DeplacementIncorrectException e){
                //On corrige le deplacement de l'agent si il sort de la grille
                if(xnew >= grille.nbLignes)
                    xnew=grille.nbLignes-1;
                if(ynew >= grille.nbColonnes)
                    ynew=grille.nbColonnes-1;
                if(xnew < 0)
                    xnew=0;
                if(ynew < 0)
                    ynew=0;
                if (Math.random() < 0.3){
                    agent.seDeplacer(xnew, ynew);
                    if(agent.getNbjoy() != 0 )
                        agent.contenuSac();
                } else{
                    int force = (int)(Math.random()*(91)+10);
                    int cptj=0;
                    for(int j=0;j<cptgar;j++){
                        if(Math.random()<((double)force/100.0)){
                            TabGard[j].seDeplacerTele(); 
                            //System.out.println("Gardien "+j+" deplacé ! ("+TabGard[j].getX()+" , "+TabGard[j].getY()+")"); Affichage plus détaillé pour les gardiens//
                            cptj++;
                        }
                    }
                    System.out.println(cptj+" Gardiens se sont téléporter !");
                    agent.seDeplacer(xnew, ynew, force);
                    if(agent.getNbjoy() != 0 )
                        agent.contenuSac();
                } 
            }
            
        }
        grille.affiche(7);
        Thread.sleep(5000);  
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}
