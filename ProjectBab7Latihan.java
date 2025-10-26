/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.praktikumpbo.projectbab7latihan;

/**
 *
 * @author Lenovo
 */
public class ProjectBab7Latihan {

    public static void main(String[] args) {
        Assassin assassin = new Assassin(100, 20);
        Goblin goblin = new Goblin(100, 10);

        System.out.println("Pertarungan Dimulai");
        int round = 1;

        while (assassin.isAlive() && goblin.isAlive()) {
            System.out.println("Ronde "+ round);

            int playerAttack = assassin.attack();
            goblin.takeDamage(playerAttack);
            System.out.println("Assassin menyerang Goblin dengan damage: "+ playerAttack);
            System.out.println("HP Goblin sekarang: "+ goblin.getHp());

            if (!goblin.isAlive()) {
                System.out.println("Goblin dikalahkan!");
                break;
            }
            
            int goblinAttack = goblin.attack();
            
            System.out.println("Goblin menyerang Assassin dengan damage: "+ goblinAttack);
            assassin.takeDamage(goblinAttack, goblin);
            System.out.println("HP Assassin sekarang: "+ assassin.getHp());

            if (!assassin.isAlive()) {
                System.out.println("Assassin dikalahkan!");
                break;
            }
            System.out.println("");
            round++;
        }

        System.out.println("Pertarungan Selesai");
        if (assassin.isAlive()) {
            System.out.println("Assassin Menang!");
        } else {
            System.out.println("Goblin Menang!");
        }
    }
}
