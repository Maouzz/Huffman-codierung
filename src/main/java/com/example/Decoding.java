package com.example;

import java.util.ArrayList;
import java.util.Stack;

public class Decoding {
    
    public void decoding(String code, Stack<Integer>[] codeStack, ArrayList<Character> Chars){
        String originalString = "";
        Stack<Integer> zwischenablage = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            zwischenablage.add((int)(code.charAt(i) - 48));
            System.out.println(zwischenablage);
            for (int o = 0; o < codeStack.length; o++) {
                boolean isCode = false;
                for (int a = 0; a < codeStack[o].size(); a++) {
                    if (codeStack[o].size() > zwischenablage.size()) {
                        break;
                    }
                    if (zwischenablage.get(a) == codeStack[o].get(a)) {
                        if (a + 1 == zwischenablage.size()) {
                            isCode = true;
                        }
                    }
                    else{
                        break;
                    }
                }
                if (isCode == true) {
                    originalString = originalString + Chars.get(o);
                    zwischenablage.clear();
                }
            }
        }
        System.out.println(originalString);
    }
}
