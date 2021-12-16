package Agriculture;

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
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\033[0;32m";
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
        return GREEN + id + ".\n" +
                RED + name+":\n" +
                BLUE +"water: " + water + "\n" +
                "temperature needed: " + temperature + "\n"+
                "soil: " + soil + "\n"+
                "growth Type: " + growthType +"\n\n\n"+ RESET;
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