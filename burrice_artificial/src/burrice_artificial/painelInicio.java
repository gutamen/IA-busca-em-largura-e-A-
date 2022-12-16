/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice_artificial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class painelInicio extends JFrame implements ActionListener {
    
    
private JButton iniciaProfundidade;
private JButton iniciaAistrela;
private JPanel fundo;


public painelInicio(){
    this.iniciaAistrela = new JButton("Trabalhar com A-Estrela");
    this.iniciaProfundidade = new JButton("Trabalhar com Busca em Profundidade");
    this.fundo = new JPanel();
            
    
    iniciaAistrela.setSize(300, 100);
    iniciaAistrela.setLocation(49, 50);
    iniciaAistrela.addActionListener(this);
    iniciaProfundidade.setSize(300, 100);
    iniciaProfundidade.addActionListener(this);
    iniciaProfundidade.setLocation(49,170);
    
    fundo.setSize(400, 400);
}


    
    
    
    public void inicia(){

            painelInicio Tela = this;
            Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            Tela.add(this.iniciaAistrela);
            Tela.add(this.iniciaProfundidade);
            Tela.add(fundo);
            Tela.setSize(400, 400);  
            Tela.setLocation(0, 10);  
            Tela.setVisible(true);
            
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iniciaAistrela)
        {   
            this.dispose();
            this.invalidate();
            this.removeAll();
            
            
            Burrice_artificial.tipo = 1;
            
            Burrice_artificial.espera.release();
            
            return;
            
        }
        
        if(e.getSource() == iniciaProfundidade)
        {   
            this.dispose();
            this.invalidate();
            this.removeAll();
            
            
            Burrice_artificial.tipo = 2;
            
            Burrice_artificial.espera.release();
            
            return;
            
        }
        
                
    }

}

