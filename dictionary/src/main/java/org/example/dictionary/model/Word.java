package org.example.dictionary.model;

public class Word {
    private String engWord;
    private String viWord;

    public Word(String engWord, String viWord) {
        this.engWord = engWord;
        this.viWord = viWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public String getViWord() {
        return viWord;
    }

    public void setViWord(String viWord) {
        this.viWord = viWord;
    }
}
