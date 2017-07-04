package service;

import beans.InputArticlesChain;
import beans.OutputCartonsChain;
import interfaces.strategy.WrapStrategy;

public class Robot {
	
	private WrapStrategy stategy;

	public OutputCartonsChain generateOutputChain(InputArticlesChain pInputChain){
		return getStategy().generateOutputChain(pInputChain);
	}

	public WrapStrategy getStategy() {
		return stategy;
	}

	public void setStategy(WrapStrategy stategy) {
		this.stategy = stategy;
	}
	
}
