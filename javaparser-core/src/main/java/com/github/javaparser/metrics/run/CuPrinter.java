package com.github.javaparser.metrics.run;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.metrics.kumo.ExecuteGeneratorOutputHtmlFile;
import com.github.javaparser.metrics.kumo.HalsteadMetricsBean;
import com.github.javaparser.metrics.utilities.HalsteadComplexityMeasures;


public class CuPrinter {
	
	final static String originPath = "./javaparser-core/src/main/java/com/github/javaparser";

    public static void main(String[] args) throws Exception {
        /*
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
		*/
		executeGenOutputHtmoFile();
    }
    
    public static void executeGenOutputHtmoFile(){
		File d1 = new File(originPath);
		enterDirectorios(d1);
	}

	public static void enterDirectorios(File d1){

		if (d1.isDirectory()){
			// Recorremos recursivamente el directorio
			String[] ficheros = d1.list();
			for (int x=0;x<ficheros.length;x++) {
				enterDirectorios(new File(d1,ficheros[x]));
			}
		}else{
		    // ejecutamos, ya que serán ficheros
			ejecutarJavaParserMetrics(d1);
		}
	}

	public static void ejecutarJavaParserMetrics(File f1){

		try {
			//FileInputStream in = new FileInputStream("Test.java");
			//InputStream in = new FileInputStream(f1);
	        FileInputStream in = new FileInputStream(f1);
	        
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


		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
}