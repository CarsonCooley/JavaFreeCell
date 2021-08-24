import java.util.ArrayList;

public class Parser {

    public String[] Parse(ArrayList<String> arrayListInput){

        String input = "";
        input += arrayListInput.get(0);
        input += arrayListInput.get(1);

        input.toUpperCase();

        String[] returnString = new String[2];
         
        String from = "";
        from += input.charAt(0);
        from += input.charAt(1);

        String to = "";
        to += input.charAt(2);
        to += input.charAt(3);

        returnString[0] = from;
        returnString[1] = to;

        return returnString;
    }
}
