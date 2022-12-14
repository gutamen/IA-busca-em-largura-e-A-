/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

/**
 *
 * @author vinid
 */
public class posistrela {

    public posicao getPos() {
        return pos;
    }

    public void setPos(posicao pos) {
        this.pos = pos;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public posistrela getAnterior() {
        return anterior;
    }

    public void setAnterior(posistrela anterior) {
        this.anterior = anterior;
    }
    private posicao pos;
    private double custo = 0;
    private posistrela anterior;
    boolean visitado = false;

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }
    private int direcao = -1;
    
    public posistrela(posistrela _anterior,posicao _pos){
        this.anterior = _anterior;
        this.pos = _pos;
    }
    
    public posistrela(){
        this.pos = new posicao(0,0);
        //this.anterior = new posicao(0,0);
    }
    
    public double calCusto(posicao _final){
        this.custo = Math.sqrt(Math.pow((this.pos.getX()-_final.getX()),2)+Math.pow((this.pos.getY()-_final.getY()),2));
        return this.custo;
    }
}
