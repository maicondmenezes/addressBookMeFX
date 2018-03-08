/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.data;

import java.io.Serializable;

/**
 *
 * @author MaJoy
 */
public class Phone implements Serializable{
    private int country;
    private int ddd;
    private int number;
    private String type;

    public Phone(int country, int ddd, int number, String type) {
        super();
        this.country = country;
        this.ddd = ddd;
        this.number = number;
        this.type = type;
    }
    
    public Phone(){
        this(0, 0, 0, "");
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "+" + this.getCountry()
                + "(" + this.getDdd() + ")"
                + this.getNumber();

    }
    /**
     * @return the country
     */
    public int getCountry() {
        return country;
    }

    /**
     * @return the ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(int country) {
        this.country = country;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
