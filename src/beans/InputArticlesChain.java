package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *  this chain will represent input articles chain
 *  it is a list of articles
 *  
 * @author Mounir ZAGHBA
 *
 */
public class InputArticlesChain {

	List<Article> articles = new ArrayList<Article>();

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	@Override
	public String toString() {
		StringBuilder returnValue = new StringBuilder("");
		if(articles!= null && !articles.isEmpty()){
			for(Article currentArticle:articles){
				returnValue.append(currentArticle.toString());
			}
		}
		return returnValue.toString();
	}
}
