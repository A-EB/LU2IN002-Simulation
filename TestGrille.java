// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.Iterator;

public class TestGrille {
   public TestGrille() {
   }

   public static void main(String[] var0) {
      Grille var1 = new Grille(4, 5);
      var1.affiche(2);
      System.out.println("Informations sur la grille:\n" + var1);
      Contenu var2 = new Contenu("Cepe", 5);

      try {
         var1.setCase(7, 41, var2);
         System.out.println("Ajout de " + var2 + " valide !");
      } catch (CoordonneesIncorrectesException var8) {
         System.out.println("Erreur: " + var8.getMessage());
      }

      try {
         var1.setCase(2, 3, var2);
         System.out.println("Ajout de " + var2 + " valide !");
      } catch (CoordonneesIncorrectesException var7) {
         System.out.println("Erreur: " + var7.getMessage());
      }

      var1.affiche(6);
      System.out.println("Informations sur la grille:\n" + var1);

      try {
         System.out.println("Dans la case (1,4): " + var1.getCase(1, 4));
         System.out.println("Liste de tous les Contenus pr\u00e9sents actuellement:");
      } catch (CoordonneesIncorrectesException var6) {
         System.out.println("Erreur: " + var6.getMessage());
      }

      ArrayList<Contenu> var3 = var1.lesContenus();
      Iterator<Contenu> var4 = var3.iterator();

      while(var4.hasNext()) {
         Contenu var5 = (Contenu)var4.next();
         System.out.println(var5);
      }

   }
}
