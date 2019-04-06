package br.com.simpletron.teste;

import br.com.simpletron.controller.Comandos;
import br.com.simpletron.controller.Controlador;
import br.com.simpletron.controller.Processador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author adriel
 */
public class ClasseDeTeste extends Controlador {

    @Override
    public void executar(Processador processador) {
        int dado;
        int comando = processador.getMemoria(processador.
                getContadorDeInstrucao());
        processador.setOperacao(comando / 1000);
        processador.setOperando(comando % 1000);
        switch (processador.getOperacao()) {
            case Comandos.READ:
                int entrada = Integer.parseInt(JOptionPane.
                        showInputDialog("Entre: "));
                processador.setMemoria(processador.getOperando(), entrada);
                break;

            case Comandos.WRITE:
                dado = processador.getMemoria(processador.getOperando());
                processador.setBarramentoSaida(String.valueOf(dado));
                break;

            case Comandos.LOAD:
                dado = processador.getMemoria(processador.getOperando());
                processador.setAcumulador(dado);
                break;

            case Comandos.STORE:
                dado = processador.getAcumulador();
                processador.setMemoria(processador.getOperando(), dado);
                break;

            case Comandos.ADD:
                dado = processador.getMemoria(processador.getOperando());
                processador.setAcumulador(processador.getAcumulador() + dado);
                break;

            case Comandos.SUB:
                dado = processador.getMemoria(processador.getOperando());
                processador.setAcumulador(processador.getAcumulador() - dado);
                break;

            case Comandos.DIV:
                dado = processador.getMemoria(processador.getOperando());
                processador.setAcumulador(processador.getAcumulador() / dado);
                break;

            case Comandos.MUL:
                dado = processador.getMemoria(processador.getOperando());
                processador.setAcumulador(processador.getAcumulador() * dado);
                break;

            case Comandos.PUSH:
                dado = processador.getAcumulador();
                processador.setPilha(processador.getPilha() + 1);
                processador.setMemoria(processador.getPilha(), dado);
                break;

            case Comandos.POP:
                dado = processador.getMemoria(processador.getPilha());
                processador.setAcumulador(dado);
                processador.setPilha(processador.getPilha() - 1);
                break;

            case Comandos.BRANCH:
                processador.setContadorDeInstrucao(processador.
                        getOperando() - 1);
                break;

            case Comandos.BRANCHNEG:
                dado = processador.getAcumulador();
                if (dado < 0) {
                    processador.setContadorDeInstrucao(processador.
                            getOperando() - 1);
                }
                break;

            case Comandos.BRANCHZERO:
                dado = processador.getAcumulador();
                if (dado == 0) {
                    processador.setContadorDeInstrucao(processador.
                            getOperando() - 1);
                }
                break;

            case Comandos.READS:
                String string = JOptionPane.showInputDialog("Entre: ");
                int posicao = processador.getOperando();
                System.out.println(string.length() + "\noperando = " + posicao);
                for (int i = 0; i < string.length(); i++) {
                    if (processador.getMemoria(posicao) == Comandos.STRING_END) {
                        break;
                    }
                    processador.setMemoria(posicao,
                            (int) string.charAt(i));
                    posicao++;
                }
                break;

            case Comandos.PRINTS:
                int deslocador = processador.getOperando();
                String stringSaida = "";
                while (processador.getMemoria(deslocador)/1000 != Comandos.STRING_END) {
                    System.out.println(processador.getMemoria(deslocador)/1000);
                    stringSaida += (char) (processador.getMemoria(deslocador)%1000);
                    deslocador++;
                }
                processador.setBarramentoSaida(stringSaida);
                break;
        }
        processador.setContadorDeInstrucao(processador.
                getContadorDeInstrucao() + 1);
    }

    public static void main(String[] args) {
        ClasseDeTeste classeDeTeste = new ClasseDeTeste();
    }

    @Override
    public BufferedReader abrirDocumento() {
        JFileChooser fileChooser = new JFileChooser();
        int opcao = fileChooser.showOpenDialog(null);
        BufferedReader leitor = null;
        if (opcao == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                leitor = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado!",
                        "Falha", JOptionPane.WARNING_MESSAGE);
            }
        }
        return leitor;
    }

    @Override
    public String ajuda() {
        return "Hello World!";
    }

    @Override
    public FileWriter salvarDocumento() {
        FileWriter escritor = null;

        JFileChooser fileChooser = new JFileChooser();
        int opcao = fileChooser.showSaveDialog(null);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            try {
                escritor = new FileWriter(fileChooser.getSelectedFile());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Os dados não podem ser "
                        + "gravados no disco.", "Falha",
                        JOptionPane.WARNING_MESSAGE);

            }
        }
        return escritor;
    }

}
