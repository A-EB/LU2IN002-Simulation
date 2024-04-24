//Ali El Boukili 21210507
//BADR BENHAMMOU 21207429
public class TestSimulation{
    public static void main(String[] args)throws CaseNonPleineException, CoordonneesIncorrectesException, InterruptedException, DeplacementIncorrectException{
        Simulation s = new Simulation(30, 30, 7, 7);
        s.lancer(20);
    }
}
