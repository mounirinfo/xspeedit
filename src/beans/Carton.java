package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *  Bean representing Carton
 *  
 * @author Mounir ZAGHBA
 *
 */
public class Carton {
	
	public final static Integer MAX_SIZE=10;
	
	// the sum of sizes of articles already in the carton
	private Integer usedSize=0;
	//list of articles already in the carton
	private List<Article> articlesInCarton = new ArrayList<Article>();

	public Integer getUsedSize() {
		return usedSize;
	}

	public void setUsedSize(Integer usedSize) {
		this.usedSize = usedSize;
	}

	public List<Article> getArticlesInCarton() {
		return articlesInCarton;
	}

	public void setArticlesInCarton(List<Article> articlesInCarton) {
		this.articlesInCarton = articlesInCarton;
	}
	
	@Override
	public String toString() {
		StringBuilder returnValue = new StringBuilder("");
		if(articlesInCarton != null && !articlesInCarton.isEmpty()){
			for(Article currentArticle : articlesInCarton){
				returnValue.append(currentArticle.toString());
			}
		}
		return returnValue.toString();
	}
}
