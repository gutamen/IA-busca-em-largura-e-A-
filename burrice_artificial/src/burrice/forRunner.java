/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo
 */



public class forRunner implements Runnable {
    private ArrayList<posistrela> percurso;
    private posistrela pos;
    
    public forRunner(ArrayList<posistrela> _per, posistrela _pos){
        this.percurso = _per;
        this.pos = _pos;
    }
    
    public void runner(){
        //System.out.println("jegui");
        for(int i = 0; i < this.percurso.size(); i++)
        {
            if(this.percurso.get(i).getPos().getX() == this.pos.getPos().getX() && this.percurso.get(i).getPos().getY() == this.pos.getPos().getY()){
                //pos.igual = 1;
                return;
            }
                        
        }
        percurso.add(pos);
        
    }
    
    @Override
    public void run() {
        this.runner();
    }
    
}
