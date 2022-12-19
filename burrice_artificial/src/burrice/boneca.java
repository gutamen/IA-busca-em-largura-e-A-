/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gustavo
 */
public class boneca {
    public posicao posAtual;

    public posicao getPosAtual() {
        return posAtual;
    }

    public void setPosAtual(posicao posAtual) {
        this.posAtual = posAtual;
    }
    
    static private long time = 200;
    public Stack<posicao> cha;
    private List<posistrela> percurso;
    
    public boneca(){
        this.cha = new Stack<>();
        this.posAtual = new posicao(0,0);
        
    }
 
   public static void setTime(int time){
       boneca.time = time;
   }

    
    Stack decisao(labirinto lab,int last, posicao _pos){
        
        
        posAtual = _pos;
        
        //atualiza tela ************************************
        burriceArtificial.tela.repaint();
        try{TimeUnit.MILLISECONDS.sleep(time);}catch(Exception e){}
        //atualiza tela ************************************
        
        if((lab.pegaValorPos(lab.pegaPosAddX(this.posAtual)) != 1) && last!=0){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;
            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            this.cha.push(newpos);
            this.posAtual.setX(this.posAtual.getX()+1);
            System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
            
            
            
            decisao(lab,2, posAtual);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubY(this.posAtual)) != 1 ) && last != 1){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;
            
            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            this.cha.push(newpos);
            this.posAtual.setY(this.posAtual.getY()-1);
            System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
            
            
            
            decisao(lab,3,posAtual);
        }
        
        if((lab.pegaValorPos(lab.pegaPosSubX(this.posAtual)) != 1)&&last!=2){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;
            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            this.cha.push(newpos);
            this.posAtual.setX(this.posAtual.getX()-1);
            System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
            
            
            
            
            decisao(lab,0,posAtual);
        }
        
        if((lab.pegaValorPos(lab.pegaPosAddY(this.posAtual)) !=  1) && last!=3){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;
           
            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            this.cha.push(newpos);
            this.posAtual.setY(this.posAtual.getY()+1);
            System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
            
            
            
            decisao(lab,1,posAtual);
        }
        
        
                   
        if(lab.pegaValorPos(posAtual) != 2){
            this.posAtual = this.cha.pop();
            
            //atualiza tela ************************************
            burriceArtificial.tela.repaint();
            try{TimeUnit.MILLISECONDS.sleep(time);}catch(Exception e){}
            //atualiza tela ************************************
            
            System.out.println("popou X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
        }
        
        return cha;           
    }
    
    List decisao(labirinto lab,int direcao, posicao inicial,posicao _final){
        
        try{TimeUnit.MILLISECONDS.sleep(time);}catch(Exception e){}
        posistrela comesso = new posistrela(null,inicial);
        int atual = 0;
        
        comesso.calCusto(_final);
        comesso.setDirecao(direcao);
        comesso.visitado = true;
        percurso = new ArrayList<>();
        percurso.add(comesso);
        
        while(true){
            posistrela um;
            posistrela dois;
            posistrela tres;
            posistrela cuatro;
            //System.out.println("Drage eh um macaco");
            if((lab.pegaValorPos(lab.pegaPosAddX(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 0){
                um = new posistrela(percurso.get(atual),lab.pegaPosAddX(percurso.get(atual).getPos()));
                um.calCusto(_final);
                um.setDirecao(2);
                percurso.add(um);
                
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubX(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 2){
                dois = new posistrela(percurso.get(atual),lab.pegaPosSubX(percurso.get(atual).getPos()));
                dois.calCusto(_final);
                dois.setDirecao(0);
                percurso.add(dois);
                
            }
            
            if((lab.pegaValorPos(lab.pegaPosAddY(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 3){
                tres = new posistrela(percurso.get(atual),lab.pegaPosAddY(percurso.get(atual).getPos()));
                tres.calCusto(_final);
                tres.setDirecao(1);
                percurso.add(tres);
                
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubY(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 1){
                cuatro = new posistrela(percurso.get(atual),lab.pegaPosSubY(percurso.get(atual).getPos()));
                cuatro.calCusto(_final);
                cuatro.setDirecao(3);
                percurso.add(cuatro);
                
            }
            
            double menor = Double.MAX_VALUE;
            for(int k = 0;k < percurso.size();k++){    
                if(percurso.get(k).getCusto() < menor && !percurso.get(k).visitado){
                    menor = percurso.get(k).getCusto();
                    atual = k;
                    System.out.println(atual);   
                    
                }
            
                System.out.println("Posi X = "+ percurso.get(k).getPos().getX() +"; Y = " + percurso.get(k).getPos().getY() + "; Custo = " + percurso.get(k).getCusto()  );    
            }
            
            //atualiza tela**********
            this.posAtual = percurso.get(atual).getPos();
            burriceArtificial.tela.repaint();
            //***********************
            
            percurso.get(atual).visitado = true;
            
            if(percurso.get(atual).getCusto()<=0)
                break;
            else System.out.println(percurso.get(atual).getCusto() + "\n");
              
            
            //System.out.println(lab.pegaValorPos(lab.pegaPosSubY(percurso.get(atual).getPos())));
            
            try{TimeUnit.MILLISECONDS.sleep(time);}catch(Exception e){}
        }
        return percurso;
    }
}
    
    
