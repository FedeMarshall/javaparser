package com.github.javaparser.metrics.kumo;

import java.awt.Color;

public class HalsteadMetricsBean {

	private String nombreClass;
	private int operatorCount;
	private int operandCount;
	private int uniqueOperatorCount; 
	private int uniqueOperandCount;
	private int vocabulary;
	private int length;
	private double volume;
	private double difficulty;
	private double effort;
	private Color color;
	
	public int getVocabularyNormalized(){
		return vocabulary;
	}
	
	public int getLengthNormalized(){
		return length;
	}
		
	public int getVolumenNormalized(){
		Long value = Math.round((volume * 250) / 8000);
		int frecuency = Integer.valueOf(value.intValue());
		return frecuency;
	}
		
	public double getDifficultyNormalized(){
		return difficulty;
	}
	
	public double getEffortNormalized(){
		return effort;
	}
	
	public String getNombreClass() {
		return nombreClass;
	}

	public void setNombreClass(String nombreClass) {
		this.nombreClass = nombreClass;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
