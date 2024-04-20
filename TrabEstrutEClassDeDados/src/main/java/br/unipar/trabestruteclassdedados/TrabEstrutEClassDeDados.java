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
        
        String[] opcoes = {"Crescente", "Decrescente", "Sair"};
        boolean opcaoInvalida = false;

        while (!opcaoInvalida) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Deseja ordenar de qual forma?",
                "Ordenação de Vetores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    opcaoCrescente(vetor);
                    break;
                case 1:
                    opcaoDecrescente(vetor);
                    break;
                case 2:
                    opcaoInvalida = true;
                    break;
                default:
                    opcaoInvalida = true;
                    break;
            }
        }
    }
    public static void opcaoCrescente(int vetor[]){//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        String[] opcoes = {"Inserção", "Seleção", "Bolha", "Voltar"};
        boolean opcaoInvalida = false;

        while (!opcaoInvalida) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecione o método de ordenação que deseja utilizar",
                "Ordenação de Vetores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    OrdenacaoPorInsercao(vetor);
                    break;
                case 1:
                    OrdenacaoPorSelecao(vetor);
                    break;
                case 2:
                    OrdenacaoBolha(vetor);
                    break;
                case 3:
                    return;
                default:
                    opcaoInvalida = true;
                    break;
            }
        }
    }
    public static void opcaoDecrescente(int vetor[]){//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        String[] opcoes = {"Inserção", "Seleção", "Bolha", "Voltar"};
        boolean opcaoInvalida = false;

        while (!opcaoInvalida) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecione o método de ordenação que deseja utilizar",
                "Ordenação de Vetores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    OrdenacaoPorInsercaoDecrescente(vetor);
                    break;
                case 1:
                    OrdenacaoPorSelecaoDrecrescente(vetor);
                    break;
                case 2:
                    OrdenacaoBolhaDrecrescente(vetor);
                    break;
                case 3:
                    return;
                default:
                    opcaoInvalida = true;
                    break;
            }
        }
    }
    
    //Ordenações por Inserção, crescente e decrescente.=================================================================================
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
    public static void OrdenacaoPorInsercaoDecrescente(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        
        int chave;
        int j;
        
        for (int i = 1; i < vetorOrdenado.length; i++) {
            chave = vetorOrdenado[i];
            for (j = i-1; (j >= 0 && vetorOrdenado[j] < chave); j--) {
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
   
    
    
    //Ordenações por Seleção, crescente e drecescente.==================================================================================
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
    public static void OrdenacaoPorSelecaoDrecrescente(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        for (int i = 0; i < vetorOrdenado.length; i++) {
            
            int posicaoMaior = i;
            for (int j = i+1; j < vetorOrdenado.length; j++) {
                
                if(vetorOrdenado[j] > vetorOrdenado[posicaoMaior]){
                    posicaoMaior = j;
                }               
            }
            
            if(posicaoMaior != i){
                int aux = vetorOrdenado[i];
                vetorOrdenado[i] = vetorOrdenado[posicaoMaior];
                vetorOrdenado[posicaoMaior] = aux;
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
    
    
    
    //Ordenações Bolha, crescente e decrescente.========================================================================================
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
    public static void OrdenacaoBolhaDrecrescente(int vetor[]){
        long tempoInicio = System.currentTimeMillis();
        
        int [] vetorOrdenado = vetor.clone();
        
        boolean houveTroca= true;
        
        while(houveTroca){
            houveTroca = false;
            
            for (int i = 0; i < vetorOrdenado.length -1; i++) {
                
                if(vetorOrdenado[i] < vetorOrdenado[i+1]){
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
