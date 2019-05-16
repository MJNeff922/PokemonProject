/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Mikey
 */
public class Move {
    private String name;
    private int power;
    
    public Move(String setName, int setPower) {
        name = setName;
        power = setPower;
    }
    
    public String getName() {return name;}
    public int getPower() {return power;}
}
