package hackerrank.string;

import org.apache.commons.lang3.ArrayUtils;

public class TestRMA {

    public static final String USER_ID_SEP ="\\\\";


    public static void main(String[] args) throws Exception {
        System.out.println(sanitizeLoginId("domain!loginId"));
    }


     public static String sanitizeLoginId(String loginId) throws Exception {
        if (loginId == null) {
            throw new Exception("Login Id is NULL");
        }
        loginId = loginId.replace("!", "\\");
        String[] loginIDArgs = splitString(loginId,USER_ID_SEP);
        if (loginIDArgs.length != 2) {
            System.out.println("Invalid login ID ");
            throw new Exception("Invalid login ID [%s]");
        }
        return loginId;
    }

    public static String[] splitString(String str, String delim) {
        if (isEmpty(str)) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return str.split(delim);
    }

    public static boolean isEmpty(String s) {
        if (s == null || "".equals(s.trim()))
            return true;
        else return false;
    }
}
