package edu.rit.swen352.tdd.hard;

import javax.lang.model.type.PrimitiveType;

public interface UnitEnum {
    
    enum Mass {
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

        public double conversionRatio(Mass convertFrom) {
            return convertFrom.kg/this.kg;
        }

        public String toString(){
            return abbr;
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
