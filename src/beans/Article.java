package beans;

/**
 * This bean will represent an article to pack
 *  
 * @author Mounir ZAGHBA
 *
 */
public class Article {
	private Integer size;

	/**
	 *  We set default constructor to private 
	 *  soo we avoid Articles without size
	 *  
	 */
	@SuppressWarnings("unused")
	private Article(){
		// not need to be implemented
	}
	/**
	 *  Constructor with the size as parameter
	 *  
	 * @param pSize
	 */
	public Article(Integer pSize){
		setSize(pSize);
	}
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer pSize) {
		if(pSize >=1 && pSize<=9){
			this.size = pSize;
		}else{
			throw new IllegalArgumentException(" The size of Article must be an integer between 1 and 9 . "); 
		}
	}
	
	@Override
	public String toString() {
		String returnValue = "";
		if(size!= null){
			returnValue = size.toString();
		}
		return returnValue;
	}

}
