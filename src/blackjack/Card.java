
package blackjack;


public class Card { 
    
private final int suit;
private final int rank;
private final int value;

    public Card(int suit, int rank, int value) { //parmitrized constructor
        
        this.rank = rank;
        this.suit= suit;
        this.value=value;
        
    }
    public Card( Card card) { // copy constructor
        
        this.rank=card.rank;
        this.suit=card.suit;
        this.value=card.value;

    }
    
    
     public int getRank() {
        return this.rank;
    }
     
    public int getSuit() {
        return this.suit;
    }

   

    
    public int getValue() {
        return this.value;
    }
    
}
