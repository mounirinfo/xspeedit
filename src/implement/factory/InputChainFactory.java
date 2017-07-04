package implement.factory;

import java.util.ArrayList;
import java.util.List;

import beans.Article;
import beans.InputArticlesChain;
import interfaces.factory.AbstractInputChainFactory;

public class InputChainFactory implements AbstractInputChainFactory{

	@Override
	public InputArticlesChain generateInputArticlesChain() {
		InputArticlesChain returnInputChain = new InputArticlesChain();
		List<Article> listOfArticles= new ArrayList<Article>();
		ArticleFactory af = new ArticleFactory();
		// we 'll generate articles according to nb max articles
		for(Integer nbArticles =0; nbArticles < AbstractInputChainFactory.MAX_ARTICLES_INPUT_LENGTH; nbArticles++){
			listOfArticles.add(af.generateRandomArticle());
		}
		returnInputChain.setArticles(listOfArticles);
		return returnInputChain;
	}

}
