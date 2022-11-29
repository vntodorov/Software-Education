package InterfacesAndAbstractionEXERCISES.Тelephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;

    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls){
        this.numbers = numbers;
        this.urls = urls;
    }



    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls){
            if (isURLValid(url)){
                sb.append("Browsing: ").append(url).append("!");
            } else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers){
            if (isNumberValid(number)){
                sb.append("Calling... ").append(number);
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static boolean isNumberValid(String number) {
        for (char symbol : number.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isURLValid(String url) {
        for (char symbol : url.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
}
