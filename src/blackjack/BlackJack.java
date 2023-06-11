
package blackjack;

import java.util.Scanner;
import javafx.scene.control.Alert;


public class BlackJack {

     static Game g =new Game();    
   //private static int highscore;

    public static void main(String[] args) {
                    GUI gui = new GUI();

        g.generate();
        g.information_players();

        gui.runGUI( g.d, g.players[0].getcard(), g.players[1].getcard(), g.players[2].getcard(), g.players[3].getcard() );
        playersTurn(gui);
        g.update();
        dealeraTurn(gui);
        g.update();
        reviewgame();

        
    }
    public static void playersTurn(GUI gui)
    {
     Scanner scanner = new Scanner (System.in);
     for (int i =0; i<g.players.length-1;i++)
     {
       String input ="";

     while (!input.equals("stand"))
         
     {
         System.out.println("player number"+i+"(hit or stand)");
     input = scanner.next();
     if (input.equals("hit"))
     {
     join_card_player(i,gui);
     }
         
     }
     
     }
    
    }
    public static void join_card_player(int index,GUI gui)
    {
    Card card =g.draw();
    g.players[index].add(card);
    gui.updatePlayerHand(card, index);
    
    }
        public static void dealeraTurn(GUI gui)
        {
            boolean deler_wins =true;
            int highscor =0;
            for(int i =0; i<g.players.length-1;i++)
            {
            if(g.mux_score[i]>=g.players[3].score)
            {
            deler_wins=false;
            }
             if(g.mux_score[i]>highscor)
                 
             {
             highscor=g.mux_score[i];
             
             }

            }  
        
        if(!deler_wins)
        {
            addcardtodealer( gui, highscor);
        
        }
        else 
        {
            return;
        }
        }
public static void addcardtodealer(GUI gui,int highscore)
{
while (g.players[3].score<highscore)
{
Card card =g.draw();
g.players[3].add(card);
gui.updateDealerHand(card, g.d);

}

}
  public static void reviewgame(){
        int winner =-1;

  int highscore=0;
  for(int i =0; i<g.players.length;i++)
  {
  if (g.mux_score[i]>highscore){
      highscore =g.mux_score[i];
      winner =i;
  
  
  }
  }
  if (winner>=0){
      System.out.println("the winner is "+ g.players[winner].name + " with score "+highscore);
  }
  }
}
