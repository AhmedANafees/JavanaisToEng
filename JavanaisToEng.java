
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nafea8846
 */
public class JavanaisToEng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL dictionaryFile = new URL("https://github.com/dwyl/english-words/raw/master/words_alpha.txt");
        Scanner textInput = new Scanner(dictionaryFile.openStream());

        ArrayList<String> dictionary = new ArrayList<>();
        while (textInput.hasNext()) {
            String word = textInput.nextLine();
            dictionary.add(word);
        }
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        word = word.toLowerCase();
        String translate = word;
        char letterBef;
        char letterAft;
        int location = translate.indexOf("av");
        while (location > 0) {
            letterBef = translate.charAt(location - 1);
            letterAft = translate.charAt(location + 2);
            location = location-1;
            if (dictionary.contains(translate)) {
                System.out.println(translate);
            } else {
                if ((letterAft == 'a' || letterAft == 'u' || letterAft == 'o' || letterAft == 'i' || letterAft == 'e') && (letterBef != 'a' || letterBef != 'u' || letterBef != 'o' || letterBef != 'i' || letterBef != 'e')) {
                    translate = translate.replaceFirst("av", "");
                    location = translate.indexOf("av");
                }
            }
        }
            System.out.println(translate);
    }

}
