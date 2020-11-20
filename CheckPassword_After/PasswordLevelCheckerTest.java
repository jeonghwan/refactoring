import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PasswordLevelCheckerTest {

    private PasswordLevelChecker meter;

    private void assertLevel(String password, int expected) {
        assertEquals(expected, meter.meter(password));
    }

    @Before
    public void setup() {
    	meter = new PasswordLevelChecker(PasswordLevel.INVALID);
    }
    
    // 모든 조건을 만족하는 경우
    @Test
    public void meetsAllCriteria_Then_Strong() {
        assertLevel("ab12!@AB", PasswordLevel.STRONG);
        assertLevel("abc1!Add", PasswordLevel.STRONG);
    }

    // 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
    @Test
    public void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertLevel("ab12!@A", PasswordLevel.NORMAL);
        assertLevel("Ab12!c", PasswordLevel.NORMAL);
    }

    // 숫자는 모함하지 않고 나머지 조건은 충족하는 경우
    @Test
    public void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertLevel("ab!@ABqwer", PasswordLevel.NORMAL);
    }

    // 값이 없는 경우
    @Test
    public void nullInput_Then_Invalid() {
        assertLevel(null, PasswordLevel.INVALID);
    }

    // 입력이 빈 문자열인 경우
    @Test
    public void emptyInput_Then_Invalid() {
        assertLevel("", PasswordLevel.INVALID);
    }

    // 대문자를 포함하지 않고 나머지 조건을 충족하는 경우 
    @Test
    public void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertLevel("ab12!@df", PasswordLevel.NORMAL);
    }

    // 길이가 8글자 이상인 경우만 충족하는 경우
    @Test
    public void meetsOnlyLengthCriteria_Then_Weak() {
        assertLevel("abdefghi", PasswordLevel.WEAK);
    }

    // 숫자 포함 조건만 충족하는 경우
    @Test
    public void meetsOnlyNumCriteria_Then_Weak() {
        assertLevel("12345", PasswordLevel.WEAK);
    }

    // 대문자 포함 조건만 충족하는 경우 
    @Test
    public void meetsOnlyUpperCriteria_Then_Weak() {
        assertLevel("ABZEF", PasswordLevel.WEAK);
    }

    // 아무 조건도 충족하지 않는 경우
    @Test
    public void meetsNoCriteria_Then_Weak() {
        assertLevel("abc", PasswordLevel.WEAK);
    }

}
