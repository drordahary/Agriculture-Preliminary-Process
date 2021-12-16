

public class Area {
    private int precipitation;
    private Range temperature;
    private Soil soil;
    private boolean tree,bush,ground;

    public Area(int precipitation, int min, int max, Soil soil, boolean tree, boolean bush, boolean ground) {
        this.precipitation = precipitation;
        this.temperature = new Range(min, max);
        this.soil = soil;
        this.tree = tree;
        this.bush = bush;
        this.ground = ground;
    }
}
