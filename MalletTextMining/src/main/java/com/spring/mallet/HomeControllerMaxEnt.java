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

import cc.mallet.pipe.*;
import cc.mallet.pipe.iterator.CsvIterator;
import cc.mallet.types.InstanceList;
import cc.mallet.classify.*;

@Controller

public class HomeControllerMaxEnt {

	@RequestMapping(value="/maxent",method=RequestMethod.GET)
	public String homePage(Model map) throws UnsupportedEncodingException, FileNotFoundException{
		System.out.println("In Max controller");
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
		 
		String filePath = "D:/URL.txt";


		ArrayList<Pipe> pipes = new ArrayList<Pipe>();
        pipes.add(new Target2Label());
        pipes.add(new CharSequence2TokenSequence(Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
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

		// Create a classifier trainer, and use it to create a classifier
		
		
		 ClassifierTrainer trainer = new MaxEntTrainer();
		Classifier classifier = trainer.train(trainingInstanceList);
        map.addAttribute("training", classifier.getAccuracy(trainingInstanceList));
        map.addAttribute("testing", classifier.getAccuracy(testingInstanceList));
        map.addAttribute("precisiontrain", classifier.getPrecision(trainingInstanceList, 6));
        map.addAttribute("precisiontest", classifier.getPrecision(testingInstanceList, 6));
        map.addAttribute("trainrank", classifier.getAverageRank(trainingInstanceList));
        map.addAttribute("testrank", classifier.getAverageRank(testingInstanceList));
        
        System.out.println ("The training accuracy is "+ classifier.getAccuracy (trainingInstanceList));
		System.out.println ("The testing accuracy is "+ classifier.getAccuracy (testingInstanceList));
		System.out.println ("Precision while training "+ classifier.getPrecision(trainingInstanceList, 6));
		System.out.println ("Precision while testing "+ classifier.getPrecision(testingInstanceList, 6));
		System.out.println ("Average Rank while training "+ classifier.getAverageRank(trainingInstanceList));
		System.out.println ("Average Rank while testing "+ classifier.getAverageRank(testingInstanceList));
		
		
        return"maxent";
	}

}
