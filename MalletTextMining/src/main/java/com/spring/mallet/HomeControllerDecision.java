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

public class HomeControllerDecision {

	@RequestMapping(value="/decision",method=RequestMethod.GET)
	public String homePage(Model map) throws UnsupportedEncodingException, FileNotFoundException{
		System.out.println("In Decision controller");
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
        //prepare instance transformation pipeline
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

        ClassifierTrainer trainer = new DecisionTreeTrainer();
        Classifier classifier = trainer.train(trainingInstanceList);
        map.addAttribute("training", classifier.getAccuracy(trainingInstanceList));
        map.addAttribute("testing", classifier.getAccuracy(testingInstanceList));
        map.addAttribute("precisiontrain", classifier.getPrecision(trainingInstanceList, 2));
        map.addAttribute("precisiontest", classifier.getPrecision(testingInstanceList, 0));
        map.addAttribute("trainrank", classifier.getAverageRank(trainingInstanceList));
        map.addAttribute("testrank", classifier.getAverageRank(testingInstanceList));
        
        System.out.println("Accuracy while training: " + classifier.getAccuracy(trainingInstanceList));
        System.out.println("Accuracy while testing: " + classifier.getAccuracy(testingInstanceList));
        System.out.println("Training Precision: " + classifier.getPrecision(trainingInstanceList, 2));
        System.out.println("Testing Precision: " + classifier.getPrecision(testingInstanceList, 0));
        System.out.println("Average Rank while training: " + classifier.getAverageRank(trainingInstanceList));
        System.out.println("Average Rank while testing: " + classifier.getAverageRank(testingInstanceList));
       
        return"decisiontree";
	}

}
