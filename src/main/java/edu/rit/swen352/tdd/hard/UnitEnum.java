package edu.rit.swen352.tdd.hard;

import javax.lang.model.type.PrimitiveType;

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

        /**
         * returns How many __this__ in one __convertFrom__ unit 
         */
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
