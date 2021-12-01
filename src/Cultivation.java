public class Cultivation {
    private int id;
    private String name;
    private int water;
    private int temperature;
    private Soil soil;
    private growthType growthType;

    public Cultivation(int id,String name, int water, int temperature, Soil ground, growthType growthType){
        this.id= id;
        this.name=name;
        this.water = water;
        this.temperature = temperature;
        this.soil = ground;
        this.growthType = growthType;
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getTemperature() {
        return temperature;
    }

    public Soil getSoil() {
        return soil;
    }

    public growthType getGrowthType() {
        return growthType;
    }

    public String toString() {
        return "Cultivation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", water=" + water +
                ", temperature=" + temperature +
                ", soil=" + soil +
                ", growthType=" + growthType +
                '}';
    }
}
