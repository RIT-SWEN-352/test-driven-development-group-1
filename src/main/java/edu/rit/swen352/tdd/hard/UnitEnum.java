package edu.rit.swen352.tdd.hard;

public interface UnitEnum {

    double getBaseRatio();
    default double getConversionRatio(UnitEnum convertTo, UnitEnum convertFrom){
        return convertFrom.getBaseRatio()/convertTo.getBaseRatio();
    }
    default double getConversionRatio(UnitEnum convertFrom){
        return getConversionRatio(this, convertFrom);
    }
    
    enum Mass implements UnitEnum {
        KILOGRAM(1,"kg"),
        MILLIGRAM(.000001,"mg"),
        GRAM(.001,"g"),
        OUNCE(0.0283495,"oz"),
        POUND(0.453592,"lb");

        private double kg;
        private String abbr;

        Mass(double kg, String abbr){
            this.kg=kg;
            this.abbr = abbr;
        }

        public String toString(){
            return abbr;
        }

        @Override
        public double getBaseRatio() {
            return kg;
        }

    }

    /*INCH, 
        FEET,
        YARD,
        MILLIMETER,
        CENTIMETER,
        METER,
        KILOMETER */

}
