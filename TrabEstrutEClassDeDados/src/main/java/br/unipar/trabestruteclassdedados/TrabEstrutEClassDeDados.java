package br.unipar.trabestruteclassdedados;

import javax.swing.JOptionPane;

public class TrabEstrutEClassDeDados {

    public static void main(String[] args) {
        
        //definindo o tamanho que será atribuido ao vetor
        String tamVetor = JOptionPane.showInputDialog(null, 
                "Diga o tamanho do vetor que deseja ordenar:", 
                "Ordenação de Vetores", 
                -1);
        int numTamVetor = Integer.parseInt(tamVetor);
        
        //iniciando o vetor e atribuindo o valor de cada posição
        int [] vetor = new int [numTamVetor];
        for (int i = 0; i < vetor.length; i++) {
            String aux = JOptionPane.showInputDialog(null,
                    (i+1)+"° posição",
                    "Definindo posições", 
                    -1);
            vetor[i] = Integer.parseInt(aux);
        }
        
        //imprime o vetor em tela para conferencia
        String msg = "Vetor = ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += ", ";
        }
        JOptionPane.showConfirmDialog(null, 
                msg, 
                "Ordenação de Vetores", 
                -1, 
                -1);
        
        
        //while para validar se o número inserido é uma opção válida
        boolean opcaoValida = false;
        while(!opcaoValida){
            
            String opcaoVetor = JOptionPane.showInputDialog(null, 
                    "Selecione o método de ordenação que deseja utilizar:"
                    + "\n1 - Ordenação por Inserção"
                    + "\n2 - Ordenação por Seleção"
                    + "\n3 - Ordenação Bolha", 
                    "Ordenação de Vetores", 
                    -1);
            int opcao = Integer.parseInt(opcaoVetor);
            
            //"Menu" de opções de Ordenação que podem ser utilizadas
            switch (opcao) {
                case 1:
                    opcaoValida = true;
                    OrdenacaoPorInsercao(vetor);
                    break;
                case 2:
                    opcaoValida = true;
                    OrdenacaoPorSelecao(vetor);
                    break;
                case 3:
                    opcaoValida = true;
                    OrdenacaoBolha(vetor);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, 
                            "Opção Inválida. Tente novamente.", 
                            "Opção Inválida", 
                            0);
                    break;
            }
        }
    }
    public static void OrdenacaoPorInsercao(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        
        int chave;
        int j;
        
        for (int i = 1; i < vetorOrdenado.length; i++) {
            chave = vetorOrdenado[i];
            for (j = i-1; (j >= 0 && vetorOrdenado[j] > chave); j--) {
                vetorOrdenado[j+1] = vetorOrdenado[j];
            }
            vetorOrdenado[j+1] = chave;
        }
        
        String msg = "Vetor Original:      ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += ", ";
        }
        msg += "\nVetor Ordenado:  ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += ", ";
        }
        long tempoFim = System.currentTimeMillis();
        long tempoExecucao = tempoFim - tempoInicio;
        
        
        JOptionPane.showMessageDialog(null,
                msg += "\nTempo de Execução: "+ tempoExecucao+ "ms", 
                "Ordenação por Inserção", 
                -1);
    }
   
    public static void OrdenacaoPorSelecao(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        for (int i = 0; i < vetorOrdenado.length; i++) {
            
            int posicaoMenor = i;
            for (int j = i+1; j < vetorOrdenado.length; j++) {
                
                if(vetorOrdenado[j] < vetorOrdenado[posicaoMenor]){
                    posicaoMenor = j;
                }               
            }
            
            if(posicaoMenor != i){
                int aux = vetorOrdenado[i];
                vetorOrdenado[i] = vetorOrdenado[posicaoMenor];
                vetorOrdenado[posicaoMenor] = aux;
            }
        }
        String msg = "Vetor Original:      ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += ", ";
        }
        msg += "\nVetor Ordenado:  ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += ", ";
        }
        long tempoFim = System.currentTimeMillis();
        long tempoExecucao = tempoFim - tempoInicio;
        
        JOptionPane.showMessageDialog(null,
                msg += "\nTempo de Execução: "+ tempoExecucao+ "ms", 
                "Ordenação por Seleção", 
                -1);
    }
    
    public static void OrdenacaoBolha(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        
        boolean houveTroca= true;
        
        while(houveTroca){
            houveTroca = false;
            
            for (int i = 0; i < vetorOrdenado.length -1; i++) {
                
                if(vetorOrdenado[i] > vetorOrdenado[i+1]){
                    int aux = vetorOrdenado[i];
                    vetorOrdenado[i] = vetorOrdenado[i+1];
                    vetorOrdenado[i+1] = aux;
                    houveTroca = true;
                }
            }
        }
        
        String msg = "Vetor Original:      ";
        for (int i = 0; i < vetor.length; i++) {
            msg += vetor[i];
            if(i < vetor.length-1)
                msg += ", ";
        }
        msg += "\nVetor Ordenado:  ";
        for (int i = 0; i < vetorOrdenado.length; i++) {
            msg += vetorOrdenado[i];
            if(i < vetorOrdenado.length-1)
                msg += ", ";
        }
        long tempoFim = System.currentTimeMillis();
        long tempoExecucao = tempoFim - tempoInicio;
        
        JOptionPane.showMessageDialog(null,
                msg += "\nTempo de Execução: "+ tempoExecucao+ "ms", 
                "Ordenação Bolha", 
                -1);
    } 
}
