package implement.factory;

import java.util.Random;

import beans.Article;
import interfaces.factory.AbstractArticleFactory;

public class ArticleFactory implements AbstractArticleFactory{

	@Override
	public Article generateRandomArticle() {
		Random myRand = new Random();
		int randSize = myRand.ints(1,10).findFirst().getAsInt();
		Article myArticle = new Article(randSize);
		return myArticle;
	}

}
