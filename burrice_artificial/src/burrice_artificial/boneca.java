/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

import java.util.Stack;

/**
 *
 * @author Gustavo
 */
public class boneca {
    public posicao pos_atual = new posicao();

    public posicao getPos_atual() {
        return pos_atual;
    }

    public void setPos_atual(posicao pos_atual) {
        this.pos_atual = pos_atual;
    }
    
    public Stack<posicao> cha = new Stack<posicao>();
 
   
    int explora_profundidade(){
        int quantos_andou=0;      
        return quantos_andou;
    }
    
    boolean decisao(labirinto lab){
        
        if((lab.posicoes[pos_atual.getY()+1][pos_atual.getX()]!=1)){
            cha.push(pos_atual);
            pos_atual.setY(pos_atual.getY()+1);
            System.out.println("novo Y = "+ pos_atual.getY());
            return false;
        }else{
            if(lab.posicoes[pos_atual.getY()-1][pos_atual.getX()]!=1){
           cha.push(pos_atual);
            pos_atual.setY(pos_atual.getY()-1);
            System.out.println("novo Y = "+ pos_atual.getY());
            return false;
            }else{
                if(lab.posicoes[pos_atual.getY()][pos_atual.getX()-1]!=1){
                cha.push(pos_atual);
                pos_atual.setX(pos_atual.getX()-1);
                System.out.println("novo X = "+ pos_atual.getX());
                return false;
            }else{
                    if(lab.posicoes[pos_atual.getY()][pos_atual.getX()+1]!=1){
                     cha.push(pos_atual);
                       pos_atual.setX(pos_atual.getX()+1);
                    System.out.println("novo X = "+ pos_atual.getX());
                    return false;
                    }else{
                   
                        System.out.println("VAI SE FODER");
                        cha.pop();
                        pos_atual.setX(cha.peek().getX());
                        pos_atual.setY(cha.peek().getY());
                        return true;
                }
            }
        }
    }
         
    }
   
}
    
    

