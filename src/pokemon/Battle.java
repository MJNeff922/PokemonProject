/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mikey
 */
public class Battle {
    private String myName;
    private ArrayList<Pokemon> myPokemon;
    private Pokemon currentPokemon;
    private String enemyName;
    private ArrayList<Pokemon> enemyPokemon;
    private Pokemon currentEnemyPokemon;
    
    public Battle(Trainer me, Trainer enemy) {
        myName = me.getName();
        enemyName = enemy.getName();
        myPokemon = me.getPokemon();
        enemyPokemon = enemy.getPokemon();
    }
    
    public boolean run() {
        System.out.println(myPokemon);
        System.out.println(enemyName + "wants to fight!");
        System.out.println(enemyPokemon);
        int enemyChoice = 0;
        currentEnemyPokemon = enemyPokemon.get(enemyChoice);
        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < myPokemon.size(); k++) {
            if (myPokemon.get(k).getHealth() > 0) {
                System.out.println(k + " " + myPokemon.get(k).getName());
            }
        }
        System.out.println("Which Pokemon would you like to use?");
        int choice = sc.nextInt();
        currentPokemon = myPokemon.get(choice);
        while (getSumHealth() > 0) {
            while (currentPokemon.getHealth() != 0) {
                System.out.println("Your Pokemon: " + currentPokemon);
                System.out.println("Enemy Pokemon: " + currentEnemyPokemon);
                System.out.println("Which move would you like to use? ");
                
                for (int j = 0; j < currentPokemon.getMoves().size(); j++) {
                    System.out.println(j + " " + currentPokemon.getMoves().get(j).getName());
                }
                int moveChoice = sc.nextInt();
                
                System.out.print("Your ");
                currentPokemon.attack(currentEnemyPokemon, moveChoice);
                
                if (currentEnemyPokemon.getHealth() == 0) {
                    System.out.println(enemyName + "'s " + currentEnemyPokemon.getName() + " fainted!");
                    int experienceGain = (int)Math.round(currentPokemon.getLevel() / 5 * Math.pow(2 * currentPokemon.getLevel() + 10, 2.5) / Math.pow(currentPokemon.getLevel() + currentEnemyPokemon.getLevel() + 10, 2.5) + 1);
                    System.out.println(currentPokemon.getName() + " earned " + experienceGain + " experience.");
                    currentPokemon.levelUp(experienceGain, true);
                    enemyChoice++;
                    if (enemyChoice == enemyPokemon.size()) {
                        System.out.println("You won the battle!");
                        return true;
                    } else {
                        currentEnemyPokemon = enemyPokemon.get(enemyChoice);
                        System.out.println(enemyName + " switched to " + currentEnemyPokemon.getName());
                    }
                }
                
                System.out.print("Enemy ");
                currentEnemyPokemon.attack(currentPokemon, (int)(Math.random() * currentEnemyPokemon.getMoves().size()));
            }
            System.out.println(currentPokemon.getName() + " fainted!");
            for (int k = 0; k < myPokemon.size(); k++) {
                if (myPokemon.get(k).getHealth() > 0) {
                    System.out.println(k + " " + myPokemon.get(k).getName());
                }
            }
            System.out.println("Which Pokemon would you like to use?");
            choice = sc.nextInt();
            currentPokemon = myPokemon.get(choice);
        }
        System.out.println("All your pokemon have fainted.");
        return false;
    }
    
    private int getSumHealth() {
        int sum = 0;
        for (Pokemon p : myPokemon) {
            sum += p.getHealth();
        }
        return sum;
    }
    
    
}
