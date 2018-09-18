import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {

        String[] words = urlToString("http://erdani.com/tdpl/hamlet.txt").split("\\s+");

        System.out.println(words.length);

        String[] wordsOccurrences = urlToString("http://erdani.com/tdpl/hamlet.txt").split("prince");
        System.out.println(wordsOccurrences.length);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;

        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }

        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}