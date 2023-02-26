import java.util.ArrayList;
import java.util.Vector;

public class Compression {

    public static ArrayList<Tag> tags = new ArrayList<Tag>();//to save all tags in it

    public static void Compress(String TextToCompress) {

        String temp = "";

        char[] TextInChar = TextToCompress.toCharArray();
        Vector<String> CustomDictionary = new Vector();
        CustomDictionary.add(null);

        System.out.println("Tags are : ");

        for (int i = 0; i < TextToCompress.length() ; i++) {
            temp += String.valueOf(TextInChar[i]);

            if (!CustomDictionary.contains(temp)) {
                CustomDictionary.add(temp);
                String prev = temp.substring(0, temp.length() - 1);
                int idx = CustomDictionary.indexOf(prev);
                if (idx == -1) {
                    idx += 1;
                }

                System.out.println("< " + idx + " , " + temp.charAt(temp.length() - 1) + " >");

                //in every iteration -->create tag and add it in Array tags
                Tag tag = new Tag();
                tag.setIndex(idx);
                tag.setchar(temp.charAt(temp.length() - 1));
                tags.add(tag);

                temp = "";
            }
        }
        char lastChar = TextInChar[(TextInChar.length) - 1];
        int indexOfLastChar = 0;
        System.out.println("< " + indexOfLastChar + " , " + lastChar + " >");
        Tag tag = new Tag();
        tag.setIndex(indexOfLastChar);
        tag.setchar(lastChar);
        tags.add(tag);


        System.out.println("CustomDictionary is  : ");
        for (int index = 0; index < CustomDictionary.size(); index++) {
            System.out.println(index + " " + CustomDictionary.get(index));
        }
    }
}