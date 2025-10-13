/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum7latihan;

/**
 *
 * @author fikry
 */
public class Player implements Attackable, Damageable {
    private int hp;
    private int baseDamage;

    public Player(int hp, int baseDamage) {
        this.hp = hp;
        this.baseDamage = baseDamage;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    @Override
    public int attack() {
        return baseDamage;
    }
    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }
    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}