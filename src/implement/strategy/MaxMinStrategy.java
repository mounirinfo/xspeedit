package implement.strategy;

import java.util.ArrayList;
import java.util.List;

import beans.Article;
import beans.Carton;
import beans.InputArticlesChain;
import beans.OutputCartonsChain;
import implement.factory.CartonFactory;
import interfaces.strategy.WrapStrategy;

/**
 *  In this strategy, we take the max and put it in th carton
 *  if we can put it with the min then we add it and remove them both from the list
 *  and iterate on the reminding list
 *  
 * @author Mounir ZAGHBA
 *
 */
public class MaxMinStrategy  implements WrapStrategy{

	@Override
	public OutputCartonsChain generateOutputChain(InputArticlesChain pInputChain) {
		OutputCartonsChain returnChain = new OutputCartonsChain();
		
		if(pInputChain!= null && pInputChain.getArticles()!= null &&!pInputChain.getArticles().isEmpty()){
			List<Article> articles = new ArrayList<Article>();
			articles.addAll(pInputChain.getArticles());
			List<Carton> lc = new ArrayList<Carton>();
			CartonFactory cFact = new CartonFactory();
			Carton curCart = cFact.generateCarton();
			Article currentMaxArticle ;
			Article currentMinArticle = null;
			while(articles != null && articles.size()>0){
				// we take next max and remove it from the list
				currentMaxArticle = getFirstMaxArticle(articles);

				if(currentMaxArticle!= null){
					articles.remove(currentMaxArticle);
				}
				// we take the min and remove it frm the list
				if(currentMinArticle== null){
					currentMinArticle = getFirstMinArticle(articles);
					if(currentMinArticle!= null){
						articles.remove(currentMinArticle);
					}
				}
				// if the current carton can't hold the article, we'll save it
				// and generate an ew carton
				if(curCart.getUsedSize()+currentMaxArticle.getSize()>Carton.MAX_SIZE){
					lc.add(curCart);
					curCart = cFact.generateCarton();
				}
				cFact.addArticleToCarton(currentMaxArticle,curCart);
				
				// if we can put the min in the same carton we put it
				if((currentMinArticle!=null)&&(curCart.getUsedSize()+currentMinArticle.getSize()<=Carton.MAX_SIZE)){
					cFact.addArticleToCarton(currentMinArticle,curCart);
					currentMinArticle=null;
				}
			}
			//add last Carton
			lc.add(curCart);
			returnChain.setCartons(lc);
		}
		return returnChain;
	}

	/**
	 * returns the max article 
	 * if several, returns the first one
	 * 
	 * @param articles
	 * @return
	 * @author Mounir ZAGHBA
	 */
	private Article getFirstMaxArticle(List<Article> articles){
		Article returnValue = null;
		if(articles!= null && articles.size()>0){
			for(Article currentArticle : articles){
				if(returnValue== null || returnValue.getSize()<currentArticle.getSize()){
					returnValue = currentArticle;
				}
			}
		}
		return returnValue;
	}
	
	/**
	 * returns the min article 
	 * if several, returns the first one
	 * 
	 * @param articles
	 * @return
	 * @author Mounir ZAGHBA
	 */
	private Article getFirstMinArticle(List<Article> articles ){
		Article returnValue = null;
		if(articles!= null && articles.size()>0){
			for(Article currentArticle : articles){
				if(returnValue== null || returnValue.getSize()>currentArticle.getSize()){
					returnValue = currentArticle;
				}
			}
		}
		return returnValue;	
	}
}
