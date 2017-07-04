package implement.factory;

import java.util.List;

import beans.Article;
import beans.Carton;
import interfaces.factory.AbstractCartonFactory;

public class CartonFactory implements AbstractCartonFactory{

	@Override
	public Carton generateCarton() {
		return new Carton();
	}

	@Override
	public void addArticleToCarton(Article pCurrentArticle, Carton pCart) {
		String ctx = "CartonFactory.addArticleToCarton : ";
		if(pCurrentArticle.getSize() + pCart.getUsedSize() <= Carton.MAX_SIZE){
			List<Article> articles = pCart.getArticlesInCarton();
			articles.add(pCurrentArticle);
			pCart.setArticlesInCarton(articles);
			pCart.setUsedSize(pCart.getUsedSize()+pCurrentArticle.getSize());
		}else{
			throw new RuntimeException(ctx+" could not add article to carton, Article size :  "+pCurrentArticle.getSize()+" used size : "+pCart.getUsedSize());
		}
		
	}

}
