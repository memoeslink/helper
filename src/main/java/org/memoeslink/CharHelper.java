package org.memoeslink;

public class CharHelper {
    public static final char NULL_CHAR = '\0';
    public static final char EMPTY_CHAR = '\u0000';
    public static final String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    public static final char[] NON_CLUSTER_CONSONANTS = {'h', 'H', 'j', 'J', 'q', 'Q', 'v', 'V', 'w', 'W', 'x', 'X'};
    public static final String VOWELS = "aeiouAEIOU";
    public static final String ACCENTED_VOWELS = "aàáâãäåāăąǻȁȃạảấầẩẫậắằẳẵặḁæǽeȅȇḕḗḙḛḝẹẻẽếềểễệēĕėęěèéêëiȉȋḭḯỉịĩīĭįiìíîïĳoœøǿȍȏṍṏṑṓọỏốồổỗộớờởỡợōòóŏőôõöuũūŭůűųùúûüȕȗṳṵṷṹṻụủứừửữựyẙỳỵỷỹŷÿýAÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮIÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYY̊ỲỴỶỸŶŸÝ";

    private CharHelper() {
    }

    public static boolean isNull(char c) {
        return c == NULL_CHAR;
    }

    public static char defaultIfNull(char c) {
        if (c == NULL_CHAR)
            return EMPTY_CHAR;
        else return c;
    }

    public static char defaultIfNull(char c, char defaultValue) {
        if (c == NULL_CHAR)
            return defaultIfNull(defaultValue);
        return c;
    }

    public static boolean equalsAny(char c, char... chars) {
        for (char character : chars) {
            if (c == character) return true;
        }
        return false;
    }

    public static boolean isLetter(char c) {
        if (c == NULL_CHAR)
            return false;
        return Character.isLetter(c);
    }

    public static boolean isVowel(char c) {
        if (c == NULL_CHAR)
            return false;
        String s = StringHelper.stripAccents(String.valueOf(c));
        return VOWELS.contains(s);
    }

    public static boolean isUnaccentedVowel(char c) {
        if (c == NULL_CHAR)
            return false;
        return VOWELS.indexOf(c) != -1;
    }

    public static boolean isRegisteredVowel(char c) {
        if (c == NULL_CHAR)
            return false;
        return ACCENTED_VOWELS.indexOf(c) != -1;
    }

    public static boolean isConsonant(char c) {
        if (c == NULL_CHAR)
            return false;
        String s = StringHelper.stripAccents(String.valueOf(c));
        return CONSONANTS.contains(s);
    }

    public static boolean isAccentedConsonant(char c) {
        if (c == NULL_CHAR)
            return false;
        String originalChar = String.valueOf(c);
        String modifiedChar = StringHelper.stripAccents(originalChar);
        return CONSONANTS.contains(modifiedChar) && !originalChar.equals(modifiedChar);
    }

    public static boolean isNonClusterConsonant(char c) {
        if (c == NULL_CHAR)
            return false;

        for (char consonant : NON_CLUSTER_CONSONANTS) {
            if (c == consonant) return true;
        }
        return false;
    }

    public static boolean isSpace(char c) {
        if (c == NULL_CHAR)
            return false;
        return Character.isSpaceChar(c);
    }

    public static char getHexDigit(int value) {
        value = IntegerHelper.defaultByMin(value, 0);
        return Integer.toHexString(value % 16).charAt(0);
    }
}
