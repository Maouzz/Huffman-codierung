package com.example;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String input = "ich habe es endlich geschafft!!!";
        Code Code = new Code();
        Stack<Integer> [] codeStack =new Stack [0];
        codeStack = Code.code(input);
        ArrayList<Character> Chars = Code.Char(input);
        for (int i = 0; i < codeStack.length; i++) {
            System.out.print(Chars.get(i) + ": " + codeStack[i]);
            System.out.println("");
        }
        Coding Coding = new Coding();
        System.out.println("");
        String code = Coding.coding(input, codeStack, Chars);
        System.out.println(code);
        Decoding Decoding = new Decoding();
        Decoding.decoding(code, codeStack, Chars);
    }
}