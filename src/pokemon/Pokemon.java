/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.util.ArrayList;

/**
 *
 * @author Mikey
 */
public class Pokemon {
    
    private String name;
    private ArrayList<Move> moves;
    private int maxHealth;
    private int health;
    private int attack;
    private int defense;
    private int experience;
    private int level;
    
    public Pokemon(String setName, ArrayList<Move> setMoves, int setHealth, int setAttack, int setDefense, int setLevel) {
        name = setName;
        moves = setMoves;
        maxHealth = setHealth;
        health = maxHealth;
        attack = setAttack;
        defense = setDefense;
        level = setLevel;
    }
    
    public Pokemon(Pokemon other) {
        name = other.name;
        moves = other.moves;
        maxHealth = other.maxHealth;
        health = maxHealth;
        attack = other.attack;
        defense = other.defense;
        level = other.level;
    }
    
    public String getName() {return name;}
    public ArrayList<Move> getMoves() {return moves;}
    public int getHealth() {return health;}
    public int getLevel() {return level;}
    
    public void attack(Pokemon other, int moveChoice) {
        Move moveUsed = moves.get(moveChoice);
        int damage = (int)Math.round((((2.0*level/5.0)* moveUsed.getPower() * attack / other.defense)/50.0 + 2.0) * (Math.random() * 0.15 + .85));
        System.out.println(this.name + " used " + moveUsed.getName() + " and did " + damage + " damage.");
        other.health -= damage;
        if (other.health < 0) {
            other.health = 0;
        }
    }
    
    public void levelUp(int experienceGain, boolean announce) {
        if (level == 100) {
            experience = 0;
            return;
        }
        experience += experienceGain;
        while (experience >= 100) {
            experience -= 100;
            level++;
            int healthAddition = (int)Math.round(maxHealth * 0.02);
            maxHealth += healthAddition;
            health += healthAddition;
            attack = (int)Math.round(attack * 1.02);
            defense = (int)Math.round(attack * 1.02);
            if(announce) {
                System.out.println(name + " leveled up!");
            }
        }
    }
    
    public void revive() {
        health = maxHealth;
    }
    
    public String toString() {
        return name + " Lvl " + level + " " + health + "/" + maxHealth + " XP: " + experience + "/100";
    }
    
}
