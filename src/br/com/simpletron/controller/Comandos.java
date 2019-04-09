package br.com.simpletron.controller;

/**
 * <p>
 * A classe tem como objetivo fornecer um conjunto de constantes que representam
 * as operações suportadas pelo MPS, seu uso não é obrigatório, mas é
 * bastante recomendado para que seu código matenha a legibilidade.</p>
 * 
 *
 */
public class Comandos {

    /**
     * <p>
     * Ler um valor da entrada padrão e armazena no endereço de memória
     * especificado.</p>
     */
    public static final int READ = 10;
    /**
     * <p>
     * Escreve o conteúdo do endereço de memória especificado na saída
     * padrão.</p>
     */
    public static final int WRITE = 11;
    /**
     * <p>
     * Carregar o conteúdo do endereço de memória especificado no
     * acumulador.</p>
     */
    public static final int LOAD = 20;
    /**
     * <p>
     * Grava o conteúdo do acumulador em um endereço de memória
     * especificado.</p>
     */
    public static final int STORE = 21;

    /**
     * <p>
     * Adciona o conteúdo do acumulador com o conteúdo de um endereço de memória
     * especificado.</p>
     */
    public static final int ADD = 30;
    /**
     * <p>
     * Subtrai o conteúdo do acumulador com o conteúdo de um endereço de memória
     * especificado e aramazena o resultado no acumulador.</p>
     */
    public static final int SUB = 31;
    /**
     * <p>
     * Divide o conteúdo do acumulador por o conteúdo de um endereço de memória
     * especificado e aramazena o resultado no acumulador.</p>
     */
    public static final int DIV = 32;
    /**
     * <p>
     * Multiplica o conteúdo do acumulador por o conteúdo de um endereço de
     * memória especificado e aramazena o resultado no acumulador.</p>
     */
    public static final int MUL = 33;
    /**
     * <p>
     * Empurra o conteúdo do acumulador para o topo da pilha.</p>
     */
    public static final int PUSH = 40;
    /**
     * <p>
     * Retira o conteúdo do topo da pilha e coloca no acumulador.</p>
     */
    public static final int POP = 41;

    /**
     * <p>
     * Desvia para um endereço de memória especificado.</p>
     */
    public static final int BRANCH = 50;
    /**
     * <p>
     * Desvia para um endereço de memória especificado quando o acumulador é
     * negativo.</p>
     */
    public static final int BRANCHNEG = 51;
    /**
     * <p>
     * Desvia para um endereço de memória especificado quando o acumulador é
     * zero.</p>
     */
    public static final int BRANCHZERO = 52;
    /**
     * <p>
     * Identificador que indica que o programa terminou.</p>
     */
    public static final int HALT = 53;

    /**
     * <p>
     * Ler uma string e armazena seus caracteres em sequência na memória.</p>
     */
    public static final int READS = 60;
    /**
     * <p>
     * Imprime uma sequência de caracteres, dado um endereço inicial.</p>
     */
    public static final int PRINTS = 61;

    /**
     * <p>
     * Idendica o final de uma strin.</p>
     */
    public static final int STRING_END = 70;

}
