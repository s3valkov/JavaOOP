package P05_Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;
    private static final String PHONE_REGEX = "^[0-9]+$";
    private static final String URL_REGEX = "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (url.matches(URL_REGEX)){
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (number.matches(PHONE_REGEX)){
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
