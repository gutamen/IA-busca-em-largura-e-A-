/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package burrice_artificial;

import java.util.List;
import java.util.Stack;


/**
 *
 * @author Gustavo
 */
public class Burrice_artificial {
    
    boolean funcaoFechada = true; 
    static grafico tela;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        
        labirinto lab = new labirinto();
        
        
        
        for (int[] posicoe : lab.posicoes) {
            for (int j = 0; j<lab.posicoes[0].length; j++) {
                System.out.print("   " + posicoe[j]);
            }
            System.out.println("");
        }
                
        
        boneca boneco = new boneca();
        boneco.pos_atual.setX(3);
        boneco.pos_atual.setY(4);
        
        tela = new grafico(lab,boneco);
        tela.desenha();
     
        Stack<posicao> cha;
        cha = boneco.decisao(lab,3,boneco.getPos_atual());
        while(!cha.empty()){
           System.out.println("caminho X = " + cha.peek().getX() +" Y = " + cha.peek().getY());
           cha.pop();
        }
           
           
        /*List<posistrela> cha;
        cha = boneco.decisao(lab, 3 ,boneco.pos_atual,new posicao(0,4));
        posistrela pronto = new posistrela();
        for (int i = 0; i <cha.size(); i ++)
            if (cha.get(i).getCusto() == 0 ) pronto = cha.get(i);
        
        while(pronto.getAnterior() != null){
            System.out.println("Caminho percorrido X = " + pronto.getPos().getX() + " Y = " + pronto.getPos().getY());
            pronto = pronto.getAnterior();
        }*/
               
           
            
        
        
    }
    
    
}
