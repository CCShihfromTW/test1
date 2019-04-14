import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

enum key {
    ARROW,
    DISTINCT,
    PLACEHOLDER,
    CSC340,
    CSC220,
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

    public static Multimap<String, Multimap> load() {

        List<String> speeches = new ArrayList<>();

        //-----------------------------------------------

        Multimap<String,String> arrow= ArrayListMultimap.create();
        Multimap<String,String> distinct= ArrayListMultimap.create();
        Multimap<String,String> placeholder= ArrayListMultimap.create();
        Multimap<String,String> csc340= ArrayListMultimap.create();
        Multimap<String,String> csc220= ArrayListMultimap.create();
        Multimap<String,String> book= ArrayListMultimap.create();
        Multimap<String,String> adverb= ArrayListMultimap.create();
        Multimap<String,String> adj= ArrayListMultimap.create();
        Multimap<String,String> inter= ArrayListMultimap.create();
        Multimap<String,String> noun= ArrayListMultimap.create();


        Multimap<String,Multimap> temp=ArrayListMultimap.create();

        //-----------------------------------------------
        for (speech spe : speech.values()) {                     //ENUM speech to List speeches
            speeches.add(spe.toString());
        }

        //-----------------------------------------------------split speech into each speechtype.
        arrow.put(speechtype.valueOf("noun").toString(),speeches.get(0));

        distinct.put(speechtype.valueOf("adjective").toString(),speeches.get(1));
        distinct.put(speechtype.valueOf("adjective").toString(),speeches.get(2));
        distinct.put(speechtype.valueOf("adverb").toString(),speeches.get(3));
        distinct.put(speechtype.valueOf("noun").toString(),speeches.get(4));
        distinct.put(speechtype.valueOf("noun").toString(),speeches.get(5));
        distinct.put(speechtype.valueOf("noun").toString(),speeches.get(6));
        distinct.put(speechtype.valueOf("noun").toString(),speeches.get(7));
        distinct.put(speechtype.valueOf("noun").toString(),speeches.get(8));

        placeholder.put(speechtype.valueOf("adjective").toString(),speeches.get(9));
        placeholder.put(speechtype.valueOf("adjective").toString(),speeches.get(10));
        placeholder.put(speechtype.valueOf("adverb").toString(),speeches.get(11));
        placeholder.put(speechtype.valueOf("conjunction").toString(),speeches.get(12));
        placeholder.put(speechtype.valueOf("interjection").toString(),speeches.get(13));
        placeholder.put(speechtype.valueOf("noun").toString(),speeches.get(14));
        placeholder.put(speechtype.valueOf("noun").toString(),speeches.get(15));
        placeholder.put(speechtype.valueOf("noun").toString(),speeches.get(16));
        placeholder.put(speechtype.valueOf("preposition").toString(),speeches.get(17));
        placeholder.put(speechtype.valueOf("pronoun").toString(),speeches.get(18));
        placeholder.put(speechtype.valueOf("verb").toString(),speeches.get(19));

        csc340.put(speechtype.valueOf("adjective").toString(),speeches.get(20));
        csc340.put(speechtype.valueOf("noun").toString(),speeches.get(21));
        csc340.put(speechtype.valueOf("noun").toString(),speeches.get(22));
        csc340.put(speechtype.valueOf("noun").toString(),speeches.get(23));

        csc220.put(speechtype.valueOf("adjective").toString(),speeches.get(24));
        csc220.put(speechtype.valueOf("verb").toString(),speeches.get(25));

        book.put(speechtype.valueOf("noun").toString(),speeches.get(26));
        book.put(speechtype.valueOf("noun").toString(),speeches.get(27));
        book.put(speechtype.valueOf("verb").toString(),speeches.get(28));
        book.put(speechtype.valueOf("verb").toString(),speeches.get(29));

        adverb.put(speechtype.valueOf("noun").toString(),speeches.get(30));
        adj.put(speechtype.valueOf("noun").toString(),speeches.get(31));
        inter.put(speechtype.valueOf("noun").toString(),speeches.get(32));
        noun.put(speechtype.valueOf("noun").toString(),speeches.get(33));


        temp.put(key.valueOf("ARROW").toString(),arrow);
        temp.put(key.valueOf("DISTINCT").toString(),distinct);
        temp.put(key.valueOf("PLACEHOLDER").toString(),placeholder);
        temp.put(key.valueOf("CSC340").toString(),csc340);
        temp.put(key.valueOf("CSC220").toString(),csc220);
        temp.put(key.valueOf("BOOK").toString(),book);
        temp.put(key.valueOf("ADVERB").toString(),adverb);
        temp.put(key.valueOf("ADJECTIVE").toString(),adj);
        temp.put(key.valueOf("INTERJECTION").toString(),inter);
        temp.put(key.valueOf("NOUN").toString(),noun);


        return temp;

    }
}















