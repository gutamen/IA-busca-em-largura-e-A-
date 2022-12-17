/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

/**
 *
 * @author Gustavo
 */
public class labirinto {
    public int[][] posicoes = {{1,1,1,1,2,1,1},
                               {1,0,0,0,0,1,1},
                               {1,0,1,1,1,0,1},
                               {1,0,0,0,0,0,1},
                               {1,1,1,4,1,1,1}};

    int pegaValorPos(posicao pos){
       
        if(pos == null)
            return 1;
        if( pos.getX() > this.posicoes[0].length || pos.getX()<0)
            return 1;
        else if( pos.getY() > this.posicoes.length || pos.getY()<0)
            return 1;
        
        /*System.out.println(pos.getY()+"  "+pos.getX());
        System.out.println(this.posicoes[pos.getY()][pos.getX()]);*/
        
        return this.posicoes[pos.getY()][pos.getX()];
    }
    
    posicao pegaPosAddX(posicao pos){
        posicao newpos = new posicao(pos.getY(),pos.getX());
        newpos.setX(newpos.getX()+1);
        
        if( newpos.getX() >= this.posicoes[0].length)
            return null;
        
        
        return newpos;
    }
    
    posicao pegaPosSubX(posicao pos){
        posicao newpos = new posicao(pos.getY(),pos.getX());
        newpos.setX(newpos.getX()-1);
        if( newpos.getX() < 0)
            return null;
        
        
        return newpos;
    }
    
    posicao pegaPosAddY(posicao pos){
        posicao newpos = new posicao(pos.getY(),pos.getX());
        newpos.setY(newpos.getY()+1);
        if( newpos.getY() >= this.posicoes.length)
            return null;
        
        
        return newpos;
    }
    
    posicao pegaPosSubY(posicao pos){
        posicao newpos = new posicao(pos.getY(),pos.getX());
        newpos.setY(newpos.getY()-1);
        if( newpos.getY() < 0)
            return null;
       
        return newpos;
    }
    
    posicao posicaoFinal()
    {
        for(int i = 0; i < this.posicoes.length; i++){
            for(int j = 0; j < this.posicoes[0].length; j++)
            {
                if(this.posicoes[i][j] == 2)
                    return new posicao(i,j);
            }
        }
        return null;
        
    }
    
    posicao posicaoInicial()
    {
        for(int i = 0; i < this.posicoes.length; i++){
            for(int j = 0; j < this.posicoes[0].length; j++)
            {
                if(this.posicoes[i][j] == 4)
                    return new posicao(i,j);
            }
        }
        return null;
        
    }
    
    
} 
