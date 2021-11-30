public class Area {
    private int precipitation, temperature;
    private Soil soil;
    private boolean tree,bush,ground;

    public Area(int precipitation, int temperature, Soil soil, boolean tree, boolean bush, boolean ground) {
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.soil = soil;
        this.tree = tree;
        this.bush = bush;
        this.ground = ground;
    }
}
