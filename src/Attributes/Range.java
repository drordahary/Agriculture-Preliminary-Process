package Attributes;

public class Range {
    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "between " + this.min + " and " + this.max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    public boolean isBetween(int num){
        return num<=max && num>=min;
    }
}
