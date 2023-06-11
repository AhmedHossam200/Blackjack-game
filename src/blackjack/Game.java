

package blackjack;
import java.util.Random;
import java.util.Scanner;
 
public class Game {
    
    public int mux_score[]=new int[4];
    public  Card d []= new Card[52];//public
    public Player players []=new Player[4];//public
    
    
    
    public void generate (){
        int count =0;
          for (int i =0; i<4;i++)
          {
            for (int j =0; j<13;j++){
            int val = (j>=10) ? 10:j+1;
            Card  card =new Card(i,j,val);  
            d[count]=  card;
            count++;
            }
          }
     }
     
    
    
    public Card draw (){
        
    Random rand= new Random();
    Card card = null;
    do {
    int randomchoice = rand.nextInt(51);
    card  = d [randomchoice];
    d [randomchoice]=null;
    }while (card==null);
    
    return card;
    }
    
    
    
    public  void information_players (){
        
        Scanner input = new Scanner(System.in);
        
         for (int i =0;i<players.length-1;i++)
         {
             System.out.println("enter the name of the player"+i);
             players[i]=new Player();
             players[i].name=input.next();
             players[i].add(this.draw());
             players[i].add(this.draw());
             // draw to card as defult
         
         }
             players[3]=new Player();
             players[3].name="Dealer";
             players[3].add(this.draw());
             players[3].add(this.draw());
             // draw to card as defult

    
    }
    
    public void update (){
    for (int i=0;i<mux_score.length;i++){
    mux_score [i]=players[i].score <=21? players[i].score:0; 
    }
    
    }   
}
