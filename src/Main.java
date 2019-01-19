import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String text;
        HashMap<Character, List<String>> parsedWords = new HashMap<>();

        text = readText();
        parsedWords = parseText(text);
        printMap(parsedWords);
    }

    public static String readText(){
        String text;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            text = reader.readLine();
            return text;
        }

        catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static HashMap<Character, List<String>> parseText(String text) {
        HashMap<Character, List<String>> parsedWords = new HashMap<>();
        //split input text by words and remove punctuation using regexp
        String[] resultArray = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        //convert the array to Arraylist
        List<String> resultList = new ArrayList<>(Arrays.asList(resultArray));


        //Populte the HashMap with all the available keys
        for (int i = 0; i < resultList.size(); i++) {
            if (!parsedWords.containsKey(resultList.get(i).charAt(0))) {
                parsedWords.put(resultList.get(i).charAt(0), new ArrayList<>()); }
        }
        //fill in the values for keys (characters)
        for (int i = 0; i < resultList.size(); i++) {
            //check if such word already exist, if no - add value to the HashMap
            if (!parsedWords.get(resultList.get(i).charAt(0)).contains(resultList.get(i))){
                parsedWords.get(resultList.get(i).charAt(0)).add(resultList.get(i));
            }
        }
        return parsedWords;
    }

    public static void printMap(HashMap<Character, List<String>> map){
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey().toString().toUpperCase() + ": " + entry.getValue().toString());
        }


    }
}
