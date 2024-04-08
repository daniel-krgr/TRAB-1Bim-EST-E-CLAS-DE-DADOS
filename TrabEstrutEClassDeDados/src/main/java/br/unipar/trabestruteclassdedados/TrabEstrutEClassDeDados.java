package br.unipar.trabestruteclassdedados;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TrabEstrutEClassDeDados {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        
        String tamVetor = JOptionPane.showInputDialog("Diga o tamanho do"
                + " vetor que deseja ordenar:");
        int numTamVetor = Integer.parseInt(tamVetor);
        
        int [] vetor = new int [Num];
        
        
        
        
        String opcaoVetor = JOptionPane.showInputDialog("Selecione o método de "
                + "ordenação que deseja utilizar:"
                + "\n1 - Ordenação por Inserção"
                + "\n2 - Ordenação por Seleção"
                + "3 - Ordenação Bolha");
        int opcao = Integer.parseInt(opcaoVetor);
        
        
        switch (opcao) {
            case 1:
                OrdenacaoPorInsercao();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                throw new AssertionError();
        }
    }
    public static void OrdenacaoPorInsercao(){
        int []vetor = {30,20,10,40,30,10};
        int chave;//armazenar o calor a ser comparado
        int j;//indice do segundo laço
        
        
        
        
        for (int i = 1; i < vetor.length; i++) {
            
            chave = vetor[i];
            for (j = i-1; (j >= 0 && vetor[j] > chave); j--) {
                vetor[j+1] = vetor[j];
            }
            vetor[j+1] = chave;
            
            
        }
        
        String msg = "";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - ";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
   
    public static void OrdenacaoPorSelecao(){
        int []vetor = {45,20,33,40,50,2,15,88,8};
        
        //temos 2 laços de repetição
        
        
        
        for (int i = 0; i < vetor.length; i++) {
            
            int posicaoMenor = i;
            
            for (int j = i+1; j < vetor.length; j++) {
                
                if(vetor[j] < vetor[posicaoMenor]){
                    posicaoMenor = j;
                }               
            }
            
            if(posicaoMenor != i){
                int aux = vetor[i];
                vetor[i] = vetor[posicaoMenor];
                vetor[posicaoMenor] = aux;
            }
        }
    
        String msg = "Vetor ordenado ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1){
                msg += ", ";
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void OrdenacaoBolha(){
        int[] vetor = {45,20,33,40,50,2,15,88,8};
        
        boolean houveTroca= true;
        
        while(houveTroca){
            houveTroca = false;
            
            for (int i = 0; i < vetor.length -1; i++) {
                
                if(vetor[i] > vetor[i+1]){
                    int aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    houveTroca = true;
                }
            }
        }
        
        String msg = "";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += " - ";
        }
        JOptionPane.showMessageDialog(null, msg);
    } 
}
