public class PasswordLevelChecker {
	
	public static int INVALID = -1;
	public static int WEAK = 0;
	public static int NORMAL = 1;
	public static int STRONG = 2;
	
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
        	return INVALID;
        
        int metCounts = 0;
        if (s.length() >= 8) 
        	metCounts++;
        
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                metCounts++;
                break;
            }
        }
        
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                metCounts++;
                break;
            }
        }
        
        if (metCounts <= 1) 
        	return WEAK;
        if (metCounts == 2) 
        	return NORMAL;

        return STRONG;
    }

}
