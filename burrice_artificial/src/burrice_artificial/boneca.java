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
        this.cha = new Stack<>();
        this.pos_atual = new posicao(0,0);
        
    }
 
   
    int explora_profundidade(){
        int quantos_andou=0;      
        return quantos_andou;
    }
    
    Stack decisao(labirinto lab,int last, int caminhos){
        int multiploCaminho = caminhos;
        
        /*int possibilidades = 0;
        if (lab.pegaValorPos(lab.pegaPosAddX(this.pos_atual)) == 0 && last!=0 )
            possibilidades++;
        if (lab.pegaValorPos(lab.pegaPosSubX(this.pos_atual)) == 0 && last!=2)
            possibilidades++;
        if (lab.pegaValorPos(lab.pegaPosAddY(this.pos_atual)) == 0 && last!=3)
            possibilidades++;
        if (lab.pegaValorPos(lab.pegaPosSubY(this.pos_atual)) == 0 && last!=1)
            possibilidades++;*/
        
        
        
        if((lab.pegaValorPos(lab.pegaPosAddX(this.pos_atual)) != 1) && last!=0){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setX(this.pos_atual.getX()+1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            decisao(lab,2,multiploCaminho);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubX(this.pos_atual)) != 1)&&last!=2){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setX(this.pos_atual.getX()-1);
            System.out.println("X atual = " + this.cha.peek().getX() + " Y atual = " + this.cha.peek().getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            
            decisao(lab,0,multiploCaminho);
        }
        
        if((lab.pegaValorPos(lab.pegaPosAddY(this.pos_atual)) !=  1) && last!=3){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setY(this.pos_atual.getY()-1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
           
            decisao(lab,1,multiploCaminho);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubY(this.pos_atual)) != 1 ) && last != 1){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setY(this.pos_atual.getY()-1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            decisao(lab,3,multiploCaminho);
        }
                   
        if(lab.pegaValorPos(pos_atual) != 2){
            this.pos_atual = this.cha.pop(); 
            System.out.println("popou X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
        }
        
        return cha;           
    }  
}
    
    

