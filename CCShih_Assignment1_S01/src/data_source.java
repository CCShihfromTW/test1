import com.google.common.collect.HashBasedTable;

import java.util.*;
import java.util.stream.Collectors;

enum key {
    ARROW,
    DISTINCT,
    PLACEHOLDER,
    CSC340,
    CSC210,
    BOOK,
    ADVERB,
    ADJECTIVE,
    INTERJECTION,
    NOUN;
}

enum speechtype {
    noun, adjective, adverb, conjunction, interjection, preposition, pronoun, verb;
}

enum speech {
    ARROW("Here is one arrow: <IMG> -=>> </IMG>"), //0

    DISTINCT01("Familiar. Worker in Java."), //1~8
    DISTINCT02("Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT03("Uniquely. Written \"distinctly\"."),
    DISTINCT04("A keyword is this assignment."),
    DISTINCT05("A keyword is this assignment."),
    DISTINCT06("A keyword is this assignment."),
    DISTINCT07("An advanced search option."),
    DISTINCT08("Distinct is a parameter in this addignment."),

    Placeholder01("To be updated..."),
    Placeholder02("To be updated..."),
    Placeholder03("To be updated..."),
    Placeholder04("To be updated..."),
    Placeholder05("To be updated..."),
    Placeholder06("To be updated..."),
    Placeholder07("To be updated..."),
    Placeholder08("To be updated..."),
    Placeholder09("To be updated..."),
    Placeholder10("To be updated..."),
    Placeholder11("To be updated..."),

    CSC340_01("C++ version of CSC210 + CSC220 + more."),
    CSC340_02("A CS upper division course"),
    CSC340_03("Many hours outside of class."),
    CSC340_04("Programming Methodology"),

    CSC210_01("Ready to create complex data structure."),
    CSC220_02("To create data structures."),

    Book_01("A set of pages."),
    Book_02("A written work published in printed or electronic form."),
    Book_03("To arrange for someone to have a seat on a plane."),
    Book_04("To arrange something on a particular date."),

    ADVERB("Adverb is a word that adds more information about place, time, manner, cause or degree to a verb, an adjective, a pharse or another adverb."),

    ADJECTIVE("Adjective is a word that describes a person or thing, for example big,red and clever in a big house, red wine and a clever idea"),

    INTERJECTION("Interjection is a short sound , word or phrase spoken suddenly to express an emotion. Oh!, Look out! and Ow! are interjections"),

    NOUN("Noun is a word that refers to a person, (such as Ann or doctor), a place(such as Paris or city) or a thing, a quality or an activity( such as plant, sorrow or tennis.)");
    private String string;

    speech(String s) {
        this.string = s;
    }

    @Override
    public String toString() {
        return string;
    }
};


public class data_source {
    public static void main(String[] args) {
        List<String> keys = new ArrayList<>();
        List<String> speechtypes = new ArrayList<>();
        List<String> speeches = new ArrayList<>();
        //-----------------------------------------------
        List<String> nounspt = new ArrayList<>();
        List<String> adjspt = new ArrayList<>();
        List<String> advspt = new ArrayList<>();
        List<String> conspt = new ArrayList<>();
        List<String> interspt = new ArrayList<>();
        List<String> prespt = new ArrayList<>();
        List<String> prospt = new ArrayList<>();
        List<String> verbspt = new ArrayList<>();
        //-----------------------------------------------

        Map<String, List> keymap = new HashMap<>();         //<List keys , List type>
        HashMap<String, List> speechmap = new HashMap<>();       //<List key,List speech>
        //-----------------------------------------------
        for (speech spe : speech.values()) {                     //ENUM speech to List speeches
            speeches.add(spe.toString());
        }
        for (key k : key.values()) {                             //ENUM key to List keys
            keys.add(k.toString());
        }
        for (speechtype spts : speechtype.values()) {            //ENUM speechtype to List speechtypes
            speechtypes.add(spts.toString());
        }

        //-----------------------------------------------------split speech into each speechtype.
        for (int i = 0; i < speeches.size(); i++) {
            if (i == 1 || i == 2 || i == 9 || i == 10 || i == 20 || i == 24 || i == 3 || i == 11 || i == 12 || i == 15 || i == 17 || i == 18 || i == 19 || i == 25 || i == 28 || i == 29) {
                continue;
            } else {
                nounspt.add(speeches.get(i));
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 1 || i == 2 || i == 9 || i == 10 || i == 20 || i == 24) {
                adjspt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 3 || i == 11) {
                advspt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 12) {
                conspt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 15) {
                interspt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 17) {
                prespt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 18) {
                prospt.add(speeches.get(i));
            } else {
                continue;
            }
        }

        for (int i = 0; i < speeches.size(); i++) {
            if (i == 19 || i == 25 || i == 28 || i == 29) {
                verbspt.add(speeches.get(i));
            } else {
                continue;
            }
        }
        //---------------------------------------------------------below is HashMap <keyword, type>
        List<List<String>> keytype = new ArrayList<List<String>>();
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            switch (i) {
                case 0: {                               //ADJECTIVE
                    keymap.put(keys.get(i), nounspt);
                    break;
                }
                case 1: {                              //ADVERB
                    keymap.put(keys.get(i), nounspt);
                    break;
                }
                case 2: {                                  //ARROW
                    keymap.put(keys.get(i), nounspt);
                    break;
                }
                case 3: {                               //BOOK
                    keytype.add(nounspt);
                    keytype.add(verbspt);
                    keymap.put(keys.get(i), keytype);
                    continue;
                }
                case 4: {                                //CSC220
                    keytype.add(verbspt);
                    keytype.add(adjspt);
                    keymap.put(keys.get(i), keytype);
                    continue;
                }
                case 5: {                                //, CSC340,
                    keytype.add(nounspt);
                    keytype.add(adjspt);
                    keymap.put(keys.get(i), keytype);
                    continue;
                }
                case 6: {                                  //DISTINCT
                    keytype.add(nounspt);
                    keytype.add(adjspt);
                    keytype.add(advspt);
                    keymap.put(keys.get(i), keytype);
                    continue;
                }
                case 7: {                              //,INTER ,
                    keymap.put(keys.get(i), nounspt);
                    break;
                }
                case 8: {                            // NOUN
                    keymap.put(keys.get(i), nounspt);
                    break;
                }
                case 9: {                                  //PLACEHOLDER
                    keytype.add(nounspt);
                    keytype.add(adjspt);
                    keytype.add(advspt);
                    keytype.add(conspt);
                    keytype.add(interspt);
                    keytype.add(prospt);
                    keytype.add(prespt);
                    keytype.add(verbspt);
                    keymap.put(keys.get(i), keytype);
                    continue;
                }
            }

            keytype.clear();
        }






