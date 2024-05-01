package org.memoeslink;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CharHelper {
    public static final char NULL_CHAR = '\0'; //\u0000
    public static final String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
    public static final String GLOBAL_CONSONANTS = "bcdfghjklmnpqrstvwxyzçðñþłŋšžBCDFGHJKLMNPQRSTVWXYZÇÐÑÞŁŊŠŽ";
    public static final String NON_CLUSTER_CONSONANTS = "hjqvwxçðñþłŋšžHJQVWXÇÐÑÞŁŊŠŽ";
    public static final String VOWELS = "aeiouAEIOU";
    public static final String GLOBAL_VOWELS = "aàáâãäåāăąǻȁȃạảấầẩẫậắằẳẵặḁæǽeȅȇḕḗḙḛḝẹẻẽếềểễệēĕėęěèéêëiȉȋḭḯỉịĩīĭįiìíîïĳoœøǿȍȏṍṏṑṓọỏốồổỗộớờởỡợōòóŏőôõöuũūŭůűųùúûüȕȗṳṵṷṹṻụủứừửữựyẙỳỵỷỹŷÿýAÀÁÂÃÄÅĀĂĄǺȀȂẠẢẤẦẨẪẬẮẰẲẴẶḀÆǼEȄȆḔḖḘḚḜẸẺẼẾỀỂỄỆĒĔĖĘĚÈÉÊËIȈȊḬḮỈỊĨĪĬĮIÌÍÎÏĲOŒØǾȌȎṌṎṐṒỌỎỐỒỔỖỘỚỜỞỠỢŌÒÓŎŐÔÕÖUŨŪŬŮŰŲÙÚÛÜȔȖṲṴṶṸṺỤỦỨỪỬỮỰYY̊ỲỴỶỸŶŸÝ";
    public static final String GLOBAL_LETTERS = GLOBAL_CONSONANTS + GLOBAL_VOWELS;
    private static final Set<Integer> GLOBAL_VOWELS_REGISTRY;
    private static final Set<Integer> GLOBAL_CONSONANTS_REGISTRY;
    private static final Set<Integer> GLOBAL_LETTERS_REGISTRY;
    private static final int[] ZERO_WIDTH_CHARS = {0x200B, 0x200C, 0x200D, 0x2060, 0xFEFF};

    static {
        GLOBAL_VOWELS_REGISTRY = GLOBAL_VOWELS.chars().boxed().collect(Collectors.toSet());
        GLOBAL_CONSONANTS_REGISTRY = GLOBAL_CONSONANTS.chars().boxed().collect(Collectors.toSet());
        GLOBAL_LETTERS_REGISTRY = GLOBAL_LETTERS.chars().boxed().collect(Collectors.toSet());
    }

    private CharHelper() {
    }

    /**
     * Overloaded method that returns a specified default character if the given character is
     * the null character ({@code '\0'}), otherwise returns the character itself.
     *
     * @param c            the character to check.
     * @param defaultValue the default value to return if {@code c} is the null character.
     * @return the specified default character if {@code c} is the null character ({@code '\0'}), otherwise {@code c}
     */
    public static char defaultIfNull(char c, char defaultValue) {
        if (isNull(c)) return defaultValue;
        return c;
    }

    /**
     * Checks if the given character matches any in the specified array of characters.
     *
     * @param c     the character to check
     * @param chars the array of characters to match against.
     * @return {@code true} if {@code c} matches any of the provided characters, otherwise {@code false}
     */
    public static boolean equalsAny(char c, char... chars) {
        for (char character : chars) {
            if (c == character) return true;
        }
        return false;
    }

    /**
     * Checks if the given character is the null character ({@code '\0'}).
     *
     * @param c the character to check
     * @return {@code true} if the character is the null character ({@code '\0'}), otherwise {@code false}
     */
    public static boolean isNull(char c) {
        return isNull((int) c);
    }

    /**
     * Checks if the given character is the null character ({@code '\0'}).
     *
     * @param c the character to check
     * @return {@code true} if the character is the null character ({@code '\0'}), otherwise {@code false}
     */
    public static boolean isNull(int c) {
        return c == (int) NULL_CHAR;
    }

    /**
     * Checks if the given character is a space.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a space, otherwise {@code false}
     */
    public static boolean isSpace(char c) {
        return isSpace((int) c);
    }

    /**
     * Checks if the given character is a space.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a space, otherwise {@code false}
     */
    public static boolean isSpace(int c) {
        return Character.isSpaceChar(c);
    }

    /**
     * Checks if the given character is whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is whitespace, otherwise {@code false}
     */
    public static boolean isWhitespace(char c) {
        return isWhitespace((int) c);
    }

    /**
     * Checks if the given character is whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is whitespace, otherwise {@code false}
     */
    public static boolean isWhitespace(int c) {
        return Character.isWhitespace(c);
    }

    /**
     * Checks if the given character is a zero-width character.
     * <p>
     * This method verifies the presence of several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a zero-width character, otherwise {@code false}
     */
    public static boolean isZeroWidthChar(char c) {
        return isZeroWidthChar((int) c);
    }

    /**
     * Checks if the given character is a zero-width character.
     * <p>
     * This method verifies the presence of several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a zero-width character, otherwise {@code false}
     */
    public static boolean isZeroWidthChar(int c) {
        return Arrays.binarySearch(ZERO_WIDTH_CHARS, c) >= 0;
    }

    /**
     * Checks if the given character is a letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter, otherwise {@code false}
     */
    public static boolean isLetter(char c) {
        return isLetter((int) c);
    }

    /**
     * Checks if the given character is a letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter, otherwise {@code false}
     */
    public static boolean isLetter(int c) {
        return Character.isLetter(c);
    }

    /**
     * Checks if the given character is a lowercase letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a lowercase letter, otherwise {@code false}
     */
    public static boolean isLowercase(char c) {
        return isLowercase((int) c);
    }

    /**
     * Checks if the given character is a lowercase letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a lowercase letter, otherwise {@code false}
     */
    public static boolean isLowercase(int c) {
        return Character.isLowerCase(c);
    }

    /**
     * Checks if the given character is an uppercase letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an uppercase letter, otherwise {@code false}
     */
    public static boolean isUppercase(char c) {
        return isUppercase((int) c);
    }

    /**
     * Checks if the given character is an uppercase letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an uppercase letter, otherwise {@code false}
     */
    public static boolean isUppercase(int c) {
        return Character.isUpperCase(c);
    }

    /**
     * Checks if the given character is a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a digit, otherwise {@code false}
     */
    public static boolean isDigit(char c) {
        return isDigit((int) c);
    }

    /**
     * Checks if the given character is a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a digit, otherwise {@code false}
     */
    public static boolean isDigit(int c) {
        return Character.isDigit(c);
    }

    /**
     * Checks if the given character is either a letter or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either a letter or a whitespace, otherwise {@code false}
     */
    public static boolean isLetterOrWhitespace(char c) {
        return isLetterOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is either a letter or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either a letter or a whitespace, otherwise {@code false}
     */
    public static boolean isLetterOrWhitespace(int c) {
        return !isNull(c) && (Character.isLetter(c) || Character.isWhitespace(c));
    }

    /**
     * Checks if the given character is either a letter or a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either a letter or a digit, otherwise {@code false}
     */
    public static boolean isLetterOrDigit(char c) {
        return isLetterOrDigit((int) c);
    }

    /**
     * Checks if the given character is either a letter or a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either a letter or a digit, otherwise {@code false}
     */
    public static boolean isLetterOrDigit(int c) {
        return Character.isLetterOrDigit(c);
    }

    /**
     * Checks if the given character is either a letter, a digit or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter, a digit or a whitespace, otherwise {@code false}
     */
    public static boolean isLetterDigitOrWhitespace(char c) {
        return isLetterDigitOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is either a letter, a digit or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter, a digit or a whitespace, otherwise {@code false}
     */
    public static boolean isLetterDigitOrWhitespace(int c) {
        return Character.isLetterOrDigit(c) || Character.isWhitespace(c);
    }

    /**
     * Checks if the given character is alphabetic. This includes characters beyond the scope of traditional alphabets.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is alphabetic, otherwise {@code false}
     */
    public static boolean isAlphabetic(char c) {
        return isAlphabetic((int) c);
    }

    /**
     * Checks if the given character is alphabetic. This includes characters beyond the scope of traditional alphabets.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is alphabetic, otherwise {@code false}
     */
    public static boolean isAlphabetic(int c) {
        return Character.isAlphabetic(c);
    }

    /**
     * Checks if the given character is either alphabetic or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either alphabetic or a whitespace, otherwise {@code false}
     */
    public static boolean isAlphabeticOrWhitespace(char c) {
        return isAlphabeticOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is either alphabetic or a whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either alphabetic or a whitespace, otherwise {@code false}
     */
    public static boolean isAlphabeticOrWhitespace(int c) {
        return Character.isAlphabetic(c) || Character.isWhitespace(c);
    }

    /**
     * Checks if the given character is either alphabetic or a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either alphabetic or a digit, otherwise {@code false}
     */
    public static boolean isAlphabeticOrDigit(char c) {
        return isAlphabeticOrDigit((int) c);
    }

    /**
     * Checks if the given character is either alphabetic or a digit.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is either alphabetic or a digit, otherwise {@code false}
     */
    public static boolean isAlphabeticOrDigit(int c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    /**
     * Checks if the given character is either alphanumeric or a whitespace character.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is alphanumeric or a whitespace character, otherwise {@code false}
     */
    public static boolean isAlphanumericOrWhitespace(char c) {
        return isAlphanumericOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is either alphanumeric or a whitespace character.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is alphanumeric or a whitespace character, otherwise {@code false}
     */
    public static boolean isAlphanumericOrWhitespace(int c) {
        return isAlphabeticOrDigit(c) || Character.isWhitespace(c);
    }

    /**
     * Checks if the given character is a special character.
     * A special character is defined as not being a letter, a digit, or whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a special character, otherwise {@code false}
     */
    public static boolean isSpecialChar(char c) {
        return isSpecialChar((int) c);
    }

    /**
     * Checks if the given character is a special character.
     * A special character is defined as not being a letter, a digit, or whitespace.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a special character, otherwise {@code false}
     */
    public static boolean isSpecialChar(int c) {
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }

    /**
     * Checks if the given character is a diacritic character.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a diacritic character, otherwise {@code false}
     */
    public static boolean isDiacritic(char c) {
        return isDiacritic((int) c);
    }

    /**
     * Checks if the given character is a diacritic character.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a diacritic character, otherwise {@code false}
     */
    public static boolean isDiacritic(int c) {
        if (isNull(c)) return false;
        int type = Character.getType(c);
        return type == Character.MODIFIER_SYMBOL || type == Character.NON_SPACING_MARK || type == Character.COMBINING_SPACING_MARK || type == Character.ENCLOSING_MARK;
    }

    /**
     * Checks if the given character is a consonant, excluding accented consonants.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a consonant, otherwise {@code false}
     */
    public static boolean isConsonant(char c) {
        return isConsonant((int) c);
    }

    /**
     * Checks if the given character is a consonant, excluding accented consonants.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a consonant, otherwise {@code false}
     */
    public static boolean isConsonant(int c) {
        if (isNull(c)) return false;
        String s = StringHelper.stripAccents(Character.toString((char) c));
        return CONSONANTS.contains(s);
    }

    /**
     * Checks if the given character is a vowel, excluding accented vowels.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a vowel, otherwise {@code false}
     */
    public static boolean isVowel(char c) {
        return isVowel((int) c);
    }

    /**
     * Checks if the given character is a vowel, excluding accented vowels.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a vowel, otherwise {@code false}
     */
    public static boolean isVowel(int c) {
        if (isNull(c)) return false;
        String s = StringHelper.stripAccents(Character.toString((char) c));
        return VOWELS.contains(s);
    }

    /**
     * Checks if the given character is considered a global letter.
     * Global letters include both unaccented and certain accented letters from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter from {@link #GLOBAL_LETTERS}, otherwise {@code false}
     */
    public static boolean isGlobalLetter(char c) {
        return isGlobalLetter((int) c);
    }

    /**
     * Checks if the given character is considered a global letter.
     * Global letters include both unaccented and certain accented letters from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a letter from {@link #GLOBAL_LETTERS}, otherwise {@code false}
     */
    public static boolean isGlobalLetter(int c) {
        return GLOBAL_LETTERS_REGISTRY.contains(c);
    }

    /**
     * Checks if the given character is considered a global consonant.
     * Global consonants include both unaccented and certain accented consonants from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a consonant from {@link #GLOBAL_CONSONANTS}, otherwise {@code false}
     */
    public static boolean isGlobalConsonant(char c) {
        return isGlobalConsonant((int) c);
    }

    /**
     * Checks if the given character is considered a global consonant.
     * Global consonants include both unaccented and certain accented consonants from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a consonant from {@link #GLOBAL_CONSONANTS}, otherwise {@code false}
     */
    public static boolean isGlobalConsonant(int c) {
        return GLOBAL_CONSONANTS_REGISTRY.contains(c);
    }

    /**
     * Checks if the given character is considered a global vowel.
     * Global vowels include both unaccented and certain accented vowels from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a vowel from {@link #GLOBAL_VOWELS}, otherwise {@code false}
     */
    public static boolean isGlobalVowel(char c) {
        return isGlobalVowel((int) c);
    }

    /**
     * Checks if the given character is considered a global vowel.
     * Global vowels include both unaccented and certain accented vowels from various languages.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a vowel from {@link #GLOBAL_VOWELS}, otherwise {@code false}
     */
    public static boolean isGlobalVowel(int c) {
        return GLOBAL_VOWELS_REGISTRY.contains(c);
    }

    /**
     * Checks if the given character is a non-cluster consonant.
     * Non-cluster consonants are specific consonants that typically do not appear in clusters within words.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a non-cluster consonant, otherwise {@code false}
     */
    public static boolean isNonClusterConsonant(char c) {
        return isNonClusterConsonant((int) c);
    }

    /**
     * Checks if the given character is a non-cluster consonant.
     * Non-cluster consonants are specific consonants that typically do not appear in clusters within words, this means,
     * any character from {@link #NON_CLUSTER_CONSONANTS}.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a non-cluster consonant, otherwise {@code false}
     */
    public static boolean isNonClusterConsonant(int c) {
        return NON_CLUSTER_CONSONANTS.indexOf(c) != -1;
    }

    /**
     * Checks if the given character is an accented letter.
     * Accented characters are determined by comparing the original character with its unaccented version.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented letter, otherwise {@code false}
     */
    public static boolean isAccentedLetter(char c) {
        return isAccentedLetter((int) c);
    }

    /**
     * Checks if the given character is an accented letter.
     * Accented characters are determined by comparing the original character with its unaccented version.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented letter, otherwise {@code false}
     */
    public static boolean isAccentedLetter(int c) {
        if (isNull(c)) return false;
        String originalChar = Character.toString((char) c);
        String modifiedChar = StringHelper.stripAccents(originalChar);
        return Character.isLetter(c) && !originalChar.equals(modifiedChar);
    }

    /**
     * Checks if the given character is an unaccented letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented letter, otherwise {@code false}
     */
    public static boolean isUnaccentedLetter(char c) {
        return isUnaccentedLetter((int) c);
    }

    /**
     * Checks if the given character is an unaccented letter.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented letter, otherwise {@code false}
     */
    public static boolean isUnaccentedLetter(int c) {
        if (isNull(c)) return false;
        String originalChar = Character.toString((char) c);
        String modifiedChar = StringHelper.stripAccents(originalChar);
        return Character.isLetter(c) && originalChar.equals(modifiedChar);
    }

    /**
     * Checks if the given character is an accented consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented consonant, otherwise {@code false}
     */
    public static boolean isAccentedConsonant(char c) {
        return isAccentedConsonant((int) c);
    }

    /**
     * Checks if the given character is an accented consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented consonant, otherwise {@code false}
     */
    public static boolean isAccentedConsonant(int c) {
        if (isNull(c)) return false;
        String originalChar = Character.toString((char) c);
        String modifiedChar = StringHelper.stripAccents(originalChar);
        return CONSONANTS.contains(modifiedChar) && !originalChar.equals(modifiedChar);
    }

    /**
     * Checks if the given character is an unaccented consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented consonant, otherwise {@code false}
     */
    public static boolean isUnaccentedConsonant(char c) {
        return isUnaccentedConsonant((int) c);
    }

    /**
     * Checks if the given character is an unaccented consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented consonant, otherwise {@code false}
     */
    public static boolean isUnaccentedConsonant(int c) {
        return CONSONANTS.indexOf(c) != -1;
    }

    /**
     * Checks if the given character is an accented vowel.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented vowel, otherwise {@code false}
     */
    public static boolean isAccentedVowel(char c) {
        return isAccentedVowel((int) c);
    }

    /**
     * Checks if the given character is an accented vowel.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an accented vowel, otherwise {@code false}
     */
    public static boolean isAccentedVowel(int c) {
        if (isNull(c)) return false;
        String originalChar = Character.toString((char) c);
        String modifiedChar = StringHelper.stripAccents(originalChar);
        return VOWELS.contains(modifiedChar) && !originalChar.equals(modifiedChar);
    }

    /**
     * Checks if the given character is an unaccented vowel.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented vowel, otherwise {@code false}
     */
    public static boolean isUnaccentedVowel(char c) {
        return isUnaccentedVowel((int) c);
    }

    /**
     * Checks if the given character is an unaccented vowel.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an unaccented vowel, otherwise {@code false}
     */
    public static boolean isUnaccentedVowel(int c) {
        return VOWELS.indexOf(c) != -1;
    }

    /**
     * Checks if the given character is a special letter.
     * A special letter is defined as a letter that is neither a vowel nor a consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a special letter, otherwise {@code false}
     */
    public static boolean isSpecialLetter(char c) {
        return isSpecialLetter((int) c);
    }

    /**
     * Checks if the given character is a special letter.
     * A special letter is defined as a letter that is neither a vowel nor a consonant.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a special letter, otherwise {@code false}
     */
    public static boolean isSpecialLetter(int c) {
        return isLetter(c) && !isVowel(c) && !isConsonant(c);
    }

    /**
     * Checks if the given character is a delimiter.
     * A delimiter is defined as a whitespace character, underscore ('_'), or hyphen ('-').
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a delimiter, otherwise {@code false}
     */
    public static boolean isDelimiter(char c) {
        return isDelimiter((int) c);
    }

    /**
     * Checks if the given character is a delimiter.
     * A delimiter is defined as a whitespace character, underscore ('_'), or hyphen ('-').
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is a delimiter, otherwise {@code false}
     */
    public static boolean isDelimiter(int c) {
        return Character.isWhitespace(c) || c == '_' || c == '-';
    }

    /**
     * Checks if the given character is part of the ASCII character set.
     * The ASCII character set includes characters with values ranging from 0 to 127 inclusive.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an ASCII character, {@code false} otherwise
     */
    public static boolean isAscii(char c) {
        return isAscii((int) c);
    }

    /**
     * Checks if the given character is part of the ASCII character set.
     * The ASCII character set includes characters with values ranging from 0 to 127 inclusive.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} is an ASCII character, {@code false} otherwise
     */
    public static boolean isAscii(int c) {
        return c <= 127;
    }

    /**
     * Checks if the given character represents a space character (32) in the ASCII character set.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} represents an ASCII space character, {@code false} otherwise
     */
    public static boolean isAsciiSpace(char c) {
        return isAsciiSpace((int) c);
    }

    /**
     * Checks if the given character represents a space character (32) in the ASCII character set.
     *
     * @param c the character to check
     * @return {@code true} if {@code c} represents an ASCII space character, {@code false} otherwise
     */
    public static boolean isAsciiSpace(int c) {
        return c == 32; //0x20
    }

    /**
     * Checks if the given character represents a whitespace character in the ASCII character set.
     * ASCII whitespace characters include horizontal tab (9), line feed (10), vertical tab (11),
     * form feed (12), carriage return (13), and space (32).
     *
     * @param c the character to check
     * @return {@code true} if {@code c} represents an ASCII whitespace character, {@code false} otherwise
     */
    public static boolean isAsciiWhitespace(char c) {
        return isAsciiWhitespace((int) c);
    }

    /**
     * Checks if the given character represents a whitespace character in the ASCII character set.
     * ASCII whitespace characters include horizontal tab (9), line feed (10), vertical tab (11),
     * form feed (12), carriage return (13), and space (32).
     *
     * @param c the character to check
     * @return {@code true} if {@code c} represents an ASCII whitespace character, {@code false} otherwise
     */
    public static boolean isAsciiWhitespace(int c) {
        return isAsciiSpace(c) || (c >= 9 && c <= 13);
    }

    /**
     * Checks if the given character is an ASCII alphabetic character.
     * This includes both uppercase and lowercase letters from 'a' to 'z' and 'A' to 'Z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlpha(char c) {
        return isAsciiAlpha((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphabetic character.
     * This includes both uppercase and lowercase letters from 'a' to 'z' and 'A' to 'Z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlpha(int c) {
        return isAsciiAlphaLower(c) || isAsciiAlphaUpper(c);
    }

    /**
     * Checks if the given character is an ASCII lowercase alphabetic character.
     * This includes letters from 'a' to 'z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII lowercase alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlphaLower(char c) {
        return isAsciiAlphaLower((int) c);
    }

    /**
     * Checks if the given character is an ASCII lowercase alphabetic character.
     * This includes letters from 'a' to 'z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII lowercase alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlphaLower(int c) {
        return c >= 'a' && c <= 'z';
    }

    /**
     * Checks if the given character is an ASCII uppercase alphabetic character.
     * This includes letters from 'A' to 'Z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII uppercase alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlphaUpper(char c) {
        return isAsciiAlphaUpper((int) c);
    }

    /**
     * Checks if the given character is an ASCII uppercase alphabetic character.
     * This includes letters from 'A' to 'Z'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII uppercase alphabetic character, {@code false} otherwise
     */
    public static boolean isAsciiAlphaUpper(int c) {
        return c >= 'A' && c <= 'Z';
    }

    /**
     * Checks if the given character is an ASCII numeric character.
     * This includes digits from '0' to '9'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII numeric character, {@code false} otherwise
     */
    public static boolean isAsciiNumeric(char c) {
        return isAsciiNumeric((int) c);
    }

    /**
     * Checks if the given character is an ASCII numeric character.
     * This includes digits from '0' to '9'.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII numeric character, {@code false} otherwise
     */
    public static boolean isAsciiNumeric(int c) {
        return c >= '0' && c <= '9';
    }

    /**
     * Checks if the given character is an ASCII alphabetic character or a space.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z') and the space character (\u0020).
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character or a space, {@code false} otherwise
     */
    public static boolean isAsciiAlphaOrSpace(char c) {
        return isAsciiAlphaOrSpace((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphabetic character or a space.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z') and the space character (\u0020).
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character or a space, {@code false} otherwise
     */
    public static boolean isAsciiAlphaOrSpace(int c) {
        return isAsciiAlpha(c) || isAsciiSpace(c);
    }

    /**
     * Checks if the given character is an ASCII alphabetic character or a whitespace character.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z') and whitespaces.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character or a whitespace, {@code false} otherwise
     */
    public static boolean isAsciiAlphaOrWhitespace(char c) {
        return isAsciiAlphaOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphabetic character or a whitespace character.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z') and whitespaces.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphabetic character or a whitespace, {@code false} otherwise
     */
    public static boolean isAsciiAlphaOrWhitespace(int c) {
        return isAsciiAlpha(c) || isAsciiWhitespace(c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character.
     * This includes both alphabetic characters ('a' to 'z', 'A' to 'Z') and digits ('0' to '9').
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumeric(char c) {
        return isAsciiAlphanumeric((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character.
     * This includes both alphabetic characters ('a' to 'z', 'A' to 'Z') and digits ('0' to '9').
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumeric(int c) {
        return isAsciiAlpha(c) || isAsciiNumeric(c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character or a space.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z'), digits ('0' to '9'),
     * and the space character (\u0020).
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character or a space, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumericOrSpace(char c) {
        return isAsciiAlphanumericOrSpace((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character or a space.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z'), digits ('0' to '9'),
     * and the space character (\u0020).
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character or a space, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumericOrSpace(int c) {
        return isAsciiAlphanumeric(c) || isAsciiSpace(c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character or whitespace.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z'), digits ('0' to '9'), and whitespaces.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character or whitespace, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumericOrWhitespace(char c) {
        return isAsciiAlphanumericOrWhitespace((int) c);
    }

    /**
     * Checks if the given character is an ASCII alphanumeric character or whitespace.
     * This includes alphabetic characters ('a' to 'z', 'A' to 'Z'), digits ('0' to '9'), and whitespaces.
     *
     * @param c the character to check
     * @return {@code true} if the character is an ASCII alphanumeric character or whitespace, {@code false} otherwise
     */
    public static boolean isAsciiAlphanumericOrWhitespace(int c) {
        return isAsciiAlphanumeric(c) || isAsciiWhitespace(c);
    }

    /**
     * Converts an integer value to its corresponding hexadecimal digit character.
     * The value is first normalized to be within the range of hexadecimal digits (0-15).
     *
     * @param value the integer value to convert
     * @return the hexadecimal digit character corresponding to the least significant 4 bits of {@code value}
     */
    public static char getHexDigit(int value) {
        value = IntegerHelper.defaultByMin(value, 0);
        return Integer.toHexString(value % 16).charAt(0);
    }
}
