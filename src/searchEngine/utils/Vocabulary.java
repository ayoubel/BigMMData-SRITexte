package searchEngine.utils;

import searchEngine.DocumentInfo;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by Louis on 02/10/2017.
 */
public class Vocabulary {

    private Vector<DocumentInfo> collection;
    private Tokenizer token;
    private String[] tokens;
    private HashMap vocabulary;


    Vocabulary(Vector<DocumentInfo> collection) {
        this.collection = collection;
        this.createVocabulary();
    }


    private void createVocabulary() {

        token = new Tokenizer(" ,.<>\"-'/():");
        vocabulary = new HashMap();

        for(DocumentInfo doc : collection) {

            this.tokens = token.tokenize(doc.getContent());

            for(String terme : tokens) {

                if (!vocabulary.containsKey(terme)) {
                    vocabulary.put(terme, 1);
                } else {
                    Integer freq = (Integer) vocabulary.get(terme);
                    vocabulary.put(terme, freq + 1);
                }
            }
        }
    }


    public int getSize() {
        return vocabulary.size();
    }


    public HashMap getVocab() {
        return vocabulary;
    }

}
