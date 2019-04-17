package br.com.simpletron.controller;

import br.com.simpletron.view.Ajuda;
import br.com.simpletron.view.Simpletron;
import static java.awt.Frame.MAXIMIZED_BOTH;
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

    private Simpletron telaPrincipal;
    private Processador processador;
    private DefaultTableModel modelo;
    private int quantidadeDeLinhas;
    private StringBuilder resultados;

    public void iniciarExecucao() {
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
        telaPrincipal.setExtendedState(MAXIMIZED_BOTH);
        telaPrincipal.setVisible(true);
    }

    /*
    
    soma de inteiros
    subtração de inteiros
    multiplicação de inteiros
    divisão de inteiros
    
    Verificação de paridade (Número par)
    leitura e impressão de texto
    empilhamento e desempilhamento de um valor inteiro.
    
     */
    public void iniciarExecucao(String... programa) {
        resultados = new StringBuilder();
        Processador p0 = executarProcessador(programa[0]);
        Processador p1 = executarProcessador(programa[1]);
        Processador p2 = executarProcessador(programa[2]);
        Processador p3 = executarProcessador(programa[3]);
        Processador p4 = executarProcessador(programa[4]);
        Processador p5 = executarProcessador(programa[5]);
        Processador p6 = executarProcessador(programa[6]);

        Processador[] teste = carregarTestes(programa);

        if (p0 == null || !p0.equals(teste[0])) {
            resultados.append("[{'nome': 'Soma de inteiros', 'estado':false},");
        } else {
            resultados.append("[{'nome': 'Soma de inteiros', 'estado':true},");
        }

        if (p1 == null || !p1.equals(teste[1])) {
            resultados.append("{'nome': 'Multiplicação de inteiros', 'estado':false},");
        } else {
            resultados.append("{'nome': 'Multiplicação de inteiros', 'estado':true},");
        }

        if (p2 == null || !p2.equals(teste[2])) {

            resultados.append("{nome: 'Divisão de inteiros', 'estado':false}");
        } else {
            resultados.append("{nome: 'Divião de inteiros', 'estado':true}");
        }

        if (p3 == null || !p3.equals(teste[3])) {
            resultados.append("{'nome': 'Teste de paridade', 'estado':false},");
        } else {
            resultados.append("{'nome': 'Teste de paridade', 'estado':true},");
        }

        if (p4 == null || !p4.equals(teste[4])) {
            resultados.append("{'nome': 'Print texto', 'estado':false},");
        } else {
            resultados.append("{'nome': 'Print texto', 'estado':true},");
        }

        if (p5 == null || !p5.equals(teste[5])) {
            resultados.append("{'nome': 'Subtração de inteiros', 'estado':false},");
        } else {
            resultados.append("{'nome': 'Subtração de inteiros', 'estado':true},");
        }

        if (p6 == null || !p6.equals(teste[6])) {
            resultados.append("{'nome': 'Empilha/Desempilha inteiro', 'estado':false}]");
        } else {
            resultados.append("{'nome': 'Empilha/Desempilha inteiro', 'estado':true}]");
        }

        try ( FileWriter escritor = new FileWriter("Resultado.json")) {
            escritor.write(resultados.toString());
            escritor.flush();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    private Processador[] carregarTestes(String... programa) {
        Processador[] lista = new Processador[7];
        if (programa.length > 7) {
            throw new IllegalArgumentException("Erro: A quantidade de argumentos deve ser 7!");
        }
        for (int i = 0; i < 7; i++) {
            lista[i] = executadorProcessadorImplementado(programa[i]);
        }
        return lista;
    }

    private Processador executadorProcessadorImplementado(String programa) {
        Processador proc = new Processador();

        String[] comandos = programa.split("\n");
        int contador = 0;
        for (String comando : comandos) {
            proc.setMemoria(contador++, Integer.parseInt(comando, 10));
        }
        proc.setPilha(contador - 1);
        Controlador imp = new Implementacao();
        while (proc.getOperacao() != 53) {
            imp.executar(proc);
        }
        return proc;
    }

    private Processador executarProcessador(String programa) {
        Processador proc = new Processador();
        String[] comandos = programa.split("\n");
        int contador = 0;
        for (String comando : comandos) {
            if (comando.matches("[+|-][0-9]{5}")) {
                proc.setMemoria(contador++, Integer.parseInt(comando, 10));
            } else {
                return null;
            }
        }

        if (contador < 1000) {
            proc.setPilha(contador - 1);
        } else {
            return null;
        }

        while (proc.getOperacao() != 53) {
            executar(proc);
        }
        return proc;
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
