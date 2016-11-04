package com.github.javaparser.metric.utilities;

import java.util.HashMap;
import com.github.javaparser.ast.CompilationUnit;

public class HalsteadComplexityMeasures {
	
	public final CompilationUnit javaProgram;
	public HashMap<String, Integer> operands = new HashMap<String, Integer>();
	public HashMap<String, Integer> operators = new HashMap<String, Integer>();
	public int operatorCount, operandCount, uniqueOperatorCount, uniqueOperandCount;
	
	public HalsteadComplexityMeasures(CompilationUnit program) {
		this.javaProgram = program;
		this.operandCount = 0;
		this.operandCount = 0;
		this.uniqueOperatorCount = 0;
		this.uniqueOperandCount = 0;
	}
	
	public void agregarOperando(String clave){
		if (operands.get(clave) != null){
			operands.put(clave, operands.get(clave) + 1);
		}
		else{
			operands.put(clave, 1);
		}
	}
	
	public void agregarOperador(String clave){
		if (operators.get(clave) != null){
			operators.put(clave, operators.get(clave) + 1);
		}
		else{
			operators.put(clave, 1);
		}
	}
	
	public void calculateUniqueCounts(){
		// Unique counts.
		this.uniqueOperatorCount = operators.size();
		this.uniqueOperandCount = operands.size();
		// Total counts.
		int op = 0;
		for (int c : operators.values()) {
			op += c;
		}
		this.operatorCount = op;
		int od = 0;
		for (int c : operands.values()) {
			od += c;
		}
		this.operandCount = od;
	}
	
	public int vocabulary() {
		return uniqueOperatorCount + uniqueOperandCount;
	}
	
	public int length() {
		return operatorCount + operandCount;
	}
	
	public double volume() {
		return length() * Math.log(vocabulary()) / Math.log(2);
	}
	
	public double difficulty() {
		return uniqueOperatorCount / 2.0 * operandCount / uniqueOperandCount;
	}
	
	public double effort() {
		return difficulty() * volume();
	}

	@Override public String toString() {
		return "HalsteadComplexityMeasures:\n"+
			"\toperatorCount= "+ operatorCount +"\n"+
			"\tuniqueOperatorCount= "+ uniqueOperatorCount +"\n"+
			"\toperandCount= "+ operandCount +"\n"+
			"\tuniqueOperandCount= "+ uniqueOperandCount +"\n"+
			"\tvocabulary= "+ vocabulary() +"\n"+
			"\tlength= "+ length() +"\n"+
			"\tvolume= "+ volume() +"\n"+
			"\tdifficulty= "+ difficulty() +"\n"+
			"\teffort= "+ effort() +"\n";
	}	
}
