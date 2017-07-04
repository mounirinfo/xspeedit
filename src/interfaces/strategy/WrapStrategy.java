package interfaces.strategy;

import beans.InputArticlesChain;
import beans.OutputCartonsChain;

/**
 *  this interface is to implement strategy pattern
 *  it'sll contain  method wrap which will decid ohw to pack Articles
 * @author Mounir ZAGHBA
 *
 */
public interface WrapStrategy {

	OutputCartonsChain generateOutputChain(InputArticlesChain pInputChain);	
}
