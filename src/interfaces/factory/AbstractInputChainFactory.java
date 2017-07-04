package interfaces.factory;

import beans.InputArticlesChain;

/**
 *  Interface for creating Input Chain Factory
 *  it the max size of Articles in the input chain is specified in the variable MAX_ARTICLES_INPUT_LENGTH
 * @author Mounir ZAGHBA
 *
 */
public interface AbstractInputChainFactory {
	
	Integer MAX_ARTICLES_INPUT_LENGTH=20;

	InputArticlesChain generateInputArticlesChain();
}
