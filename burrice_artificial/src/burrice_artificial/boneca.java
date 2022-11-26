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
    public posicao pos_atual;

    public posicao getPos_atual() {
        return pos_atual;
    }

    public void setPos_atual(posicao pos_atual) {
        this.pos_atual = pos_atual;
    }
    
    public Stack<posicao> cha;
    
    public boneca(){
        this.cha = new Stack();
        this.pos_atual = new posicao();
        
    }
 
   
    int explora_profundidade(){
        int quantos_andou=0;      
        return quantos_andou;
    }
    
    void decisao(labirinto lab,int last){
        
        if((lab.posicoes[this.pos_atual.getY()][this.pos_atual.getX()+1]!=1)&&last!=0){
            this.cha.push(this.pos_atual);
            this.pos_atual.setX(this.pos_atual.getX()+1);
            System.out.println("X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
            decisao(lab,2);
        }
        
        if((lab.posicoes[this.pos_atual.getY()][this.pos_atual.getX()-1]!=1)&&last!=2){
            this.cha.push(this.pos_atual);
            this.pos_atual.setX(this.pos_atual.getX()-1);
            System.out.println("X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
            decisao(lab,0);
        }
        
        if((lab.posicoes[this.pos_atual.getY()-1][this.pos_atual.getX()]!=1)&&last!=1){
            this.cha.push(this.pos_atual);
            this.pos_atual.setY(this.pos_atual.getY()-1);
            System.out.println("X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
            decisao(lab,3);
        }
        if((lab.posicoes[this.pos_atual.getY()+1][this.pos_atual.getX()]!=1)&&last!=3){
            this.cha.push(this.pos_atual);
            this.pos_atual.setY(this.pos_atual.getY()+1);
            System.out.println("X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
            decisao(lab,1);
        }
                   
        
        this.cha.pop(); 
        System.out.println("popou X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
        
                              
    }  
}
    
    

