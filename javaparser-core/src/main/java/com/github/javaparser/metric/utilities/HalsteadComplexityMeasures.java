package com.github.javaparser.metric.utilities;
import java.util.HashMap;
import com.github.javaparser.ast.CompilationUnit;

public class HalsteadComplexityMeasures {
	
	public final CompilationUnit javaProgram;
	public final HashMap<String, Integer> operands = new HashMap<String, Integer>();
	public final HashMap<String, Integer> operators = new HashMap<String, Integer>();
	public final int operatorCount, operandCount, uniqueOperatorCount, uniqueOperandCount;
	
	public HalsteadComplexityMeasures(CompilationUnit program) {
		this.javaProgram = program;
		HashMap<String, Integer> operands = new HashMap<String, Integer>();
		HashMap<String, Integer> operators = new HashMap<String, Integer>();
		program.halteadNumbers(operands, operators);
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
