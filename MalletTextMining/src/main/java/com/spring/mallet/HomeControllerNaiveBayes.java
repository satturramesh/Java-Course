package com.spring.mallet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cc.mallet.classify.Classifier;
import cc.mallet.classify.ClassifierTrainer;
import cc.mallet.classify.NaiveBayes;
import cc.mallet.classify.NaiveBayesEMTrainer;
import cc.mallet.classify.NaiveBayesTrainer;
import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.FeatureSequence2FeatureVector;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.PrintInputAndTarget;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.TokenSequenceLowercase;
import cc.mallet.pipe.TokenSequenceRemoveStopwords;
import cc.mallet.pipe.iterator.CsvIterator;
import cc.mallet.types.InstanceList;

@Controller

public class HomeControllerNaiveBayes {

	@RequestMapping(value="/naive",method=RequestMethod.GET)
	public String homePage(Model map) throws UnsupportedEncodingException, FileNotFoundException{
		System.out.println("In Naive controller");
		String filePath = "D:/URL.txt";
		/*JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("choosertitle");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }*/
		//String filePath = "D:/news.txt";
		//String filestopword ="C:/mallet/stoplists/en.txt";
        //prepare instance transformation pipeline
		
		
		/*
		  Pipe instancePipe = new SerialPipes (new Pipe[] {
			new Target2Label (),							  // Target String -> class label
			new Input2CharSequence (),				  // Data File -> String containing contents
			//new CharSubsequence (CharSubsequence.SKIP_HEADER), // Remove UseNet or email header
			new CharSequence2TokenSequence (Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")),  // Data String -> TokenSequence
			new TokenSequenceLowercase (),		  // TokenSequence words lowercased
			new TokenSequenceRemoveStopwords (new File("C:/mallet/stoplists/en.txt"), "UTF-8", false, false, false),// Remove stopwords from sequence
			new TokenSequence2FeatureSequence(),// Replace each Token with a feature index
			new FeatureSequence2FeatureVector(),// Collapse word order into a "feature vector"
			new PrintInputAndTarget(),
		});
		  */
        ArrayList<Pipe> pipes = new ArrayList<Pipe>();
        pipes.add(new Target2Label());
        pipes.add(new CharSequence2TokenSequence(Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
        pipes.add(new TokenSequenceLowercase());
       // pipes.add(new TokenSequenceRemoveStopwords (new File(filestopword), "UTF-8", false, false, false));
        pipes.add(new TokenSequence2FeatureSequence());
        pipes.add(new FeatureSequence2FeatureVector());
        SerialPipes pipe = new SerialPipes(pipes);

        Reader fileReader = new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8");
        //prepare training instances
      InstanceList trainingInstanceList = new InstanceList(pipe);
        trainingInstanceList.addThruPipe(new CsvIterator (fileReader, Pattern.compile("^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$"), 3, 2, 1));
        //prepare test instances
        InstanceList testingInstanceList = new InstanceList(pipe);        
        testingInstanceList.addThruPipe(new CsvIterator(new FileReader(filePath), "^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$", 2, 1, -1));
       /*
        Reader reader = new InputStreamReader(input);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		 InputStream input = classLoader.getResourceAsStream("application.properties");*/

        
        ClassifierTrainer trainer = new NaiveBayesTrainer();
        Classifier classifier = trainer.train(trainingInstanceList);
        ClassifierTrainer trainer1 = new NaiveBayesEMTrainer();
        Classifier classifier1 = trainer1.train(testingInstanceList);
        
       //NaiveBayesTrainer 
        map.addAttribute("training", classifier.getAccuracy(trainingInstanceList));
        map.addAttribute("testing", classifier.getAccuracy(testingInstanceList));
        map.addAttribute("precisiontrain", classifier.getPrecision(trainingInstanceList, 6));
        map.addAttribute("precisiontest", classifier.getPrecision(testingInstanceList, 5));
        map.addAttribute("trainrank", classifier.getAverageRank(trainingInstanceList));
        map.addAttribute("testrank", classifier.getAverageRank(testingInstanceList));
        map.addAttribute("recall", classifier.getRecall(trainingInstanceList, 1));
        
        //NaiveBayesTrainer
        System.out.println("Accuracy while training: " + classifier.getAccuracy(trainingInstanceList));
        System.out.println("Accuracy while testing: " + classifier.getAccuracy(testingInstanceList));
        System.out.println("Precision while training: " + classifier.getPrecision(trainingInstanceList, 6));
        System.out.println("Precision while testing: " + classifier.getPrecision(testingInstanceList,  5));
        System.out.println("Average Rank while training: " + classifier.getAverageRank(trainingInstanceList));
        System.out.println("Average Rank while testing: " + classifier.getAverageRank(testingInstanceList));
        System.out.println("Recall: " + classifier.getRecall(trainingInstanceList, 0));
        System.out.println("F1: "+ classifier.getF1(testingInstanceList, 6));
        
        //NaiveBayesEMTrainer
        System.out.println("Accuracy while training: " + classifier1.getAccuracy(testingInstanceList));
        
		return"naivebayes";
	}
}
