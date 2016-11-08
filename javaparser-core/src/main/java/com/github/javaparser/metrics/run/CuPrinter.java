package com.github.javaparser.metrics.run;
import java.io.FileInputStream;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.metrics.kumo.ExecuteGeneratorOutputHtmlFile;
import com.github.javaparser.metrics.kumo.HalsteadMetricsBean;
import com.github.javaparser.metrics.utilities.HalsteadComplexityMeasures;


public class CuPrinter {

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("Test.java");

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
        
        HalsteadComplexityMeasures halsteadMeasures = new HalsteadComplexityMeasures(cu);
        // llamamamos al metodo de Node para ejecutar haltstead metrics
        halsteadMeasures.javaProgram.halsteadNumbers(halsteadMeasures);
        halsteadMeasures.calculateUniqueCounts();
        System.out.println(halsteadMeasures.vocabulary());
        System.out.println(halsteadMeasures.length());
        System.out.println(halsteadMeasures.volume());
        System.out.println(halsteadMeasures.difficulty());
        System.out.println(halsteadMeasures.effort());
        System.out.println(halsteadMeasures);
        
        System.out.println("Creando Word Cloud!!!");
        
		HalsteadMetricsBean halsteadMetric = new HalsteadMetricsBean();
		halsteadMetric.setOperatorCount(halsteadMeasures.operatorCount);
		halsteadMetric.setOperandCount(halsteadMeasures.operandCount);
		halsteadMetric.setUniqueOperatorCount(halsteadMeasures.uniqueOperatorCount);
		halsteadMetric.setUniqueOperandCount(halsteadMeasures.uniqueOperandCount);
		halsteadMetric.setVocabulary(halsteadMeasures.vocabulary());
		halsteadMetric.setLength(halsteadMeasures.length());
		halsteadMetric.setVolume(halsteadMeasures.volume());
		halsteadMetric.setDifficulty(halsteadMeasures.difficulty());
		halsteadMetric.setEffort(halsteadMeasures.effort());
		
		ExecuteGeneratorOutputHtmlFile.execute(halsteadMetric);        
    }
}