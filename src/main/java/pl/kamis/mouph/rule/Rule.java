package pl.kamis.mouph.rule;

public class Rule {

    private final int ruleSize;
    private final boolean[] state;

    public Rule(int seed) {
        ruleSize = 8;
        state = new boolean[ruleSize];
        for (int i = 0; i < ruleSize; i++) {
            state[i] = (seed & 1) == 1;
            seed = seed >>> 1;
        }
    }

    public boolean[] getState() {
        return state;
    }

    public boolean getState(boolean first, boolean second, boolean third) {
        if (!first && !second && !third) {
            return state[0];
        } else if (!first && !second) {
            return state[1];
        } else if (!first && !third) {
            return state[2];
        } else if (!first) {
            return state[3];
        } else if (!second && !third) {
            return state[4];
        } else if (!second) {
            return state[5];
        } else if (!third) {
            return state[6];
        } else {
            return state[7];
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = ruleSize - 1; i >= 0; i--) {
            s.append(state[i] ? 1 : 0);
        }
        return s.toString();
    }
}
