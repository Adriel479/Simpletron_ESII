package br.com.simpletron.controller;

import br.com.simpletron.view.Ajuda;
import br.com.simpletron.view.Simpletron;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * <p>
 * A classe é responsável por ligar as funções do processador à tela do MPS.</p>
 *
 */
@SuppressWarnings("")
public abstract class Controlador implements ActionListener {

    private final Simpletron telaPrincipal;
    private final Processador processador;
    private final DefaultTableModel modelo;
    private int quantidadeDeLinhas;

    public Controlador() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simpletron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        telaPrincipal = new Simpletron();

        telaPrincipal.btnExecutar.addActionListener(this);
        telaPrincipal.btnAbrir.addActionListener(this);
        telaPrincipal.btnAjuda.addActionListener(this);
        telaPrincipal.btnSalvar.addActionListener(this);

        modelo = (DefaultTableModel) telaPrincipal.tbMemoria.getModel();

        processador = new Processador();
    }

    /**
     * <p>
     * Método ouvinte.</p>
     *
     * @param evento - ActionEvent
     */
    @Override
    public final void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == telaPrincipal.btnAbrir) {
            String conteudo = "";
            try ( BufferedReader leitor = abrirDocumento()) {
                while (leitor.ready()) {
                    conteudo += leitor.readLine() + "\n";
                }
                telaPrincipal.tfCodigo.setText(conteudo);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o arquivo.", "Simpletron - Falha - Arquivo", JOptionPane.WARNING_MESSAGE);
            }
        } else if (evento.getSource() == telaPrincipal.btnAjuda) {
            new Ajuda(telaPrincipal, true, ajuda()).setVisible(true);
        } else if (evento.getSource() == telaPrincipal.btnExecutar) {
            reinicializador();
            apresentarResultados();

            String[] comandos = telaPrincipal.tfCodigo.getText().split("\n");

            int contador = 0;
            for (String comando : comandos) {
                if (comando.matches("[+|-][0-9]{5}")) {
                    processador.setMemoria(contador++, Integer.parseInt(comando, 10));
                } else {
                    JOptionPane.showMessageDialog(telaPrincipal, "A sintaxe do programa é inválida!", "Simpletron - Falha - Sintaxe", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            if (contador < 1000) {
                processador.setPilha(contador - 1);
            } else {
                JOptionPane.showMessageDialog(null, "O Simpletron não possui memória suficiente.", "Simpletron - Falha - Memória", JOptionPane.WARNING_MESSAGE);
            }

            quantidadeDeLinhas = processador.getTamanhoMemoria() / 10;

            new Thread(() -> {
                while (processador.getOperacao() != 53) {
                    executar(processador);
                    apresentarResultados();
                }
            }).start();
        } else {
            try ( FileWriter escritor = salvarDocumento();) {
                escritor.write(telaPrincipal.tfCodigo.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Os dados não podem ser "
                        + "gravados no disco.", "Simpletron"
                        + " - Falha - Arquivo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void reinicializador() {
        // Reinicialização - Registradores
        processador.setAcumulador(0);
        processador.setContadorDeInstrucao(0);
        processador.setOperacao(0);
        processador.setOperando(0);
        processador.setPilha(0);
        processador.setSaidaPadrao("");

        // Reinicialização -Memória
        for (int i = 0; i < 1000; i++) {
            processador.setMemoria(i, 0);
        }

        telaPrincipal.tfSaida.setText("");

        apresentarResultados();
    }

    private void apresentarResultados() {
        telaPrincipal.tfAcumulador.setText(String.format("%04d", processador.getAcumulador()));
        telaPrincipal.tfCI.setText(String.format("%04d", processador.getContadorDeInstrucao()));
        telaPrincipal.tfOperacao.setText(String.format("%04d", processador.getOperacao()));
        telaPrincipal.tfOperando.setText(String.format("%04d", processador.getOperando()));
        telaPrincipal.tfPilha.setText(String.format("%04d", processador.getPilha()));

        int tamanhoColuna = processador.getTamanhoMemoria() / 10;
        int contador = 0;
        for (int i = 0; i < tamanhoColuna; i++) {
            for (int j = 0; j < 10; j++) {
                modelo.setValueAt(String.format("%04d", processador.getMemoria(contador)), i, j);
                contador++;
            }
        }

        if (!processador.getSaidaPadrao().isEmpty()) {
            telaPrincipal.tfSaida.setText(String.valueOf(processador.getSaidaPadrao() + "\n"));
        }

        telaPrincipal.invalidate();
        telaPrincipal.validate();
        telaPrincipal.repaint();
    }

    /**
     * <p>
     * Devolve um conjunto de comandos listados no editor de texto do MPS.</p>
     *
     * @return comandos
     */
    public final String getComandos() {
        return telaPrincipal.tfCodigo.getText();
    }

    /**
     * <p>
     * Devolve um leitor de dados textuais para carregamento de comandos do
     * MPS.</p>.
     *
     * @return BufereredReader
     */
    public abstract BufferedReader abrirDocumento();

    /**
     * <p>
     * Define conteúdo que deve ser apresentado ao usuário, quando o mesmo
     * clicar no botão de ajuda.</p>
     *
     * @return String
     */
    public abstract String ajuda();

    /**
     * <p>
     * Executa o processador. A reptição está implicitamente definida para esse
     * método. O mesmo será executado até que o registador de operação contenha
     * a operação de parada.</p>
     *
     * @param processador 
     */
    public abstract void executar(final Processador processador);

    /**
     * <p>
     * Retornar objeto escritor para gravação do programa fonte em disco.</p>
     *
     * @return FileWriter
     */
    public abstract FileWriter salvarDocumento();

}
