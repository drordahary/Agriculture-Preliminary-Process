package Attributes;

public enum Classification {
    Vegetable,
    Fruit,
    Grain,
    Berry,
    Citrus,
    RootVegetable,
    Legumes;
    public String toString(){
        if (this==Vegetable)
        return "Vegetable";
        if (this==Fruit)
        return "Fruit";
        if (this==Grain)
        return "Grain";
        if (this==Berry)
        return "Berry";
        if (this==Citrus)
        return "Citrus";
        if (this==Legumes)
        return "Legumes";
         if (this==RootVegetable)
        return "Root vegetable";
        return null;
    }
}
