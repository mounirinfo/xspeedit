package pkgmain;

import beans.InputArticlesChain;
import beans.OutputCartonsChain;
import implement.factory.InputChainFactory;
import implement.strategy.*;
import interfaces.factory.AbstractInputChainFactory;
import interfaces.strategy.WrapStrategy;
import service.Robot;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Hello, welcome in my awsome application ");
		System.out.println("We'll generate random input chain ");
		AbstractInputChainFactory aIfact = new InputChainFactory();
		
		InputArticlesChain inputArticles = aIfact.generateInputArticlesChain();
		
		System.out.println(" Input Chain is :"+inputArticles);
		Robot mainRobot = new Robot();
		//1- default strategy
		WrapStrategy currentStrategy = new DefaultStrategy();
		mainRobot.setStategy(currentStrategy);
		OutputCartonsChain oCC1= mainRobot.generateOutputChain(inputArticles);
		System.out.println("1- The output chain is with Default "+oCC1 +" number of used cartons : "+oCC1.getCartons().size());
		
		//2- sort Asc strategy
		WrapStrategy sortAsc = new SortAscendingBeforeDefault();
		mainRobot.setStategy(sortAsc);
		OutputCartonsChain oCC2= mainRobot.generateOutputChain(inputArticles);
		System.out.println("2- The output chain is with Sort ascending "+oCC2 +" number of used cartons : "+oCC2.getCartons().size());
		
		//3- sort Desc strategy
		WrapStrategy sortDesc = new SortDescendingBeforeDefault();
		mainRobot.setStategy(sortDesc);
		OutputCartonsChain oCC3= mainRobot.generateOutputChain(inputArticles);
		System.out.println("3- The output chain is with Sort descending "+oCC3 +" number of used cartons : "+oCC3.getCartons().size());
		
		//4- sort Min Max
		WrapStrategy sortMinMax = new MaxMinStrategy();
		mainRobot.setStategy(sortMinMax);
		OutputCartonsChain oCC4= mainRobot.generateOutputChain(inputArticles);
		System.out.println("4- The output chain is with Sort Min Max "+oCC4 +" number of used cartons : "+oCC4.getCartons().size());
		
		//5- Optimal strategy
		WrapStrategy optimal = new OptimalSizeStrategy();
		mainRobot.setStategy(optimal);
		OutputCartonsChain oCC5= mainRobot.generateOutputChain(inputArticles);
		System.out.println("5- The output chain is with Optimal Sort "+oCC5 +" number of used cartons : "+oCC5.getCartons().size());
	}
}
