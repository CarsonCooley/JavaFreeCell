import java.util.ArrayList;

public class FreecellGame{

    public Tableau t1, t2, t3, t4, t5, t6, t7, t8;
    public ArrayList<Tableau> tableaux;
    public Freecell f1;
	public Freecell f2;
	public Freecell f3;
	public Freecell f4;
    public ArrayList<Freecell> freecells;
    public Homecell h1, h2, h3, h4;
    public ArrayList<Homecell> homecells;
    public int moveCount;


    public FreecellGame(){

        Deck deck = new Deck();
        deck.shuffle();

        moveCount = 0;

        ArrayList<Card> tableau1 = new ArrayList<Card>();
        ArrayList<Card> tableau2 = new ArrayList<Card>();
        ArrayList<Card> tableau3 = new ArrayList<Card>();
        ArrayList<Card> tableau4 = new ArrayList<Card>();
        ArrayList<Card> tableau5 = new ArrayList<Card>();
        ArrayList<Card> tableau6 = new ArrayList<Card>();
        ArrayList<Card> tableau7 = new ArrayList<Card>();
        ArrayList<Card> tableau8 = new ArrayList<Card>();
        

        int i = 1;
        while(!(deck.isEmpty())){
            if (i % 8 == 1){
                tableau1.add(deck.deal());
            } else if (i % 8 == 2){
                tableau2.add(deck.deal());
            } else if (i % 8 == 3){
                tableau3.add(deck.deal());
            } else if (i % 8 == 4){
                tableau4.add(deck.deal());
            } else if (i % 8 == 5){
                tableau5.add(deck.deal());
            } else if (i % 8 == 6){
                tableau6.add(deck.deal());
            } else if (i % 8 == 7){
                tableau7.add(deck.deal());
            } else if (i % 8 == 0){
                tableau8.add(deck.deal());
            }

            i++;

        }

        t1 = new Tableau(tableau1, "t1");
        t2 = new Tableau(tableau2, "t2");
        t3 = new Tableau(tableau3, "t3");
        t4 = new Tableau(tableau4, "t4");
        t5 = new Tableau(tableau5, "t5");
        t6 = new Tableau(tableau6, "t6");
        t7 = new Tableau(tableau7, "t7");
        t8 = new Tableau(tableau8, "t8");

        tableaux = new ArrayList<Tableau>();

        tableaux.add(t1);
        tableaux.add(t2);
        tableaux.add(t3);
        tableaux.add(t4);
        tableaux.add(t5);
        tableaux.add(t6);
        tableaux.add(t7);
        tableaux.add(t8);


        f1 = new Freecell(new ArrayList<Card>(), "f1");
        f2 = new Freecell(new ArrayList<Card>(), "f2");
        f3 = new Freecell(new ArrayList<Card>(), "f3");
        f4 = new Freecell(new ArrayList<Card>(), "f4");

        freecells = new ArrayList<Freecell>();

        freecells.add(f1);
        freecells.add(f2);
        freecells.add(f3);
        freecells.add(f4);


        h1 = new Homecell(new ArrayList<Card>(), "h1");
        h2 = new Homecell(new ArrayList<Card>(), "h2");
        h3 = new Homecell(new ArrayList<Card>(), "h3");
        h4 = new Homecell(new ArrayList<Card>(), "h4");

        homecells = new ArrayList<Homecell>();

        homecells.add(h1);
        homecells.add(h2);
        homecells.add(h3);
        homecells.add(h4);
        

    }

    public boolean isOver(){
        for (Tableau t : tableaux){
            if (!(t.isAscending(t.getCards())) || !(t.isAlternatingColor(t.getCards()))){
                return false;
            }
        }

        //System.out.println("YOU WON!");
        return true;
    }


    public String toString(){
        String str = "========================================================================  Move #" + moveCount + 
                     "  ======================================================================\n\n";
        str += "T1: " + t1.toString() + "\n";
        str += "\nT2: " + t2.toString() + "\n";
        str += "\nT3: " + t3.toString() + "\n";
        str += "\nT4: " + t4.toString() + "\n";
        str += "\nT5: " + t5.toString() + "\n";
        str += "\nT6: " + t6.toString() + "\n";
        str += "\nT7: " + t7.toString() + "\n";
        str += "\nT8: " + t8.toString() + "\n";

        str += "\nF1: " + f1.toString() +"\n";
        str += "F2: " + f2.toString() + "\n";
        str += "F3: " + f3.toString() + "\n";
        str += "F4: " + f4.toString() + "\n";

        str += "\nH1: " + h1.getTopCard() +"\n";
        str += "H2: " + h2.getTopCard() + "\n";
        str += "H3: " + h3.getTopCard() + "\n";
        str += "H4: " + h4.getTopCard() + "\n";

        return str;
    }

}