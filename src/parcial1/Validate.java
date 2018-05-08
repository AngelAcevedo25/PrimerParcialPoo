/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author user
 */
public class Validate {
    
    public int ValidateInt(String val){
        int rslt;
        try{
            rslt = Integer.parseInt(val);
        }
        catch(java.lang.NumberFormatException e){
            rslt = -1;
        }
        return rslt;
    }
    
    public double ValidateDouble(String val){
        double rslt;
        try{
            rslt = Double.parseDouble(val);
        }
        catch(java.lang.NumberFormatException e){
            rslt = -1;
        }
        return rslt;
    }
    public char ValidateChar(String val){
        char rslt;
        try{
            rslt = val.charAt(0);
        }
        catch(java.lang.NumberFormatException e){
            rslt = 'Z';
        }
        return rslt;
    }
}
