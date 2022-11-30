/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

import java.util.ArrayList;
import java.util.List;
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
    
    Stack decisao(labirinto lab,int last){

        if((lab.pegaValorPos(lab.pegaPosAddX(this.pos_atual)) != 1) && last!=0){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setX(this.pos_atual.getX()+1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            decisao(lab,2);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubX(this.pos_atual)) != 1)&&last!=2){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setX(this.pos_atual.getX()-1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            
            decisao(lab,0);
        }
        
        if((lab.pegaValorPos(lab.pegaPosAddY(this.pos_atual)) !=  1) && last!=3){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setY(this.pos_atual.getY()-1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
           
            decisao(lab,1);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubY(this.pos_atual)) != 1 ) && last != 1){
            posicao newpos = new posicao(this.pos_atual.getY(),this.pos_atual.getX());
            this.cha.push(newpos);
            this.pos_atual.setY(this.pos_atual.getY()-1);
            System.out.println("X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
            
            if(lab.pegaValorPos(pos_atual) == 2)
                return cha;
            
            decisao(lab,3);
        }
                   
        if(lab.pegaValorPos(pos_atual) != 2){
            this.pos_atual = this.cha.pop(); 
            System.out.println("popou X atual = " + this.pos_atual.getX() + " Y atual = " + this.pos_atual.getY());
        }
        
        return cha;           
    }
    
    List decisao(labirinto lab,posicao inicial,posicao _final){
        posistrela comesso = new posistrela(null,inicial);
        int i = 0;
        
        comesso.calCusto(_final);
        List<posistrela> percurso = new ArrayList<posistrela>();
        
        percurso.add(comesso);
        
        while(true){
            posistrela um;
            posistrela dois;
            posistrela tres;
            posistrela cuatro;
            
            if((lab.pegaValorPos(lab.pegaPosAddX(percurso.get(i).getPos())) != 1)){
                um = new posistrela(percurso.get(i).getPos(),lab.pegaPosAddX(percurso.get(i).getPos()));
                um.calCusto(_final);
                percurso.add(um);
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubX(percurso.get(i).getPos())) != 1)){
                dois = new posistrela(percurso.get(i).getPos(),lab.pegaPosAddX(percurso.get(i).getPos()));
                dois.calCusto(_final);
                percurso.add(dois);
            }
            
            if((lab.pegaValorPos(lab.pegaPosAddY(percurso.get(i).getPos())) != 1)){
                tres = new posistrela(percurso.get(i).getPos(),lab.pegaPosAddX(percurso.get(i).getPos()));
                tres.calCusto(_final);
                percurso.add(tres);
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubY(percurso.get(i).getPos())) != 1)){
                cuatro = new posistrela(percurso.get(i).getPos(),lab.pegaPosAddX(percurso.get(i).getPos()));
                cuatro.calCusto(_final);
                percurso.add(cuatro);
            }
            
            for(int k = 0;k < percurso.size();k++){
                double menor = Double.MAX_VALUE;
                if(percurso.get(i).getCusto()<menor){
                    i = k;
                }
            }
            
            if(percurso.get(i).getCusto()==0)
                break;
            
        }
        return percurso;
    }
}
    
    

