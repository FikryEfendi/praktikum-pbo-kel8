/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum7latihan;

/**
 *
 * @author fikry
 */
public class Praktikum7Latihan {

    public static void main(String[] args) {
        Player player = new Player(100, 20);
        Goblin goblin = new Goblin(100, 10);

        System.out.println("Pertarungan Dimulai");
        int round = 1;

        while (player.isAlive() && goblin.isAlive()) {
            System.out.println("Ronde "+ round);

            int playerAttack = player.attack();
            goblin.takeDamage(playerAttack);
            System.out.println("Player menyerang Goblin dengan damage: "+ playerAttack);
            System.out.println("HP Goblin sekarang: "+ goblin.getHp());

            if (!goblin.isAlive()) {
                System.out.println("Goblin dikalahkan!");
                break;
            }
            
            int goblinAttack = goblin.attack();
            player.takeDamage(goblinAttack);
            System.out.println("Goblin menyerang Player dengan damage: "+ goblinAttack);
            System.out.println("HP Player sekarang: "+ player.getHp());

            if (!player.isAlive()) {
                System.out.println("Player dikalahkan!");
                break;
            }
            System.out.println("");
            round++;
        }

        System.out.println("Pertarungan Selesai");
        if (player.isAlive()) {
            System.out.println("Player Menang!");
        } else {
            System.out.println("Goblin Menang!");
        }
    }
}
