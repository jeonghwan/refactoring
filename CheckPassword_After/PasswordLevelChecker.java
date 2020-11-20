public class PasswordLevelChecker {
	
	private PasswordLevel _passwordLevel;

	public PasswordLevelChecker(int typeCode) {
		this.setTypeCode(typeCode);
	}

	public int getTypeCode() {
		return _passwordLevel.getTypeCode();
	}

	public void setTypeCode(int typeCode) {
		this._passwordLevel = new PasswordLevel(typeCode);
	}

	/*
	 * 검사할 규칙 세 가지:
	 * - 1. 암호의 길이가 8 글자 이상
	 * - 2. 0~9 사이의 숫자를 포함
	 * - 3. 대문자 포함
	 * - 위 세 가지 규칙을 충족하면 암호는 강함(STRONG)
	 * - 두 가지 규칙을 충족하면 암호는 보통(NORMAL)
	 * - 1개 이하의 규칙을 충족하면 암호는 약함(WEAK)
	 */
    public int meter(String s) {

        if (s == null || s.isEmpty()) 
        	return PasswordLevel.INVALID;
        
        if (getMetCounts(s) <= 1) 
        	return PasswordLevel.WEAK;
        
        if (getMetCounts(s) == 2) 
        	return PasswordLevel.NORMAL;

        return PasswordLevel.STRONG;
    }

    private int getMetCounts(String s) {
    	int metCounts = 0;
    	if (s.length() >= 8) 
        	metCounts++;
        
        if (meetsContainingNumeric(s)) 
    	    metCounts++;
        
        if (meetsContainingUppercase(s)) 
        	metCounts++;

        return metCounts;
    }
    
    private boolean meetsContainingNumeric(String s) {
    	for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
    	return false;
    }
    
    private boolean meetsContainingUppercase(String s) {
    	for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
    	return false;
    }
}
