import java.util.ArrayList;

public class Freecell {

    public ArrayList<Card> freeList;
    private String name;

    public Freecell(ArrayList<Card> freeList, String name){
        this.freeList = new ArrayList<Card>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getCards(){
        return this.freeList;
    }


    public void moveFtoH(ArrayList<Card> fromCell, ArrayList<Card> toCell){
        Card cardToMove = fromCell.get(0);
        if(toCell.isEmpty() && cardToMove.getRank() == 1){
            toCell.add(cardToMove);
            fromCell.remove(cardToMove);
        } else {
            Card linkCard = toCell.get(toCell.size()-1);
            if (cardToMove.getRank() - linkCard.getRank() == 1 && cardToMove.getSuit().equals(linkCard.getSuit())){
                toCell.add(cardToMove);
                fromCell.remove(cardToMove);
            } else{
                toCell.get(100);
            }
        }
    }

    public void moveFtoT(ArrayList<Card> fromCell, ArrayList<Card> toCell){
        if (toCell.isEmpty()){
            Card cardToMove = fromCell.get(0);
            toCell.add(cardToMove);
            fromCell.remove(cardToMove);
        }else{

            Card cardToMove = fromCell.get(0);
            Card linkCard = toCell.get(toCell.size()-1);

            if(cardToMove.getRank() - linkCard.getRank() == -1 && !(cardToMove.getColor().equals(linkCard.getColor()))){
                toCell.add(cardToMove);
                fromCell.remove(cardToMove);
            } else{
                toCell.get(100);
            }
        }  
    }

    public void moveFtoF(ArrayList<Card> fromCell, ArrayList<Card> toCell){
        if(toCell.isEmpty()){
            Card c = fromCell.get(0);
            fromCell.remove(c);
            toCell.add(c);
        }
    }

    public String toString(){
        String str = "";
        for (Card c : this.freeList){
            str += c;
        }
        return str;
    }

}