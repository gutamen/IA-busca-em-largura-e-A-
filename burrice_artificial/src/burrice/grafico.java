/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice;

/**
 *
 * @author Gustavo
 */
import java.awt.*;  
import javax.swing.*;  
import java.awt.geom.*;  
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
  
//Extends JPanel class  
public class grafico extends JPanel{  
    
    
    int larguraLab, alturaLab;
    static labirinto lab;
    static boneca boneco;
    static JFrame Tela;
    
    public static int cont = 0;
public grafico(labirinto _lab, boneca _boneco){
    this.lab = _lab;
    this.larguraLab = _lab.posicoes[0].length;
    this.alturaLab = _lab.posicoes.length;
    this.boneco = _boneco;
}

    @Override
    protected void paintComponent(Graphics grf){  
        //create instance of the Graphics to use its methods  
        super.paintComponent(grf);  
        Graphics2D graph = (Graphics2D)grf;  
          
        //Sets the value of a single preference for the rendering algorithms.  
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
          
        // get width and height  
        int width = getWidth();  
        int height = getHeight();  
        int larguraQuad = width/this.larguraLab;
        int alturaQuad = height/this.alturaLab;
        
        
        graph.setPaint(Color.BLACK); 
        for(int i = 0; i < this.alturaLab; i++){
            for(int j = 0; j < this.larguraLab; j++){
                if(lab.posicoes[i][j] == 1)
                    graph.fillRect((j)*larguraQuad, (i)*alturaQuad, larguraQuad, alturaQuad);
                if(lab.posicoes[i][j] == 2){
                    graph.setPaint(Color.CYAN);
                    graph.fillOval(((j)*larguraQuad)+larguraQuad/4, ((i)*alturaQuad)+alturaQuad/4, larguraQuad-larguraQuad/2, alturaQuad-alturaQuad/2);
                    graph.setPaint(Color.BLACK); 
                }
            }
        }
        graph.setPaint(Color.PINK);
        graph.fillOval((boneco.getPosAtual().getX())*larguraQuad, 
                (boneco.getPosAtual().getY())*alturaQuad, 
                larguraQuad, alturaQuad);

        
        
        
        
        
    }  
      
        
      
    // funcao desenhar  
    public void desenha(){  
         
        Tela = new JFrame();
        Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Tela.add(this);  
        Tela.setSize(1000, 700);  
        Tela.setLocation(200, 10);  
        Tela.setVisible(true); 
        
        
        
            
        
    }  
    

}  