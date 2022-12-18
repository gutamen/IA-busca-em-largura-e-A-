/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package burrice_artificial;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gustavo
 */
public class Burrice_artificial {
    
    boolean funcaoFechada = true; 
    static grafico tela;
    static painelInicio inicio;
    static int tipo = 0;
    static Semaphore espera = new Semaphore(0);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        labirinto lab = new labirinto();
        boneca boneco = new boneca();
        boneco.setPos_atual(lab.posicaoInicial());
       
        
       
        
        
        
        inicio = new painelInicio();   
        inicio.inicia();
  
        
        
        try {
            espera.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Burrice_artificial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(tipo == 1){
            tela = new grafico(lab,boneco);
            tela.desenha();
            grafico.Tela.setTitle("Busca A*");
            buscaAEstrela(lab,boneco); 
            
            
            JOptionPane.showMessageDialog(tela, "Encontrou o Final","Finalização",JOptionPane.INFORMATION_MESSAGE);
            grafico.Tela.dispose();
            
        }else if(tipo == 2){
            tela = new grafico(lab,boneco);
            tela.desenha();
            grafico.Tela.setTitle("Busca Profundidade");
            buscaProfundidade(lab,boneco);
            JOptionPane.showMessageDialog(tela, "Encontrou o Final","Finalização",JOptionPane.INFORMATION_MESSAGE);
            grafico.Tela.dispose();
            
        }
          
        
    }
    
    public static void buscaProfundidade(labirinto lab, boneca boneco){
        
        Stack<posicao> cha;
        cha = boneco.decisao(lab,3,boneco.getPos_atual());
        while(!cha.empty()){
           System.out.println("caminho X = " + cha.peek().getX() +" Y = " + cha.peek().getY());
           cha.pop();
        }
    }
    
    public static void buscaAEstrela(labirinto lab, boneca boneco){
        
        
        
        
        List<posistrela> cha;
        cha = boneco.decisao(lab, 3 ,boneco.pos_atual,lab.posicaoFinal());
        posistrela pronto = new posistrela();
        for (int i = 0; i <cha.size(); i ++)
            if (cha.get(i).getCusto() == 0 ) pronto = cha.get(i);
        
        while(pronto.getAnterior() != null){
            System.out.println("Caminho percorrido X = " + pronto.getPos().getX() + " Y = " + pronto.getPos().getY());
            pronto = pronto.getAnterior();
        }
    }
    
    
 
    
    
}
