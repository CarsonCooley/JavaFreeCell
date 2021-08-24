import java.util.ArrayList;

public class Homecell {

    private ArrayList<Card> homeList;
    private String name;

    public Homecell(ArrayList<Card> homeList, String name){
        this.homeList = new ArrayList<Card>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getCards(){
        return this.homeList;
    }

    public String getTopCard(){
        if (this.homeList.isEmpty()){
            return "";
        } else {
            return this.homeList.get(this.homeList.size()-1).toString();
        }
    }

    public Card getTop(){
        if (this.homeList.isEmpty()){
            return null;
        }
        return this.homeList.get(this.homeList.size()-1);
    }

    public String toString(){
        String str = "";
        for (Card c : this.homeList){
            str += c + " | ";
        }
        return str;
    }

}