public class Cultivation {
    private static int generator =1;
    private int id, water, temperature, profit, cost, singleLifeTime, plantationLifeTime;
    private String name;
    private Soil soil;
    private growthType growthType;

    public Cultivation(String name, int water, int temperature, Soil ground, growthType growthType, int cost, int profit, int singleLifeTime, int plantationLifeTime) {
        this.id= generator++;
        this.name=name;
        this.water = water;
        this.temperature = temperature;
        this.soil = ground;
        this.growthType = growthType;
        this.cost = cost;
        this.profit = profit;
        this.singleLifeTime = singleLifeTime;
        this.plantationLifeTime = plantationLifeTime;
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

    public int getCost() {
        return cost;
    }

    public int getProfit() {
        return profit;
    }

    public int getSingleLifeTime() {
        return singleLifeTime;
    }

    public int getPlantationLifeTime() {
        return plantationLifeTime;
    }


}
