package task2;
/*
CMD: java task2.Main
CMD: java task2.Main en EN
CMD: java task2.Main ru RU
 */
public class Main {
    public static void main(String[] args) {

        final String defaultLanguage = "en";
        final String defaultCountry = "EN";

        String language, country;

        if (args.length == 2) {
            language = args[0];
            country = args[1];
        } else {
            language = defaultLanguage;
            country = defaultCountry;
        }

        new Application(language, country);
    }

}
