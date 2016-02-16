package pl.kamis.mouph.cellular;

import pl.kamis.mouph.rule.Rule;

import java.util.Arrays;

public class CellularAutomataConverter {

    public boolean[] closeCircleAutomatConverter(Rule rule, boolean[] binaryMessage, int iterations) {
        for (int j = 0; j < iterations; j++) {
            for (int i = 0; i < binaryMessage.length; i++) {
                if (i > 1 && i < binaryMessage.length - 1) {
                    binaryMessage[i] = rule.getState(binaryMessage[i - 1], binaryMessage[i], binaryMessage[i + 1]);
                } else if (i == 0) {
                    binaryMessage[i] = rule.getState(binaryMessage[binaryMessage.length - 1], binaryMessage[i], binaryMessage[i + 1]);
                } else {
                    binaryMessage[i] = rule.getState(binaryMessage[binaryMessage.length - 2], binaryMessage[binaryMessage.length - 1], binaryMessage[0]);
                }
            }
        }
        return binaryMessage;
    }

    public boolean[] taperingAutomatConverter(Rule rule, boolean[] binaryMessage) {
        while (binaryMessage.length > 128) {
            for (int i = 0; i < binaryMessage.length; i++) {
                if (i > 1 && i < binaryMessage.length - 1) {
                    binaryMessage[i] = rule.getState(binaryMessage[i - 1], binaryMessage[i], binaryMessage[i + 1]);
                }
            }
            binaryMessage = Arrays.copyOfRange(binaryMessage, 1, binaryMessage.length - 1);
        }
        return binaryMessage;
    }
}
