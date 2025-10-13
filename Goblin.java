/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7latihan;

/**
 *
 * @author fikry
 */
import java.util.Random;

public class Goblin extends Enemy {
    private Random rand = new Random();

    public Goblin(int hp, int baseDamage) {
        super(hp, baseDamage);
    }
    @Override
    public int attack() {
        if (rand.nextInt(100) < 5) {
            System.out.println("Serangan Critical! Goblin memberikan damage ganda!");
            return getBaseDamage() * 2;
        }
        return getBaseDamage();
    }
}