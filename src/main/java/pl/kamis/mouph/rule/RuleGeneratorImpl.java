package pl.kamis.mouph.rule;

public class RuleGeneratorImpl implements RuleGenerator {

    private double max;
    private int bitsCount;
    private int current = -1;

    public RuleGeneratorImpl(int bitsCount) {
        this.bitsCount = bitsCount;
        max = Math.pow(2, bitsCount) - 1;
    }

    public boolean hasNext() {
        return current < max;
    }
}
