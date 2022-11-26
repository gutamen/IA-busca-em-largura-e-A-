/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package burrice_artificial;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class Burrice_artificial {
    
    boolean funcaoFechada = true; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boneca boneco = new boneca();
        boneco.pos_atual.setX(3);
        boneco.pos_atual.setY(4); 
        
        boolean parou = false;
        labirinto lab = new labirinto();
        
        //for(int i=0;i<5;i++){
         //   for(int j=0;j<5;j++){
        //        System.out.print(lab.posicoes[i][j]);
         //   }
         //   System.out.println("");
        //}
                
      System.out.print(lab.posicoes[0][0]+" ");
      System.out.print(lab.posicoes[0][1]+" ");
      System.out.print(lab.posicoes[0][2]+" ");
      System.out.print(lab.posicoes[0][3]+" ");
      System.out.print(lab.posicoes[0][4]+" ");
      System.out.println("");
      
      System.out.print(lab.posicoes[1][0]+" ");
      System.out.print(lab.posicoes[1][1]+" ");
      System.out.print(lab.posicoes[1][2]+" ");
      System.out.print(lab.posicoes[1][3]+" ");
      System.out.print(lab.posicoes[1][4]+" ");
      System.out.println("");
      
      System.out.print(lab.posicoes[2][0]+" ");
      System.out.print(lab.posicoes[2][1]+" ");
      System.out.print(lab.posicoes[2][2]+" ");
      System.out.print(lab.posicoes[2][3]+" ");
      System.out.print(lab.posicoes[2][4]+" ");
      System.out.println("");
      
      System.out.print(lab.posicoes[3][0]+" ");
      System.out.print(lab.posicoes[3][1]+" ");
      System.out.print(lab.posicoes[3][2]+" ");
      System.out.print(lab.posicoes[3][3]+" ");
      System.out.print(lab.posicoes[3][4]+" ");
      System.out.println("");
      
      System.out.print(lab.posicoes[4][0]+" ");
      System.out.print(lab.posicoes[4][1]+" ");
      System.out.print(lab.posicoes[4][2]+" ");
      System.out.print(lab.posicoes[4][3]+" ");
      System.out.print(lab.posicoes[4][4]+" ");
      System.out.println("");
      
      
      
      
      
            boneco.decisao(lab,3);
            
           // boneco.pos_atual.setX(boneco.cha.peek().getX());
           // boneco.pos_atual.setY(boneco.cha.peek().getY());
            
        
        
    }
    
    
}
