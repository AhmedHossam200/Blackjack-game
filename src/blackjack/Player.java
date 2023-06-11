    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Android-161220
 */
public class Player {
    public String name;
    public int score=0;
    private int counter=0;
    private Card h [] = new Card[11]; // private 
    
    
    public void add(Card card){
    if (counter<11){
    h [counter]= card;
    counter++;
    score+=card.getValue();
    
    }
    }
    public Card [] getcard(){
        return this.h;
        
    } 
    }

