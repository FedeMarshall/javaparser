package com.github.javaparser.metrics.kumo;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.image.AngleGenerator;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;

public class KumoGeneratorOutputWordCloud {
	
	private static final Random RANDOM = new Random();
		
	public static void kumoGenerateOutputWordCloud(String fileWordCloudToWrite, HalsteadMetricsBean halstedMetrics) throws IOException{
	    final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
	    frequencyAnalyzer.setWordFrequenciesToReturn(600);
	    frequencyAnalyzer.setMinWordLength(5);
	    		
	    final Dimension dimension = new Dimension(600, 600);
	    final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
	    wordCloud.setPadding(1);
	    wordCloud.setBackground(new CircleBackground(300));
	    wordCloud.setBackgroundColor(Color.WHITE);
	    wordCloud.setColorPalette(buildRandomColorPalette(2));
	    
	    InputStream inp = new FileInputStream("kumo/font/OpenSansEmoji.ttf");
	    wordCloud.setKumoFont(new KumoFont(inp));
	    
	    wordCloud.setFontScalar(new LinearFontScalar(8, 130));
	    
	    wordCloud.build(buildWordFrequenciesByHashMap(halstedMetrics.getHalsteadWordFrecuency()));
	    
	    wordCloud.writeToFile(fileWordCloudToWrite);
	}
	
	public static void kumoGenerateOutputWordCloud(String fileWordCloudToWrite, ArrayList<HalsteadMetricsBean> halstedMetricsList) throws IOException{
	    final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
	    frequencyAnalyzer.setWordFrequenciesToReturn(600);
	    frequencyAnalyzer.setMinWordLength(5);
	    		
	    final Dimension dimension = new Dimension(600, 600);
	    final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
	    wordCloud.setPadding(1);
	    wordCloud.setBackground(new CircleBackground(300));
	    wordCloud.setBackgroundColor(Color.WHITE);
	    wordCloud.setColorPalette(buildRandomColorPalette(2));
	    wordCloud.setAngleGenerator(new AngleGenerator(0));
	    
	    InputStream inp = new FileInputStream("kumo/font/OpenSansEmoji.ttf");
	    wordCloud.setKumoFont(new KumoFont(inp));
	    
	    wordCloud.setFontScalar(new LinearFontScalar(8, 130));
	    
	    
	    //wordCloud.build(buildWordFrequenciesByHashMap(halstedMetrics.getHalsteadWordFrecuency()));
	    wordCloud.build(buildWordFrequenciesByHashMap(halstedMetricsList));
	    
	    wordCloud.writeToFile(fileWordCloudToWrite);
	}

    private static ColorPalette buildRandomColorPalette(int n) {
        final Color[] colors = new Color[n];
        for(int i = 0; i < colors.length; i++) {
            colors[i] = new Color(RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25, RANDOM.nextInt(230) + 25);
        }
        return new ColorPalette(colors);
    }
    
    private static List<WordFrequency> buildWordFrequencies() {
        final List<WordFrequency> wordFrequencies = new ArrayList<>();
        for (final String emoji : EMOJIS) {
            wordFrequencies.add(new WordFrequency(emoji, RANDOM.nextInt(250)));
        }
        return wordFrequencies;
    }
    
    private static List<WordFrequency> buildWordFrequenciesByHashMap(HashMap<String, Integer> wordFrecuencies){
    	final List<WordFrequency> wordFrequencies = new ArrayList<>();
    	for (String key : wordFrecuencies.keySet()) {
    		wordFrequencies.add(new WordFrequency(key, wordFrecuencies.get(key)));
    	}
    	return wordFrequencies;
    }
    
    private static List<WordFrequency> buildWordFrequenciesByHashMap(ArrayList<HalsteadMetricsBean> halstedList){
    	final List<WordFrequency> wordFrequencies = new ArrayList<>();
    	for (HalsteadMetricsBean halsteadMetricsBean : halstedList) {
    		HashMap<String, Integer> wordFrecuencies = halsteadMetricsBean.getVolumenHalsteadWordFrecuency();
    		
        	for (String key : wordFrecuencies.keySet()) {
        		wordFrequencies.add(new WordFrequency(key, wordFrecuencies.get(key)));
        		
        	}
		}
    
    	return wordFrequencies;
    }
    
    
    private static final String[] EMOJIS = {
            "Vocabulario",
            "Longitud",
            	"Pequeño",
            	"Mediano",
            	"Grande",
            	"Muy grande",
            "Volumen",
            	"demasiadas cosas",
            "Nivel",
            	"- errores",
            "Dificultad",
            	"+ errores",
            "Esfuerzo",
            	"+ Comprender :)",
            	"- Comprender :(",
            "Tiempo",
            "Contenido",
            /*
            "\uD83D\uDE02",
            "\uD83D\uDC4D",
            "\uD83D\uDE0A",
            "\uD83D\uDE01",
            "\uD83D\uDE12",
            "\uD83D\uDE11",
			"\uD83D\uDE0D",
            "\uD83D\uDC4C",
            "\uD83D\uDE2D",		
			"\uD83D\uDE29",
            "\uD83D\uDE21",
     		"\uD83D\uDE21",
     		"\uD83D\uDE32",
     		"\uD83D\uDE31",
            "\uD83D\uDE0F",
            */
    };
}
