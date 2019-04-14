import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// package info here if needed


/**
 * @author [Cheng Chia Shih]:
 * <p>
 * Feel Free to describe your program here, but don't forget about the write up.
 * <p>
 * First of all, I'm very sad that I'm not satisfy with my program.
 * This program could only print out only one output. I　had convert the enum object into ArraryList,
 * then I merge all three elements into two hashmap. The key are same as the word, in order to collate each other.
 * However, I found that my loop for merging the speechtype and speech is overwriting the hashmap storage into null.
 * In other to avoid that situation. I had to use switch case and many List into hashmap.
 * I think I could make a progress on this Assignment if I had found a better way to solve this problem.
 * For the efficiency and avoiding hard coding, I tried my best to keep the code dynamically,
 * but for the case to merge the relationship between (key,type,speech) I did only what's necessary.
 * last, I'm sad that I doesn't know how to link to the tester without init() so I create my own.
 * Hopefully, that doesn't affact me score.
 *
 * <p>
 * This page is to load dictionary into data structure.
 */

public class Dictionary {

    // Feel Free to add more methods

    /**
     * Consider starting Here
     */
    private static boolean distinct = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> arrarylist = new ArrayList<>();

        int i = 0;
        System.out.println("! Loadng data...");

        Multimap<String, Multimap> ds = ArrayListMultimap.create(data_source.load());
        String type = "";
        System.out.println("! Loading completed...");
        System.out.println("   |");
        System.out.print("Search: ");
        while (input.hasNext()) {
            String row = "";
            String keyword = input.nextLine();
            if (keyword.equals("!Q")) {
                break;
            }
            System.out.println("   |");
            String[] entries = keyword.split(" ", -1);
            for (String word : entries) {
                if (ds.keySet().contains(word.toUpperCase()) || ds.get(word.toUpperCase()).parallelStream().iterator().next().keySet().contains(word.toLowerCase())) {                                     //check key is correct
                    if (ds.keySet().contains(word.toUpperCase()) && row.isEmpty()) {
                        type = ds.get(word.toUpperCase()).parallelStream().iterator().next().keySet().toString();
                        row = word;
                    } else if (ds.get(word.toUpperCase()).parallelStream().iterator().next().keySet().contains(word.toLowerCase())) { //check distinct or type
                        if (ds.get(word.toUpperCase()).parallelStream().iterator().next().keySet().contains(word.toLowerCase())) {
                            arrarylist.add(word.toString());
                            continue;
                        } else if (word.equals("distinct")) {
                            distinct = true;
                            continue;
                        } else {
                            continue;
                        }
                    } else if (word.equals("distinct")) {
                        distinct = true;
                        continue;
                    } else if (!(word.equals("distinct") && ds.get(word.toUpperCase()).parallelStream().iterator().next().keySet().contains(word.toLowerCase()))) {
                        //arrarylist
                    } else {
                        System.out.println("<2nd arugment must be a part of speech or \"distinct\">");
                        break;
                    }
                } else {
                    System.out.println("<Not found>");
                    break;
                }
            }
            querryDictionary(row.toUpperCase(), arrarylist.toString(), distinct);
            System.out.println("   |");
            System.out.print("Search: ");
        }
        System.out.println("----End----");
    }

    public static void init() {
    }


    /**
     * Process dictionary querry data and returns meaningful data
     *
     * @param word       the word to be processed or null
     * @param speechType The SpeechType to check or null
     * @param distinct   boolean whether or not to remove duplicates
     * @return an ArrayList of Strings where each entry is properly formatted for output
     * EX: for a word named "word" ["word [PartOfSpeech1] Definition1", "word [PartOfSpeech2] Definition2"]
     * for a word not in the Dictionary ["none"]
     */

    public static HashBasedTable<String, String, String> querryDictionary(String word, String speechType, boolean distinct) {

        // add querryDictionary here
        Multimap<String, Multimap> match_Data = ArrayListMultimap.create(data_source.load());
        HashBasedTable<String, String, String> dist = HashBasedTable.create();
        speechType = speechType.replace(",", " ").replace("[", "").replace("]", "");
        String[] s = speechType.split(" ");

        for (String key : match_Data.keySet()) {
            for (Object type : match_Data.get(key).iterator().next().keySet()) {
                for (Object speech : match_Data.get(key).iterator().next().get(type)) {
                    dist.put(key, type.toString(), speech.toString());
                }
            }
        }

        if (distinct) {
            if (speechType.isEmpty()) {//loop speech
                for (Object type : dist.row(word).keySet()) {
                    System.out.println(word + " [" + type + "] : " + dist.get(word, type));
                }

            } else {//loop tpye
                for (Object type : dist.row(word).keySet()) {
                    if (type.toString().equals(speechType)) {
                        System.out.println(word + " [" + type + "] : " + dist.get(word, type));
                    }
                }


            }
        } else if (!speechType.isEmpty()) {
            for (Object type : match_Data.get(word).iterator().next().keySet()) {
                for (Object speech : match_Data.get(word).iterator().next().get(type)) {
                    if (type.toString().equals(speechType)) {
                        System.out.println(word + " [" + type + "] : " + speech.toString());
                    }
                }
            }
        } else {
            for (Object type : match_Data.get(word).iterator().next().keySet()) {
                for (Object speech : match_Data.get(word).iterator().next().get(type)) {
                    System.out.println(word + " [" + type + "] : " + speech.toString());
                }
            }
        }


        return null;// make sure to return the correct data
    }
}



