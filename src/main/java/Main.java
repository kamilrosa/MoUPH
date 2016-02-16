import pl.kamis.mouph.cellular.CellularAutomataConverter;
import pl.kamis.mouph.converter.BooleanArrayToStringConverter;
import pl.kamis.mouph.converter.StringToBinaryConverter;
import pl.kamis.mouph.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        CellularAutomataConverter c = new CellularAutomataConverter();
//        List<String> uniqueHash = new ArrayList<String>();
//        for(int z=0; z<256; z++) {
//            System.out.println("RULE : " + z);
//            Rule rule = new Rule(z);
//            boolean[] message = StringToBinaryConverter.convertTextToBoolean("What's that? Is it a plane ? No. It's MoUPH!");
//            message = c.closeCircleAutomatConverter(rule, message, 1000);
//            uniqueHash.add(BooleanArrayToStringConverter.convertBooleanArrayToString(message));
//            while (true) {
//                Thread.sleep(1);
//                message = c.closeCircleAutomatConverter(rule, message, 1000);
//                if (uniqueHash.contains(BooleanArrayToStringConverter.convertBooleanArrayToString(message))) {
//                    System.out.println("HASH REPEAT : " + uniqueHash.size());
//                    break;
//                } else {
//                    uniqueHash.add(BooleanArrayToStringConverter.convertBooleanArrayToString(message));
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        CellularAutomataConverter c = new CellularAutomataConverter();
        Rule r = new Rule(165);
        for (int i = 0; i < 256; i++) {
            System.out.println("RULE : " + i);
            Rule rule = new Rule(i);
            boolean[] booleanMessage = StringToBinaryConverter.convertTextToBoolean("This is initial message");
            List<String> uniqueHash = new ArrayList<>();
            int j = 0;
            while (true) {
                j++;
                Thread.sleep(1);
                boolean[] booleen = c.taperingAutomatConverter(rule, booleanMessage);
                String s = BooleanArrayToStringConverter.convertBooleanArrayToString(booleen);
                if (uniqueHash.contains(s)) {
                    System.out.println("HASH REPEAT : " + uniqueHash.size());
                    break;
                } else {
                    uniqueHash.add(s);
                }
                booleanMessage = c.closeCircleAutomatConverter(r, booleanMessage, 1);
                if(j > 30000) {
                    System.out.println("UNLIMITED ?!@#$%");
                    break;
                }
            }
        }
    }
}