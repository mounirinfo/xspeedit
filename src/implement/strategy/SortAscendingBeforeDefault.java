package implement.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import beans.Article;
import beans.Carton;
import beans.InputArticlesChain;
import beans.OutputCartonsChain;
import implement.factory.CartonFactory;
import interfaces.strategy.WrapStrategy;

/**
 *  The same as the default strategy 
 *  but we sort the list of input articles before treating them
 *  this method is sometimes more optimal than default but not every time
 *  
 * @author Mounir ZAGHBA
 *
 */
public class SortAscendingBeforeDefault implements WrapStrategy{

	@Override
	public OutputCartonsChain generateOutputChain(InputArticlesChain pInputChain) {
		OutputCartonsChain returnChain = new OutputCartonsChain();
		
		if(pInputChain!= null && pInputChain.getArticles()!= null &&!pInputChain.getArticles().isEmpty()){
			List<Article> articles = new ArrayList<Article>();
			articles.addAll(pInputChain.getArticles());
			// sorting articles using lambda expression
			Collections.sort(articles,new Comparator<Article>(){
				public int compare(Article a1, Article a2){
					return a1.getSize()-a2.getSize();
				}
			});
			List<Carton> lc = new ArrayList<Carton>();
			CartonFactory cFact = new CartonFactory();
			Carton curCart = cFact.generateCarton();
			// we'll read all articles
			for(Article currentArticle : articles){
				// if the current carton can't hold the article, we'll save it
				// and generate an ew carton
				if(curCart.getUsedSize()+currentArticle.getSize()>Carton.MAX_SIZE){
					lc.add(curCart);
					curCart = cFact.generateCarton();
				}
				cFact.addArticleToCarton(currentArticle,curCart);
			}
			//add last Carton
			lc.add(curCart);
			returnChain.setCartons(lc);
		}
		return returnChain;
	}

}
