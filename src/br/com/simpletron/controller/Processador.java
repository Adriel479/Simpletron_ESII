/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simpletron.controller;

/**
 *
 * @author adriel
 */
public class Processador {

    private int acumulador = 0;
    private int contadorDeInstrucao = 0;
    private int operacao = 0;
    private int operando = 0;
    private int pilha = 0;
    private final int[] memoria = new int[1000];
    private String barramentoSaida = "";

    /**
     * @return the acumulador
     */
    public int getAcumulador() {
        return acumulador;
    }

    /**
     * @param acumulador the acumulador to set
     */
    public void setAcumulador(int acumulador) {
        this.acumulador = acumulador;
    }

    /**
     * @return the contadorDeInstrucao
     */
    public int getContadorDeInstrucao() {
        return contadorDeInstrucao;
    }

    /**
     * @param contadorDeInstrucao the contadorDeInstrucao to set
     */
    public void setContadorDeInstrucao(int contadorDeInstrucao) {
        this.contadorDeInstrucao = contadorDeInstrucao;
    }

    /**
     * @return the operacao
     */
    public int getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the operando
     */
    public int getOperando() {
        return operando;
    }

    /**
     * @param operando the operando to set
     */
    public void setOperando(int operando) {
        this.operando = operando;
    }

    /**
     * @return the pilha
     */
    public int getPilha() {
        return pilha;
    }

    /**
     * @param pilha the pilha to set
     */
    public void setPilha(int pilha) {
        this.pilha = pilha;
    }

    public void setMemoria(int posicao, int valor) {
        memoria[posicao] = valor;
    }

    public int getMemoria(int posicao) {
        return memoria[posicao];
    }

    /**
     * @return the barramentoSaida
     */
    public String getBarramentoSaida() {
        return barramentoSaida;
    }

    /**
     * @param barramentoSaida the barramentoSaida to set
     */
    public void setBarramentoSaida(String barramentoSaida) {
        this.barramentoSaida = barramentoSaida;
    }

    public int getTamanhoMemoria() {
        return memoria.length;
    }
}
