import Attributes.GrowthType;
import Attributes.Season;
import Attributes.Soil;

import java.util.ListIterator;

public class Cultivation implements ListIterator<Cultivation> {
    private int id;
    private String name;
    private int water;
    private int temperature;
    private Season season;
    private Soil soil;
    private GrowthType growthType;

    public Cultivation(int id, String name, int water, int temperature,Season season, Soil soil, GrowthType growthType){
        this.id= id;
        this.name=name;
        this.water = water;
        this.temperature = temperature;
        this.season=season;
        this.soil = soil;
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

    public GrowthType getGrowthType() {
        return growthType;
    }


    @Override
    public String toString() {
        return id + ".\n" +
                 name+":\n" +
                "water: " + water + "\n" +
                "temperature needed: " + temperature + "\n"+
                "soil: " + soil + "\n"+
                "growth Type: " + growthType +"\n\n\n";
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Cultivation next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Cultivation previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Cultivation cultivation) {

    }

    @Override
    public void add(Cultivation cultivation) {

    }
}
