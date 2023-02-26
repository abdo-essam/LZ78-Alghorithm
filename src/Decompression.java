import java.util.ArrayList;

public class Decompression {

    ArrayList<String> Dictionary = new ArrayList<String>();
    String phrase;

    int index;
    char x;

    public void decompress(ArrayList<Tag> tags) {
        Tag tag;
        Dictionary.add(null);
        phrase = null;

        for (int j = 0; j < tags.size(); j++) {
            tag = tags.get(j);
            index = tag.getIndex();
            x = tag.getchar();


            if (index == 0) {
                //that's means this is the frost time the symbol appears
                //add symbol in dictionary
                Dictionary.add(String.valueOf(x));
                //put symbol in the output phrase.
                phrase = phrase + x;

            } else {
                //this means this symbol founded in dictionary
                String intry;//string to save in it the intry of dictionary at index i.
                //get intry at index i
                intry = Dictionary.get(index);
                //add the intry + the symbol at the end of dictionary
                Dictionary.add(intry + x);
                //build the phrase
                phrase = phrase + (intry + x);
            }
        }
        System.out.println(phrase);

    }
}