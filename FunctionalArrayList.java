/**
 * A functional list is a list with a few additional methods that are
 * common in functional languages (such as Lisp, Clojure, or Haskell)
 * to work with lists in a recursive way. 
 *
 * Not all operations on a recursive list will always be
 * successful. For example, a programmer may try to extract the head
 * from an empty list. Since we hace not covered exceptions yet, we
 * need another mechanism to report errors. In order to do that,
 * methods of this list will return a {@see ReturnObject} that will
 * contain either an object or an error value of the right kind (as
 * defined in {@see ErrorMessage}).
 * 
 * @author PiJ
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	private Object[] myFuncArrayList;
	
		public FunctionalArrayList (){
			this.myFuncArrayList = new Object[10];
		}
    /**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head(){
    	if(listArray[0] != null){
    		myFuncArrayList = listArray;
    		ReturnObject returnObj = new ReturnObjectImpl(myFuncArrayList[0], ErrorMessage.NO_ERROR);
			return returnObj;
    	}else {
    		ReturnObject returnObj = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
			return returnObj;
    	}
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalArrayList rest(){
    	FunctionalArrayList returnList = new FunctionalArrayList();
    	if(isEmpty() == false){
    		for(int i = 0; i < size(); i++){
    			returnList.myFuncArrayList[i] = listArray[i+1];
    		}	
    			return returnList;
    	} else {
    		return returnList;
    	}
    }
}
