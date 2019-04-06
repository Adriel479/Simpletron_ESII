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
public class Comandos {

    public static final int READ = 10;
    public static final int WRITE = 11;

    public static final int LOAD = 20;
    public static final int STORE = 21;

    public static final int ADD = 30;
    public static final int SUB = 31;
    public static final int DIV = 32;
    public static final int MUL = 33;

    public static final int PUSH = 40;
    public static final int POP = 41;

    public static final int BRANCH = 50;
    public static final int BRANCHNEG = 51;
    public static final int BRANCHZERO = 52;
    public static final int HALT = 53;
    
    public static final int READS = 60;
    public static final int PRINTS = 61;
    
    public static final int STRING_END = 70;

}
