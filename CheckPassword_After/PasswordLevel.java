
public class PasswordLevel {

	public static int INVALID = -1;
	public static int WEAK = 0;
	public static int NORMAL = 1;
	public static int STRONG = 2;
	
	private int _typeCode;

	public PasswordLevel(int typeCode) {
		this._typeCode = typeCode;
	}

	public int getTypeCode() {
		return _typeCode;
	}	

}
