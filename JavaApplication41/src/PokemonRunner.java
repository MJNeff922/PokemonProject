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
        Pokemon Charmander1 = new Pokemon("Charmander", 43, 52, 43, 1);
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
        Battle rivalBattle = new Battle(me, rival);
        boolean rivalBattleResult = rivalBattle.run();
        if (!rivalBattleResult) {
            System.out.println(rival.getName() + " gives you some rare candies to help level your Pokemon up.");
            me.getPokemon().get(0).levelUp(600, true);
        }
        System.out.println("You go to heal your Pokemon at the Pokemon center.");
        me.heal(true);
        rival.heal(false);
        
        System.out.println("You enter into the forest and come across a Pikachu.");
        Trainer wild1 = new Trainer("Pikachu");
        Pokemon Pikachu1 = new Pokemon("Pikachu", 35, 55, 40, 6);
        Pikachu1.learnMove(new Move("Quick Attack", 40));
        Pikachu1.learnMove(new Move("Thundershock", 50));
        wild1.addPokemon(Pikachu1);
        Battle pikachuBattle = new Battle(me, wild1);
        boolean pikachuBattleResult = pikachuBattle.run();
        if (pikachuBattleResult) {
            System.out.println("You captured the Pikachu!");
        } else {
            System.out.println("The Pikachu took pity on you and joined your team.");
            System.out.println("Also " + me.getPokemon().get(0).getName() + " gained some experience.");
            me.getPokemon().get(0).levelUp(1300, true);
        }
        me.addPokemon(Pikachu1);
        System.out.println(me.getPokemon().get(0).getName() + " learned Slam.");
        me.getPokemon().get(0).learnMove(new Move("Slam", 80));
        System.out.println("You go to heal your Pokemon at the Pokemon center.");
        me.heal(true);
        wild1.heal(false);
        
        System.out.println("Upon coming out Gary wants to fight again. He says that he's done a lot of training");
        rival.getPokemon().get(0).learnMove(new Move("Tackle", 60));
        rival.getPokemon().get(0).levelUp(1800 , false);
        Pokemon Rattata1 = new Pokemon("Rattata", 30, 56, 35, 6);
        Rattata1.learnMove(new Move("Scratch", 45));
        rival.addPokemon(Rattata1);
        rivalBattle.run();
        
        
    }
}