        //---------------------------------------------------------  below is HashMap <keyword ,speech>
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0: {
                    speechmap.put(keys.get(i), speeches.subList(31, 32));//ADJECTIVE
                    break;
                }
                case 1: {
                    speechmap.put(keys.get(i), speeches.subList(30, 31));//ADVERB
                    break;
                }
                case 2: {
                    speechmap.put(keys.get(i), speeches.subList(0, 1)); //ARROW
                    break;
                }
                case 3: {
                    speechmap.put(keys.get(i), speeches.subList(26, 30));//BOOK
                    break;
                }
                case 4: {
                    speechmap.put(keys.get(i), speeches.subList(24, 26));//CSC220
                    break;
                }
                case 5: {
                    speechmap.put(keys.get(i), speeches.subList(20, 24));//CSC340
                    break;
                }
                case 6: {
                    speechmap.put(keys.get(i), speeches.subList(1, 9));//DISTINCT
                    break;
                }
                case 7: {
                    speechmap.put(keys.get(i), speeches.subList(32, 33));//INTERJECTION
                    break;
                }
                case 8: {
                    speechmap.put(keys.get(i), speeches.subList(33, 34));//NOUN
                    break;
                }
                case 9: {
                    speechmap.put(keys.get(i), speeches.subList(9, 20));//PLACEHOLDER
                    break;
                }
            }

        }

        //---------------------------------------------------------交叉比對 <keyword ,speech> and <key,type>
        //--------temp<keyword,type,speech>
        System.out.println(keymap.get("ADVERB").size());
        HashBasedTable<String, String, String> temp = HashBasedTable.create();

        for (String key : keymap.keySet()) {
            int index_sp = 0;
            while (speechmap.get(key).listIterator(index_sp).hasNext()) {
                int index_key = 0;
                while (keymap.get(key).listIterator(index_key).nextIndex()<keymap.get(key).size()) {
                    String speech;
                    String keyspeech;
                    speech = speechmap.get(key).listIterator(index_sp).next().toString();
                    keyspeech = keymap.get(key).listIterator(index_key).next().toString();
                    if(keymap.get(key).listIterator(index_key).next() instanceof ArrayList){
                        keyspeech =keymap.values().stream().flatMap(Collection::stream).collect(Collectors.toList()).listIterator(index_key).next().toString();
                    }
                    if ( keyspeech.equals(speech)&& verbspt.contains(speech)) {
                        temp.put(key, "verb", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && adjspt.contains(speech)) {
                        temp.put(key, "adjective", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && advspt.contains(speech)) {
                        temp.put(key, "adverb", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && conspt.contains(speech)) {
                        temp.put(key, "conjunction", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && interspt.contains(speech)) {
                        temp.put(key, "interjection", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && prespt.contains(speech)) {
                        temp.put(key, "prepostition", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && prospt.contains(speech)) {
                        temp.put(key, "pronoun", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    } else if (keyspeech.equals(speech) && nounspt.contains(speech)) {
                        temp.put(key, "noun", speechmap.get(key).listIterator(index_sp).next().toString());
                        index_key++;
                        continue;
                    }
                    index_key++;
                }
                index_sp++;
            }

        }


        //-------------------------------------------------------------------

        for (String rowkey : temp.rowKeySet()) {

            for (String column : temp.row(rowkey).keySet()) {
                //System.out.println(temp);

            }
        }


    }
}








