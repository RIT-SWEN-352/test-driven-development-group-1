package edu.rit.swen352.tdd.hard;

public interface UnitEnum {
    
    enum Mass {
        KILOGRAM(1),
        MILLIGRAM(.000001),
        GRAM(.001),
        OUNCE(0.0283495),
        POUND(0.453592);

        private double kg;

        Mass(double kg){
            this.kg=kg;
        }

        public double conversionRatio(Mass convertFrom) {
            return convertFrom.kg/this.kg;
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
