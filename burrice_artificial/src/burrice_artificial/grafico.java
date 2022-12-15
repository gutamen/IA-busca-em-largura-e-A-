/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

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
    //initialize coordinates  
    int[] cord = {65, 20, 40, 80};  
    int larguraLab, alturaLab;
    static labirinto lab;
    static boneca boneco;
   
    
    public static int cont = 0;
public grafico(labirinto _lab, boneca _boneco){
    this.lab = _lab;
    this.larguraLab = _lab.posicoes[0].length;
    this.alturaLab = _lab.posicoes.length;
    this.boneco = _boneco;
}

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
                    
            }
        }
        graph.setPaint(Color.PINK);
        graph.fillOval((boneco.getPos_atual().getX())*larguraQuad, 
                (boneco.getPos_atual().getY())*alturaQuad, 
                larguraQuad, alturaQuad);

        
        //find value of x and scale to plot points  
        double scaley = (double)(height/20);  
        double scalex = (double)(width/20);
        
        
        
        
    }  
      
    //create getMax() method to find maximum value  
    private int getMax(){  
        int max = -Integer.MAX_VALUE;  
        for(int i=0; i<cord.length; i++){  
            if(cord[i]>max)  
                max = cord[i];  
             
        }  
        return max;  
    }         
      
    // funcao desenhar  
    public void desenha(){  
         
        JFrame Tela = new JFrame();
        //System.out.println(boneco.getPos_atual().getX() + " " + boneco.getPos_atual().getY() );
        Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Tela.add(this);  
        Tela.setSize(1000, 700);  
        Tela.setLocation(200, 10);  
        Tela.setVisible(true); 
        
        
    }  
    

}  