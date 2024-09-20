package com.example;
import java.util.ArrayList;
import java.util.Stack;

public class Coding {
    
    public String coding(String input, Stack<Integer>[] codeStack, ArrayList<Character> Chars){
        String codeoutput = "";
        String codeclener = "";
        System.out.println("\u001B[31m" + input + "\u001B[37m");
        for (int i = 0; i < input.length(); i++) {
            for (int o = 0; o < Chars.size(); o++) {
                if (input.charAt(i) == Chars.get(o)) {
                    codeclener = codeclener + codeStack[o];
                }
            }
        }
        for (int i = 0; i < codeclener.length(); i++) {
            if (codeclener.charAt(i) == '0' || codeclener.charAt(i) == '1') {
                codeoutput = codeoutput + codeclener.charAt(i);
            }
        }
        return codeoutput;
    }
}
