package amazon.pages.utils;

public enum FieldEntries {

	QATESTINGFORBEGINNERS("qa testing for beginners"),
    SOME("Information architecture"), 
    OTHER("Data structures"),
    BOOK("The book of geeks");

    private String value; 
    
    
    
    public String getValue() {
		return value;
	}


	FieldEntries(String value) {
        this.value = value;
    }
    
    
    public String toString() {
        return value;
        
    }
    
}
