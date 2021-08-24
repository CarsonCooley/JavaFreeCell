import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppView extends JFrame{

    private FreecellGame game;
    private ArrayList<CardPanel> fPanels = new ArrayList<CardPanel>();
    private ArrayList<CardPanel> hPanels = new ArrayList<CardPanel>();
    private ArrayList<TableauPanel> tPanels = new ArrayList<TableauPanel>();
    public ArrayList<String> inputString = new ArrayList<String>();

    public Parser p = new Parser();

    public AppView(){
        this.setTitle("The Game of Freecell");
        this.game = new FreecellGame();

        CardPanel fpanel1 = new CardPanel();
        CardPanel fpanel2 = new CardPanel();
        CardPanel fpanel3 = new CardPanel();
        CardPanel fpanel4 = new CardPanel();
        
        CardPanel hpanel1 = new CardPanel();
        CardPanel hpanel2 = new CardPanel();
        CardPanel hpanel3 = new CardPanel();
        CardPanel hpanel4 = new CardPanel();
        Icon babyYoda = new ImageIcon("babyyoda.gif");

        JButton newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                FreecellGame newGame = new FreecellGame();
                game = newGame;
                for (int i = 0; i < tPanels.size(); i++){
                    tPanels.get(i).setCards(game.tableaux.get(i).getCards());
                }
                for (int i = 0; i < hPanels.size(); i++){
                    hPanels.get(i).setCard(null);
                }
                for (int i = 0; i < fPanels.size(); i++){
                    fPanels.get(i).setCard(null);
                }
        }});

        

        fPanels.add(fpanel1);
        fPanels.add(fpanel2);
        fPanels.add(fpanel3);
        fPanels.add(fpanel4);

        hPanels.add(hpanel1);
        hPanels.add(hpanel2);
        hPanels.add(hpanel3);
        hPanels.add(hpanel4);

        JLabel flabel = new JLabel("  FREECELLS  ");
        flabel.setBackground(Color.WHITE);
        flabel.setOpaque(true);
        JLabel hlabel = new JLabel("  HOMECELLS  ");
        hlabel.setBackground(Color.WHITE);
        hlabel.setOpaque(true);


        Container c = getContentPane();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        c.setLayout(layout);
        constraints.gridx = 3;
        constraints.gridy = 0;

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = GridBagConstraints.VERTICAL;

        Color myGreen = new Color(1,153,39);

        c.setBackground(myGreen);

        layout.setConstraints(flabel, constraints);
        c.add(flabel);
        constraints.gridx = 4;
        layout.setConstraints(hlabel, constraints);
        c.add(hlabel);


        constraints.ipadx = 100;
        constraints.ipady = 200;
        constraints.gridx = 0;
        constraints.gridy = 1;

        layout.setConstraints(fpanel1, constraints);
        c.add(fpanel1);
        constraints.gridx = 1;
        layout.setConstraints(fpanel2, constraints);
        c.add(fpanel2);
        constraints.gridx = 2;
        layout.setConstraints(fpanel3, constraints);
        c.add(fpanel3);
        constraints.gridx = 3;
        layout.setConstraints(fpanel4, constraints);
        c.add(fpanel4);

        constraints.gridx = 4;
        layout.setConstraints(hpanel1, constraints);
        c.add(hpanel1);
        constraints.gridx = 5;
        layout.setConstraints(hpanel2, constraints);
        c.add(hpanel2);
        constraints.gridx = 6;
        layout.setConstraints(hpanel3, constraints);
        c.add(hpanel3);
        constraints.gridx = 7;
        layout.setConstraints(hpanel4, constraints);
        c.add(hpanel4);

        constraints.ipady = 480;
        constraints.gridy = 15;
        constraints.gridx = 0;

        TableauPanel tpanel1 = new TableauPanel(game.t1.getCards());
        TableauPanel tpanel2 = new TableauPanel(game.t2.getCards());
        TableauPanel tpanel3 = new TableauPanel(game.t3.getCards());
        TableauPanel tpanel4 = new TableauPanel(game.t4.getCards());
        TableauPanel tpanel5 = new TableauPanel(game.t5.getCards());
        TableauPanel tpanel6 = new TableauPanel(game.t6.getCards());
        TableauPanel tpanel7 = new TableauPanel(game.t7.getCards());
        TableauPanel tpanel8 = new TableauPanel(game.t8.getCards());

        tPanels.add(tpanel1);
        tPanels.add(tpanel2);
        tPanels.add(tpanel3);
        tPanels.add(tpanel4);
        tPanels.add(tpanel5);
        tPanels.add(tpanel6);
        tPanels.add(tpanel7);
        tPanels.add(tpanel8);


        for (TableauPanel tP : tPanels){

            tP.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if(e.getSource() == tpanel1){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t1");
                        } else {
                            inputString.add(1, "t1");
                        }
                    } else if (e.getSource() == tpanel2){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t2");
                        } else {
                            inputString.add(1, "t2");
                        }
                    } else if (e.getSource() == tpanel3){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t3");
                        } else {
                            inputString.add(1, "t3");
                        }

                    } else if (e.getSource() == tpanel4){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t4");
                        } else {
                            inputString.add(1, "t4");
                        }

                    } else if (e.getSource() == tpanel5){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t5");
                        } else {
                            inputString.add(1, "t5");
                        }

                    } else if (e.getSource() == tpanel6){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t6");
                        } else {
                            inputString.add(1, "t6");
                        }

                    } else if (e.getSource() == tpanel7){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t7");
                        } else {
                            inputString.add(1, "t7");
                        }

                    } else if (e.getSource() == tpanel8){
                        if(inputString.isEmpty()){
                            inputString.add(0, "t8");
                        } else {
                            inputString.add(1, "t8");
                        }
                    } 
 
                    makeMove();

                    for (int i = 0; i < tPanels.size(); i++){
                        tPanels.get(i).setCards(game.tableaux.get(i).getCards());
                    }
                    for (int j = 0; j < fPanels.size(); j++){
                        if (game.freecells.get(j).getCards().isEmpty()){
                            fPanels.get(j).setCard(null);
                        }else{
                        fPanels.get(j).setCard(game.freecells.get(j).getCards().get(0));
                        }
                    }
                    for (int k = 0; k < hPanels.size(); k++){
                        if (game.homecells.get(k).getCards().isEmpty()){
                            hPanels.get(k).setCard(null);
                        }else{
                            hPanels.get(k).setCard(game.homecells.get(k).getTop());
                        }
                    }

                    
                }

            });           

            layout.setConstraints(tP, constraints);
            c.add(tP);
            constraints.gridx += 1;

        }

        for (CardPanel cP : fPanels){

            cP.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if(e.getSource() == fpanel1){
                        if(inputString.isEmpty()){
                            inputString.add(0, "f1");
   
                        } else {
                            inputString.add(1, "f1");
                            
                        }
                    } else if (e.getSource() == fpanel2){
                        if(inputString.isEmpty()){
                            inputString.add(0, "f2");
                        } else {
                            inputString.add(1, "f2");
                        }
                    } else if (e.getSource() == fpanel3){
                        if(inputString.isEmpty()){
                            inputString.add(0, "f3");
                        } else {
                            inputString.add(1, "f3");
                        }

                    } else if (e.getSource() == fpanel4){
                        if(inputString.isEmpty()){
                            inputString.add(0, "f4");
                        } else {
                            inputString.add(1, "f4");
                        }

                    }

                    makeMove();
                    
                    for (int i = 0; i < tPanels.size(); i++){
                        tPanels.get(i).setCards(game.tableaux.get(i).getCards());
                    }
                    for (int j = 0; j < fPanels.size(); j++){
                        if (game.freecells.get(j).getCards().isEmpty()){
                            fPanels.get(j).setCard(null);
                        }else{
                        fPanels.get(j).setCard(game.freecells.get(j).getCards().get(0));
                        }
                    }
                    for (int k = 0; k < hPanels.size(); k++){
                        if (game.homecells.get(k).getCards().isEmpty()){
                            hPanels.get(k).setCard(null);
                        }else{
                            hPanels.get(k).setCard(game.homecells.get(k).getTop());
                        }
                    }
                    
                }

            });
        
        }

        for (CardPanel cP : hPanels){

            cP.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if(e.getSource() == hpanel1){
                        if(inputString.isEmpty()){
                            inputString.add(0, "h1");
                        } else {
                            inputString.add(1, "h1");
                        }
                    } else if (e.getSource() == hpanel2){
                        if(inputString.isEmpty()){
                            inputString.add(0, "h2");
                        } else {
                            inputString.add(1, "h2");
                        }
                    } else if (e.getSource() == hpanel3){
                        if(inputString.isEmpty()){
                            inputString.add(0, "h3");
                        } else {
                            inputString.add(1, "h3");
                        }

                    } else if (e.getSource() == hpanel4){
                        if(inputString.isEmpty()){
                            inputString.add(0, "h4");
                        } else {
                            inputString.add(1, "h4");
                        }

                    }

                    makeMove();
                    
                    for (int i = 0; i < tPanels.size(); i++){
                        tPanels.get(i).setCards(game.tableaux.get(i).getCards());
                    }
                    for (int j = 0; j < fPanels.size(); j++){
                        if (game.freecells.get(j).getCards().isEmpty()){
                            fPanels.get(j).setCard(null);
                        }else{
                        fPanels.get(j).setCard(game.freecells.get(j).getCards().get(0));
                        }
                    }
                    for (int k = 0; k < hPanels.size(); k++){
                        if (game.homecells.get(k).getCards().isEmpty()){
                            hPanels.get(k).setCard(null);
                        }else{
                            hPanels.get(k).setCard(game.homecells.get(k).getTop());
                        }
                    }


                }

            });
            
            
        }


        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.gridy = 20;
        constraints.gridx = 6;
        layout.setConstraints(newGame, constraints);
        c.add(newGame);

        constraints.gridy = 20;
        constraints.gridx = 7;
        JLabel bY = new JLabel(babyYoda);
        layout.setConstraints(bY, constraints);
        c.add(bY);

        c.setVisible(true);


    }


    public boolean canBeParsed(){

        if(inputString.size() == 2){
            return true;
        } else {
            return false;
        }
    }

    public void makeMove(){
        if(canBeParsed() == true){

            ArrayList<Card> fromCell = new ArrayList<Card>();
            ArrayList<Card> toCell = new ArrayList<Card>();
       
            for (Tableau t : game.tableaux){
                 if(t.getName().equals(inputString.get(0))){
                      fromCell = t.getCards();
                      
                 }
                 if(t.getName().equals(inputString.get(1))){
                      toCell = t.getCards();
                      

                 }
             }
       
            for (Freecell f : game.freecells){
                 if(f.getName().equals(inputString.get(0))){
                      fromCell = f.getCards();
                      
                 }
                 if(f.getName().equals(inputString.get(1))){
                      toCell = f.getCards();
                 }
            }
       
            for (Homecell h : game.homecells){
                 if(h.getName().equals(inputString.get(0))){
                      fromCell = h.getCards();
                 }
                 if(h.getName().equals(inputString.get(1))){
                      toCell = h.getCards();
                 }
            }

            if (fromCell.isEmpty()){
                JOptionPane.showMessageDialog(null, "INVALID MOVE");
            }else{

               try {
                    if(inputString.get(0).charAt(0) == 't' && inputString.get(1).charAt(0) == 't'){
                         Card c = game.t1.cardToBeMoved(fromCell, toCell);
                         game.t1.moveTtoT(fromCell, toCell, c);
                    } else if(inputString.get(0).charAt(0) == 't' && inputString.get(1).charAt(0) == 'f'){
                         game.t1.moveTtoF(fromCell, toCell);
                    } else if(inputString.get(0).charAt(0) == 't' && inputString.get(1).charAt(0) == 'h'){
                         game.t1.moveTtoH(fromCell, toCell);
                    } else if(inputString.get(0).charAt(0) == 'f' && inputString.get(1).charAt(0) == 't'){
                         game.f1.moveFtoT(fromCell, toCell);
                    } else if(inputString.get(0).charAt(0) == 'f' && inputString.get(1).charAt(0) == 'h'){
                         game.f1.moveFtoH(fromCell, toCell);
                    } else if(inputString.get(0).charAt(0) == 'f' && inputString.get(1).charAt(0) == 'f'){
                         game.f1.moveFtoF(fromCell, toCell);
                    } else if(inputString.get(0).charAt(0) == 'h'){
                        JOptionPane.showMessageDialog(null, "INVALID MOVE");
                    }
               } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "INVALID MOVE");
               }

               
            }
        }

        if (inputString.size() == 2){
            inputString.clear();
        }

        if (game.isOver()){
            JOptionPane.showMessageDialog(null, "You Won!");
        }

    }


}