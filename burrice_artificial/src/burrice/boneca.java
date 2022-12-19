/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ArrayList<posistrela> percurso;
    
    
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
                

            int existe = 0;
            for(int i = 0; i < cha.size();i++){
                if(cha.get(i).getX() == newpos.getX() && cha.get(i).getY() == newpos.getY()){
                    existe = 1;
                    break;
                }
            }
                

            if (existe == 0){
                this.cha.push(newpos);
                this.posAtual.setX(this.posAtual.getX()+1);
                System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
                decisao(lab,2, posAtual);
            }
                    
        }
                
                    
            
            
          
        if((lab.pegaValorPos(lab.pegaPosSubY(this.posAtual)) != 1 ) && last != 1){
            
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;

            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            
            
            int existe = 0;
            for(int i = 0; i < cha.size();i++){
                if(cha.get(i).getX() == newpos.getX() && cha.get(i).getY() == newpos.getY()){
                    existe = 1;
                    break;
                }
            }
            
            if(existe == 0){
                this.cha.push(newpos);
                this.posAtual.setY(this.posAtual.getY()-1);
                System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
                decisao(lab,3,posAtual);
            }
        }
            
            
            
        if((lab.pegaValorPos(lab.pegaPosSubX(this.posAtual)) != 1)&&last!=2){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;
            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            

            int existe = 0;
            for(int i = 0; i < cha.size();i++){
                if(cha.get(i).getX() == newpos.getX() && cha.get(i).getY() == newpos.getY()){
                    existe = 1;
                    break;
                }
            }

            if(existe == 0){
                this.cha.push(newpos);
                this.posAtual.setX(this.posAtual.getX()-1);
                System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
                decisao(lab,0,posAtual);
            }   
        }
            

            
        if((lab.pegaValorPos(lab.pegaPosAddY(this.posAtual)) !=  1) && last!=3){
            if(lab.pegaValorPos(posAtual) == 2)
                return cha;

            posicao newpos = new posicao(this.posAtual.getY(),this.posAtual.getX());
            

            int existe = 0;
            for(int i = 0; i < cha.size();i++){
                if(cha.get(i).getX() == newpos.getX() && cha.get(i).getY() == newpos.getY()){
                    existe = 1;
                    break;
                }
            }
            if(existe == 0){
                this.cha.push(newpos);
                this.posAtual.setY(this.posAtual.getY()+1);
                System.out.println("X atual = " + this.posAtual.getX() + " Y atual = " + this.posAtual.getY());
                decisao(lab,1,posAtual);
            }
        }
            
        
        
                   
        if(lab.pegaValorPos(posAtual) != 2 && !cha.empty()){
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
            posistrela um = null;
            posistrela dois = null;
            posistrela tres = null;
            posistrela cuatro = null;
            
            Thread corredor1 = null;
            Thread corredor2 = null;
            Thread corredor3 = null;
            Thread corredor4 = null;
            
            //System.out.println("Drage eh um macaco");
            if((lab.pegaValorPos(lab.pegaPosAddX(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 0){
                um = new posistrela(percurso.get(atual),lab.pegaPosAddX(percurso.get(atual).getPos()));
                um.calCusto(_final);
                um.setDirecao(2);
                
                
                corredor1 = new Thread(new forRunner(percurso, um));
                corredor1.start();
                
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubX(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 2){
                dois = new posistrela(percurso.get(atual),lab.pegaPosSubX(percurso.get(atual).getPos()));
                dois.calCusto(_final);
                dois.setDirecao(0);
                
                corredor2 = new Thread(new forRunner(percurso, dois));
                corredor2.start();
            }
            
            if((lab.pegaValorPos(lab.pegaPosAddY(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 3){
                tres = new posistrela(percurso.get(atual),lab.pegaPosAddY(percurso.get(atual).getPos()));
                tres.calCusto(_final);
                tres.setDirecao(1);
                
                corredor3 = new Thread(new forRunner(percurso, tres));
                corredor3.start();
            }
            
            if((lab.pegaValorPos(lab.pegaPosSubY(percurso.get(atual).getPos())) != 1) && percurso.get(atual).getDirecao() != 1){
                cuatro = new posistrela(percurso.get(atual),lab.pegaPosSubY(percurso.get(atual).getPos()));
                cuatro.calCusto(_final);
                cuatro.setDirecao(3);
                
                
                corredor4 = new Thread(new forRunner(percurso, cuatro));
                corredor4.start();
            }
            
            try {
                if(corredor1 != null)corredor1.join();
                if(corredor2 != null)corredor2.join();
                if(corredor3 != null)corredor3.join();
                if(corredor4 != null)corredor4.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(boneca.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            /*if(um != null){
                if(um.igual == 0) percurso.add(um);
            }
            if(dois !=null){
                if(dois.igual == 0) percurso.add(dois);
            }
            
            if(tres != null){
                if(tres.igual == 0) percurso.add(tres);
            }
            if(cuatro != null){
                if(cuatro.igual == 0) percurso.add(cuatro);
            }*/
            
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
    
    

