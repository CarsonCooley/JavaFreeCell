import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the GUI component for painting an image of a playing card.
 * @author 
 *
 */
public class TableauPanel extends JPanel{

    private ArrayList<Card> cards;

    /**
     * Constructor for an empty panel, displays a wire frame. 
     */
    public TableauPanel(){
        Color myGreen = new Color(1,153,39);
        setBackground(myGreen);
        cards = new ArrayList<Card>();
        //this(null);
    }

    /**
     * Constructor to display a given card's image.
     * @param c the card to display.
     */
    public TableauPanel(ArrayList<Card> c){
        Color myGreen = new Color(1,153,39);
        setBackground(myGreen);
        cards = new ArrayList<Card>(c);
    }

    /**
     * Paints the card's face image if a card is present, otherwise, paints the back side image.
     */
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
    	
    	if (cards.isEmpty()){
            Icon image;
    		image = Card.getBack();
    		g.setColor(Color.yellow);
    		int x = (getWidth() - image.getIconWidth()) / 2;
    		int y = (getHeight() - image.getIconHeight()) / 2;
    		g.drawRect(x, y, image.getIconWidth(), image.getIconHeight());
    	}
    	else{

            int y = 10;
            
            for (Card c : cards){
                if (!c.isFaceUp()){
                    c.turn();
                }
                Icon image = c.getImage();
                int x = (getWidth() - image.getIconWidth()) / 2;
                image.paintIcon(this, g, x, y);
                y+= 35;
            }
    	}
    }
    
    /**
     * Resets the panel's cards and refreshes the panel.
     * @param c the card to be displayed.
     */
    public void setCards(ArrayList<Card> c){
    	cards = c;
    	repaint();
    }

}
