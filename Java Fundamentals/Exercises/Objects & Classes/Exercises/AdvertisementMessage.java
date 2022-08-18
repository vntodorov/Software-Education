package ObjectsAndClassesEXERCISE;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[] phrasesArray = new String[6];
        phrasesArray[0] = "Excellent product.";
        phrasesArray[1] = "Such a great product.";
        phrasesArray[2] = "I always use that product.";
        phrasesArray[3] = "Best product of its category.";
        phrasesArray[4] = "Exceptional product.";
        phrasesArray[5] = "I can’t live without this product.";
        String[] eventsArray = new String[6];
        eventsArray[0] = "Now I feel good.";
        eventsArray[1] = "I have succeeded with this product.";
        eventsArray[2] = "Makes miracles. I am happy of the results!";
        eventsArray[3] = "I cannot believe but now I feel awesome.";
        eventsArray[4] = "Try it yourself, I am very satisfied.";
        eventsArray[5] = "I feel great!";
        String[] authorsArray = new String[8];
        authorsArray[0] = "Diana";
        authorsArray[1] = "Petya";
        authorsArray[2] = "Stella";
        authorsArray[3] = "Elena";
        authorsArray[4] = "Katya";
        authorsArray[5] = "Iva";
        authorsArray[6] = "Annie";
        authorsArray[7] = "Eva";
        String[] citiesArray = new String[5];
        citiesArray[0] = "Burgas";
        citiesArray[1] = "Sofia";
        citiesArray[2] = "Plovdiv";
        citiesArray[3] = "Varna";
        citiesArray[4] = "Ruse";
        for (int i = 1; i <= 3 ; i++) {
            Random rndPhrase = new Random();
            int rndIndexPhrase = rndPhrase.nextInt(phrasesArray.length);
            String currentPhrase = phrasesArray[rndIndexPhrase];
            Random rndEvent = new Random();
            int rndIndexEvent = rndEvent.nextInt(eventsArray.length);
            String currentEvent = eventsArray[rndIndexEvent];
            Random rndAuthor = new Random();
            int rndIndexAuthor = rndAuthor.nextInt(authorsArray.length);
            String currentAuthor = authorsArray[rndIndexAuthor];
            Random rndCity = new Random();
            int rndIndexCity = rndCity.nextInt(citiesArray.length);
            String currentCity = citiesArray[rndIndexCity];
            System.out.printf("%s %s %s - %s.%n", currentPhrase, currentEvent, currentAuthor, currentCity);
        }
    }
}
