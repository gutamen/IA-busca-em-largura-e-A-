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
        boneco.pos_atual.setX(4);
        boneco.pos_atual.setY(2);
        
        boolean parou = false;
        labirinto lab = new labirinto();
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(lab.posicoes[i][j]);
            }
            System.out.println("");
        }
                
      System.out.println(lab.posicoes[4][2]);
        while(parou==false){
            parou = boneco.decisao(lab);
            System.out.println("X atual = " + boneco.pos_atual.getX() + " Y atual = "+boneco.pos_atual.getY());
            //boneco.pos_atual.setX(boneco.cha.peek().getX());
           // boneco.pos_atual.setY(boneco.cha.peek().getY());
            
        }
        
    }
    
    
}
