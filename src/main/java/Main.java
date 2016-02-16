import pl.kamis.mouph.cellular.CellularAutomataConverter;
import pl.kamis.mouph.converter.BooleanArrayToStringConverter;
import pl.kamis.mouph.converter.StringToBinaryConverter;
import pl.kamis.mouph.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CellularAutomataConverter c = new CellularAutomataConverter();
        List<String> uniqueHash = new ArrayList<String>();
        for(int z=61; z<256; z++) {
            System.out.println("RULE : " + z);
            Rule rule = new Rule(z);
            boolean[] message = StringToBinaryConverter.convertTextToBoolean("What's that? Is it a plane ? No. It's MoUPH!");
            message = c.closeCircleAutomatConverter(rule, message, 100);
            uniqueHash.add(BooleanArrayToStringConverter.convertBooleanArrayToString(message));
            while (true) {
                Thread.sleep(1);
                message = c.closeCircleAutomatConverter(rule, message, 100);
                if (uniqueHash.contains(BooleanArrayToStringConverter.convertBooleanArrayToString(message))) {
                    System.out.println("HASH REPEAT : " + uniqueHash.size());
                    break;
                } else {
                    uniqueHash.add(BooleanArrayToStringConverter.convertBooleanArrayToString(message));
                }
            }
        }
    }
}