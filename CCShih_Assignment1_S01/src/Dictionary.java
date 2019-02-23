// package info here if needed

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author [Cheng Chia Shih]:
 *
 * Feel Free to describe your program here, but don't forget about the write up
 *
 * This page is to load dictionary into data structure.
 *
 */
public class Dictionary {

    // Feel Free to add more methods

    /**
     *
     * Consider starting Here
     *
     */


    public static void init(){
        List<key> keys = new ArrayList<>();
        List<speechtype> speechtypes = new ArrayList<>();
        List<speech> speeches = new ArrayList<>();

        for (speech sp:speech.values()){
            speeches.add(sp);
        }
        for (speechtype spt:speechtype.values()){
            speechtypes.add(spt);
        }
        for (key k:key.values()){
            keys.add(k);
        }

        HashMap<String,LinkedList<LinkedList>> keymap=new HashMap<String,LinkedList<LinkedList>>();
        LinkedList<LinkedList> spt = new LinkedList<LinkedList>();
        LinkedList<String> sp = new LinkedList<String>();


    }

    /**
     * Process dictionary querry data and returns meaningful data
     *
     * @param word
     *            the word to be processed or null
     * @param speechType
     *            The SpeechType to check or null
     * @param distinct
     *            boolean whether or not to remove duplicates
     * @return
     *            an ArrayList of Strings where each entry is properly formatted for output
     *            EX: for a word named "word" ["word [PartOfSpeech1] Definition1", "word [PartOfSpeech2] Definition2"]
     *                for a word not in the Dictionary ["none"]
     *
     *
     */
    public static ArrayList<String> querryDictionary(String word, String speechType, boolean distinct) {

        // add querryDictionary here



        return null;// make sure to return the correct data
    }




}
