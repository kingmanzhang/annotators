package org.sifrproject.scoring.cvalue;


import java.util.Comparator;

public class CValueTerm {
    private String term;
    private int wordNumber;
    private int frequency;

    private double cvalue;

    public CValueTerm(final String term) {
        this.term = term;
        this.frequency = 1;
        this.wordNumber = term.split(" ").length;
    }

    public boolean contains(final CValueTerm subTerm){
        final String word = subTerm.getTerm();
        return term.contains(" "+word+" ") ||  term.startsWith(word+" ") || term.endsWith(" "+word);
    }

    // getter and setter
    // -----------------
    public String getTerm() {
        return term;
    }
    public int getWordNumber() {
        return wordNumber;
    }
    public int getFrequency() {
        return frequency;
    }
    public void incFrequency(){
        this.frequency++;
    }

    public double getCValue() {
        return cvalue;
    }
    public void setCValue(final double cvalue) {
        this.cvalue = cvalue;
    }


    // Comparators
    // -----------
    public static final Comparator<CValueTerm> wordNumberComparator = new Comparator<CValueTerm>() {
        @Override
        public int compare(final CValueTerm o1, final CValueTerm o2) {
            if (o2.getWordNumber() > o1.getWordNumber()) return 1;
            else if (o2.getWordNumber() < o1.getWordNumber()) return -1;
            else if (o2.getTerm().compareTo(o1.getTerm()) < 0) return 1;
            else if (o2.getTerm().compareTo(o1.getTerm()) > 0) return -1;
            else return 0;
        }
    };

    public static final Comparator<CValueTerm> importanceComparator = new Comparator<CValueTerm>() {
        @Override
        public int compare(final CValueTerm o1, final CValueTerm o2) {
            if (o2.getCValue() > o1.getCValue()) return 1;
            else if (o2.getCValue() < o1.getCValue()) return -1;
            else {
                return 1 - o2.getTerm().compareTo(o1.getTerm());
            }
        }
    };


    // for printing
    // ------------
    @Override
    public String toString()
    {
        return "\nTerm:      " + getTerm() + "\n"
                + "Frequency: " + getFrequency() + "\n"
                + "Num_words: " + getWordNumber();
    }

}
