/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simpletron.view;

/**
 *
 * @author adriel
 */
public class Simpletron extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Simpletron() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tfCodigo = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnExecutar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAjuda = new javax.swing.JButton();
        pRegistradores = new javax.swing.JPanel();
        lbAcumulador = new javax.swing.JLabel();
        tfAcumulador = new javax.swing.JTextField();
        lbCI = new javax.swing.JLabel();
        tfCI = new javax.swing.JTextField();
        lbOperacao = new javax.swing.JLabel();
        tfOperacao = new javax.swing.JTextField();
        lbOperando = new javax.swing.JLabel();
        tfOperando = new javax.swing.JTextField();
        lbTopoPilha = new javax.swing.JLabel();
        tfPilha = new javax.swing.JTextField();
        pMemoria = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMemoria = new javax.swing.JTable();
        pSaida = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfSaida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simpletron - V 0.1");

        tfCodigo.setColumns(20);
        tfCodigo.setFont(new java.awt.Font("Noto Sans", 0, 48)); // NOI18N
        tfCodigo.setRows(5);
        jScrollPane1.setViewportView(tfCodigo);

        btnExecutar.setText("Executar");
        btnExecutar.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(btnExecutar);

        btnAbrir.setText("Abrir");
        btnAbrir.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(btnAbrir);

        btnSalvar.setText("Salvar");
        btnSalvar.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(btnSalvar);

        btnAjuda.setText("Ajuda");
        btnAjuda.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(btnAjuda);

        pRegistradores.setBorder(javax.swing.BorderFactory.createTitledBorder("Registradores"));
        pRegistradores.setLayout(new javax.swing.BoxLayout(pRegistradores, javax.swing.BoxLayout.Y_AXIS));

        lbAcumulador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAcumulador.setText("Acumulador");
        pRegistradores.add(lbAcumulador);

        tfAcumulador.setEditable(false);
        tfAcumulador.setBackground(new java.awt.Color(0, 255, 0));
        tfAcumulador.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        tfAcumulador.setForeground(new java.awt.Color(0, 0, 0));
        tfAcumulador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAcumulador.setText("0000");
        pRegistradores.add(tfAcumulador);

        lbCI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCI.setText("Contador de instrução");
        pRegistradores.add(lbCI);

        tfCI.setEditable(false);
        tfCI.setBackground(new java.awt.Color(255, 0, 0));
        tfCI.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        tfCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCI.setText("0000");
        pRegistradores.add(tfCI);

        lbOperacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOperacao.setText("Operação");
        pRegistradores.add(lbOperacao);

        tfOperacao.setEditable(false);
        tfOperacao.setBackground(new java.awt.Color(0, 0, 255));
        tfOperacao.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        tfOperacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfOperacao.setText("0000");
        pRegistradores.add(tfOperacao);

        lbOperando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOperando.setText("Operando");
        pRegistradores.add(lbOperando);

        tfOperando.setEditable(false);
        tfOperando.setBackground(new java.awt.Color(0, 0, 255));
        tfOperando.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        tfOperando.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfOperando.setText("0000");
        pRegistradores.add(tfOperando);

        lbTopoPilha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTopoPilha.setText("Topo da pilha");
        pRegistradores.add(lbTopoPilha);

        tfPilha.setEditable(false);
        tfPilha.setBackground(new java.awt.Color(255, 251, 0));
        tfPilha.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        tfPilha.setForeground(new java.awt.Color(0, 0, 0));
        tfPilha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPilha.setText("00000");
        pRegistradores.add(tfPilha);

        pMemoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Memória"));

        tbMemoria.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        tbMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMemoria.setShowGrid(true);
        jScrollPane2.setViewportView(tbMemoria);

        javax.swing.GroupLayout pMemoriaLayout = new javax.swing.GroupLayout(pMemoria);
        pMemoria.setLayout(pMemoriaLayout);
        pMemoriaLayout.setHorizontalGroup(
            pMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pMemoriaLayout.setVerticalGroup(
            pMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pSaida.setBorder(javax.swing.BorderFactory.createTitledBorder("Saída"));
        pSaida.setLayout(new java.awt.BorderLayout());

        tfSaida.setEditable(false);
        tfSaida.setBackground(new java.awt.Color(0, 0, 0));
        tfSaida.setColumns(20);
        tfSaida.setFont(new java.awt.Font("Noto Sans", 0, 48)); // NOI18N
        tfSaida.setForeground(new java.awt.Color(0, 255, 0));
        tfSaida.setLineWrap(true);
        tfSaida.setRows(5);
        jScrollPane4.setViewportView(tfSaida);

        pSaida.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pRegistradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pRegistradores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Simpletron().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbrir;
    public javax.swing.JButton btnAjuda;
    public javax.swing.JButton btnExecutar;
    public javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbAcumulador;
    private javax.swing.JLabel lbCI;
    private javax.swing.JLabel lbOperacao;
    private javax.swing.JLabel lbOperando;
    private javax.swing.JLabel lbTopoPilha;
    private javax.swing.JPanel pMemoria;
    private javax.swing.JPanel pRegistradores;
    private javax.swing.JPanel pSaida;
    public javax.swing.JTable tbMemoria;
    public javax.swing.JTextField tfAcumulador;
    public javax.swing.JTextField tfCI;
    public javax.swing.JTextArea tfCodigo;
    public javax.swing.JTextField tfOperacao;
    public javax.swing.JTextField tfOperando;
    public javax.swing.JTextField tfPilha;
    public javax.swing.JTextArea tfSaida;
    // End of variables declaration//GEN-END:variables
}
