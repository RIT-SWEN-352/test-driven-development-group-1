package edu.rit.swen352.tdd.hard;

public interface UnitEnum {

    double getBaseRatio();
    default double getConversionRatio(UnitEnum convertTo, UnitEnum convertFrom){
        return convertFrom.getBaseRatio()/convertTo.getBaseRatio();
    }
    /**
    * returns how many __this__ are in one __convertFrom__ unit
     */
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

    enum Length implements UnitEnum{
        METER(1,"m"),
        MILLIMETER(.001,"mm"),
        CENTIMETER(.01,"cm"),
        KILOMETER(1000,"km"),
        INCH(0.0254,"in"), 
        FEET(.3048,"ft"),
        YARD(.9144,"yd"),
        MILE(1609.34,"mi");

        private double meter;
        private String abbr;

        Length(double meter, String abbr){
            this.meter=meter;
            this.abbr=abbr;
        }

        @Override
        public double getBaseRatio() {
            return meter;
        }

        @Override
        public String toString() {
            return abbr;
        }

    }

    enum Time implements UnitEnum{
        SECOND(1,"s"),
        MINUTE(60,"min"),
        HOUR(360,"hr")
        ;

        private double sec;
        private String abbr;

        Time(double sec, String abbr){
            this.sec=sec;
            this.abbr=abbr;
        }

        @Override
        public double getBaseRatio() {
            return sec;
        }

        @Override
        public String toString() {
            return abbr;
        }

    }
}
