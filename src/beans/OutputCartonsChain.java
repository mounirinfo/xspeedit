package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *  this chain will represent output cartons chain
 *  it is a list of Cartons
 *  
 * @author Mounir ZAGHBA
 *
 */
public class OutputCartonsChain {
	private final String INIT_OUTPUT_CHAIN = "";
	private final String CARTON_SEPARATOR = "/";

	private List<Carton> cartons= new ArrayList<Carton>();

	public List<Carton> getCartons() {
		return cartons;
	}

	public void setCartons(List<Carton> cartons) {
		this.cartons = cartons;
	}
	
	@Override
	public String toString() {
		StringBuilder returnValue = new StringBuilder(INIT_OUTPUT_CHAIN);
		if(cartons!= null && !cartons.isEmpty()){
			Boolean firstElement = Boolean.TRUE;
			for(Carton currentCarton:cartons){
				if(!firstElement){
					returnValue.append(CARTON_SEPARATOR);
				}else{
					firstElement=Boolean.FALSE;
				}
				returnValue.append(currentCarton.toString());
			}
		}
		return returnValue.toString();
	}
}
