package com.github.javaparser.metrics.kumo;

import java.util.HashMap;

public class HalsteadMetricsBean {

	private int operatorCount;
	private int operandCount;
	private int uniqueOperatorCount; 
	private int uniqueOperandCount;
	private int vocabulary;
	private int length;
	private double volume;
	private double difficulty;
	private double effort;
	
	public HashMap<String, Integer> getHalsteadWordFrecuency(){
		HashMap<String, Integer> wordFrecuncy = new HashMap<String, Integer>();
		getLargoWordFrecuency(wordFrecuncy);
		getVolumenWordFrecuency(wordFrecuncy);
		return wordFrecuncy;
	}
		
	private HashMap<String, Integer> getLargoWordFrecuency(HashMap<String, Integer> wordFrecuncy){
	
		if(length <= 100){
			wordFrecuncy.put("Pequeño", 250);
			wordFrecuncy.put("Mediano", 200);
			wordFrecuncy.put("Grande", 100);
			wordFrecuncy.put("Muy Grande",50);
		}else if(length > 100 && length <= 500){
			wordFrecuncy.put("Pequeño", 100);
			wordFrecuncy.put("Mediano", 250);
			wordFrecuncy.put("Grande", 100);
			wordFrecuncy.put("Muy Grande",50);
		}else if(length > 500 && length <= 1500){
			wordFrecuncy.put("Pequeño", 100);
			wordFrecuncy.put("Mediano", 150);
			wordFrecuncy.put("Grande", 250);
			wordFrecuncy.put("Muy Grande",100);
		}else{//length > 1500
			wordFrecuncy.put("Pequeño", 50);
			wordFrecuncy.put("Mediano", 50);
			wordFrecuncy.put("Grande", 100);
			wordFrecuncy.put("Muy Grande",250);
		}
		return wordFrecuncy;
	}
	
	private HashMap<String, Integer> getVolumenWordFrecuency(HashMap<String, Integer> wordFrecuncy){
		Long value = Math.round((volume * 250) / 8000);
		int frecuency = Integer.valueOf(value.intValue());
		wordFrecuncy.put("Volumen", frecuency);
		return wordFrecuncy;
	}
	
	public int getOperatorCount() {
		return operatorCount;
	}
	public void setOperatorCount(int operatorCount) {
		this.operatorCount = operatorCount;
	}
	public int getOperandCount() {
		return operandCount;
	}
	public void setOperandCount(int operandCount) {
		this.operandCount = operandCount;
	}
	public int getUniqueOperatorCount() {
		return uniqueOperatorCount;
	}
	public void setUniqueOperatorCount(int uniqueOperatorCount) {
		this.uniqueOperatorCount = uniqueOperatorCount;
	}
	public int getUniqueOperandCount() {
		return uniqueOperandCount;
	}
	public void setUniqueOperandCount(int uniqueOperandCount) {
		this.uniqueOperandCount = uniqueOperandCount;
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
}
