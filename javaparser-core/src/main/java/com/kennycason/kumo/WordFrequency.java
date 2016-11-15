package com.kennycason.kumo;

/**
 * Created by kenny on 6/29/14.
 */
public class WordFrequency implements Comparable<WordFrequency> {

    private final String word;

    private final int frequency;
    
	private int vocabulary;
	private int length;
	private double volume;
	private double difficulty;
	private double effort;
	
    public WordFrequency(final String word, final int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    
    public WordFrequency(final String word, final int frequency, int voc, int len, double vol, double diff, double eff) {
        this.word = word;
        this.frequency = frequency;
        this.vocabulary = voc;
        this.length = len;
        this.volume = vol;
        this.difficulty = diff;
        this.effort = eff;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(final WordFrequency wordFrequency) {
        return wordFrequency.frequency - frequency;
    }
    
	public int getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(int vocabulary) {
		this.vocabulary = vocabulary;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public double getEffort() {
		return effort;
	}

	public void setEffort(double effort) {
		this.effort = effort;
	}

	@Override
    public String toString() {
        return "WordFrequency [word=" + word + ", frequency=" + frequency + "]";
    }
}
