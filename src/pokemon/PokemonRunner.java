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
public class PokemonRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        ArrayList<Pokemon> myPokemon = new ArrayList<>(6);
        ArrayList<Move> charizardMoveset = new ArrayList<>(4);
        charizardMoveset.add(new Move("Flare Blitz", 120));
        charizardMoveset.add(new Move("Dragon Claw", 80));
        Pokemon Charizard1 = new Pokemon("Charizard", charizardMoveset, 78, 84, 78, 1);
        Pokemon Charizard2 = new Pokemon(Charizard1);
        Charizard1.levelUp(6000, false);
        Charizard2.levelUp(4500, false);
        myPokemon.add(Charizard1);
        ArrayList<Pokemon> enemyPokemon = new ArrayList<>(6);
        enemyPokemon.add(Charizard2);
        Trainer me = new Trainer(sc.nextLine(), myPokemon);
        Trainer enemy = new Trainer("Gary", enemyPokemon);
        Battle battle1 = new Battle(me, enemy);
        me.heal();
        enemy.heal();
        for (int k = 0; k < 10; k++) {
            battle1.run();
            enemy.heal();
        }
    }
}
