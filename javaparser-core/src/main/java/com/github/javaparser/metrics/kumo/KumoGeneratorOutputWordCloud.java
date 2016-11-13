package com.github.javaparser.metrics.kumo;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
			
	public static void kumoGenerateOutputWordCloud(String fileWordCloudToWrite, ArrayList<HalsteadMetricsBean> halstedMetricsList) throws IOException{
	    final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
	    frequencyAnalyzer.setWordFrequenciesToReturn(600);
	    frequencyAnalyzer.setMinWordLength(5);
	    		
	    final Dimension dimension = new Dimension(600, 600);
	    final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
	    wordCloud.setPadding(1);
	    wordCloud.setBackground(new CircleBackground(300));
	    wordCloud.setBackgroundColor(Color.WHITE);
	    //wordCloud.setColorPalette(buildRandomColorPalette(250));
	    wordCloud.setColorPalette(buildBlackColorPalette(2));
	    wordCloud.setAngleGenerator(new AngleGenerator(0));
	    InputStream inp = new FileInputStream("kumo/font/OpenSansEmoji.ttf");
	    wordCloud.setKumoFont(new KumoFont(inp));
	    wordCloud.setFontScalar(new LinearFontScalar(10, 75));
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
    
    private static ColorPalette buildBlackColorPalette(int n) {
        final Color[] colors = new Color[n];
        for(int i = 0; i < colors.length; i++) {
            colors[i] = new Color(0x00000);
        }
        return new ColorPalette(colors);
    }
            
    private static List<WordFrequency> buildWordFrequenciesByHashMap(ArrayList<HalsteadMetricsBean> halstedList){
    	final List<WordFrequency> wordFrequencies = new ArrayList<>();
    	for (HalsteadMetricsBean halsteadMetricsBean : halstedList) {
        	wordFrequencies.add(new WordFrequency(halsteadMetricsBean.getNombreClass(), 
        						halsteadMetricsBean.getVolumenNormalized(),//Es la Frecuencia en realidad = Volumen.
        						halsteadMetricsBean.getVocabularyNormalized(),
        						halsteadMetricsBean.getLengthNormalized(),
        						halsteadMetricsBean.getVolumenNormalized(),
        						halsteadMetricsBean.getDifficultyNormalized(),
        						halsteadMetricsBean.getEffortNormalized()));      	
		}
    	return wordFrequencies;
    }
}
