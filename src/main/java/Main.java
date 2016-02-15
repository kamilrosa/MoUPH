import pl.kamis.mouph.cellular.CellularAutomataConverter;
import pl.kamis.mouph.converter.StringToBinaryConverter;
import pl.kamis.mouph.rule.Rule;

public class Main {
    public static void main(String[] args) {
        CellularAutomataConverter c = new CellularAutomataConverter();
        boolean[] message = StringToBinaryConverter.convertTextToBoolean("What's that? It's a plane ? No. It's MoUPH!");
        c.closeCircleAutomatConverter(new Rule(86), message, 10);
    }
}
