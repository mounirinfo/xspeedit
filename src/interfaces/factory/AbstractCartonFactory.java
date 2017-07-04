package interfaces.factory;

import beans.Article;
import beans.Carton;

/**
 * Interface for building Carton classes
 * it may contain (in the future) some tools for updating Carton objects
 * @author Mounir ZAGHBA
 *
 */
public interface AbstractCartonFactory {

	/**
	 * generate an empty Carton (with size=0, and empty article list)
	 * 
	 * @return
	 * @author Mounir ZAGHBA
	 */
	Carton generateCarton();
	
	
	/**
	 * adds the article to carton
	 * and updates carton used size
	 * 
	 * @param currentArticle
	 * @param newCart
	 * @author Mounir ZAGHBA
	 */
	void addArticleToCarton(Article currentArticle, Carton newCart) ;
}
