package interfaces.factory;

import beans.Article;

/**
 * Interface for building Article classes
 * it may contain (in the future) some tools for updating Article objects
 * @author Mounir ZAGHBA
 *
 */
public interface AbstractArticleFactory {

	/**
	 *  generate an articole with randome size (between 1 and 9)
	 *  
	 * @return
	 * @author Mounir ZAGHBA
	 */
	Article generateRandomArticle();
}
