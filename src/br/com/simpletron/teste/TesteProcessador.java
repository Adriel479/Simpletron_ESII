package br.com.simpletron.teste;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adriel
 */
public class TesteProcessador {

    public static String p0 = "+20005\n"
            + "+30006\n"
            + "+21007\n"
            + "+11007\n"
            + "+53000\n"
            + "+00020\n"
            + "+00030\n"
            + "+00000";

    public static String p1 = "+20005\n"
            + "+31006\n"
            + "+21007\n"
            + "+11007\n"
            + "+53000\n"
            + "+00020\n"
            + "+00030\n"
            + "+00000";

    public static String p2 = "+20005\n"
            + "+32006\n"
            + "+21007\n"
            + "+11007\n"
            + "+53000\n"
            + "+00020\n"
            + "+00030\n"
            + "+00000";
    public static String p3 = "+20005\n"
            + "+33006\n"
            + "+21007\n"
            + "+11007\n"
            + "+53000\n"
            + "+00020\n"
            + "+00030\n"
            + "+00000";
    public static String p4 = "+20010\n"
            + "+31011\n"
            + "+21010\n"
            + "+51006\n"
            + "+52008\n"
            + "+50001\n"
            + "+11013\n"
            + "+53000\n"
            + "+11012\n"
            + "+53000\n"
            + "+00010\n"
            + "+00002\n"
            + "+00001\n"
            + "+00000";
    public static String p5 = "+20006\n"
            + "+40000\n"
            + "+20007\n"
            + "+41000\n"
            + "+21007\n"
            + "+53000\n"
            + "+01998\n"
            + "+00000";
    public static String p6 = "+61002\n"
            + "+53000\n"
            + "+00072\n"
            + "+00069\n"
            + "+00076\n"
            + "+00076\n"
            + "+00079\n"
            + "+00032\n"
            + "+00087\n"
            + "+00079\n"
            + "+00082\n"
            + "+00076\n"
            + "+00068\n"
            + "+00033\n"
            + "+70000";

    public static void main(String[]args) throws IOException {
        ProcessadorTeste c = new ProcessadorTeste();
        c.iniciarExecucao(p0, p1, p2, p3, p4, p5, p6);
    }

}
