/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burrice;

import java.awt.Font;
import static java.awt.Font.MONOSPACED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Gustavo
 */
public class painelInicio extends JFrame implements ActionListener {
    
    
private JButton iniciaProfundidade;
private JButton iniciaAistrela, escolheArquivo;
private JPanel fundo;
private JSpinner temporizador;
private JTextField spinnerText, spinnerTextTimeType;
private JFileChooser selecionaLab;


public painelInicio(){
    UIManager.put("FileChooser.cancelButtonText", "Cancelar");
    UIManager.put("FileChooser.cancelButtonToolTipText", "Cancela a Seleção");
    this.iniciaAistrela = new JButton("Trabalhar com A-Estrela");
    this.iniciaProfundidade = new JButton("Trabalhar com Busca em Profundidade");
    this.temporizador = new JSpinner(new SpinnerNumberModel(200,0,2000,10));
    this.fundo = new JPanel();
    this.spinnerText = new JTextField("Tempo de Execução");
    this.spinnerTextTimeType = new JTextField("ms");
    this.escolheArquivo = new JButton("Selecione o Labirinto");
    this.selecionaLab = new JFileChooser();        
    
    
    
    temporizador.setSize(100, 30);
    temporizador.setLocation(184, 300);
    temporizador.setFont(new Font(MONOSPACED,0,11));
    temporizador.addChangeListener((ChangeEvent e) -> {
        boneca.setTime((Integer)temporizador.getValue());
    });
    
    
    spinnerTextTimeType.setLocation(285, 300);
    spinnerTextTimeType.setSize(30, 30);
    spinnerTextTimeType.setEditable(false);
    spinnerTextTimeType.setFont(new Font(MONOSPACED,0,11));
    
    spinnerText.setLocation(63, 300);
    spinnerText.setSize(120, 30);
    spinnerText.setEditable(false);
    spinnerText.setFont(new Font(MONOSPACED,0,11));
   
    iniciaAistrela.setSize(300, 100);
    iniciaAistrela.setLocation(49, 50);
    iniciaAistrela.addActionListener(this);
    iniciaAistrela.setFont(new Font(MONOSPACED,0,11));
    
    iniciaProfundidade.setSize(300, 100);
    iniciaProfundidade.addActionListener(this);
    iniciaProfundidade.setLocation(49,170);
    iniciaProfundidade.setFont(new Font(MONOSPACED,0,11));
    
    escolheArquivo.setSize(200, 30);
    escolheArquivo.addActionListener(this);
    escolheArquivo.setLocation(99,10);
    escolheArquivo.setFont(new Font(MONOSPACED,0,11));
    
    fundo.setSize(400, 400);
}


    
    
    
    public void inicia(){

            painelInicio Tela = this;
            this.setTitle("Menu");
            
            Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            Tela.add(this.iniciaAistrela);
            Tela.add(this.iniciaProfundidade);
            Tela.add(this.temporizador);
            Tela.add(this.spinnerText);
            Tela.add(this.spinnerTextTimeType);
            Tela.add(this.escolheArquivo);
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
            
            
            burriceArtificial.tipo = 1;
            
            burriceArtificial.espera.release();
            
            return;
            
        }
        
        if(e.getSource() == iniciaProfundidade)
        {   
            this.dispose();
            this.invalidate();
            this.removeAll();
            
            
            burriceArtificial.tipo = 2;
            
            burriceArtificial.espera.release();
            
            return;
            
        }
        
        if(e.getSource() == escolheArquivo)
        {   
            int[][] newMatrix;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de Texto", "txt", "text");
            selecionaLab.setFileFilter(filter);
            selecionaLab.setDialogTitle("Selecione o Labirinto");
            selecionaLab.setApproveButtonText("Selecionar");
            selecionaLab.setApproveButtonToolTipText("Somente Arquivos de Texto");
            selecionaLab.setAcceptAllFileFilterUsed(false);
            selecionaLab.setDragEnabled(false);
            selecionaLab.setMultiSelectionEnabled(false);
            
            
            
            
            int returnVal = selecionaLab.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = selecionaLab.getSelectedFile();
                String data = null;
                try {
                    data = new String(Files.readAllBytes(file.toPath()));
                } catch (IOException ex) {
                    Logger.getLogger(painelInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                char[] matrixConverter = null;
                if(data != null) matrixConverter = data.toCharArray();
                
                int copier = 0;
                int copierLine = 0;
                int matrixHeight = 0;
                int copierAux = 0;
                int temQuatro = 0;
                int temDois = 0;
                
                
                for(int i = 0; i < matrixConverter.length; i++){
                    if(matrixConverter[i] == 48 || matrixConverter[i] == 49 || matrixConverter[i] == 52 || matrixConverter[i] == 50) copierLine++;
                    
                    if(matrixConverter[i] == 10) break;
                }
                
                for(int i = 0; i < matrixConverter.length; i++){
                    if(matrixConverter[i] == 10)
                       matrixHeight++; 
                }
                
                newMatrix = new int[matrixHeight+1][copierLine];
               
                   
                 
                matrixHeight = 0;
                while(copier< matrixConverter.length){
                    
                    
                    if(matrixConverter[copier] == 48 || matrixConverter[copier] == 49 || matrixConverter[copier] == 52 || matrixConverter[copier] == 50)
                    {
                        /*System.out.println(matrixHeight);
                        System.out.println(copierAux);*/
                        
                        newMatrix[matrixHeight][copierAux] = matrixConverter[copier] - 48;
                        
                        
                        if(newMatrix[matrixHeight][copierAux] == 2){
                            temDois++;
                        }else if(temDois > 1){
                            JOptionPane.showMessageDialog(this, "Muitas Saídas\n Retorna a Matriz padrão","Erro",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        if(newMatrix[matrixHeight][copierAux] == 4){
                            temQuatro++;
                        }else if(temQuatro > 1){
                            JOptionPane.showMessageDialog(this, "Muitas Entradas\n Retorna a Matriz padrão","Erro",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                        copierAux++;
                        
                    }else if(copierAux > copierLine){
                        JOptionPane.showMessageDialog(this, "Formato de Matriz Incorreto\n Retorna a Matriz padrão","Erro",JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if(copierLine == newMatrix[0].length && matrixConverter[copier] == 10){
                        matrixHeight++;
                        copierAux = 0;
                    }
                        
                    
                    copier++;
                    
                }
                
                if(temQuatro == 0 || temDois == 0){
                    JOptionPane.showMessageDialog(this, "Formato de Matriz falta entrada ou saída\n Retorna a Matriz padrão","Erro",JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
               
               copierAux = 0;
               for(int i = 0; i <= newMatrix[0].length; i++)
               {
                   if(i < newMatrix[0].length){
                       if(newMatrix[newMatrix.length-1][i] != 0 ){
                           copierAux++;
                       }
                   }else if(copierAux == 0){
                       copierAux = -1;
                   }
                   
               }
              
               if(copierAux == -1){
                    int[][] newnewMatrix = new int[newMatrix.length-1][newMatrix[0].length];
                    System.arraycopy(newMatrix, 0, newnewMatrix, 0, newMatrix.length-1);
                    burriceArtificial.lab.posicoes = newnewMatrix;
                    burriceArtificial.boneco.setPosAtual(burriceArtificial.lab.posicaoInicial());
                    return;
               }
               
               System.out.println(newMatrix.length);
               burriceArtificial.lab.posicoes = newMatrix;
               burriceArtificial.boneco.setPosAtual(burriceArtificial.lab.posicaoInicial());
                     
            } 
            
        }
        
                
    }

}

