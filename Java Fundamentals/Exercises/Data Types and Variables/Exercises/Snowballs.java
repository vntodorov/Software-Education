package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte snowballs = Byte.parseByte(scanner.nextLine());
        double maxSnowballValue = Double.MIN_VALUE;
        short maxSnowballSnow = 0;
        short maxSnowballTime = 0;
        byte maxSnowballQuality = 0;
        for (int i = 1; i <= snowballs; i++) {
            short snowballSnow = Short.parseShort(scanner.nextLine());
            short snowballTime = Short.parseShort(scanner.nextLine());
            byte snowballQuality = Byte.parseByte(scanner.nextLine());
            double snowballValue = Math.pow((double) snowballSnow / snowballTime, snowballQuality);
            if (snowballValue > maxSnowballValue) {
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
                maxSnowballValue = snowballValue;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
