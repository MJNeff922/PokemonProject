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
        String myName = sc.nextLine();
        System.out.println("What is your rival's name?");
        String enemyName = sc.nextLine();
        System.out.println("Hello " + myName + "! Which starter pokemon would you like?");
        Trainer me = new Trainer(myName);
        Trainer rival = new Trainer(enemyName);
        System.out.println("0 Charmander");
        System.out.println("1 Squirtle");
        System.out.println("2 Bulbasaur");
        int starterChoice = sc.nextInt();
        Pokemon Charmander1 = new Pokemon("Charmander", 39, 52, 43, 1);
        Charmander1.learnMove(new Move("Ember", 40));
        Pokemon Squirtle1 = new Pokemon("Squirtle", 44, 48, 65, 1);
        Squirtle1.learnMove(new Move("Bubble", 40));
        Pokemon Bulbasaur1 = new Pokemon("Bulbasaur", 45, 49, 49, 1);
        Bulbasaur1.learnMove(new Move("Vine Whip", 40));
        switch (starterChoice) {
            case 0:
                me.addPokemon(Charmander1);
                rival.addPokemon(Squirtle1);
                break;
            case 1:
                me.addPokemon(Squirtle1);
                rival.addPokemon(Bulbasaur1);
                break;
            case 2:
                me.addPokemon(Bulbasaur1);
                rival.addPokemon(Charmander1);
        }
        System.out.println("Your rival " + rival.getName() + " wants to have a battle with your new Pokemon!");
        Battle battle1 = new Battle(me, rival);
        battle1.run();
        System.out.println("You go to heal your Pokemon at the Pokemon center");
        me.heal();
        rival.heal();
    }
}
