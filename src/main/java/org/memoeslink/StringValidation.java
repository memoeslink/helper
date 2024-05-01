package org.memoeslink;

import java.text.Normalizer;

public class StringValidation {

    private StringValidation() {
    }

    /**
     * Determines if the provided string contains at least one space character.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one space character; otherwise, {@code false}
     */
    public static boolean hasSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isSpace);
    }

    /**
     * Checks if the string contains at least one whitespace character.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one whitespace character; otherwise, {@code false}
     */
    public static boolean hasWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isWhitespace);
    }

    /**
     * Checks if the string contains at least one zero-width character.
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
     * @param s the string to check
     * @return {@code true} if the string contains at least one zero-width character; otherwise, {@code false}
     */
    public static boolean hasZeroWidthChar(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isZeroWidthChar);
    }

    /**
     * Verifies if the string contains at least one letter.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one letter; otherwise, {@code false}
     */
    public static boolean hasLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isLetter);
    }

    /**
     * Determines if the string has at least one lowercase letter.
     *
     * @param s the string to check
     * @return {@code true} if there is at least one lowercase letter in the string; otherwise, {@code false}
     */
    public static boolean hasLowercase(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isLowercase);
    }

    /**
     * Checks if the string contains at least one uppercase letter.
     *
     * @param s the string to check
     * @return {@code true} if there is at least one uppercase letter in the string; otherwise, {@code false}
     */
    public static boolean hasUppercase(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isUppercase);
    }

    /**
     * Verifies if the string contains at least one digit.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one digit; otherwise, {@code false}
     */
    public static boolean hasDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isDigit);
    }

    /**
     * Determines if the string contains at least one letter or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one letter or whitespace; otherwise, {@code false}
     */
    public static boolean hasLetterOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isLetterOrWhitespace);
    }

    /**
     * Checks if the string contains at least one letter or digit.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one letter or digit; otherwise, {@code false}
     */
    public static boolean hasLetterOrDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isLetterOrDigit);
    }

    /**
     * Verifies if the string contains at least one letter, digit, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one letter, digit, or whitespace;
     * otherwise, {@code false}
     */
    public static boolean hasLetterDigitOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isLetterDigitOrWhitespace);
    }

    /**
     * Checks if the string contains at least one alphabetic character. Alphabetic characters
     * include letters without regard to case.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one alphabetic character; otherwise, {@code false}
     */
    public static boolean hasAlphabetic(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAlphabetic);
    }

    /**
     * Determines if the string contains at least one alphabetic character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one alphabetic character or whitespace;
     * otherwise, {@code false}
     */
    public static boolean hasAlphabeticOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAlphabeticOrWhitespace);
    }

    /**
     * Verifies if the string contains at least one alphabetic character or digit.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one alphabetic character or digit; otherwise, {@code false}
     */
    public static boolean hasAlphabeticOrDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAlphabeticOrDigit);
    }

    /**
     * Checks if the string contains at least one alphanumeric character or whitespace.
     * Alphanumeric characters include letters and digits.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one alphanumeric character or whitespace;
     * otherwise, {@code false}
     */
    public static boolean hasAlphanumericOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAlphanumericOrWhitespace);
    }

    /**
     * Determines if the provided string contains at least one special character.
     * Special characters are defined as any character that is not a letter, digit, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one special character; otherwise, {@code false}
     */
    public static boolean hasSpecialChar(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isSpecialChar);
    }

    /**
     * Checks if the string contains at least one consonant.
     * Consonants are defined as alphabetic characters that are not vowels.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one consonant; otherwise, {@code false}
     */
    public static boolean hasConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isConsonant);
    }

    /**
     * Verifies if the string contains at least one vowel.
     * Vowels are defined according to the standard English alphabet (a, e, i, o, u).
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one vowel; otherwise, {@code false}
     */
    public static boolean hasVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isVowel);
    }

    /**
     * Determines if the string contains at least one letter from {@link CharHelper#GLOBAL_LETTERS}.
     * This includes letters from alphabets beyond the standard English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one letter from {@link CharHelper#GLOBAL_LETTERS};
     * otherwise, {@code false}
     */
    public static boolean hasGlobalLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isGlobalLetter);
    }

    /**
     * Checks if the string contains at least one consonant from {@link CharHelper#GLOBAL_CONSONANTS}.
     * This considers consonants across various languages, not limited to the English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one consonant from {@link CharHelper#GLOBAL_CONSONANTS};
     * otherwise, {@code false}
     */
    public static boolean hasGlobalConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isGlobalConsonant);
    }

    /**
     * Verifies if the string contains at least one vowel from {@link CharHelper#GLOBAL_VOWELS}.
     * This method broadens the definition of vowels to include those found in languages beyond English.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one vowel from {@link CharHelper#GLOBAL_VOWELS};
     * otherwise, {@code false}
     */
    public static boolean hasGlobalVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isGlobalVowel);
    }

    /**
     * Determines if the string contains at least one consonant that does not form part of a cluster.
     * A non-cluster consonant is one that stands alone without adjacent consonants in the string, this means,
     * any character from {@link CharHelper#NON_CLUSTER_CONSONANTS}.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one non-cluster consonant; otherwise, {@code false}
     */
    public static boolean hasNonClusterConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isNonClusterConsonant);
    }

    /**
     * Determines if the provided string contains at least one accented letter.
     * Accented letters include characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one accented letter; otherwise, {@code false}
     */
    public static boolean hasAccentedLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAccentedLetter);
    }

    /**
     * Checks if the string contains at least one unaccented letter.
     * Unaccented letters are standard alphabetic characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one unaccented letter; otherwise, {@code false}
     */
    public static boolean hasUnaccentedLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isUnaccentedLetter);
    }

    /**
     * Verifies if the string contains at least one accented consonant.
     * Accented consonants are consonant characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one accented consonant; otherwise, {@code false}
     */
    public static boolean hasAccentedConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAccentedConsonant);
    }

    /**
     * Determines if the string has at least one unaccented consonant.
     * Unaccented consonants are consonant characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if there is at least one unaccented consonant in the string; otherwise, {@code false}
     */
    public static boolean hasUnaccentedConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isUnaccentedConsonant);
    }

    /**
     * Checks if the string contains at least one accented vowel.
     * Accented vowels are vowel characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if there is at least one accented vowel in the string; otherwise, {@code false}
     */
    public static boolean hasAccentedVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAccentedVowel);
    }

    /**
     * Verifies if the string contains at least one unaccented vowel.
     * Unaccented vowels are standard vowel characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one unaccented vowel; otherwise, {@code false}
     */
    public static boolean hasUnaccentedVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isUnaccentedVowel);
    }

    /**
     * Determines if the string contains at least one special letter.
     * Special letters include unique alphabetic characters that may not be classified as standard accented
     * or unaccented characters.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one special letter; otherwise, {@code false}
     */
    public static boolean hasSpecialLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isSpecialLetter);
    }

    /**
     * Checks if the string contains at least one ASCII character.
     * ASCII characters are those within the standard ASCII table, ranging from 0 to 127.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII character; otherwise, {@code false}
     */
    public static boolean hasAscii(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAscii);
    }

    /**
     * Checks if the string contains at least one ASCII space (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII space; otherwise, {@code false}
     */
    public static boolean hasAsciiSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiSpace);
    }

    /**
     * Checks if the string contains at least one ASCII whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII whitespace; otherwise, {@code false}
     */
    public static boolean hasAsciiWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiWhitespace);
    }

    /**
     * Checks if the string contains at least one ASCII alphabetic character.
     * ASCII alphabetic characters are those from 'a' to 'z' and 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasAsciiAlpha(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlpha);
    }

    /**
     * Checks if the string contains at least one ASCII alphabetic character.
     * Lowercase ASCII alphabetic characters are those from 'a' to 'z'.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one lowercase ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphaLower(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphaLower);
    }

    /**
     * Checks if the string contains at least one ASCII alphabetic character.
     * Uppercase ASCII alphabetic characters are those from 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one uppercase ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphaUpper(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphaUpper);
    }

    /**
     * Checks if the string contains at least one ASCII numeric character.
     * ASCII numeric characters are those from '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII numeric character; otherwise, {@code false}
     */
    public static boolean hasAsciiNumeric(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiNumeric);
    }

    /**
     * Checks if the string contains at least one ASCII alphabetic character or space.
     * This includes characters from 'A' to 'Z', 'a' to 'z', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphabetic character or space; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphaOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphaOrSpace);
    }

    /**
     * Checks if the string contains at least one ASCII alphabetic character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphabetic character or whitespace; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphaOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphaOrWhitespace);
    }

    /**
     * Checks if the string contains at least one ASCII alphanumeric character.
     * ASCII alphanumeric characters are those from 'A' to 'Z', 'a' to 'z', and '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphanumeric character; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphanumeric(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphanumeric);
    }

    /**
     * Checks if the string contains at least one ASCII alphanumeric character or space.
     * This includes characters from 'A' to 'Z', 'a' to 'z', '0' to '9', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphanumeric character or space; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphanumericOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphanumericOrSpace);
    }

    /**
     * Checks if the string contains at least one alphanumeric character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string contains at least one ASCII alphanumeric character or whitespace; otherwise, {@code false}
     */
    public static boolean hasAsciiAlphanumericOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().anyMatch(CharHelper::isAsciiAlphanumericOrWhitespace);
    }

    /**
     * Checks if the given string contains a diacritic mark.
     *
     * @param s the string to check
     * @return {@code true} if the string contains a diacritic mark, {@code false} otherwise
     */
    public static boolean hasDiacritic(String s) {
        if (StringHelper.isNullOrEmpty(s)) return false;
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return RegexFilter.DIACRITIC_PATTERN.matcher(normalized).find();
    }

    /**
     * Determines if the provided string does not contain any space character.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any space character; otherwise, {@code false}
     */
    public static boolean hasNoSpace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isSpace);
    }

    /**
     * Checks if the string does not contain any whitespace character.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any whitespace character; otherwise, {@code false}
     */
    public static boolean hasNoWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isWhitespace);
    }

    /**
     * Checks if the string does not contain any zero-width character.
     * <p>
     * This method verifies the absence of several specific zero-width characters, including:
     * <ul>
     *     <li>Zero Width Space (U+200B)</li>
     *     <li>Zero Width Non-Joiner (U+200C)</li>
     *     <li>Zero Width Joiner (U+200D)</li>
     *     <li>Word Joiner (U+2060)</li>
     *     <li>Zero Width No-Break Space (U+FEFF), also known as Byte Order Mark (BOM)</li>
     * </ul>
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any zero-width character; otherwise, {@code false}
     */
    public static boolean hasNoZeroWidthChar(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isZeroWidthChar);
    }

    /**
     * Verifies if the string does not contain any letter.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any letter; otherwise, {@code false}
     */
    public static boolean hasNoLetter(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isLetter);
    }

    /**
     * Determines if the string has no lowercase letter.
     *
     * @param s the string to check
     * @return {@code true} if there is no lowercase letter in the string; otherwise, {@code false}
     */
    public static boolean hasNoLowercase(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isLowercase);
    }

    /**
     * Checks if the string does not contain any uppercase letter.
     *
     * @param s the string to check
     * @return {@code true} if there is no uppercase letter in the string; otherwise, {@code false}
     */
    public static boolean hasNoUppercase(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isUppercase);
    }

    /**
     * Verifies if the string does not contain any digit.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any digit; otherwise, {@code false}
     */
    public static boolean hasNoDigit(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isDigit);
    }

    /**
     * Determines if the string does not contain any letter or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any letter or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoLetterOrWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isLetterOrWhitespace);
    }

    /**
     * Checks if the string does not contain any letter or digit.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any letter or digit; otherwise, {@code false}
     */
    public static boolean hasNoLetterOrDigit(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isLetterOrDigit);
    }

    /**
     * Verifies if the string does not contain any letter, digit, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any letter, digit, or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoLetterDigitOrSpace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isLetterDigitOrWhitespace);
    }

    /**
     * Checks if the string does not contain any alphabetic character.
     * Alphabetic characters include letters without regard to case.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any alphabetic character; otherwise, {@code false}
     */
    public static boolean hasNoAlphabetic(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAlphabetic);
    }

    /**
     * Determines if the string does not contain any alphabetic character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any alphabetic character or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoAlphabeticOrWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAlphabeticOrWhitespace);
    }

    /**
     * Checks if the string does not contain any alphabetic character or digit.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any alphabetic character or digit; otherwise, {@code false}
     */
    public static boolean hasNoAlphabeticOrDigit(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAlphabeticOrDigit);
    }

    /**
     * Verifies if the string does not contain any alphanumeric character or whitespace.
     * Alphanumeric characters include letters and digits.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any alphanumeric character or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoAlphanumericOrWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAlphanumericOrWhitespace);
    }

    /**
     * Determines if the provided string does not contain any special character.
     * Special characters are defined as any character that is not a letter, digit, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any special character; otherwise, {@code false}
     */
    public static boolean hasNoSpecialChar(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isSpecialChar);
    }

    /**
     * Checks if the string does not contain any consonant.
     * Consonants are defined as alphabetic characters that are not vowels.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any consonant; otherwise, {@code false}
     */
    public static boolean hasNoConsonant(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isConsonant);
    }

    /**
     * Verifies if the string does not contain any vowel.
     * Vowels are defined according to the standard English alphabet (a, e, i, o, u).
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any vowel; otherwise, {@code false}
     */
    public static boolean hasNoVowel(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isVowel);
    }

    /**
     * Determines if the string does not contain any letter from {@link CharHelper#GLOBAL_LETTERS}.
     * This includes letters from alphabets beyond the standard English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any letter from {@link CharHelper#GLOBAL_LETTERS}; otherwise, {@code false}
     */
    public static boolean hasNoGlobalLetter(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isGlobalLetter);
    }

    /**
     * Checks if the string does not contain any consonant from {@link CharHelper#GLOBAL_CONSONANTS}.
     * This considers consonants across various languages, not limited to the English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any consonant from {@link CharHelper#GLOBAL_CONSONANTS}; otherwise, {@code false}
     */
    public static boolean hasNoGlobalConsonant(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isGlobalConsonant);
    }

    /**
     * Verifies if the string does not contain any vowel from {@link CharHelper#GLOBAL_VOWELS}.
     * This method broadens the definition of vowels to include those found in languages beyond English.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any vowel from {@link CharHelper#GLOBAL_VOWELS}; otherwise, {@code false}
     */
    public static boolean hasNoGlobalVowel(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isGlobalVowel);
    }

    /**
     * Determines if the string does not contain any non-cluster consonant.
     * A non-cluster consonant is one that stands alone without adjacent consonants in the string, this means,
     * any character from {@link CharHelper#NON_CLUSTER_CONSONANTS}.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any non-cluster consonant; otherwise, {@code false}
     */
    public static boolean hasNoNonClusterConsonant(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isNonClusterConsonant);
    }

    /**
     * Determines if the provided string does not contain any accented letter.
     * Accented letters include characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any accented letter; otherwise, {@code false}
     */
    public static boolean hasNoAccentedLetter(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAccentedLetter);
    }

    /**
     * Checks if the string does not contain any unaccented letter.
     * Unaccented letters are standard alphabetic characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any unaccented letter; otherwise, {@code false}
     */
    public static boolean hasNoUnaccentedLetter(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isUnaccentedLetter);
    }

    /**
     * Verifies if the string does not contain any accented consonant.
     * Accented consonants are consonant characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any accented consonant; otherwise, {@code false}
     */
    public static boolean hasNoAccentedConsonant(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAccentedConsonant);
    }

    /**
     * Determines if the string does not contain any unaccented consonant.
     * Unaccented consonants are consonant characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any unaccented consonant; otherwise, {@code false}
     */
    public static boolean hasNoUnaccentedConsonant(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isUnaccentedConsonant);
    }

    /**
     * Checks if the string does not contain any accented vowel.
     * Accented vowels are vowel characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any accented vowel; otherwise, {@code false}
     */
    public static boolean hasNoAccentedVowel(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAccentedVowel);
    }

    /**
     * Verifies if the string does not contain any unaccented vowel.
     * Unaccented vowels are standard vowel characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any unaccented vowel; otherwise, {@code false}
     */
    public static boolean hasNoUnaccentedVowel(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isUnaccentedVowel);
    }

    /**
     * Determines if the string does not contain any special letter.
     * Special letters include unique alphabetic characters that may not be classified as standard accented or unaccented characters.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any special letter; otherwise, {@code false}
     */
    public static boolean hasNoSpecialLetter(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isSpecialLetter);
    }

    /**
     * Determines if the string does not contain any ASCII character.
     * ASCII characters are those within the standard ASCII table, ranging from 0 to 127.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII character; otherwise, {@code false}
     */
    public static boolean hasNoAscii(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAscii);
    }

    /**
     * Determines if the string does not contain any ASCII space (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII space; otherwise, {@code false}
     */
    public static boolean hasNoAsciiSpace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiSpace);
    }

    /**
     * Determines if the string does not contain any ASCII whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII whitespace; otherwise, {@code false}
     */
    public static boolean hasNoAsciiWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiWhitespace);
    }

    /**
     * Determines if the string does not contain any ASCII alphabetic character.
     * ASCII alphabetic characters are those from 'a' to 'z' and 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlpha(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlpha);
    }

    /**
     * Determines if the string does not contain any lowercase ASCII alphabetic character.
     * Lowercase ASCII alphabetic characters are those from 'a' to 'z'.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any lowercase ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphaLower(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphaLower);
    }

    /**
     * Determines if the string does not contain any uppercase ASCII alphabetic character.
     * Uppercase ASCII alphabetic characters are those from 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any uppercase ASCII alphabetic character; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphaUpper(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphaUpper);
    }

    /**
     * Determines if the string does not contain any ASCII numeric character.
     * ASCII numeric characters are those from '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII numeric character; otherwise, {@code false}
     */
    public static boolean hasNoAsciiNumeric(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiNumeric);
    }

    /**
     * Determines if the string does not contain any ASCII alphabetic character or space.
     * This includes characters from 'A' to 'Z', 'a' to 'z', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphabetic character or space; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphaOrSpace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphaOrSpace);
    }

    /**
     * Determines if the string does not contain any ASCII alphabetic character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphabetic character or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphaOrWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphaOrWhitespace);
    }

    /**
     * Determines if the string does not contain any ASCII alphanumeric character.
     * ASCII alphanumeric characters are those from 'A' to 'Z', 'a' to 'z', and '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphanumeric character; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphanumeric(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphanumeric);
    }

    /**
     * Determines if the string does not contain any ASCII alphanumeric character or space.
     * This includes characters from 'A' to 'Z', 'a' to 'z', '0' to '9', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphanumeric character or space; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphanumericOrSpace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphanumericOrSpace);
    }

    /**
     * Determines if the string does not contain any alphanumeric character or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain any ASCII alphanumeric character or whitespace; otherwise, {@code false}
     */
    public static boolean hasNoAsciiAlphanumericOrWhitespace(String s) {
        return StringHelper.isNullOrEmpty(s) || s.chars().noneMatch(CharHelper::isAsciiAlphanumericOrWhitespace);
    }

    /**
     * Determines if the given string does not contain a diacritic mark.
     *
     * @param s the string to check
     * @return {@code true} if the string does not contain a diacritic mark, {@code false} otherwise
     */
    public static boolean hasNoDiacritic(String s) {
        return !hasDiacritic(s);
    }

    /**
     * Determines if all characters in the provided string are space characters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are space characters; otherwise, {@code false}
     */
    public static boolean isOnlySpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isSpace);
    }

    /**
     * Checks if all characters in the string are whitespace characters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are whitespace characters; otherwise, {@code false}
     */
    public static boolean isOnlyWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isWhitespace);
    }

    /**
     * Checks if all characters in the string are zero-width characters.
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
     * @param s the string to check
     * @return {@code true} if all characters in the string are zero-width characters; otherwise, {@code false}
     */
    public static boolean isOnlyZeroWidthChar(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isZeroWidthChar);
    }

    /**
     * Verifies if all characters in the string are letters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are letters; otherwise, {@code false}
     */
    public static boolean isOnlyLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isLetter);
    }

    /**
     * Determines if all characters in the string are lowercase letters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are lowercase letters; otherwise, {@code false}
     */
    public static boolean isOnlyLowercase(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isLowercase);
    }

    /**
     * Checks if all characters in the string are uppercase letters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are uppercase letters; otherwise, {@code false}
     */
    public static boolean isOnlyUppercase(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isUppercase);
    }

    /**
     * Verifies if all characters in the string are digits.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are digits; otherwise, {@code false}
     */
    public static boolean isOnlyDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isDigit);
    }

    /**
     * Determines if all characters in the string are letters or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are letters or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyLetterOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isLetterOrWhitespace);
    }

    /**
     * Checks if all characters in the string are letters or digits.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are letters or digits; otherwise, {@code false}
     */
    public static boolean isOnlyLetterOrDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isLetterOrDigit);
    }

    /**
     * Verifies if all characters in the string are letters, digits, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are letters, digits, or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyLetterDigitOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isLetterDigitOrWhitespace);
    }

    /**
     * Checks if all characters in the string are alphabetic characters.
     * Alphabetic characters include letters without regard to case.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are alphabetic characters; otherwise, {@code false}
     */
    public static boolean isOnlyAlphabetic(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAlphabetic);
    }

    /**
     * Determines if all characters in the string are alphabetic characters or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are alphabetic characters or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyAlphabeticOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAlphabeticOrWhitespace);
    }

    /**
     * Verifies if all characters in the string are alphabetic characters or digits.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are alphabetic characters or digits; otherwise, {@code false}
     */
    public static boolean isOnlyAlphabeticOrDigit(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAlphabeticOrDigit);
    }

    /**
     * Checks if all characters in the string are alphanumeric characters or whitespace.
     * Alphanumeric characters include letters and digits.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are alphanumeric characters or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyAlphanumericOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAlphanumericOrWhitespace);
    }

    /**
     * Determines if all characters in the provided string are special characters.
     * Special characters are defined as any character that is not a letter, digit, or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are special characters; otherwise, {@code false}
     */
    public static boolean isOnlySpecialChar(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isSpecialChar);
    }

    /**
     * Checks if all characters in the string are consonants.
     * Consonants are defined as alphabetic characters that are not vowels.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are consonants; otherwise, {@code false}
     */
    public static boolean isOnlyConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isConsonant);
    }

    /**
     * Verifies if all characters in the string are vowels.
     * Vowels are defined according to the standard English alphabet (a, e, i, o, u).
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are vowels; otherwise, {@code false}
     */
    public static boolean isOnlyVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isVowel);
    }

    /**
     * Determines if all characters in the string are letters from {@link CharHelper#GLOBAL_LETTERS}.
     * This includes letters from alphabets beyond the standard English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are letters from {@link CharHelper#GLOBAL_LETTERS}; otherwise, {@code false}
     */
    public static boolean isOnlyGlobalLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isGlobalLetter);
    }

    /**
     * Checks if all characters in the string are consonants from {@link CharHelper#GLOBAL_CONSONANTS}.
     * This considers consonants across various languages, not limited to the English alphabet.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are consonants from {@link CharHelper#GLOBAL_CONSONANTS}; otherwise, {@code false}
     */
    public static boolean isOnlyGlobalConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isGlobalConsonant);
    }

    /**
     * Verifies if all characters in the string are vowels from {@link CharHelper#GLOBAL_VOWELS}.
     * This method broadens the definition of vowels to include those found in languages beyond English.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are vowels from {@link CharHelper#GLOBAL_VOWELS}; otherwise, {@code false}
     */
    public static boolean isOnlyGlobalVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isGlobalVowel);
    }

    /**
     * Determines if all characters in the string are non-cluster consonants.
     * A non-cluster consonant is one that stands alone without adjacent consonants in the string, this means,
     * any character from {@link CharHelper#NON_CLUSTER_CONSONANTS}.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are non-cluster consonants; otherwise, {@code false}
     */
    public static boolean isOnlyNonClusterConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isNonClusterConsonant);
    }

    /**
     * Determines if all characters in the provided string are accented letters.
     * Accented letters include characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are accented letters; otherwise, {@code false}
     */
    public static boolean isOnlyAccentedLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAccentedLetter);
    }

    /**
     * Checks if all characters in the string are unaccented letters.
     * Unaccented letters are standard alphabetic characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are unaccented letters; otherwise, {@code false}
     */
    public static boolean isOnlyUnaccentedLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isUnaccentedLetter);
    }

    /**
     * Verifies if all characters in the string are accented consonants.
     * Accented consonants are consonant characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are accented consonants; otherwise, {@code false}
     */
    public static boolean isOnlyAccentedConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAccentedConsonant);
    }

    /**
     * Determines if all characters in the string are unaccented consonants.
     * Unaccented consonants are consonant characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are unaccented consonants; otherwise, {@code false}
     */
    public static boolean isOnlyUnaccentedConsonant(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isUnaccentedConsonant);
    }

    /**
     * Checks if all characters in the string are accented vowels.
     * Accented vowels are vowel characters with diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are accented vowels; otherwise, {@code false}
     */
    public static boolean isOnlyAccentedVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAccentedVowel);
    }

    /**
     * Verifies if all characters in the string are unaccented vowels.
     * Unaccented vowels are standard vowel characters without diacritical marks.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are unaccented vowels; otherwise, {@code false}
     */
    public static boolean isOnlyUnaccentedVowel(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isUnaccentedVowel);
    }

    /**
     * Determines if all characters in the string are special letters.
     * Special letters include unique alphabetic characters that may not be classified as standard accented
     * or unaccented characters.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are special letters; otherwise, {@code false}
     */
    public static boolean isOnlySpecialLetter(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isSpecialLetter);
    }

    /**
     * Checks if all characters in the string are ASCII characters.
     * ASCII characters are those within the standard ASCII table, ranging from 0 to 127.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII characters; otherwise, {@code false}
     */
    public static boolean isOnlyAscii(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAscii);
    }

    /**
     * Checks if all characters in the string are ASCII spaces (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII spaces; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiSpace);
    }

    /**
     * Checks if all characters in the string are ASCII whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiWhitespace);
    }

    /**
     * Checks if all characters in the string are ASCII alphabetic characters.
     * ASCII alphabetic characters are those from 'a' to 'z' and 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphabetic characters; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlpha(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlpha);
    }

    /**
     * Checks if all characters in the string are lowercase ASCII alphabetic characters.
     * Lowercase ASCII alphabetic characters are those from 'a' to 'z'.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are lowercase ASCII alphabetic characters; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphaLower(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphaLower);
    }

    /**
     * Checks if all characters in the string are uppercase ASCII alphabetic characters.
     * Uppercase ASCII alphabetic characters are those from 'A' to 'Z'.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are uppercase ASCII alphabetic characters; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphaUpper(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphaUpper);
    }

    /**
     * Checks if all characters in the string are ASCII numeric characters.
     * ASCII numeric characters are those from '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII numeric characters; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiNumeric(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiNumeric);
    }

    /**
     * Checks if all characters in the string are ASCII alphabetic characters or spaces.
     * This includes characters from 'A' to 'Z', 'a' to 'z', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphabetic characters or spaces; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphaOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphaOrSpace);
    }

    /**
     * Checks if all characters in the string are ASCII alphabetic characters or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphabetic characters or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphaOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphaOrWhitespace);
    }

    /**
     * Checks if all characters in the string are ASCII alphanumeric characters.
     * ASCII alphanumeric characters are those from 'A' to 'Z', 'a' to 'z', and '0' to '9'.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphanumeric characters; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphanumeric(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphanumeric);
    }

    /**
     * Checks if all characters in the string are ASCII alphanumeric characters or spaces.
     * This includes characters from 'A' to 'Z', 'a' to 'z', '0' to '9', and the space character (\u0020).
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphanumeric characters or spaces; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphanumericOrSpace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphanumericOrSpace);
    }

    /**
     * Checks if all characters in the string are ASCII alphanumeric characters or whitespace.
     *
     * @param s the string to check
     * @return {@code true} if all characters in the string are ASCII alphanumeric characters or whitespace; otherwise, {@code false}
     */
    public static boolean isOnlyAsciiAlphanumericOrWhitespace(String s) {
        return StringHelper.isNotNullOrEmpty(s) && s.chars().allMatch(CharHelper::isAsciiAlphanumericOrWhitespace);
    }
}
