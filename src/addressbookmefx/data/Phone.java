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
    private String number;
    private String type;

    public Phone(String number, String type) {
        super();
        this.number = number;
        this.type = type;
    }
    
    public Phone(){
        this("", "");
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.getNumber()+" Tipo: "+this.getType();
    }
    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
