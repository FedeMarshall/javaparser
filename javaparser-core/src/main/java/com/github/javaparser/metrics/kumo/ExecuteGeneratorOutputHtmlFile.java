package com.github.javaparser.metrics.kumo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExecuteGeneratorOutputHtmlFile {

	final static String originPath = "kumo/entradaHtml/";
	final static String destinoPath = "salidaHtml/";
	final static String originWordCloud = "kumo/SalidaWordCloud/HalsteadWordCloud.png";
		
	public static void execute(ArrayList<HalsteadMetricsBean> halsteadMetric){
		try {
			KumoGeneratorOutputWordCloud.kumoGenerateOutputWordCloud("kumo/SalidaWordCloud/HalsteadWordCloud.png", halsteadMetric);
			executeGenOutputHtmoFile();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void executeGenOutputHtmoFile(){
		File d1 = new File(originPath);

		long yourmilliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyyHH-mm-ss");
		Date resultdate = new Date(yourmilliseconds);
		String folderPath = sdf.format(resultdate);

		File d2 = new File(destinoPath + "/" + folderPath);

		copiarDirectorios(d1, d2);

		File wordCloud1 = new File(originWordCloud);
		File wordCloudOutPut = new File(destinoPath + "/" + folderPath + "/assets/img/HalsteadWordCloud.png");
		copiarWordCloud(wordCloud1, wordCloudOutPut);
		
		abrirArchivo(destinoPath + "/" + folderPath + "/" + "index.html");
	}

	public static void copiarDirectorios(File d1, File d2){

		if (d1.isDirectory()){
			// Recorremos recursivamente el directorio
			if (!d2.exists()){
				d2.mkdir();
				System.out.println("Creando directorio " + d2.toString());
			}

			String[] ficheros = d1.list();
			for (int x=0;x<ficheros.length;x++) {
			  copiarDirectorios(new File(d1,ficheros[x]),new File(d2,ficheros[x]));
			}
		}else{
		    // Copiamos d1 a d2, ya que serán ficheros
			copiarFicheros(d1, d2);
		}
	}

	public static void copiarFicheros(File f1, File f2){

		try {
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

	public static void copiarWordCloud(File f1, File f2){
		copiarFicheros(f1, f2);
	}
	
	public static void abrirArchivo(String archivo){
        File objetofile = new File (archivo);
        boolean paso = false;
        try {
        	Desktop.getDesktop().open(objetofile);
        	paso = true;
		} catch (IOException ex) {
			//No hacemos nada.
		}
        
        if(!paso){
        	try {
        		Desktop.getDesktop().browse(objetofile.toURI());
			} catch (IOException ex) {
				//No hacemos nada.
			}
        }
	} 
}