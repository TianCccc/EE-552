/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.solarsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Tiancheng Xu
 */
public class Body {
    private final String name;
    private final String orbits;
    private final long mass;
    private final long diameter;
    private final long distance; // Mean distance from what it orbits
    private final String orbPeriod;
    
    Body (String name, String orbits, long mass, long diameter, long distance, String orbPeriod) {
        this.name = name;
        this.orbits = orbits;
        this.mass = mass;
        this.diameter = diameter;
        this.distance = distance;
        this.orbPeriod = orbPeriod;
    }
    
    public String toString() {
        return "------------------------\n"
             + "Name: " + name + '\n'
             + "Orbits: " + orbits + '\n'
             + "Mass: " + mass + " kg\n"
             + "Diameter: " + diameter + " m\n"
             + "Mean distance: " + distance + " m\n"
             + "orbPeriod: " + orbPeriod + " days\n";
    }
    
    static HashMap<String, Body> bodiesByName;
    
    private static void saveBody(String s) {
        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                // Name	 Orbits	 Mass(kg)	 Diam(m)	 Perihelion(m)	Aphelion(m)	orbPeriod(days)	rotationalPeriod(hours)	axialtilt(deg) orbinclin(deg)
                // Sun	 NaN	 1.9891e30	 1.391684e9	 0		        0		    0		        587.28			        0	           0
                
                String name = words[0];
                String orbits = words[1];
                long mass = Double.valueOf(words[2]).longValue();
                long diameter = Double.valueOf(words[3]).longValue();
                long Peri = Double.valueOf(words[4]).longValue();
                long Aphe = Double.valueOf(words[5]).longValue();
                String orbPeriod = words[6];
                
                // Add to Hashmap
                bodiesByName.put(name, new Body(name, orbits, mass, diameter, (Peri + Aphe)/2, orbPeriod));
            }
            Iterator iter = bodiesByName.entrySet().iterator();
//            while (iter.hasNext()) {
//                Map.Entry entry = (Map.Entry) iter.next();
//                Object key = entry.getKey();
//                Object value = entry.getValue();
//                System.out.println(key + ":" + value);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        bodiesByName = new HashMap<>();
        saveBody("solarsystem.dat");
        Body sun = bodiesByName.get("Sun");
        System.out.println(sun);
        Body venus = bodiesByName.get("Venus");
        System.out.println(venus);
        Body earth = bodiesByName.get("Earth");
        System.out.println(earth);
        Body moon = bodiesByName.get("Moon");
        System.out.println(moon);
    }

}
