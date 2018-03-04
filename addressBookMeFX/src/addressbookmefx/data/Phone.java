/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.data;

/**
 *
 * @author MaJoy
 */
public class Phone {

    private int country;
    private int ddd;
    private int number;
    private String type;

    public Phone(int country, int ddd, int number, String type) {
        this.country = country;
        this.ddd = ddd;
        this.number = number;
        this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "+" + this.country
                + "(" + this.ddd + ")"
                + this.number;

    }
}
