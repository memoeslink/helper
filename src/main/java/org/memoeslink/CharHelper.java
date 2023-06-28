package org.memoeslink;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CharHelper {
    public static final char NULL_CHAR = '\0';
    public static final char EMPTY_CHAR = '\u0000';
    public static final String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    public static final char[] NON_CLUSTER_CONSONANTS = {'h', 'H', 'j', 'J', 'q', 'Q', 'v', 'V', 'w', 'W', 'x', 'X'};
    public static final String VOWELS = "aeiouAEIOU";
    public static final String ACCENTED_VOWELS = "aàáâãäåāăąǻȁȃạảấầẩẫậắằẳẵặḁæǽeȅȇḕḗḙḛḝẹẻẽếềểễệēĕėęěèéêëiȉȋḭḯỉịĩīĭįiìíîïĳoœøǿȍȏṍṏṑṓọỏốồổỗộớờởỡợōòóŏőôõöuũūŭůűųùúûüȕȗṳṵṷṹṻụủứừửữựyẙỳỵỷỹŷÿýAÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮIÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYY̊ỲỴỶỸŶŸÝ";

    public static boolean isNull(char c) {
        return c == NULL_CHAR;
    }

    public static char defaultIfNull(char c) {
        if (c == NULL_CHAR)
            return Character.SPACE_SEPARATOR;
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

    public static boolean isPrintable(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return (!Character.isISOControl(c)) &&
                block != null &&
                block != Character.UnicodeBlock.SPECIALS;
    }

    public static boolean isCharDisplayableInFont(char c) {
        if (c == NULL_CHAR || Character.isWhitespace(c))
            return false;
        Graphics g = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).getGraphics();
        Font font = new Font(g.getFont().toString(), Font.PLAIN, 5);
        g.dispose();
        return font.canDisplay(c);
    }

    public static boolean isGlyphDisplayable(char c) {
        return isPrintable(c) && isCharDisplayableInFont(c);
    }

    public static char getFirstDisplayableGlyph(char... chars) {
        for (char c : chars) {
            if (isGlyphDisplayable(c))
                return c;
        }
        return '\0';
    }

    public static String getUnicode(char c) {
        if (c == NULL_CHAR)
            return StringHelper.EMPTY;
        return String.format("\\u%04x", (int) c);
    }

    public static char getHexDigit(int value) {
        value = IntegerHelper.defaultByMin(value, 0);
        return Integer.toHexString(value % 16).charAt(0);
    }
}
