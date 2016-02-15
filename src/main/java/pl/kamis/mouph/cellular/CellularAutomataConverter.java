package pl.kamis.mouph.cellular;

import pl.kamis.mouph.rule.Rule;

public class CellularAutomataConverter {

    public boolean[] closeCircleAutomatConverter(Rule rule, boolean[] binaryMessage, int iterations) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < iterations; j++) {
            int length = binaryMessage.length;
            for (int i = 0; i < binaryMessage.length; i++) {
                if (i > 1 && i < length - 1) {
                    binaryMessage[i] = rule.getState(binaryMessage[i - 1], binaryMessage[i], binaryMessage[i + 1]);
                } else if (i == 0) {
                    binaryMessage[i] = rule.getState(binaryMessage[binaryMessage.length - 1], binaryMessage[i], binaryMessage[i + 1]);
                } else {
                    binaryMessage[i] = rule.getState(binaryMessage[binaryMessage.length - 2], binaryMessage[binaryMessage.length - 1], binaryMessage[0]);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("TOTAL CIRCLE TIME : " + ((end - start) / 1000));
        return binaryMessage;
    }
}
