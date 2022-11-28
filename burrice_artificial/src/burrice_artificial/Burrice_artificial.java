/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package burrice_artificial;

import java.util.Stack;
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
        
        for (int[] posicoe : lab.posicoes) {
            for (int j = 0; j<lab.posicoes[0].length; j++) {
                System.out.print("   " + posicoe[j]);
            }
            System.out.println("");
        }
                
        
      
     
           Stack<posicao> cha;
      
           cha = boneco.decisao(lab,3,-1);
           
           for (int i = 0; i <cha.size(); i ++)
            System.out.println("X = "+cha.get(i).getX()+ " " + "Y = "+cha.get(i).getY());
            
           // boneco.pos_atual.setX(boneco.cha.peek().getX());
           // boneco.pos_atual.setY(boneco.cha.peek().getY());
            
        
        
    }
    
    
}
