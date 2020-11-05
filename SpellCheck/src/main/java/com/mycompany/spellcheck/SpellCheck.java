/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spellcheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Tiancheng Xu
 */
public class SpellCheck {
    int keyDict = 1;
    HashMap<Integer, String> Dict = new HashMap<Integer, String>();
    
    private void saveDict(String s) {
        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s,\\-\\.\\?\\!\\+]+");
                /// Add to dict
                for (String w: words) {
                    Dict.put(keyDict, line);        
                keyDict +=1 ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void splitString(String s) {
        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s,\\-\\.\\?\\!\\+]+");
                for (String w: words){
                    if (! Dict.containsValue(w)){
                        System.out.println(w);
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        SpellCheck a = new SpellCheck();
        a.saveDict("dict.txt");
        a.splitString("spell.txt");
    }
}
