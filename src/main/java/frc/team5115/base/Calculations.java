package frc.team5115.base;

public class Calculations {

    private static int id;

    public static int getClosestValue(double currentValue, double[] data) {
        double difference = Math.abs(data[0] - currentValue);
        for(int i = 1; i < data.length; i++) {
            double currentDifference = Math.abs(data[i] - currentValue);
            if(currentDifference < difference) {
                id = i;
                difference = currentDifference;
            }
        }
        return id;
    }
}
