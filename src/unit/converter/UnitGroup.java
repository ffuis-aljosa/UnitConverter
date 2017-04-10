package unit.converter;

import java.util.ArrayList;

public class UnitGroup {
    private String name;
    private ArrayList<String> units;
    private ArrayList<Double> coeficients;

    public UnitGroup(String name, String mainUnit, String[] units, double[] coeficients) {
        this.name = name;
        
        if (units.length != coeficients.length)
            throw new Error("Units and coeficients need to be of same size");
        
        this.units = new ArrayList<>();
        this.units.add(mainUnit);
        
        for (String unit : units)
            this.units.add(unit);
        
        this.coeficients = new ArrayList<>();
        this.coeficients.add(1.0);
        
        for (double coeficient : coeficients)
            this.coeficients.add(coeficient);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    public ArrayList<Double> getCoeficients() {
        return coeficients;
    }
    
    public double convert(double value, int fromIndex, int toIndex) {
        return value * coeficients.get(fromIndex) / coeficients.get(toIndex);
    }
}
