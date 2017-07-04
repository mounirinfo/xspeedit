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
 *  and we search the most optimum min number to put it with it
 *  
 *  
 * @author Mounir ZAGHBA
 *
 */
public class OptimalSizeStrategy  implements WrapStrategy{

	@Override
	public OutputCartonsChain generateOutputChain(InputArticlesChain pInputChain) {
		OutputCartonsChain returnChain = new OutputCartonsChain();
		
		if(pInputChain!= null && pInputChain.getArticles()!= null &&!pInputChain.getArticles().isEmpty()){
			List<Article> articles = new ArrayList<Article>();
			articles.addAll(pInputChain.getArticles());
			List<Carton> lc = new ArrayList<Carton>();
			CartonFactory cFact = new CartonFactory();
			Carton curCart = cFact.generateCarton();
			Article currentMaxArticle =  null;
			Article currentMinArticle = null;
			while((articles != null && articles.size()>0)||(currentMinArticle != null)||(currentMaxArticle != null) ){
				// we take next max and remove it from the list
				currentMaxArticle = getFirstMaxArticle(articles);

				if(currentMaxArticle!= null){
					articles.remove(currentMaxArticle);
				}
				// find Nearest optimal min and we d'ont remove it till we're sur that it'll match
				currentMinArticle = getOptimalMinArticle(currentMaxArticle,articles);
				
				if(currentMinArticle!= null){
					articles.remove(currentMinArticle);
				}
				// if the current carton can't hold the article, we'll save it
				// and generate an ew carton
				if((currentMaxArticle!=null)&&(curCart.getUsedSize()+currentMaxArticle.getSize()>Carton.MAX_SIZE)){
					lc.add(curCart);
					curCart = cFact.generateCarton();
					
				}
				cFact.addArticleToCarton(currentMaxArticle,curCart);
				currentMaxArticle=null;
				
				// if we can put the min in the same carton we put it
				if((currentMinArticle!= null) && (curCart.getUsedSize()+currentMinArticle.getSize()<=Carton.MAX_SIZE)){
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
	 * returns the optimal min article
	 * it'll be the greater min article which can be put with the max article in carton
	 * 
	 * @param articles
	 * @return
	 * @author Mounir ZAGHBA
	 */
	private Article getOptimalMinArticle(Article pMaxArticle, List<Article> articles ){
		Article returnValue = null;
		if(articles!= null && articles.size()>0){
			for(Article currentArticle : articles){
				
				// if the sum of the sizes equals the max , we choose current article--> we're in optimal situation
				if(Carton.MAX_SIZE.equals(currentArticle.getSize()+pMaxArticle.getSize())){
					returnValue = currentArticle;
					break;
				}else if((currentArticle.getSize()+pMaxArticle.getSize()<Carton.MAX_SIZE) && (returnValue== null || returnValue.getSize()<currentArticle.getSize())){
					// if it's the first element, or we found more optimal which could be put in the Carton					
					returnValue = currentArticle;
				}
			}
		}
		return returnValue;	
	}
}
