import java.util.ArrayList;

public class Tableau{

    private ArrayList<Card> tableau;
    private String name;

    public Tableau(ArrayList<Card> tableau, String name){
        this.tableau = tableau;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getCards(){
        return this.tableau;
    }

    public Card cardToBeMoved(ArrayList<Card> fromCell, ArrayList<Card> toCell){
        if (toCell.size() > 0){
            Card linkCard = toCell.get(toCell.size()-1);
            
            for(int i = fromCell.size()-1; i>=0; i--){
                if(linkCard.getRank() - fromCell.get(i).getRank() == 1 && !(fromCell.get(i).getColor().equals(linkCard.getColor()))){
                    return fromCell.get(i);
                }
            }
            return null;
        }else{
            ArrayList<Card> clone = new ArrayList<Card>(fromCell);
            for (int i = fromCell.size()-1; i>=0; i--){
                if (isAscending(clone) && isAlternatingColor(clone)){
                    return clone.get(0);
                }else{
                    clone.remove(0);
                }
            }
            return null;

        }

    }

    // We may need to use an arrayList interpretation because we need to return an index
    public boolean isValidMove(ArrayList<Card> fromStack, ArrayList<Card> toStack){

        if(fromStack.size() == 1){
            return true;
        }

        Card targetCard = cardToBeMoved(fromStack, toStack);
        ArrayList<Card> clone = new ArrayList<Card>();
        int index = fromStack.indexOf(targetCard);

        
        if(index == fromStack.size()-1){
            Card target = fromStack.get(index);
            Card link = toStack.get(toStack.size()-1);

            if(target.getRank() - link.getRank() == -1 && ! target.getColor().equals(link.getColor())){
                return true;
            } else {
                return false;
            }
        }

        for(int i = index; i<=fromStack.size()-1; i++){
            clone.add(fromStack.get(i));
        }

        if(clone.isEmpty()){
            return false;
        }

        if(isAlternatingColor(clone) && isAscending(clone)){
            return true;
        }

        return false;
    } 

    // isAlternatingColor and isDescending are both popping a card from input stack, it is not using clone properly
    public boolean isAlternatingColor(ArrayList<Card> lyst){

        ArrayList<Card> clone = new ArrayList<Card>();

        for(Card c : lyst){
            clone.add(c);
        }

        for(int i = clone.size()-1; i>0; i--){
            if(clone.get(i).getColor().equals(clone.get(i-1).getColor())){
                return false;
            }
        }

        return true;
        
    }

    public boolean isAscending(ArrayList<Card> lyst){

        if(lyst.isEmpty()){
            return true;
        }

        ArrayList<Card> clone = new ArrayList<Card>();

        for(Card c : lyst){
            clone.add(c);
        }

        for(int i = clone.size()-1; i>0; i--){
            if(clone.get(i).getRank() - clone.get(i-1).getRank() != -1){
                return false;
            }
        }

        return true;
    }

    public void moveTtoT(ArrayList<Card> fromStack, ArrayList<Card> toStack, Card target){
        if (toStack.isEmpty()){
            int index = fromStack.indexOf(target);
            for(int i = fromStack.size()-1; i>= index; i--){
                Card c = fromStack.get(index);
                fromStack.remove(c);
                toStack.add(c);
            }
        }else{
            if(isValidMove(fromStack, toStack)){
                int index = fromStack.indexOf(target);
                for(int i = fromStack.size()-1; i>= index; i--){
                    Card c = fromStack.get(index);
                    fromStack.remove(c);
                    toStack.add(c);
                }
            } else{
                if (!isValidMove(fromStack, toStack)){
                    toStack.get(100);
                }
            }
        }
        
        
    }

    public void moveTtoF(ArrayList<Card> fromStack, ArrayList<Card>toStack){
        Card cardToMove = fromStack.get(fromStack.size()-1);
        if(toStack.isEmpty()){
            toStack.add(cardToMove);
            fromStack.remove(cardToMove);
        } 
    }

    public void moveTtoH(ArrayList<Card> fromCell, ArrayList<Card> toCell){
        Card cardToMove = fromCell.get(fromCell.size()-1);
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

    public String toString(){
        String str = "";
        for (Card c : this.tableau){
            str += c + " | ";
        }
        return str;
    }

}