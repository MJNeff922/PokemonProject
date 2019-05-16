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
public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemon;
    
    public Trainer(String setName, ArrayList<Pokemon> setPokemon) {
        name = setName;
        pokemon = setPokemon;
    }
    
    public String getName() {return name;}
    public ArrayList<Pokemon> getPokemon() {return pokemon;}
    public void heal() {
        for (Pokemon p : pokemon) {
            p.revive();
        }
    }

}
