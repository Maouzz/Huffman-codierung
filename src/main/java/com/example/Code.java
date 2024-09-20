package com.example;
import java.util.ArrayList;
import java.util.Stack;

public class Code {
    
    public Stack<Integer>[] code(String input){
        
        //////initialistion of base arrays
        ArrayList<Character> Chars = Char(input);
        char [] chars = new char[Chars.size()];
        int [] charCount = new int [Chars.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Chars.get(i);
        }
        for (int i = 0; i < input.length(); i++) {
            for (int t = 0; t < Chars.size(); t++) {
                if (input.charAt(i) == Chars.get(t)) {
                    charCount[t] += 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < charCount.length; i++) {
            sum += charCount[i];
        }

        //////sorting of chars and charsCout
        int maxlength = charCount.length - 1;
        for (int i = 0; i < charCount.length; i++) {
            int max = charCount[0];
            char maxChar = chars[0];
            int maxindex = 0;
            for (int t = 0; t < maxlength + 1; t++) {
                if (max < charCount[t]) {
                    max = charCount[t];
                    maxChar = chars[t];
                    maxindex = t;
                }
            }
            charCount[maxindex] = charCount[maxlength];
            charCount[maxlength] = max;
            chars[maxindex] = chars[maxlength];
            chars[maxlength] = maxChar;
            maxlength -= 1;
        }

        //////initialising Stacks
        Stack<Integer> [] codeStack = new Stack[chars.length];
        for (int i = 0; i < chars.length; i++) {
            codeStack[i] = new Stack<>();
        }
        Stack<String> [] charStack = new Stack[chars.length];
        for (int i = 0; i < chars.length; i++) {
            charStack[i] = new Stack<>();
            charStack[i].add("" + chars[i]);
        }

        //////generating tree...2%
        boolean generating = true;
        int t = 0;
        int c = 0; 
        while (generating) {
            if (c + 1 != charCount.length) {
                int count = charCount[c]  + charCount[c + 1];
                charCount[c] = count;
                charCount [c + 1] = 0;
                for (int i = 0; i < chars.length; i++) {    // adding 1s to codestack
                    if (charStack[c].contains("" + Chars.get(i))) {
                        codeStack[i].add(1);
                    }
                }
                for (int i = 0; i < chars.length; i++) {       // adding 0s to codestack
                    if (charStack[c + 1].contains("" + Chars.get(i))) {
                        codeStack[i].add(0);
                    }
                }
                while (charStack[c + 1].empty() == false) { 
                    charStack[c].add(charStack[c + 1].pop());   
                }
                boolean sortingIn = true;
                int v = c;
                while (sortingIn) {
                    if (v + 1 != charCount.length) {
                        if (charCount[v] > charCount[v + 1]) {
                            int cC = charCount[v];
                            Stack<String> cS= charStack[v];
                            charCount[v] = charCount[v + 1];
                            charCount[v + 1] = cC;
                            charStack[v] = charStack[v + 1];
                            charStack[v + 1] = cS;
                            v += 1;
                        }
                        else{
                            sortingIn = false;
                        }
                    }
                    else{
                        sortingIn = false;
                    }
                }  
                c += 1;
            }
            else{
                generating = false;
            }
        }
        /* */
        for (int i = 0; i < codeStack.length; i++) {
            Stack<Integer> holding = new Stack<>();
           while(codeStack[i].empty() == false) {
                holding.add(codeStack[i].pop());
            }
            codeStack[i] = holding;
        }
        return codeStack;
    }

    public ArrayList Char(String input){
        ArrayList<Character> Chars = new  ArrayList<Character>();
        for (int i = 0; i < input.length(); i++) {
            boolean charExists = false;
            for (int t = 0; t < Chars.size(); t++) {
                if (input.charAt(i) == Chars.get(t)) {
                    charExists = true;
                }
            }
            if (charExists == false) {
                Chars.add (input.charAt(i));
            }
        }
        return  Chars;
    }
}
