/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.praktikumpbo.projectbab7latihan;

/**
 *
 * @author Lenovo
 */
import java.util.Random;

public class Assassin extends Player implements Attackable, Damageable{

    Random rand = new Random();
    public Assassin(int hp, int baseDamage){
        super(hp,baseDamage);
    }
       
       public int takeDamage(int damage, Enemy a) {
       int dodge = rand.nextInt(1,6);
       if (dodge < 2){
           System.out.println("Assassin menghindari serangan!");
           System.out.println("Assassin menyerang dengan damage " +damage);
           a.takeDamage(damage);

       }
       else{
            int newHp = getHp() - damage;
            if (newHp < 0) newHp = 0;
            setHp(newHp);
        }
        return getHp();
           
       }
        
    }
    

