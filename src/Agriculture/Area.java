package Agriculture;

import Attributes.Range;
import Attributes.Soil;

public class Area {
    private int id;
    private String name;
    private Range precipitation;
    private Range s_temperature;
    private Range w_temperature;
    private Soil soil;

    public Area(int id, String name , Range precipitation, Range s_temperature,Range w_temperature, Soil soil) {
        this.id = id;
        this.name = name;
        this.precipitation = precipitation;
        this.s_temperature = s_temperature;
        this.w_temperature = w_temperature;
        this.soil = soil;
    }

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\033[0;32m";

    public int getId() {
        return id;
    }

    public Range getPrecipitation() {
        return precipitation;
    }

    public String getName() {
        return name;
    }

    public Range getS_temperature() {
        return s_temperature;
    }

    public Range getW_temperature() {
        return w_temperature;
    }

    public Soil getSoil() {
        return soil;
    }

    @Override
    public String toString() {
        return GREEN + id + ".\n" +
                RED + name+":\n" +
                BLUE +"precipitation is: " + precipitation.toString() + "\n" +
                BLUE +"temperature in winter is: " + w_temperature.toString() + "\n" +
                BLUE +"temperature in summer is: " + s_temperature.toString() + "\n" +
                "soil: " + soil + "\n" +"\n\n\n"+ RESET;
    }

}
