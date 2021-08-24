import java.util.Scanner;
import java.util.ArrayList;

public class TestFreecellGame{
    public static void main(String[] args){
        FreecellGame g = new FreecellGame();
        Parser p = new Parser();
        Scanner sc = new Scanner(System.in);

        while (!g.isOver()){
            g.moveCount++;
            System.out.println(g);
            System.out.print("ENTER MOVE: ");
            String userInput = sc.nextLine();

            String[] returnString = new String[2];
            if (userInput.equals("q")){
                break;
            }
            try {
                 returnString = p.Parse(userInput);
            } catch (Exception e){
                 //System.out.println("INVALID ENTRY");
            }
            
       
            ArrayList<Card> fromCell = new ArrayList<Card>();
            ArrayList<Card> toCell = new ArrayList<Card>();
       
            for (Tableau t : g.tableaux){
                 if(t.getName().equals(returnString[0])){
                      fromCell = t.getCards();
                 }
                 if(t.getName().equals(returnString[1])){
                      toCell = t.getCards();
                 }
             }
       
            for (Freecell f : g.freecells){
                 if(f.getName().equals(returnString[0])){
                      fromCell = f.getCards();
                 }
                 if(f.getName().equals(returnString[1])){
                      toCell = f.getCards();
                 }
            }
       
            for (Homecell h : g.homecells){
                 if(h.getName().equals(returnString[0])){
                      fromCell = h.getCards();
                 }
                 if(h.getName().equals(returnString[1])){
                      toCell = h.getCards();
                 }
            }

            if (fromCell.isEmpty()){
                 System.out.println("INVALID MOVE");
            }else{

               try {
                    if(returnString[0].charAt(0) == 't' && returnString[1].charAt(0) == 't'){
                         Card c = g.t1.cardToBeMoved(fromCell, toCell);
                         g.t1.moveTtoT(fromCell, toCell, c);
                    } else if(returnString[0].charAt(0) == 't' && returnString[1].charAt(0) == 'f'){
                         g.t1.moveTtoF(fromCell, toCell);
                    } else if(returnString[0].charAt(0) == 't' && returnString[1].charAt(0) == 'h'){
                         g.t1.moveTtoH(fromCell, toCell);
                    } else if(returnString[0].charAt(0) == 'f' && returnString[1].charAt(0) == 't'){
                         g.f1.moveFtoT(fromCell, toCell);
                    } else if(returnString[0].charAt(0) == 'f' && returnString[1].charAt(0) == 'h'){
                         g.f1.moveFtoH(fromCell, toCell);
                    } else if(returnString[0].charAt(0) == 'f' && returnString[1].charAt(0) == 'f'){
                         g.f1.moveFtoF(fromCell, toCell);
                    } else if(returnString[0].charAt(0) == 'h'){
                         System.out.println("INVALID MOVE");
                    }
               } catch (Exception e){
                    System.out.println("INVALID MOVE");
               }

               
            }
             
        }

        sc.close();
    }
}