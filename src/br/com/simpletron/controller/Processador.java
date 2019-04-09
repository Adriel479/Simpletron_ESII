package br.com.simpletron.controller;

/**
 * <p>
 * A classe representa o estado corrente do processador.</p>
 *
 */
public class Processador {

    private int acumulador = 0;
    private int contadorDeInstrucao = 0;
    private int operacao = 0;
    private int operando = 0;
    private int pilha = 0;
    private final int[] memoria = new int[1000];
    private String saidaPadrao = "";

    /**
     * <p>
     * Retornar o valor contido no acumulador.</p>
     *
     * @return acumulador
     */
    public int getAcumulador() {
        return acumulador;
    }

    /**
     * <p>
     * Configurar um valor no acumulador</p>
     *
     * @param acumulador
     */
    public void setAcumulador(int acumulador) {
        this.acumulador = acumulador;
    }

    /**
     * <p>
     * Retornar o contador de instrução</p>
     *
     * @return contadorDeInstrucao
     */
    public int getContadorDeInstrucao() {
        return contadorDeInstrucao;
    }

    /**
     * <p>
     * Configura o contador de instrução.</p>
     *
     * @param contadorDeInstrucao
     */
    public void setContadorDeInstrucao(int contadorDeInstrucao) {
        this.contadorDeInstrucao = contadorDeInstrucao;
    }

    /**
     * <p>
     * Retornar a operação corrente.</p>
     *
     * @return operacao
     */
    public int getOperacao() {
        return operacao;
    }

    /**
     * <p>
     * Configura uma operação passada por parâmetro.</p>
     *
     * @param operacao
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    /**
     * <p>
     * Retorna o endereço de memória do operando corrente.</p>
     *
     * @return operando
     */
    public int getOperando() {
        return operando;
    }

    /**
     * <p>
     * Configura operando.</p>
     *
     * @param operando
     */
    public void setOperando(int operando) {
        this.operando = operando;
    }

    /**
     * <p>Retorna o endereço do topo da pilha.</p>
     * @return pilha
     */
    public int getPilha() {
        return pilha;
    }

    /**
     * <p>Configura o endereço do topo da pilha. Aqui o index que indica o topo
     * da pilha será atualizado. Utilize o método de setMemoria para configurar
     * um valor no topo da pilha após a atualização.</p>
     * @param pilha
     */
    public void setPilha(int pilha) {
        this.pilha = pilha;
    }

    /**
     * <p>Configura um valor em uma determinada posição de mémoria.</p>
     * @param posicao
     * @param valor 
     */
    public void setMemoria(int posicao, int valor) {
        memoria[posicao] = valor;
    }

    /**
     * <p>Devolve um valor em uma determinada posição de memória.</p>
     * @param posicao
     * @return 
     */
    public int getMemoria(int posicao) {
        return memoria[posicao];
    }

    /**
     * <p>Devolve o valor da que será enviado para a saída.</p>
     * @return barramentoSaida
     */
    public String getSaidaPadrao() {
        return saidaPadrao;
    }

    /**
     * <p>Configura o conteúdo que será enviado para a saída.</p>
     * @param saidaPadrao 
     */
    public void setSaidaPadrao(String saidaPadrao) {
        this.saidaPadrao = saidaPadrao;
    }

    /**
     * <p>Devolve a quantidade de células de memória.</p> 
     * 
     * @return quantidadeDeCelulaDeMemoria;
     */
    public int getTamanhoMemoria() {
        return memoria.length;
    }
}
