package org.memoeslink;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
    public static final int INDEX_NOT_FOUND = -1;
    public static final String EMPTY = "";
    public static final String DEFAULT_VALUE = "?";

    private StringHelper() {
    }

    /**
     * Checks if the given string is {@code null} or empty.
     *
     * @param s the string to check
     * @return {@code true} if the string is {@code null} or its length is 0, {@code false} otherwise
     */
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    /**
     * Checks if the given string is not {@code null} and not empty.
     *
     * @param s the string to check
     * @return {@code true} if the string is not {@code null} and its length is greater than 0, {@code false} otherwise
     */
    public static boolean isNotNullOrEmpty(String s) {
        return !isNullOrEmpty(s);
    }

    /**
     * Checks if the given string is {@code null} or contains only whitespace characters.
     *
     * @param s the string to check
     * @return {@code true} if the string is {@code null} or blank, {@code false} otherwise
     */
    public static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }

    /**
     * Checks if the given string is not {@code null} and contains at least one non-whitespace character.
     *
     * @param s the string to check
     * @return {@code true} if the string is not {@code null} and not blank, {@code false} otherwise
     */
    public static boolean isNotNullOrBlank(String s) {
        return !isNullOrBlank(s);
    }

    /**
     * Returns the index within the given string of the first occurrence of the specified character.
     *
     * @param s the string to search
     * @param c the character to find
     * @return the index of the first occurrence of the character in the string, or {@value #INDEX_NOT_FOUND} if the character does not occur
     */
    public static int indexOf(String s, char c) {
        return indexOf(s, String.valueOf(c));
    }

    /**
     * Returns the index within the given string of the first occurrence of the specified substring.
     *
     * @param s          the string to search
     * @param occurrence the substring to find
     * @return the index of the first occurrence of the substring in the string, or {@value #INDEX_NOT_FOUND} if the substring does not occur
     */
    public static int indexOf(String s, String occurrence) {
        if (isNullOrEmpty(s)) return INDEX_NOT_FOUND;
        return s.indexOf(occurrence);
    }

    /**
     * Returns a default value if the given string is {@code null}, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not {@code null}, otherwise {@value #DEFAULT_VALUE}
     */
    public static String defaultOnNull(String s) {
        return defaultIfNull(s, DEFAULT_VALUE);
    }

    /**
     * Returns an empty string if the given string is {@code null}, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not {@code null}, otherwise an empty string
     */
    public static String defaultIfNull(String s) {
        return defaultIfNull(s, EMPTY);
    }

    /**
     * Returns the default value if the given string is {@code null}, otherwise returns the string itself.
     *
     * @param s            the string to check
     * @param defaultValue the default value to return if {@code s} is {@code null}
     * @return the original string if it is not {@code null}, otherwise the specified default value
     */
    public static String defaultIfNull(String s, String defaultValue) {
        if (s == null) return defaultValue == null ? EMPTY : defaultValue;
        return s;
    }

    /**
     * Returns a default value if the given string is empty, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not empty, otherwise {@value #DEFAULT_VALUE}
     */
    public static String defaultOnEmpty(String s) {
        return defaultIfEmpty(s, DEFAULT_VALUE);
    }

    /**
     * Returns an empty string if the given string is empty, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not empty, otherwise an empty string
     */
    public static String defaultIfEmpty(String s) {
        return defaultIfEmpty(s, EMPTY);
    }

    /**
     * Returns the default value if the given string is empty, otherwise returns the string itself.
     *
     * @param s            the string to check
     * @param defaultValue the default value to return if {@code s} is empty
     * @return the original string if it is not empty, otherwise the specified default value
     */
    public static String defaultIfEmpty(String s, String defaultValue) {
        if (isNullOrEmpty(s)) return defaultValue == null ? EMPTY : defaultValue;
        return s;
    }

    /**
     * Returns a default value if the given string is blank, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not blank, otherwise {@value #DEFAULT_VALUE}
     */
    public static String defaultOnBlank(String s) {
        return defaultIfBlank(s, DEFAULT_VALUE);
    }

    /**
     * Returns an empty string if the given string is blank, otherwise returns the string itself.
     *
     * @param s the string to check
     * @return the original string if it is not blank, otherwise an empty string
     */
    public static String defaultIfBlank(String s) {
        return defaultIfBlank(s, EMPTY);
    }

    /**
     * Returns the default value if the given string is blank, otherwise returns the string itself.
     *
     * @param s            the string to check
     * @param defaultValue the default value to return if {@code s} is blank
     * @return the original string if it is not blank, otherwise the specified default value
     */
    public static String defaultIfBlank(String s, String defaultValue) {
        if (isNullOrBlank(s)) return defaultValue == null ? EMPTY : defaultValue;
        return s;
    }

    /**
     * Returns the first non-null string from the given array, or the default value if all are {@code null}.
     *
     * @param strings the array of strings to check
     * @return the first non-null string, or the specified default value if all strings are {@code null}
     */
    public static String getFirstNonNull(String... strings) {
        return getFirstNonNullOrDefault(null, strings);
    }

    /**
     * Returns the first string that is not {@code null} or empty from the given array, or the default value if all are {@code null} or empty.
     *
     * @param strings the array of strings to check
     * @return the first string that is not {@code null} or empty, or the specified default value if all strings are {@code null} or empty
     */
    public static String getFirstNonEmpty(String... strings) {
        return getFirstNonEmptyOrDefault(null, strings);
    }

    /**
     * Returns the first string that is not {@code null} or blank from the given array, or the default value if all are {@code null} or blank.
     *
     * @param strings the array of strings to check
     * @return the first string that is not {@code null} or blank, or the specified default value if all strings are {@code null} or blank
     */
    public static String getFirstNonBlank(String... strings) {
        return getFirstNonBlankOrDefault(null, strings);
    }

    /**
     * Returns the first non-null string from the given array, or the specified default value if all are {@code null}.
     *
     * @param defaultValue the default value to return if all strings are {@code null}
     * @param strings      the array of strings to check
     * @return the first non-null string, or the specified default value if all strings are {@code null}
     */
    public static String getFirstNonNullOrDefault(String defaultValue, String... strings) {
        for (String s : strings) {
            if (s != null) return s;
        }
        return defaultValue;
    }

    /**
     * Returns the first string that is not {@code null} or empty from the given array, or the specified default value if all are {@code null} or empty.
     *
     * @param defaultValue the default value to return if all strings are {@code null} or empty
     * @param strings      the array of strings to check
     * @return the first string that is not {@code null} or empty, or the specified default value if all strings are {@code null} or empty
     */
    public static String getFirstNonEmptyOrDefault(String defaultValue, String... strings) {
        for (String s : strings) {
            if (isNotNullOrEmpty(s)) return s;
        }
        return defaultValue;
    }

    /**
     * Returns the first string that is not {@code null} or blank from the given array, or the specified default value if all are {@code null} or blank.
     *
     * @param defaultValue the default value to return if all strings are {@code null} or blank
     * @param strings      the array of strings to check
     * @return the first string that is not {@code null} or blank, or the specified default value if all strings are {@code null} or blank
     */
    public static String getFirstNonBlankOrDefault(String defaultValue, String... strings) {
        for (String s : strings) {
            if (isNotNullOrBlank(s)) return s;
        }
        return defaultValue;
    }

    /**
     * Returns the first string from the given array that is not {@code null}; otherwise, returns a default value.
     *
     * @param strings the array of strings to check
     * @return the first non-null string from the array, or {@value #DEFAULT_VALUE} if all strings are {@code null}
     */
    public static String getFirstNonNullElseDefault(String... strings) {
        return getFirstNonNullOrDefault(DEFAULT_VALUE, strings);
    }

    /**
     * Returns the first string from the given array that is not {@code null} or empty; otherwise, returns a default value.
     *
     * @param strings the array of strings to check
     * @return the first non-empty string from the array, or {@value #DEFAULT_VALUE} if all strings are {@code null} or empty
     */
    public static String getFirstNonEmptyElseDefault(String... strings) {
        return getFirstNonEmptyOrDefault(DEFAULT_VALUE, strings);
    }

    /**
     * Returns the first string from the given array that is not {@code null} or blank; otherwise, returns a default value.
     *
     * @param strings the array of strings to check
     * @return the first non-blank string from the array, or {@value #DEFAULT_VALUE} if all strings are {@code null} or blank
     */
    public static String getFirstNonBlankElseDefault(String... strings) {
        return getFirstNonBlankOrDefault(DEFAULT_VALUE, strings);
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null}.
     *
     * @param s      the string to prepend to
     * @param prefix the prefix to prepend
     * @return the string with the prefix prepended if the string is not {@code null}; otherwise, {@code null}
     */
    public static String prependIfNotNull(String s, String prefix) {
        return prependIfNotNull(s, prefix, EMPTY);
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null}, using a default prefix if the given prefix is {@code null}.
     *
     * @param s             the string to prepend to
     * @param prefix        the prefix to prepend
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @return the string with the prefix or default prefix prepended if the string is not {@code null}; otherwise, {@code null}
     */
    public static String prependIfNotNull(String s, String prefix, String defaultPrefix) {
        if (s == null) return null;
        return defaultIfNull(prefix, defaultPrefix) + s;
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null} or empty.
     *
     * @param s      the string to prepend to
     * @param prefix the prefix to prepend
     * @return the string with the prefix prepended if the string is not {@code null} or empty; otherwise, returns the original string
     */
    public static String prependIfNotEmpty(String s, String prefix) {
        return prependIfNotEmpty(s, prefix, EMPTY);
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null} or empty, using a default prefix if the given prefix is {@code null}.
     *
     * @param s             the string to prepend to
     * @param prefix        the prefix to prepend
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @return the string with the prefix or default prefix prepended if the string is not {@code null} or empty; otherwise, returns the original string
     */
    public static String prependIfNotEmpty(String s, String prefix, String defaultPrefix) {
        if (isNullOrEmpty(s)) return s;
        return defaultIfNull(prefix, defaultPrefix) + s;
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null} or blank.
     *
     * @param s      the string to prepend to
     * @param prefix the prefix to prepend
     * @return the string with the prefix prepended if the string is not {@code null} or blank; otherwise, returns the original string
     */
    public static String prependIfNotBlank(String s, String prefix) {
        return prependIfNotBlank(s, prefix, EMPTY);
    }

    /**
     * Prepends the given prefix to the string if the string is not {@code null} or blank, using a default prefix if the given prefix is {@code null}.
     *
     * @param s             the string to prepend to
     * @param prefix        the prefix to prepend
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @return the string with the prefix or default prefix prepended if the string is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String prependIfNotBlank(String s, String prefix, String defaultPrefix) {
        if (isNullOrBlank(s)) return s;
        return defaultIfNull(prefix, defaultPrefix) + s;
    }

    /**
     * Prepends a space to the specified string if the string is not {@code null}.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading space if {@code s} is not {@code null}; otherwise, returns {@code null}
     */
    public static String prependSpaceIfNotNull(String s) {
        return prependIfNotNull(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Prepends a space to the specified string if the string is not {@code null} or empty.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading space if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String prependSpaceIfNotEmpty(String s) {
        return prependIfNotEmpty(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Prepends a space to the specified string if the string is not {@code null} or blank.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading space if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String prependSpaceIfNotBlank(String s) {
        return prependIfNotBlank(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Prepends a hyphen to the specified string if the string is not {@code null}.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading hyphen if {@code s} is not {@code null}; otherwise, returns {@code null}
     */
    public static String prependHyphenIfNotNull(String s) {
        return prependIfNotNull(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Prepends a hyphen to the specified string if the string is not {@code null} or empty.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading hyphen if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String prependHyphenIfNotEmpty(String s) {
        return prependIfNotEmpty(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Prepends a hyphen to the specified string if the string is not {@code null} or blank.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading hyphen if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String prependHyphenIfNotBlank(String s) {
        return prependIfNotBlank(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Prepends a line break to the specified string if the string is not {@code null}. Uses the system's line separator
     * as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading line break if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String prependLineBreakIfNotNull(String s) {
        return prependIfNotNull(s, System.lineSeparator());
    }

    /**
     * Prepends a line break to the specified string if the string is not {@code null} or empty.
     * Uses the system's line separator as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading line break if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String prependLineBreakIfNotEmpty(String s) {
        return prependIfNotEmpty(s, System.lineSeparator());
    }

    /**
     * Prepends a line break to the specified string if the string is not {@code null} or blank.
     * Uses the system's line separator as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to prepend to
     * @return the modified string with a leading line break if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String prependLineBreakIfNotBlank(String s) {
        return prependIfNotBlank(s, System.lineSeparator());
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null}.
     *
     * @param s      the string to append to
     * @param suffix the suffix to append
     * @return the modified string with the suffix appended if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String appendIfNotNull(String s, String suffix) {
        return appendIfNotNull(s, suffix, EMPTY);
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null}, using a default suffix if the given suffix is {@code null}.
     *
     * @param s             the string to append to
     * @param suffix        the suffix to append
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the string with the suffix or default suffix appended if the string is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String appendIfNotNull(String s, String suffix, String defaultSuffix) {
        if (s == null) return null;
        return s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null} or empty.
     *
     * @param s      the string to append to
     * @param suffix the suffix to append
     * @return the modified string with the suffix appended if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String appendIfNotEmpty(String s, String suffix) {
        return appendIfNotEmpty(s, suffix, EMPTY);
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null} or empty, using a default suffix
     * if the given suffix is {@code null}.
     *
     * @param s             the string to append to
     * @param suffix        the suffix to append
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the string with the suffix or default suffix appended if the string is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String appendIfNotEmpty(String s, String suffix, String defaultSuffix) {
        if (isNullOrEmpty(s)) return s;
        return s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null} or blank.
     *
     * @param s      the string to append to
     * @param suffix the suffix to append
     * @return the modified string with the suffix appended if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String appendIfNotBlank(String s, String suffix) {
        return appendIfNotBlank(s, suffix, EMPTY);
    }

    /**
     * Appends the given suffix to the string if the string is not {@code null} or blank, using a default suffix
     * if the given suffix is {@code null}.
     *
     * @param s             the string to append to
     * @param suffix        the suffix to append
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the string with the suffix or default suffix appended if the string is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String appendIfNotBlank(String s, String suffix, String defaultSuffix) {
        if (isNullOrBlank(s)) return s;
        return s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Appends a space to the specified string if the string is not {@code null}.
     *
     * @param s the string to append to
     * @return the modified string with a trailing space if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String appendSpaceIfNotNull(String s) {
        return appendIfNotNull(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Appends a space to the specified string if the string is not {@code null} or empty.
     *
     * @param s the string to append to
     * @return the modified string with a trailing space if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String appendSpaceIfNotEmpty(String s) {
        return appendIfNotEmpty(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Appends a space to the specified string if the string is not {@code null} or blank.
     *
     * @param s the string to append to
     * @return the modified string with a trailing space if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String appendSpaceIfNotBlank(String s) {
        return appendIfNotBlank(s, String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Appends a hyphen to the specified string if the string is not {@code null}.
     *
     * @param s the string to append to
     * @return the modified string with a trailing hyphen if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String appendHyphenIfNotNull(String s) {
        return appendIfNotNull(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Appends a hyphen to the specified string if the string is not {@code null} or empty.
     *
     * @param s the string to append to
     * @return the modified string with a trailing hyphen if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String appendHyphenIfNotEmpty(String s) {
        return appendIfNotEmpty(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Appends a hyphen to the specified string if the string is not {@code null} or blank.
     *
     * @param s the string to append to
     * @return the modified string with a trailing hyphen if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String appendHyphenIfNotBlank(String s) {
        return appendIfNotBlank(s, String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Appends a line break to the specified string if the string is not {@code null}.
     * Uses the system's line separator as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to append to
     * @return the modified string with a trailing line break if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String appendLineBreakIfNotNull(String s) {
        return appendIfNotNull(s, System.lineSeparator());
    }

    /**
     * Appends a line break to the specified string if the string is not {@code null} or empty.
     * Uses the system's line separator as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to append to
     * @return the modified string with a trailing line break if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String appendLineBreakIfNotEmpty(String s) {
        return appendIfNotEmpty(s, System.lineSeparator());
    }

    /**
     * Appends a line break to the specified string if the string is not {@code null} or blank.
     * Uses the system's line separator as defined by the system property {@code "line.separator"}.
     *
     * @param s the string to append to
     * @return the modified string with a trailing line break if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String appendLineBreakIfNotBlank(String s) {
        return appendIfNotBlank(s, System.lineSeparator());
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null}.
     *
     * @param s      the string to modify
     * @param prefix the prefix to add
     * @param suffix the suffix to add
     * @return the modified string with the prefix and suffix added if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String affixIfNotNull(String s, String prefix, String suffix) {
        return affixIfNotNull(s, prefix, suffix, EMPTY, EMPTY);
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null}, using default values
     * for the prefix and suffix if they are {@code null}.
     *
     * @param s             the string to modify
     * @param prefix        the prefix to add
     * @param suffix        the suffix to add
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the modified string with the prefix and suffix (or their defaults) added if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String affixIfNotNull(String s, String prefix, String suffix, String defaultPrefix, String defaultSuffix) {
        if (s == null) return null;
        return defaultIfNull(prefix, defaultPrefix) + s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null} or empty.
     *
     * @param s      the string to modify
     * @param prefix the prefix to add
     * @param suffix the suffix to add
     * @return the modified string with the prefix and suffix added if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String affixIfNotEmpty(String s, String prefix, String suffix) {
        return affixIfNotEmpty(s, prefix, suffix, EMPTY, EMPTY);
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null} or empty, using default values for
     * the prefix and suffix if they are {@code null}.
     *
     * @param s             the string to modify
     * @param prefix        the prefix to add
     * @param suffix        the suffix to add
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the modified string with the prefix and suffix (or their defaults) added if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String affixIfNotEmpty(String s, String prefix, String suffix, String defaultPrefix, String defaultSuffix) {
        if (isNullOrEmpty(s)) return s;
        return defaultIfNull(prefix, defaultPrefix) + s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null} or blank.
     *
     * @param s      the string to modify
     * @param prefix the prefix to add
     * @param suffix the suffix to add
     * @return the modified string with the prefix and suffix added if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String affixIfNotBlank(String s, String prefix, String suffix) {
        return affixIfNotBlank(s, prefix, suffix, EMPTY, EMPTY);
    }

    /**
     * Adds the specified prefix and suffix to the string if it is not {@code null} or blank, using default values
     * for the prefix and suffix if they are {@code null}.
     *
     * @param s             the string to modify
     * @param prefix        the prefix to add
     * @param suffix        the suffix to add
     * @param defaultPrefix the default prefix to use if {@code prefix} is {@code null}
     * @param defaultSuffix the default suffix to use if {@code suffix} is {@code null}
     * @return the modified string with the prefix and suffix (or their defaults) added if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String affixIfNotBlank(String s, String prefix, String suffix, String defaultPrefix, String defaultSuffix) {
        if (isNullOrBlank(s)) return s;
        return defaultIfNull(prefix, defaultPrefix) + s + defaultIfNull(suffix, defaultSuffix);
    }

    /**
     * Adds a space to both the beginning and end of the specified string if it is not {@code null}.
     *
     * @param s the string to modify
     * @return the modified string with spaces added at both ends if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String affixSpacesIfNotNull(String s) {
        return affixIfNotNull(s, String.valueOf(Separator.SPACE.getCharacter()), String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Adds a space to both the beginning and end of the specified string if it is not {@code null} or empty.
     *
     * @param s the string to modify
     * @return the modified string with spaces added at both ends if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String affixSpacesIfNotEmpty(String s) {
        return affixIfNotEmpty(s, String.valueOf(Separator.SPACE.getCharacter()), String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Adds a space to both the beginning and end of the specified string if it is not {@code null} or blank.
     *
     * @param s the string to modify
     * @return the modified string with spaces added at both ends if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String affixSpacesIfNotBlank(String s) {
        return affixIfNotBlank(s, String.valueOf(Separator.SPACE.getCharacter()), String.valueOf(Separator.SPACE.getCharacter()));
    }

    /**
     * Adds a hyphen to both the beginning and end of the specified string if it is not {@code null}.
     *
     * @param s the string to modify
     * @return the modified string with hyphens added at both ends if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String affixHyphensIfNotNull(String s) {
        return affixIfNotNull(s, String.valueOf(Separator.HYPHEN.getCharacter()), String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Adds a hyphen to both the beginning and end of the specified string if it is not {@code null} or empty.
     *
     * @param s the string to modify
     * @return the modified string with hyphens added at both ends if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String affixHyphensIfNotEmpty(String s) {
        return affixIfNotEmpty(s, String.valueOf(Separator.HYPHEN.getCharacter()), String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Adds a hyphen to both the beginning and end of the specified string if it is not {@code null} or blank.
     *
     * @param s the string to modify
     * @return the modified string with hyphens added at both ends if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String affixHyphensIfNotBlank(String s) {
        return affixIfNotBlank(s, String.valueOf(Separator.HYPHEN.getCharacter()), String.valueOf(Separator.HYPHEN.getCharacter()));
    }

    /**
     * Adds a line break to both the beginning and end of the specified string if it is not {@code null}.
     *
     * @param s the string to modify
     * @return the modified string with line breaks added at both ends if {@code s} is not {@code null};
     * otherwise, returns {@code null}
     */
    public static String affixLineBreaksIfNotNull(String s) {
        return affixIfNotNull(s, System.lineSeparator(), System.lineSeparator());
    }

    /**
     * Adds a line break to both the beginning and end of the specified string if it is not {@code null} or empty.
     *
     * @param s the string to modify
     * @return the modified string with line breaks added at both ends if {@code s} is not {@code null} or empty;
     * otherwise, returns the original string
     */
    public static String affixLineBreaksIfNotEmpty(String s) {
        return affixIfNotEmpty(s, System.lineSeparator(), System.lineSeparator());
    }

    /**
     * Adds a line break to both the beginning and end of the specified string if it is not {@code null} or blank.
     *
     * @param s the string to modify
     * @return the modified string with line breaks added at both ends if {@code s} is not {@code null} or blank;
     * otherwise, returns the original string
     */
    public static String affixLineBreaksIfNotBlank(String s) {
        return affixIfNotBlank(s, System.lineSeparator(), System.lineSeparator());
    }

    /**
     * Wraps the given string in quotation marks if it is not {@code null} or blank.
     * Uses “ and ” as the quotation marks to enclose the string.
     *
     * @param s the string to be quoted
     * @return the quoted string if {@code s} is not {@code null} or blank; otherwise, returns the original string
     */
    public static String quote(String s) {
        return affixIfNotBlank(s, "“", "”");
    }

    /**
     * Pads the given string on the left to reach a specified length. If the specified padding character
     * is the {@code null} character, a space is used instead.
     * This method ensures the resulting string reaches a specific minimum length by adding the specified character
     * to the beginning of the string as many times as needed.
     *
     * @param s       the string to be padded
     * @param length  the target length of the string after padding
     * @param padChar the character to use for padding. If this character is the {@code null} character, a space will be used.
     * @return the left-padded string, or {@code null} if the input string is {@code null}
     */
    public static String padLeft(String s, int length, char padChar) {
        if (s == null) return null;

        if (CharHelper.isNull(padChar)) padChar = Separator.SPACE.getCharacter();
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() < length) {
            sb.insert(0, padChar);
        }
        return sb.toString();
    }

    /**
     * Pads the given string on the right to reach a specified length. If the specified padding character
     * is the {@code null} character, a space is used instead.
     * This method ensures the resulting string reaches a specific minimum length by adding the specified character
     * to the end of the string as many times as needed.
     *
     * @param s       the string to be padded
     * @param length  the target length of the string after padding
     * @param padChar the character to use for padding. If this character is the {@code null} character, a space will be used.
     * @return the right-padded string, or {@code null} if the input string is {@code null}
     */
    public static String padRight(String s, int length, char padChar) {
        if (s == null) return null;

        if (CharHelper.isNull(padChar)) padChar = Separator.SPACE.getCharacter();
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() < length) {
            sb.append(padChar);
        }
        return sb.toString();
    }

    /**
     * Splits a string into an array of substrings based on the matches of the given regular expression.
     *
     * @param s     the string to be split
     * @param regex the regular expression to match the delimiter
     * @return an array of substrings split from the input string, or an empty array if either {@code s}
     * or {@code regex} is {@code null} or empty
     */
    public static String[] split(String s, String regex) {
        if (s == null || isNullOrEmpty(regex)) return new String[]{};
        return s.split(regex);
    }

    /**
     * Splits a string into an array of substrings using a single character as the delimiter.
     *
     * @param s         the string to be split
     * @param delimiter the character used as the delimiter
     * @return an array of substrings split from the input string, or an empty array if {@code s} is {@code null}
     */
    public static String[] split(String s, char delimiter) {
        if (s == null) return new String[]{};
        String[] temp = new String[(s.length() / 2) + 1];
        int partCount = 0;
        int i = 0;
        int j = s.indexOf(delimiter);

        while (j >= 0) {
            temp[partCount++] = s.substring(i, j);
            i = j + 1;
            j = s.indexOf(delimiter, i);
        }
        temp[partCount++] = s.substring(i);
        String[] result = new String[partCount];
        System.arraycopy(temp, 0, result, 0, partCount);
        return result;
    }

    /**
     * Splits a string into an array of substrings using a specified string as the delimiter.
     *
     * @param s         the string to be split
     * @param delimiter the string used as the delimiter
     * @return an array of substrings split from the input string, or an empty array if {@code s} is {@code null}
     * or does not contain the delimiter
     */
    public static String[] splitByDelimiter(String s, String delimiter) {
        if (s == null) return new String[]{};

        if (delimiter == null || s.length() < delimiter.length()) return new String[]{s};
        String[] parts = new String[s.length() / 2];
        int partCount = 0;
        int index = s.indexOf(delimiter);
        int startIndex = 0;
        int endIndex;

        while (index >= 0) {
            endIndex = index;

            if (startIndex < endIndex) {
                parts[partCount] = s.substring(startIndex, endIndex);
                partCount++;
            }
            startIndex = endIndex + delimiter.length();
            index = s.indexOf(delimiter, index + 1);
        }

        if (startIndex < s.length() - 1) {
            parts[partCount] = s.substring(startIndex);
            partCount++;
        }
        String[] result = new String[partCount];
        System.arraycopy(parts, 0, result, 0, partCount);
        return result;
    }

    /**
     * Splits a string into an array of substrings using a space character as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitBySpace(String s) {
        return split(s, Separator.SPACE.getCharacter());
    }

    /**
     * Splits a string into an array of substrings using a hyphen character as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitByHyphen(String s) {
        return split(s, Separator.HYPHEN.getCharacter());
    }

    /**
     * Splits a string into an array of substrings using the system's line separator as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitByLineBreak(String s) {
        return splitByDelimiter(s, System.lineSeparator());
    }

    /**
     * Splits a string into an array of substrings using the paragraph mark (¶) followed by optional spaces as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitByParagraphMark(String s) {
        return split(s, "¶[ ]*");
    }

    /**
     * Splits a string into an array of substrings using a comma followed by optional spaces as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitByComma(String s) {
        return split(s, ",[ ]*");
    }

    /**
     * Splits a string into an array of substrings using a tab character followed by optional spaces as the delimiter.
     *
     * @param s the string to be split
     * @return an array of substrings split from the input string
     */
    public static String[] splitByTab(String s) {
        return split(s, "\t[ ]*");
    }

    /**
     * Concatenates two strings, replacing any {@code null} values with empty strings before concatenation.
     *
     * @param a the first string to concatenate
     * @param b the second string to concatenate
     * @return the concatenated result of {@code a} and {@code b}, with {@code null} values replaced by empty strings
     */
    public static String connect(String a, String b) {
        a = defaultIfNull(a);
        b = defaultIfNull(b);
        return a + b;
    }

    /**
     * Joins an array of strings using a specified character as the separator.
     *
     * @param c       the character to use as a separator
     * @param strings the array of strings to join
     * @return a single string composed of all the elements in {@code strings}, separated by {@code c}
     */
    public static String join(char c, String... strings) {
        return join(String.valueOf(c), strings);
    }

    /**
     * Joins a list of strings using a specified character as the separator.
     *
     * @param c       the character to use as a separator
     * @param strings the list of strings to join
     * @return a single string composed of all the elements in {@code strings}, separated by {@code c},
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String join(char c, List<String> strings) {
        if (strings == null) return null;
        return join(String.valueOf(c), strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using a specified string as the separator.
     *
     * @param separator the string to use as a separator
     * @param strings   the array of strings to join
     * @return a single string composed of all the elements in {@code strings}, separated by {@code separator}
     */
    public static String join(String separator, String... strings) {
        StringBuilder sb = new StringBuilder();
        separator = defaultIfNull(separator);

        for (String s : strings) {
            if (isNotNullOrEmpty(s)) {
                if (!sb.isEmpty()) sb.append(separator);
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * Joins a list of strings using a specified string as the separator.
     *
     * @param separator the string to use as a separator
     * @param strings   the list of strings to join
     * @return a single string composed of all the elements in {@code strings}, separated by {@code separator},
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String join(String separator, List<String> strings) {
        if (strings == null) return null;
        return join(separator, strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings without any separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} concatenated together without any separator
     */
    public static String joinWithoutSeparator(String... strings) {
        return join(EMPTY, strings);
    }

    /**
     * Joins a list of strings without any separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} concatenated together without any separator,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithoutSeparator(List<String> strings) {
        if (strings == null) return null;
        return joinWithoutSeparator(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using a space as the separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a space
     */
    public static String joinWithSpace(String... strings) {
        return join(String.valueOf(Separator.SPACE.getCharacter()), strings);
    }

    /**
     * Joins a list of strings using a space as the separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a space,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithSpace(List<String> strings) {
        if (strings == null) return null;
        return joinWithSpace(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using a hyphen as the separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a hyphen
     */
    public static String joinWithHyphen(String... strings) {
        return join(String.valueOf(Separator.HYPHEN.getCharacter()), strings);
    }

    /**
     * Joins a list of strings using a hyphen as the separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a hyphen,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithHyphen(List<String> strings) {
        if (strings == null) return null;
        return joinWithHyphen(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using the system's line separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by the system's line separator
     */
    public static String joinWithLineBreak(String... strings) {
        return join(System.lineSeparator(), strings);
    }

    /**
     * Joins a list of strings using the system's line separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by the system's line separator,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithLineBreak(List<String> strings) {
        if (strings == null) return null;
        return joinWithLineBreak(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using a forward slash as the separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a forward slash
     */
    public static String joinWithSlash(String... strings) {
        return join(String.valueOf('/'), strings);
    }

    /**
     * Joins a list of strings using a forward slash as the separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a forward slash,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithSlash(List<String> strings) {
        if (strings == null) return null;
        return joinWithSlash(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using a backslash as the separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a backslash
     */
    public static String joinWithBackslash(String... strings) {
        return join(String.valueOf('\\'), strings);
    }

    /**
     * Joins a list of strings using a backslash as the separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by a backslash,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithBackslash(List<String> strings) {
        if (strings == null) return null;
        return joinWithBackslash(strings.toArray(new String[0]));
    }

    /**
     * Joins an array of strings using the platform-specific file separator.
     *
     * @param strings the array of strings to join
     * @return a single string composed of all elements in {@code strings} separated by the platform-specific file separator
     */
    public static String joinWithFileSeparator(String... strings) {
        return join(File.separator, strings);
    }

    /**
     * Joins a list of strings using the platform-specific file separator.
     *
     * @param strings the list of strings to join
     * @return a single string composed of all elements in {@code strings} separated by the platform-specific file separator,
     * or {@code null} if {@code strings} is {@code null}
     */
    public static String joinWithFileSeparator(List<String> strings) {
        if (strings == null) return null;
        return joinWithFileSeparator(strings.toArray(new String[0]));
    }

    /**
     * Welds two strings together, making adjustments based on the ending character of the first string and the starting character of the second string.
     * If the ending character of the first string and the starting character of the second string are the same, it removes the duplicate character.
     * If one is a vowel and the other isn't, or if either character is not a letter, it simply concatenates the two strings.
     * Otherwise, it removes the appropriate character to ensure smooth concatenation.
     *
     * @param a the first string to weld
     * @param b the second string to weld
     * @return the welded string, or an empty string if either input is {@code null} or empty
     */
    public static String weld(String a, String b) {
        if (isNullOrEmpty(a) || isNullOrEmpty(b)) return EMPTY;
        char ending = getLastChar(a);
        char start = getFirstChar(b);
        boolean vowel;

        if (ending == start) return removeLastChar(a) + b;

        if (!Character.isLetter(ending) || !Character.isLetter(start)) return a + b;

        if ((vowel = CharHelper.isVowel(ending)) ^ CharHelper.isVowel(start)) return a + b;
        return vowel ? (a + removeFirstChar(b)) : (removeLastChar(a) + b);
    }

    /**
     * Repeats the given string a specified number of times.
     *
     * @param s     the string to repeat
     * @param count the number of times to repeat the string
     * @return the concatenated string after repeating, or {@code null} if the input string is {@code null} or the count is negative
     */
    public static String repeat(String s, int count) {
        if (s == null || count < 0) return null;
        return s.repeat(count);
    }

    /**
     * Trims whitespace from the beginning and end of the given string.
     *
     * @param s the string to trim
     * @return the trimmed string, or {@code null} if the input string is {@code null}
     */
    public static String trim(String s) {
        return s == null ? null : s.trim();
    }

    /**
     * Trims the given string and returns {@code null} if the result is an empty string.
     *
     * @param s the string to trim
     * @return the trimmed string, or {@code null} if the result is empty or the input is {@code null}
     */
    public static String trimToNull(String s) {
        s = trim(s);
        return isNullOrEmpty(s) ? null : s;
    }

    /**
     * Trims the given string and returns an empty string if the input is {@code null}.
     *
     * @param s the string to trim
     * @return the trimmed string, or an empty string if the input is {@code null}
     */
    public static String trimToEmpty(String s) {
        return s == null ? EMPTY : s.trim();
    }

    /**
     * Trims the given string and returns a default value if the result is an empty string.
     * Overloaded to use a predefined default value.
     *
     * @param s the string to trim
     * @return the trimmed string, or {@value #DEFAULT_VALUE} if the result is empty
     */
    public static String trimOrDefault(String s) {
        return trimOrDefault(s, DEFAULT_VALUE);
    }

    /**
     * Trims the given string and returns a specified default value if the result is an empty string.
     *
     * @param s            the string to trim
     * @param defaultValue the default value to return if the trimmed string is empty
     * @return the trimmed string, or the specified default value if the result is empty
     */
    public static String trimOrDefault(String s, String defaultValue) {
        return defaultIfEmpty(trimToEmpty(s), defaultValue);
    }

    /**
     * Strips whitespace from both ends of the given string.
     *
     * @param s the string to strip
     * @return the stripped string, or {@code null} if the input string is {@code null}
     */
    public static String strip(String s) {
        return s == null ? null : s.strip();
    }

    /**
     * Strips whitespace from both ends of the given string and returns {@code null} if the result is an empty string.
     *
     * @param s the string to strip
     * @return the stripped string, or {@code null} if the result is empty or the input is {@code null}
     */
    public static String stripToNull(String s) {
        s = strip(s);
        return isNullOrEmpty(s) ? null : s;
    }

    /**
     * Strips whitespace from both ends of the given string and returns an empty string if the input is {@code null}.
     *
     * @param s the string to strip
     * @return the stripped string, or an empty string if the input is {@code null}
     */
    public static String stripToEmpty(String s) {
        return s == null ? EMPTY : s.strip();
    }

    /**
     * Strips whitespace from both ends of the given string and returns a default value if the result is an empty string.
     * Overloaded to use a predefined default value.
     *
     * @param s the string to strip
     * @return the stripped string, or {@value #DEFAULT_VALUE} if the result is empty
     */
    public static String stripOrDefault(String s) {
        return stripOrDefault(s, DEFAULT_VALUE);
    }

    /**
     * Strips whitespace from both ends of the given string and returns a specified default value if the result is an empty string.
     *
     * @param s            the string to strip
     * @param defaultValue the default value to return if the stripped string is empty
     * @return the stripped string, or the specified default value if the result is empty
     */
    public static String stripOrDefault(String s, String defaultValue) {
        return defaultIfEmpty(stripToEmpty(s), defaultValue);
    }

    /**
     * Removes leading whitespace from the given string.
     *
     * @param s the string from which to remove leading whitespace
     * @return the string with leading whitespace removed
     */
    public static String stripStart(String s) {
        if (isNullOrEmpty(s)) return s;
        int index = 0;

        while (Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        return s.substring(index);
    }

    /**
     * Removes trailing whitespace from the given string.
     *
     * @param s the string from which to remove trailing whitespace
     * @return the string with trailing whitespace removed
     */
    public static String stripEnd(String s) {
        if (isNullOrEmpty(s)) return s;
        int index = s.length() - 1;

        while (Character.isWhitespace(s.charAt(index))) {
            index--;
        }
        return s.substring(0, index + 1);
    }

    /**
     * Strips indent (leading and trailing whitespace) from the given string.
     *
     * @param s the string from which to strip indent
     * @return the string with indent stripped
     */
    public static String stripIndent(String s) {
        s = stripStart(s);
        return stripEnd(s);
    }

    /**
     * Normalizes a string to its ASCII form by removing diacritics (accents) and then filters out non-ASCII characters.
     *
     * @param s the string to normalize
     * @return the normalized ASCII string, or the original string if it is {@code null} or empty
     */
    public static String normalize(String s) {
        if (isNullOrEmpty(s)) return s;
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return RegexFilter.EXCEPT_ASCII_PATTERN.matcher(normalized).replaceAll(EMPTY);
    }

    /**
     * Normalizes a string to its ASCII form and removes all characters that are not alphabetic letters.
     *
     * @param s the string to normalize and clean
     * @return the normalized string containing only ASCII alphabetic characters,
     * or the original string if it is {@code null} or empty
     */
    public static String normalizeAlpha(String s) {
        s = normalize(s);
        return StringFilter.keepAsciiAlpha(s);
    }

    /**
     * Normalizes a string to its ASCII form and removes all characters that are not alphanumeric.
     *
     * @param s the string to normalize and clean
     * @return the normalized string containing only ASCII alphanumeric characters,
     * or the original string if it is {@code null} or empty
     */
    public static String normalizeAlphanumeric(String s) {
        s = normalize(s);
        return StringFilter.keepAsciiAlphanumeric(s);
    }

    /**
     * Normalizes a string to its ASCII form and removes all characters except alphabetic letters and whitespaces.
     *
     * @param s the string to normalize and clean
     * @return the normalized string containing only ASCII alphabetic characters and whitespaces,
     * or the original string if it is {@code null} or empty
     */
    public static String normalizeAlphaWhitespace(String s) {
        s = normalize(s);
        return StringFilter.keepAsciiAlphaOrWhitespaces(s);
    }

    /**
     * Normalizes a string to its ASCII form and removes all characters except alphanumeric characters and whitespaces.
     *
     * @param s the string to normalize and clean
     * @return the normalized string containing only ASCII alphanumeric characters and whitespaces,
     * or the original string if it is {@code null} or empty
     */
    public static String normalizeAlphanumericWhitespace(String s) {
        s = normalize(s);
        return StringFilter.keepAlphanumericOrWhitespaces(s);
    }

    /**
     * Strips accents from a string, leaving behind the base characters.
     *
     * @param s the string from which to strip accents
     * @return the string with accents removed, or the original string if it is {@code null} or empty
     */
    public static String stripAccents(String s) {
        if (isNullOrEmpty(s)) return s;
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD);
        return RegexFilter.DIACRITIC_PATTERN.matcher(normalized).replaceAll(EMPTY);
    }

    /**
     * Converts a given string to uppercase.
     *
     * @param s the string to convert
     * @return the uppercase version of the string, or the original string if it is {@code null} or empty
     */
    public static String toUppercase(String s) {
        if (isNullOrEmpty(s)) return s;
        return s.toUpperCase();
    }

    /**
     * Converts a given string to lowercase.
     *
     * @param s the string to convert
     * @return the lowercase version of the string, or the original string if it is {@code null} or empty
     */
    public static String toLowercase(String s) {
        if (isNullOrEmpty(s)) return s;
        return s.toLowerCase();
    }

    /**
     * Converts the first character of the specified string to uppercase. All other characters
     * in the string are converted to lowercase.
     *
     * @param s the input string to be modified
     * @return a string with the first character converted to uppercase, if applicable
     */
    public static String capitalizeFirst(String s) {
        return capitalize(s, 1L);
    }

    /**
     * Converts the first character of each word in the specified string to uppercase. All other characters
     * in each word are converted to lowercase.
     *
     * @param s the input string to be modified
     * @return a string with the first character of each word capitalized and the rest in lowercase
     */
    public static String capitalize(String s) {
        return capitalize(s, Long.MAX_VALUE);
    }

    /**
     * Converts the first N characters of the specified string to uppercase, where N is determined by
     * the {@code remainingMatches} parameter. Once the limit is reached, the rest of the characters are
     * converted to lowercase.
     *
     * @param s                the input string to be modified
     * @param remainingMatches the number of characters to be converted to uppercase
     * @return a modified string based on the {@code remainingMatches} criteria
     */
    private static String capitalize(String s, long remainingMatches) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        boolean upperPending = true;
        long replacementCount = 0L;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) upperPending = true;
            else if (upperPending && replacementCount < remainingMatches) {
                chars[i] = Character.toUpperCase(c);
                replacementCount++;
                upperPending = false;
            } else chars[i] = Character.toLowerCase(c);
        }
        return new String(chars);
    }

    /**
     * Converts the first character of the specified string to uppercase. This method
     * does not alter the case of the other characters in the string.
     *
     * @param s the input string to be modified
     * @return a string with its first character converted to uppercase, if applicable
     */
    public static String capitalizeStart(String s) {
        return capitalizeStarts(s, 1L);
    }

    /**
     * Converts the first character of each word in the specified string to uppercase.
     * This method does not alter the case of the other characters within each word.
     *
     * @param s the input string to be modified
     * @return a string with the first character of each word converted to uppercase
     */
    public static String capitalizeStarts(String s) {
        return capitalizeStarts(s, Long.MAX_VALUE);
    }

    /**
     * Converts the first character of each word in the specified string to uppercase,
     * limited by the specified number of matches. This method does not alter the case
     * of the other characters within each word after the specified number of matches.
     *
     * @param s                the input string to be modified
     * @param remainingMatches the maximum number of words to apply the capitalization
     * @return a string with the first character of each word converted to uppercase,
     * up to the specified number of matches
     */
    private static String capitalizeStarts(String s, long remainingMatches) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        boolean upperPending = true;
        long replacementCount = 0L;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) upperPending = true;
            else if (upperPending) {
                if (replacementCount >= remainingMatches) break;
                chars[i] = Character.toUpperCase(c);
                replacementCount++;
                upperPending = false;
            }
        }
        return new String(chars);
    }

    /**
     * Converts the first character of the specified string to lowercase. All other characters
     * in the string are converted to uppercase.
     *
     * @param s the input string to be modified
     * @return a string with the first character converted to lowercase, if applicable
     */
    public static String toUppercaseExceptStart(String s) {
        return toUppercaseExceptStarts(s, 1L);
    }

    /**
     * Converts the first character of each word in the specified string to lowercase. All other characters
     * in each word are converted to uppercase.
     *
     * @param s the input string to be modified
     * @return a string with the first character of each word in lowercase and the rest in uppercase
     */
    public static String toUppercaseExceptStarts(String s) {
        return toUppercaseExceptStarts(s, Long.MAX_VALUE);
    }

    /**
     * Converts the first N characters of the specified string to lowercase, where N is determined by
     * the {@code remainingMatches} parameter. Once the limit is reached, the rest of the characters are
     * converted to uppercase.
     *
     * @param s                the input string to be modified
     * @param remainingMatches the number of characters to be converted to lowercase
     * @return a modified string based on the {@code remainingMatches} criteria
     */
    private static String toUppercaseExceptStarts(String s, long remainingMatches) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        boolean lowerPending = true;
        long replacementCount = 0L;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) lowerPending = true;
            else if (lowerPending && replacementCount < remainingMatches) {
                chars[i] = Character.toLowerCase(c);
                replacementCount++;
                lowerPending = false;
            } else chars[i] = Character.toUpperCase(c);
        }
        return new String(chars);
    }

    /**
     * Converts the first character of the specified string to lowercase. This method
     * does not alter the case of the other characters in the string.
     *
     * @param s the input string to be modified
     * @return a string with its first character converted to lowercase, if applicable
     */
    public static String uncapitalizeStart(String s) {
        return uncapitalizeStarts(s, 1L);
    }

    /**
     * Converts the first character of each word in the specified string to lowercase.
     * This method does not alter the case of the other characters within each word.
     *
     * @param s the input string to be modified
     * @return a string with the first character of each word converted to lowercase
     */
    public static String uncapitalizeStarts(String s) {
        return uncapitalizeStarts(s, Long.MAX_VALUE);
    }

    /**
     * Converts the first character of each word in the specified string to lowercase,
     * limited by the specified number of matches. This method does not alter the case
     * of the other characters within each word after the specified number of matches.
     *
     * @param s                the input string to be modified
     * @param remainingMatches the maximum number of words to apply the lowercase conversion
     * @return a string with the first character of each word converted to lowercase,
     * up to the specified number of matches
     */
    private static String uncapitalizeStarts(String s, long remainingMatches) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        boolean lowerPending = true;
        long replacementCount = 0L;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c)) lowerPending = true;
            else if (lowerPending) {
                if (replacementCount >= remainingMatches) break;
                chars[i] = Character.toLowerCase(c);
                replacementCount++;
                lowerPending = false;
            }
        }
        return new String(chars);
    }

    /**
     * Swaps uppercase characters to lowercase and vice versa in a given string.
     *
     * @param s the string whose case is to be swapped
     * @return a new string with all uppercase characters converted to lowercase
     * and all lowercase characters converted to uppercase
     */
    public static String swapCase(String s) {
        if (isNullOrEmpty(s)) return s;
        StringBuilder sb = new StringBuilder(s.length());

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    /**
     * Transforms the case of the input string randomly. Each character in the string
     * that is a letter will be randomly transformed to either uppercase or lowercase.
     * Non-letter characters are not affected by this transformation.
     *
     * @param s the input string to be converted
     * @return a new string where the case of each letter has been randomly transformed,
     * or the original string if it is {@code null} or empty
     */
    public static String randomCase(String s) {
        return randomCase(s, null);
    }

    /**
     * Transforms the case of the input string randomly. Each character in the string
     * that is a letter will be randomly transformed to either uppercase or lowercase.
     * Non-letter characters are not affected by this transformation.
     *
     * @param s    the input string to be converted
     * @param seed the seed used for the randomization, or {@code null} for a random seed
     * @return a new string where the case of each letter has been randomly transformed,
     * or the original string if it is {@code null} or empty
     */
    public static String randomCase(String s, Long seed) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        Random r = new Random();

        if (seed != null) r.setSeed(seed);

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (r.nextBoolean()) chars[i] = Character.toUpperCase(chars[i]);
                else chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    /**
     * Converts a given string into camelCase format.
     * <p>
     * This method transforms the input string to camelCase, where the first letter of the
     * first word is lowercase, and the first letter of each subsequent word is capitalized
     * while the rest are in lowercase. Non-alphanumeric characters such as whitespace,
     * underscores (_), and hyphens (-) are removed, and they signify the start of a new word.
     *
     * @param s the input string to be converted
     * @return the converted string in camelCase format; if the input is {@code null} or empty, returns the original input
     */
    public static String toCamelCase(String s) {
        if (isNullOrEmpty(s)) return s;
        StringBuilder sb = new StringBuilder();
        boolean upperPending = false;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c) || c == '_' || c == '-') upperPending = true;
            else if (Character.isLetterOrDigit(c)) {
                if (upperPending) {
                    sb.append(Character.toUpperCase(c));
                    upperPending = false;
                } else sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * Converts a given string into PascalCase format.
     * <p>
     * This method transforms the input string to PascalCase, where the first letter of
     * each word is capitalized and the rest are in lowercase. Non-alphanumeric characters
     * such as whitespace, underscores (_), and hyphens (-) are removed, and they signify
     * the start of a new word.
     *
     * @param s the input string to be converted
     * @return the converted string in PascalCase format; if the input is {@code null} or empty, returns the original input
     */
    public static String toPascalCase(String s) {
        if (isNullOrEmpty(s)) return s;
        StringBuilder sb = new StringBuilder();
        boolean upperPending = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c) || c == '_' || c == '-') upperPending = true;
            else if (Character.isLetterOrDigit(c)) {
                if (upperPending) {
                    sb.append(Character.toUpperCase(c));
                    upperPending = false;
                } else sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    /**
     * Transforms the case of a string to a specified format. The function supports various case styles
     * typically used in programming such as camelCase, PascalCase, snake_case, and others. This method
     * is useful for standardizing string formats for code identifiers or data processing.
     * <p>
     * Supported Naming Conventions:
     * <ul>
     *     <li>PASCAL_CASE: "PascalCase"</li>
     *     <li>CAMEL_CASE: "camelCase"</li>
     *     <li>SNAKE_CASE: "snake_case"</li>
     *     <li>KEBAB_CASE: "kebab-case"</li>
     *     <li>FLAT_CASE: "flatcase"</li>
     *     <li>UPPER_FLAT_CASE: "UPPERFLATCASE"</li>
     *     <li>PASCAL_SNAKE_CASE: "Pascal_Snake_Case"</li>
     *     <li>CAMEL_SNAKE_CASE: "camel_Snake_Case"</li>
     *     <li>SCREAMING_SNAKE_CASE: "SCREAMING_SNAKE_CASE"</li>
     *     <li>TRAIN_CASE: "Train-Case"</li>
     *     <li>COBOL_CASE: "COBOL-CASE"</li>
     * </ul>
     * <p>
     * Non-alphanumeric characters in the input are treated as word boundaries and are not included in the
     * output unless they are part of the target case style's formatting.
     *
     * @param s         the string to convert
     * @param caseStyle the case style to apply
     * @return the converted string, or the original string if it is {@code null} or empty
     */
    public static String convertCase(String s, CaseStyle caseStyle) {
        if (isNullOrEmpty(s) || caseStyle == null) return s;
        s += Separator.SPACE.getCharacter();
        char[] chars = s.toCharArray();
        char prevChar = chars[0];
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < chars.length - 1; n++) {
            char c = chars[n];
            char nextChar = chars[n + 1];

            if (!CharHelper.isDelimiter(prevChar) && CharHelper.isDelimiter(c) && Character.isLetterOrDigit(nextChar)) {
                switch (caseStyle) {
                    case SNAKE_CASE, PASCAL_SNAKE_CASE, CAMEL_SNAKE_CASE, SCREAMING_SNAKE_CASE -> sb.append('_');
                    case KEBAB_CASE, TRAIN_CASE, COBOL_CASE -> sb.append('-');
                }
            } else {
                if (!Character.isLetterOrDigit(c)) continue;

                switch (caseStyle) {
                    case PASCAL_CASE, PASCAL_SNAKE_CASE, TRAIN_CASE -> {
                        if (sb.isEmpty() || CharHelper.isDelimiter(prevChar)) sb.append(Character.toUpperCase(c));
                        else sb.append(Character.toLowerCase(c));
                    }
                    case CAMEL_CASE, CAMEL_SNAKE_CASE -> {
                        if (!sb.isEmpty() && CharHelper.isDelimiter(prevChar)) sb.append(Character.toUpperCase(c));
                        else sb.append(Character.toLowerCase(c));
                    }
                    case SNAKE_CASE, KEBAB_CASE, FLAT_CASE -> sb.append(Character.toLowerCase(c));
                    case UPPER_FLAT_CASE, SCREAMING_SNAKE_CASE, COBOL_CASE -> sb.append(Character.toUpperCase(c));
                }
            }
            prevChar = c;
        }
        return sb.toString();
    }

    /**
     * Reverses the characters of the given string.
     *
     * @param s the string to be reversed
     * @return the reversed string, or the original string if it is {@code null} or empty
     */
    public static String reverse(String s) {
        if (isNullOrEmpty(s)) return s;
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Masks all non-space characters in a string with asterisks.
     *
     * @param s the string to be masked
     * @return the masked string where all characters are replaced by '*', or the original string if it is {@code null} or empty
     */
    public static String mask(String s) {
        return mask(s, '*');
    }

    /**
     * Masks all non-space characters in a string with a specified replacement character.
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String mask(String s, char replacement) {
        if (isNullOrEmpty(s)) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');
        return RegexFilter.EXCEPT_SPACE_PATTERN.matcher(s).replaceAll(String.valueOf(replacement));
    }

    /**
     * Masks a specific range of characters in a string.
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @param start       the starting index (inclusive) of the range to mask
     * @param end         the ending index (inclusive) of the range to mask
     * @return a masked string with the specified range masked; or the original string
     * if it is {@code null} or empty, or if the range is invalid
     */
    public static String mask(String s, char replacement, int start, int end) {
        if (isNullOrEmpty(s)) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (start > end || start < 0 || end >= s.length()) return s;
        return s.substring(0, start) + String.valueOf(replacement).repeat(end - start + 1) + s.substring(end + 1);
    }

    /**
     * Masks the beginning of a string with asterisks, leaving the last four characters visible.
     *
     * @param s the string to be masked
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskStart(String s) {
        return maskStart(s, '*');
    }

    /**
     * Masks the beginning of a string with a specified replacement character, leaving the last four characters visible.
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskStart(String s, char replacement) {
        if (isNullOrEmpty(s)) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() > 4) return s.replaceAll("\\S(?=.{4})", String.valueOf(replacement));
        return String.valueOf(replacement).repeat(s.length());
    }

    /**
     * Masks the beginning of a string, leaving a specified number of characters at the end unmasked.
     *
     * @param s             the string to be masked
     * @param replacement   the character used for masking, which, by default, is '*'
     * @param unmaskedChars the number of characters at the end of the string to leave unmasked
     * @return a masked string with the specified end characters unmasked;
     * or the original string if it is {@code null} or empty, or if {@code unmaskedChars} is equal or less than 0;
     * but if the string length is less than or equal to {@code unmaskedChars}, the entire string is masked
     */
    public static String maskStart(String s, char replacement, int unmaskedChars) {
        if (isNullOrEmpty(s) || unmaskedChars <= 0) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() <= unmaskedChars) return String.valueOf(replacement).repeat(s.length());
        return String.valueOf(replacement).repeat(s.length() - unmaskedChars) + s.substring(s.length() - unmaskedChars);
    }

    /**
     * Masks the middle characters of a given string with asterisks, depending on the string's length.
     * Utilizes different masking rules based on the string length:
     * <ul>
     * <li>If length ≤ 4, replaces all characters.</li>
     * <li>If length between 5 and 8, masks all except the first and last characters.</li>
     * <li>If length between 9 and 12, masks all except the first two and last two characters.</li>
     * <li>If length > 12, masks all except the first three and last three characters.</li>
     * </ul>
     *
     * @param s the string to be masked
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskMiddle(String s) {
        return maskMiddle(s, '*');
    }

    /**
     * Masks the middle characters of a given string using a specified replacement character, depending on the string's length.
     * Utilizes different masking rules based on the string length:
     * <ul>
     * <li>If length ≤ 4, replaces all characters.</li>
     * <li>If length between 5 and 8, masks all except the first and last characters.</li>
     * <li>If length between 9 and 12, masks all except the first two and last two characters.</li>
     * <li>If length > 12, masks all except the first three and last three characters.</li>
     * </ul>
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskMiddle(String s, char replacement) {
        if (isNullOrEmpty(s)) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() <= 4) return String.valueOf(replacement).repeat(s.length());

        if (s.length() <= 8) return s.replaceAll("(?<=.)\\S(?=.)", String.valueOf(replacement));

        if (s.length() <= 12) return s.replaceAll("(?<=.{2})\\S(?=.{2})", String.valueOf(replacement));
        return s.replaceAll("(?<=.{3})\\S(?=.{3})", String.valueOf(replacement));
    }

    /**
     * Masks a specific number of characters in the middle of a string, leaving the rest unmasked.
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @param maskedChars the number of characters in the middle of the string to mask
     * @return a masked string with the middle characters masked;
     * or the original string if it is {@code null} or empty, or if {@code maskedChars} is equal or less than 0;
     * but if the string length is less than or equal to {@code maskedChars}, the entire string is masked
     */
    public static String maskMiddle(String s, char replacement, int maskedChars) {
        if (isNullOrEmpty(s) || maskedChars <= 0) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() <= maskedChars) return String.valueOf(replacement).repeat(s.length());
        int start = (s.length() - maskedChars) / 2;
        int end = start + maskedChars;
        return s.substring(0, start) + String.valueOf(replacement).repeat(maskedChars) + s.substring(end);
    }

    /**
     * Masks the end of a string with asterisks, leaving the first four characters visible.
     *
     * @param s the string to be masked
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskEnd(String s) {
        return maskEnd(s, '*');
    }

    /**
     * Masks the end of a string with a specified replacement character, leaving the first four characters visible.
     *
     * @param s           the string to be masked
     * @param replacement the character used for masking, which, by default, is '*'
     * @return the masked string, or the original string if it is {@code null} or empty
     */
    public static String maskEnd(String s, char replacement) {
        if (isNullOrEmpty(s)) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() > 4) return s.replaceAll("(?<=.{4})\\S", String.valueOf(replacement));
        return String.valueOf(replacement).repeat(s.length());
    }

    /**
     * Masks the end of a string, leaving a specified number of characters at the beginning unmasked.
     *
     * @param s             the string to be masked
     * @param replacement   the character used for masking, which, by default, is '*'
     * @param unmaskedChars the number of characters at the beginning of the string to leave unmasked
     * @return a masked string with the specified beginning characters unmasked;
     * or the original string if it is {@code null} or empty, or if {@code unmaskedChars} is equal or less than 0;
     * but if the string length is less than or equal to {@code unmaskedChars}, the entire string is masked
     */
    public static String maskEnd(String s, char replacement, int unmaskedChars) {
        if (isNullOrEmpty(s) || unmaskedChars <= 0) return s;
        replacement = CharHelper.defaultIfNull(replacement, '*');

        if (s.length() <= unmaskedChars) return String.valueOf(replacement).repeat(s.length());
        return s.substring(0, unmaskedChars) + String.valueOf(replacement).repeat(s.length() - unmaskedChars);
    }

    /**
     * Shuffles the characters of a string.
     * Uses the Fisher-Yates algorithm for efficient, in-place shuffling.
     *
     * @param s the string to shuffle
     * @return the shuffled string, or the original string if it is {@code null} or empty
     */
    public static String shuffle(String s) {
        return shuffle(s, null);
    }

    /**
     * Shuffles the characters of a string.
     * Uses the Fisher-Yates algorithm for efficient, in-place shuffling.
     *
     * @param s    the string to shuffle
     * @param seed the seed used for the randomization, or {@code null} for a random seed
     * @return the shuffled string, or the original string if it is {@code null} or empty
     */
    public static String shuffle(String s, Long seed) {
        if (isNullOrEmpty(s)) return s;
        char[] chars = s.toCharArray();
        Random r = new Random();

        if (seed != null) r.setSeed(seed);

        for (int i = chars.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);
            char temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;
        }
        return new String(chars);
    }

    /**
     * Extracts a substring from a string, with support for negative indices. Negative start or end indices are treated
     * as offsets from the end of the string.
     *
     * @param s          the original string
     * @param startIndex the starting index of the substring, inclusive. If negative, it is treated as an offset
     *                   from the end of the string.
     * @param endIndex   the ending index of the substring, exclusive. If negative, it is treated as an offset
     *                   from the end of the string.
     * @return the extracted substring or the original string if it is {@code null} or empty
     */
    public static String substring(String s, int startIndex, int endIndex) {
        if (isNullOrEmpty(s)) return s;

        if (startIndex < 0) startIndex = s.length() + startIndex;
        startIndex = IntegerHelper.defaultByRange(startIndex, 0, s.length());

        if (endIndex < 0) endIndex = s.length() + endIndex;
        endIndex = IntegerHelper.defaultByRange(endIndex, startIndex, s.length());
        return s.substring(startIndex, endIndex);
    }

    /**
     * Extracts the portion of a string before the first occurrence of a specified separator.
     *
     * @param s         the original string
     * @param separator the string to search for
     * @return the substring before the first occurrence of the separator, or the original string if the separator
     * is not found or {@code null}
     */
    public static String substringBefore(String s, String separator) {
        if (isNullOrEmpty(s) || separator == null) return s;

        if (separator.isEmpty()) return EMPTY;
        final int index = s.indexOf(separator);

        if (index == INDEX_NOT_FOUND) return s;
        return s.substring(0, index);
    }

    /**
     * Extracts the substring between two substrings, using the first occurrence of each.
     *
     * @param s     the original string
     * @param open  the string defining the start of the target substring
     * @param close the string defining the end of the target substring
     * @return the substring between the specified start and end strings, or {@code null} if any input is {@code null}
     * or the delimiters are not found
     */
    public static String substringBetween(String s, String open, String close) {
        if (isNullOrEmpty(s) || isNullOrEmpty(open) || isNullOrEmpty(close)) return null;
        int start = s.indexOf(open);

        if (start != INDEX_NOT_FOUND) {
            final int end = s.indexOf(close, start + open.length());

            if (end != INDEX_NOT_FOUND) return s.substring(start + open.length(), end);
        }
        return null;
    }

    /**
     * Extracts the portion of a string after the first occurrence of a specified separator.
     *
     * @param s         the original string
     * @param separator the string to search for
     * @return the substring after the first occurrence of the separator, or an empty string if the separator is not found
     */
    public static String substringAfter(String s, String separator) {
        if (isNullOrEmpty(s)) return s;

        if (separator == null) return EMPTY;
        final int index = s.indexOf(separator);

        if (index == INDEX_NOT_FOUND) return EMPTY;
        return s.substring(index + separator.length());
    }

    /**
     * Replaces every occurrence of a character in a string with another character.
     * It utilizes {@code replace(String s, String occurrence, String replacement)}
     * by converting characters to strings.
     *
     * @param s           the original string
     * @param occurrence  the character to be replaced
     * @param replacement the character to replace with
     * @return the modified string with replacements, or {@code s} if it is {@code null} or empty
     */
    public static String replace(String s, char occurrence, char replacement) {
        if (isNullOrEmpty(s)) return s;
        return s.replace(occurrence, replacement);
    }

    /**
     * Replaces all occurrences of a substring within a string with another substring.
     *
     * @param s           the original string
     * @param occurrence  the substring to find and replace
     * @param replacement the substring to replace with
     * @return the modified string with replacements, or {@code s} if it is {@code null} or empty
     */
    public static String replace(String s, String occurrence, String replacement) {
        if (isNullOrEmpty(s) || isNullOrEmpty(occurrence) || replacement == null) return s;
        return s.replace(occurrence, replacement);
    }

    /**
     * Replaces all occurrences of a substring within a string with another substring.
     * This is a legacy method that was used before the optimizations in Java 11.
     *
     * @param s           the original string
     * @param occurrence  the substring to find and replace
     * @param replacement the substring to replace with
     * @return the modified string with replacements, or {@code s} if it is {@code null} or empty
     */
    public static String replaceWith(String s, String occurrence, String replacement) {
        if (isNullOrEmpty(s) || isNullOrEmpty(occurrence) || replacement == null) return s;
        int i = 0;

        if ((i = s.indexOf(occurrence, i)) >= 0) {
            char[] strChars = s.toCharArray();
            char[] replacementChars = replacement.toCharArray();
            int occurrenceLength = occurrence.length();
            StringBuilder sb = new StringBuilder(strChars.length);
            sb.append(strChars, 0, i).append(replacementChars);
            i += occurrenceLength;
            int j = i;

            while ((i = s.indexOf(occurrence, i)) > 0) {
                sb.append(strChars, j, i - j).append(replacementChars);
                i += occurrenceLength;
                j = i;
            }
            sb.append(strChars, j, strChars.length - j);
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }

    /**
     * Replaces a substring between specified indices with a replacement string.
     *
     * @param s           the original string
     * @param startIndex  the beginning index, inclusive
     * @param endIndex    the ending index, exclusive
     * @param replacement the string to replace the specified substring
     * @return the modified string
     */
    public static String replaceByIndex(String s, int startIndex, int endIndex, String replacement) {
        if (isNullOrEmpty(s)) return s;

        if (startIndex < 0) startIndex = s.length() + startIndex;

        if (!IntegerHelper.isBetween(startIndex, 0, s.length() - 1)) return s;

        if (endIndex < 0) endIndex = s.length() + endIndex;

        if (!IntegerHelper.isBetween(endIndex, 0, s.length() - 1)) return s;

        if (Math.abs(endIndex) < Math.abs(startIndex)) return s;
        return new StringBuilder(s).replace(startIndex, endIndex, replacement).toString();
    }

    /**
     * Replaces the first character of the given string with a replacement string.
     *
     * @param s           the original string
     * @param replacement the replacement string
     * @return the string with the first character replaced
     */
    public static String replaceFirstChar(String s, String replacement) {
        if (isNotNullOrEmpty(s) && replacement != null) s = replacement + s.substring(1);
        return s;
    }

    /**
     * Replaces the last character of the given string with a replacement string.
     *
     * @param s           the original string
     * @param replacement the replacement string
     * @return the string with the last character replaced
     */
    public static String replaceLastChar(String s, String replacement) {
        if (isNotNullOrEmpty(s) && replacement != null) s = s.substring(0, s.length() - 1) + replacement;
        return s;
    }

    /**
     * Replaces the first occurrence of a substring within the given string with a replacement string.
     *
     * @param s           the original string
     * @param occurrence  the substring to be replaced
     * @param replacement the replacement string
     * @return the string with the first occurrence of the substring replaced
     */
    public static String replaceOnce(String s, String occurrence, String replacement) {
        int index = indexOf(s, occurrence);

        if (index == -1) return s;
        return s.substring(0, index).concat(replacement).concat(s.substring(index + occurrence.length()));
    }

    /**
     * Replaces the final occurrence of a substring within the given string with a replacement string.
     *
     * @param s           the original string
     * @param occurrence  the substring to be replaced
     * @param replacement the replacement string
     * @return the string with the final occurrence of the substring replaced
     */
    public static String replaceFinal(String s, String occurrence, String replacement) {
        if (isNullOrEmpty(s)) return s;
        int lastIndex = s.lastIndexOf(occurrence);
        if (lastIndex < 0) return s;
        String tail = s.substring(lastIndex).replaceFirst(occurrence, replacement);
        return s.substring(0, lastIndex) + tail;
    }

    /**
     * Replaces the first occurrence of a regex pattern in the given string with a replacement string.
     *
     * @param s           the original string
     * @param regex       the regex pattern to match
     * @param replacement the replacement string
     * @return the string with the first regex match replaced
     */
    public static String replaceFirst(String s, String regex, String replacement) {
        if (isNotNullOrEmpty(s) && replacement != null) return s.replaceFirst(regex, replacement);
        return s;
    }

    /**
     * Replaces the last occurrence of a regex pattern in the given string with a replacement string.
     *
     * @param s           the original string
     * @param regex       the regex pattern to match
     * @param replacement the replacement string
     * @return the string with the last regex match replaced
     */
    public static String replaceLast(String s, String regex, String replacement) {
        return s.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

    /**
     * Replaces each occurrence of strings in the given array with corresponding replacement strings.
     *
     * @param s            the original string
     * @param occurrences  the array of strings to be replaced
     * @param replacements the array of replacement strings
     * @return the string with all specified strings replaced
     */
    public static String replaceEach(String s, String[] occurrences, String[] replacements) {
        if (occurrences == null || replacements == null) return s;

        for (int n = 0; n < occurrences.length && n < replacements.length; n++) {
            s = replace(s, occurrences[n], replacements[n]);
        }
        return s;
    }

    /**
     * Replaces all occurrences of a regex pattern in the given string with a replacement string.
     *
     * @param s           the original string
     * @param regex       the regex pattern to match
     * @param replacement the replacement string
     * @return the string with all regex matches replaced
     */
    public static String replaceAll(String s, String regex, String replacement) {
        if (isNotNullOrEmpty(s) && replacement != null) return s.replaceAll(regex, replacement);
        return s;
    }

    /**
     * Replaces the content of a specific capturing group identified by its index in each match of a regex pattern
     * within the string.
     *
     * @param s           the original string
     * @param regex       the regex pattern containing the group
     * @param groupIndex  the index of the capturing group to replace
     * @param replacement the replacement string
     * @return the modified string
     */
    public static String replaceGroup(String s, String regex, int groupIndex, String replacement) {
        return replaceGroup(s, regex, groupIndex, 1, replacement);
    }

    /**
     * Replaces a specific capturing group within a regex match in a string. If the regex has multiple matches,
     * it targets the occurrence specified by {@code groupOccurrence}.
     *
     * @param s               the original string
     * @param regex           the regular expression pattern containing the group
     * @param groupIndex      the index of the capturing group to replace
     * @param groupOccurrence the occurrence of the match to target
     * @param replacement     the replacement string
     * @return the modified string with the specified group replaced, or the original string if no match
     * is found or parameters are invalid
     */
    public static String replaceGroup(String s, String regex, int groupIndex, int groupOccurrence, String replacement) {
        if (s == null || replacement == null) return s;
        Matcher matcher = Pattern.compile(regex).matcher(s);

        for (int i = 0; i < groupOccurrence; i++) {
            if (!matcher.find()) return s;
        }

        if (groupIndex > matcher.groupCount() || matcher.group(groupIndex) == null) return s;
        return new StringBuilder(s).replace(matcher.start(groupIndex), matcher.end(groupIndex), replacement).toString();
    }

    /**
     * Replaces the start of the string matching a given prefix with a replacement string.
     *
     * @param s           the original string
     * @param prefix      the prefix to match and replace
     * @param replacement the replacement string
     * @return the modified string
     */
    public static String replaceStart(String s, String prefix, String replacement) {
        if (startsWith(s, prefix) && replacement != null) return replacement + s.substring(prefix.length());
        return s;
    }

    /**
     * Replaces the start of the string with a replacement string if it starts with any of the given prefixes.
     *
     * @param s           the original string
     * @param replacement the replacement string
     * @param prefixes    an array of prefixes to check against the start of the string
     * @return the string with the start replaced if it matches any of the prefixes, or the original string otherwise
     */
    public static String replaceAnyStart(String s, String replacement, String... prefixes) {
        for (String prefix : prefixes) {
            if (startsWith(s, prefix)) return replaceStart(s, prefix, replacement);
        }
        return s;
    }

    /**
     * Iteratively replaces the start of the string with the corresponding replacement if it matches
     * any of the given prefixes.
     *
     * @param s            the original string
     * @param prefixes     an array of prefixes to check against the start of the string
     * @param replacements an array of replacement strings corresponding to each prefix
     * @return the string with the start replaced if it matches any of the prefixes, or the original string otherwise
     */
    public static String replaceEachStart(String s, String[] prefixes, String[] replacements) {
        if (prefixes == null || replacements == null) return s;

        for (int n = 0; n < prefixes.length && n < replacements.length; n++) {
            String result = replaceStart(s, prefixes[n], replacements[n]);

            if (!equals(s, result)) return result;
        }
        return s;
    }

    /**
     * Replaces the end of the string matching a given suffix with a replacement string.
     *
     * @param s           the original string
     * @param suffix      the suffix to match and replace
     * @param replacement the replacement string
     * @return the modified string
     */
    public static String replaceEnd(String s, String suffix, String replacement) {
        if (endsWith(s, suffix) && replacement != null)
            return s.substring(0, s.length() - suffix.length()) + replacement;
        return s;
    }

    /**
     * Replaces the end of the string with a replacement string if it ends with any of the given suffixes.
     *
     * @param s           the original string
     * @param replacement the replacement string
     * @param suffixes    an array of suffixes to check against the end of the string
     * @return the string with the end replaced if it matches any of the suffixes, or the original string otherwise
     */
    public static String replaceAnyEnd(String s, String replacement, String... suffixes) {
        for (String suffix : suffixes) {
            if (endsWith(s, suffix)) return replaceEnd(s, suffix, replacement);
        }
        return s;
    }

    /**
     * Iteratively replaces the end of the string with the corresponding replacement if it matches
     * any of the given suffixes.
     *
     * @param s            the original string
     * @param suffixes     an array of suffixes to check against the end of the string
     * @param replacements an array of replacement strings corresponding to each suffix
     * @return the string with the end replaced if it matches any of the suffixes, or the original string otherwise
     */
    public static String replaceEachEnd(String s, String[] suffixes, String[] replacements) {
        if (suffixes == null || replacements == null) return s;

        for (int n = 0; n < suffixes.length && n < replacements.length; n++) {
            String result = replaceEnd(s, suffixes[n], replacements[n]);

            if (!equals(s, result)) return result;
        }
        return s;
    }

    /**
     * Replaces the content between two specific characters in a string, while keeping the delimiters.
     *
     * @param s           the original string
     * @param opening     the opening delimiter character
     * @param closing     the closing delimiter character
     * @param replacement the string to replace the content between the delimiters
     * @return the modified string, or the original if any of the delimiters is {@code null}
     */
    public static String replaceBetweenChars(String s, char opening, char closing, String replacement) {
        if (CharHelper.isNull(opening) || CharHelper.isNull(closing)) return s;
        String regex = String.format("\\Q%1$s\\E.*?\\Q%2$s\\E", opening, closing);
        return replaceAll(s, regex, opening + replacement + closing);
    }

    /**
     * Replaces the content between two instances of the same delimiter character in a string,
     * while keeping the delimiters.
     *
     * @param s           the original string
     * @param delimiter   the character that acts as both the opening and closing delimiter
     * @param replacement the string to replace the content between the delimiters
     * @return the modified string, or the original if the delimiter is {@code null}
     */
    public static String replaceBetweenChars(String s, char delimiter, String replacement) {
        return replaceBetweenChars(s, delimiter, delimiter, replacement);
    }

    /**
     * Replaces the content between parentheses in a string, while keeping the parentheses.
     *
     * @param s           the original string
     * @param replacement the string to replace content within parentheses
     * @return the modified string with content within parentheses replaced
     */
    public static String replaceBetweenParentheses(String s, String replacement) {
        return replaceBetweenChars(s, '(', ')', replacement);
    }

    /**
     * Replaces tags in the given string with their corresponding values from a map. Tags are in the format "${tag}".
     *
     * @param s         the original string
     * @param valuesMap a map containing tag-value pairs
     * @return the string with all tags replaced by their corresponding values from the map
     */
    static String replaceTags(String s, Map<String, String> valuesMap) {
        if (isNullOrEmpty(s) || valuesMap == null) return s;
        StringBuilder sb = new StringBuilder(s);

        for (Map.Entry<String, String> entry : valuesMap.entrySet()) {
            int start;
            String tag = "${" + entry.getKey() + "}";
            String value = entry.getValue();

            while ((start = sb.indexOf(tag)) != -1) {
                sb.replace(start, start + tag.length(), value);
            }
        }
        return sb.toString();
    }

    /**
     * Removes all occurrences of a specified character from the string.
     *
     * @param s          the original string
     * @param occurrence the character to remove
     * @return the string with all occurrences of the specified character removed
     */
    public static String remove(String s, char occurrence) {
        return replace(s, String.valueOf(occurrence), EMPTY);
    }

    /**
     * Removes all occurrences of a specified substring from the string.
     *
     * @param s          the original string
     * @param occurrence the substring to remove
     * @return the string with all occurrences of the specified substring removed
     */
    public static String remove(String s, String occurrence) {
        return replace(s, occurrence, EMPTY);
    }

    /**
     * Removes a substring from the string, specified by start and end indices.
     *
     * @param s          the original string
     * @param startIndex the beginning index, inclusive
     * @param endIndex   the ending index, exclusive
     * @return the string with the specified substring removed
     */
    public static String removeByIndex(String s, int startIndex, int endIndex) {
        return replaceByIndex(s, startIndex, endIndex, EMPTY);
    }

    /**
     * Removes each occurrence of the specified substrings from the string.
     *
     * @param s           the original string
     * @param occurrences the substrings to remove
     * @return the string with all specified substrings removed
     */
    public static String removeEach(String s, String... occurrences) {
        if (isNullOrEmpty(s) || occurrences == null) return s;

        for (String occurrence : occurrences) {
            if (isNotNullOrEmpty(occurrence)) s = replace(s, occurrence, EMPTY);
        }
        return s;
    }

    /**
     * Removes all text that matches a given regular expression.
     *
     * @param s     the original string
     * @param regex the regular expression pattern that matches the text to remove
     * @return the string with all matches removed
     */
    public static String removeAll(String s, String regex) {
        if (isNotNullOrEmpty(s) && isNotNullOrEmpty(regex)) return s.replaceAll(regex, EMPTY);
        return s;
    }

    /**
     * Removes a specific capturing group within a regex match in the string.
     *
     * @param s          the original string
     * @param regex      the regular expression pattern containing the group
     * @param groupIndex the index of the capturing group to remove
     * @return the modified string with the specified group removed
     */
    public static String removeGroup(String s, String regex, int groupIndex) {
        return replaceGroup(s, regex, groupIndex, 1, EMPTY);
    }

    /**
     * Removes the content of a specific capturing group identified by its index in a specific occurrence of a
     * regex match within the string.
     *
     * @param s               the original string
     * @param regex           the regular expression pattern containing the group
     * @param groupIndex      the index of the capturing group to remove
     * @param groupOccurrence the occurrence of the group to target for removal
     * @return the modified string with the specified group content removed
     */
    public static String removeGroup(String s, String regex, int groupIndex, int groupOccurrence) {
        return replaceGroup(s, regex, groupIndex, groupOccurrence, EMPTY);
    }

    /**
     * Removes the first character of the string.
     *
     * @param s the original string
     * @return the string with its first character removed
     */
    public static String removeFirstChar(String s) {
        if (isNotNullOrEmpty(s)) s = s.substring(1);
        return s;
    }

    /**
     * Removes the last character of the string.
     *
     * @param s the original string
     * @return the string with its last character removed
     */
    public static String removeLastChar(String s) {
        if (isNotNullOrEmpty(s)) s = s.substring(0, s.length() - 1);
        return s;
    }

    /**
     * Removes the first occurrence of a specified substring from the string.
     *
     * @param s          the original string
     * @param occurrence the substring to remove
     * @return the string with the first occurrence of the specified substring removed
     */
    public static String removeOnce(String s, String occurrence) {
        return replaceOnce(s, occurrence, EMPTY);
    }

    /**
     * Removes the final occurrence of a specified substring from the string.
     *
     * @param s          the original string
     * @param occurrence the substring to remove
     * @return the string with the final occurrence of the specified substring removed
     */
    public static String removeFinal(String s, String occurrence) {
        return replaceFinal(s, occurrence, EMPTY);
    }

    /**
     * Removes the first occurrence of text that matches a given regular expression.
     *
     * @param s     the original string
     * @param regex the regular expression pattern that matches the text to remove
     * @return the string with the first match removed
     */
    public static String removeFirst(String s, String regex) {
        return replaceFirst(s, regex, EMPTY);
    }

    /**
     * Removes the last occurrence of text that matches a given regular expression.
     *
     * @param s     the original string
     * @param regex the regular expression pattern that matches the text to remove
     * @return the string with the last match removed
     */
    public static String removeLast(String s, String regex) {
        return replaceLast(s, regex, EMPTY);
    }

    /**
     * Removes the start of the string if it matches a given prefix.
     *
     * @param s      the original string
     * @param prefix the prefix to match and remove
     * @return the string with the prefix removed
     */
    public static String removeStart(String s, String prefix) {
        return replaceStart(s, prefix, EMPTY);
    }

    /**
     * Removes the start of the string if it matches any of the given prefixes.
     *
     * @param s        the original string
     * @param prefixes the prefixes to check and remove from the start of the string
     * @return the string with any matching prefix removed
     */
    public static String removeAnyStart(String s, String... prefixes) {
        return replaceAnyStart(s, EMPTY, prefixes);
    }

    /**
     * Removes the end of the string if it matches a given suffix.
     *
     * @param s      the original string
     * @param suffix the suffix to match and remove
     * @return the string with the suffix removed
     */
    public static String removeEnd(String s, String suffix) {
        return replaceEnd(s, suffix, EMPTY);
    }

    /**
     * Removes the end of the string if it matches any of the given suffixes.
     *
     * @param s        the original string
     * @param suffixes the suffixes to check and remove from the end of the string
     * @return the string with any matching suffix removed
     */
    public static String removeAnyEnd(String s, String... suffixes) {
        return replaceAnyEnd(s, EMPTY, suffixes);
    }

    /**
     * Removes the content between two specific characters in a string, including the delimiters.
     *
     * @param s       the original string
     * @param opening the opening delimiter character
     * @param closing the closing delimiter character
     * @return the modified string, or the original if any of the delimiters is {@code null}
     */
    public static String removeWithinDelimiters(String s, char opening, char closing) {
        if (CharHelper.isNull(opening) || CharHelper.isNull(closing)) return s;
        String regex = String.format("\\Q%1$s\\E.*?\\Q%2$s\\E", opening, closing);
        return s.replaceAll(regex, EMPTY);
    }

    /**
     * Removes the content between two instances of the same delimiter character in a string, including the delimiters.
     *
     * @param s         the original string
     * @param delimiter the character that acts as both the opening and closing delimiter
     * @return the modified string, or the original if the delimiter is {@code null}
     */
    public static String removeWithinDelimiters(String s, char delimiter) {
        return removeWithinDelimiters(s, delimiter, delimiter);
    }

    /**
     * Removes the content between parentheses in a string, including the parentheses.
     *
     * @param s the original string
     * @return the modified string
     */
    public static String removeWithinParentheses(String s) {
        return removeWithinDelimiters(s, '(', ')');
    }

    /**
     * Returns the first character of the given string, or a {@code null} character if the string is {@code null} or empty.
     *
     * @param s the string from which to retrieve the first character
     * @return the first character of the string, or the null character ({@code '\0'}) if the string is {@code null} or empty
     */
    public static char getFirstChar(String s) {
        if (isNotNullOrEmpty(s)) return s.charAt(0);
        return CharHelper.NULL_CHAR;
    }

    /**
     * Returns the last character of the given string, or a {@code null} character if the string is {@code null} or empty.
     *
     * @param s the string from which to retrieve the last character
     * @return the last character of the string, or the null character ({@code '\0'}) if the string is {@code null} or empty
     */
    public static char getLastChar(String s) {
        if (isNotNullOrEmpty(s)) return s.charAt(s.length() - 1);
        return CharHelper.NULL_CHAR;
    }

    /**
     * Returns the first character of the given string as a String, or the original string if it is {@code null} or empty.
     *
     * @param s the string from which to retrieve the first character
     * @return a String containing the first character, or the original string if it is {@code null} or empty
     */
    public static String getStart(String s) {
        if (isNotNullOrEmpty(s)) return String.valueOf(s.charAt(0));
        return s;
    }

    /**
     * Returns the last character of the given string as a String, or the original string if it is {@code null} or empty.
     *
     * @param s the string from which to retrieve the last character
     * @return a String containing the last character, or the original string if it is {@code null} or empty
     */
    public static String getEnd(String s) {
        if (isNotNullOrEmpty(s)) return String.valueOf(s.charAt(s.length() - 1));
        return s;
    }

    /**
     * Returns the leftmost {@code n} characters of the given string, or the original string if {@code n}
     * exceeds the string's length.
     *
     * @param s the string from which to extract characters
     * @param n the number of characters to extract from the start of the string
     * @return the leftmost {@code n} characters of {@code s}, or {@code s} itself if {@code n} is greater
     * than the length of {@code s}
     */
    public static String left(String s, int n) {
        if (s == null || n < 0) return s;
        else if (s.length() <= n) return s;
        return s.substring(0, n);
    }

    /**
     * Returns the rightmost {@code n} characters of the given string, or the original string if {@code n}
     * exceeds the string's length.
     *
     * @param s the string from which to extract characters
     * @param n the number of characters to extract from the end of the string
     * @return the rightmost {@code n} characters of {@code s}, or {@code s} itself if {@code n}
     * is greater than the length of {@code s}
     */
    public static String right(String s, int n) {
        if (s == null || n < 0) return s;
        else if (s.length() <= n) return s;
        return s.substring(s.length() - n);
    }

    /**
     * Returns the substring of {@code s} that occurs before the last occurrence of the specified separator.
     * If the separator is not found, returns the original string.
     *
     * @param s         the string to search
     * @param separator the string to search for
     * @return the substring before the last occurrence of {@code separator}, or {@code s} itself
     * if {@code separator} is not found
     */
    public static String substringBeforeLast(final String s, final String separator) {
        if (isNullOrEmpty(s) || isNullOrEmpty(separator)) return s;
        int n = s.lastIndexOf(separator);

        if (n == INDEX_NOT_FOUND) return s;
        return s.substring(0, n);
    }

    /**
     * Returns the substring of {@code s} that occurs after the last occurrence of the specified separator.
     * If the separator is not found or is at the end of the string, returns the original string.
     *
     * @param s         the string to search
     * @param separator the string to search for
     * @return the substring after the last occurrence of {@code separator}, or {@code s} itself if {@code separator}
     * is not found or is at the end of {@code s}
     */
    public static String substringAfterLast(final String s, final String separator) {
        if (isNullOrEmpty(s) || isNullOrEmpty(separator)) return s;
        int n = s.lastIndexOf(separator);

        if (n == INDEX_NOT_FOUND || n == s.length() - separator.length()) return s;
        return s.substring(n + 1);
    }

    /**
     * Checks if two strings are equal, considering {@code null} values.
     *
     * @param a the first string
     * @param b the second string
     * @return {@code true} if the strings are equal, {@code false} otherwise
     */
    public static boolean equals(String a, String b) {
        return Objects.equals(a, b);
    }

    /**
     * Checks if two strings are equal ignoring case, considering {@code null} values.
     *
     * @param a the first string
     * @param b the second string
     * @return {@code true} if the strings are equal ignoring case, {@code false} otherwise
     */
    public static boolean equalsIgnoreCase(String a, String b) {
        if (a == null || b == null) return equals(a, b);
        return a.equalsIgnoreCase(b);
    }

    /**
     * Checks if a string is equal to any of the specified occurrences, considering {@code null} values.
     *
     * @param s           the string to check
     * @param occurrences an array of strings to compare against
     * @return {@code true} if the string is equal to any of the specified occurrences, {@code false} otherwise
     */
    public static boolean equalsAny(String s, String... occurrences) {
        if (s == null) return false;

        for (String occurrence : occurrences) {
            if (equals(s, occurrence)) return true;
        }
        return false;
    }

    /**
     * Checks if a string is equal to the predefined default value.
     *
     * @param s the string to check
     * @return {@code true} if the string is equal to {@value #DEFAULT_VALUE}, {@code false} otherwise
     */
    public static boolean equalsDefault(String s) {
        return equals(s, DEFAULT_VALUE);
    }

    /**
     * Checks if a string starts with a specified character.
     *
     * @param s the string to check
     * @param c the character to check at the start of the string
     * @return {@code true} if the string starts with the specified character, {@code false} otherwise
     */
    public static boolean startsWith(String s, char c) {
        if (isNotNullOrEmpty(s) && !CharHelper.isNull(c)) return s.charAt(0) == c;
        return CharHelper.isNull(c);
    }

    /**
     * Checks if a string starts with a specified prefix.
     *
     * @param s      the string to check
     * @param prefix the prefix to check at the start of the string
     * @return {@code true} if the string starts with the specified prefix, {@code false} otherwise
     */
    public static boolean startsWith(String s, String prefix) {
        if (isNotNullOrEmpty(s) && isNotNullOrEmpty(prefix) && s.length() >= prefix.length())
            return s.indexOf(prefix) == 0;
        return prefix == null;
    }

    /**
     * Checks if a string starts with any of the specified characters.
     *
     * @param s     the string to check
     * @param chars an array of characters to check against the start of the string
     * @return {@code true} if the string starts with any of the specified characters, {@code false} otherwise
     */
    public static boolean startsWithAny(String s, char... chars) {
        for (char c : chars) {
            if (startsWith(s, c)) return true;
        }
        return false;
    }

    /**
     * Checks if a string starts with any of the specified prefixes.
     *
     * @param s        the string to check
     * @param prefixes an array of prefixes to check against the start of the string
     * @return {@code true} if the string starts with any of the specified prefixes, {@code false} otherwise
     */
    public static boolean startsWithAny(String s, String... prefixes) {
        for (String prefix : prefixes) {
            if (startsWith(s, prefix)) return true;
        }
        return false;
    }

    /**
     * Checks if a string ends with a specified character.
     *
     * @param s the string to check
     * @param c the character to check at the end of the string
     * @return {@code true} if the string ends with the specified character, {@code false} otherwise
     */
    public static boolean endsWith(String s, char c) {
        if (isNotNullOrEmpty(s) && !CharHelper.isNull(c)) return s.charAt(s.length() - 1) == c;
        return CharHelper.isNull(c);
    }

    /**
     * Checks if a string ends with a specified suffix.
     *
     * @param s      the string to check
     * @param suffix the suffix to check at the end of the string
     * @return {@code true} if the string ends with the specified suffix, {@code false} otherwise
     */
    public static boolean endsWith(String s, String suffix) {
        if (isNotNullOrEmpty(s) && isNotNullOrEmpty(suffix) && s.length() >= suffix.length()) return s.endsWith(suffix);
        return suffix == null;
    }

    /**
     * Checks if a string ends with any of the specified characters.
     *
     * @param s     the string to check
     * @param chars an array of characters to check against the end of the string
     * @return {@code true} if the string ends with any of the specified characters, {@code false} otherwise
     */
    public static boolean endsWithAny(String s, char... chars) {
        for (char c : chars) {
            if (endsWith(s, c)) return true;
        }
        return false;
    }

    /**
     * Checks if a string ends with any of the specified suffixes.
     *
     * @param s        the string to check
     * @param suffixes an array of suffixes to check against the end of the string
     * @return {@code true} if the string ends with any of the specified suffixes, {@code false} otherwise
     */
    public static boolean endsWithAny(String s, String... suffixes) {
        for (String suffix : suffixes) {
            if (endsWith(s, suffix)) return true;
        }
        return false;
    }

    /**
     * Checks if the given string contains the specified character.
     *
     * @param s the string to check
     * @param c the character to find
     * @return {@code true} if the character is found in the string, {@code false} otherwise
     */
    public static boolean has(String s, char c) {
        return indexOf(s, c) != -1;
    }

    /**
     * Checks if the given string contains the specified substring.
     *
     * @param s          the string to check
     * @param occurrence the substring to find
     * @return {@code true} if the substring is found in the string, {@code false} otherwise
     */
    public static boolean has(String s, String occurrence) {
        return indexOf(s, occurrence) != -1;
    }

    /**
     * Checks if the given string contains any of the specified characters.
     *
     * @param s     the string to check
     * @param chars the characters to find
     * @return {@code true} if any of the characters are found in the string, {@code false} otherwise
     */
    public static boolean hasAny(String s, char... chars) {
        if (isNullOrEmpty(s)) return false;

        for (char character : chars) {
            for (char c : s.toCharArray()) {
                if (c == character) return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given string contains any of the specified affixes.
     *
     * @param s       the string to check
     * @param affixes the affixes to find
     * @return {@code true} if any of the affixes are found in the string, {@code false} otherwise
     */
    public static boolean hasAny(String s, String... affixes) {
        if (isNullOrEmpty(s) || ArrayHelper.isNullOrEmpty(affixes)) return false;

        for (String affix : affixes) {
            if (affix != null && s.contains(affix)) return true;
        }
        return false;
    }

    /**
     * Escapes special characters in a Java String using escape sequences.
     * <p>
     * This method processes the input string and applies escape sequences to special characters,
     * such as the backslash (\), newline (\n), and others, making the string safe for use in Java source code.
     * <p>
     * Supported escape sequences include:
     * <ul>
     *     <li>\\ (backslash)</li>
     *     <li>\b (backspace)</li>
     *     <li>\f (form feed)</li>
     *     <li>\n (newline)</li>
     *     <li>\r (carriage return)</li>
     *     <li>\t (horizontal tab)</li>
     *     <li>\' (single quote)</li>
     *     <li>\" (double quote)</li>
     * </ul>
     *
     * @param s the string to escape
     * @return the escaped string, or {@code null} if the input string is {@code null}
     */
    public static String escapeJavaString(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '\\' -> sb.append("\\\\");
                case '\b' -> sb.append("\\b");
                case '\f' -> sb.append("\\f");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                case '\'' -> sb.append("\\'");
                case '\"' -> sb.append("\\\"");
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Unescapes a string that contains standard Java escape sequences.
     * <ul>
     *     <li><strong>&#92;b &#92;f &#92;n &#92;r &#92;t &#92;" &#92;'</strong> :
     *     BS, FF, NL, CR, TAB, double and single quote.</li>
     *     <li><strong>&#92;X &#92;XX &#92;XXX</strong> : Octal character
     *     specification (0 - 377, 0x00 - 0xFF).</li>
     *     <li><strong>&#92;uXXXX</strong> : Hexadecimal based Unicode character.</li>
     * </ul>
     *
     * @param st a string optionally containing standard java escape sequences
     * @return the translated string
     */
    public static String unescapeJavaString(String st) {
        if (isNullOrEmpty(st)) return st;
        StringBuilder sb = new StringBuilder(st.length());

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);

            if (ch == '\\') {
                char nextChar = (i == st.length() - 1) ? '\\' : st.charAt(i + 1);

                // Octal escape?
                if (nextChar >= '0' && nextChar <= '7') {
                    String code = EMPTY + nextChar;
                    i++;
                    if ((i < st.length() - 1) && st.charAt(i + 1) >= '0' && st.charAt(i + 1) <= '7') {
                        code += st.charAt(i + 1);
                        i++;
                        if ((i < st.length() - 1) && st.charAt(i + 1) >= '0' && st.charAt(i + 1) <= '7') {
                            code += st.charAt(i + 1);
                            i++;
                        }
                    }
                    sb.append((char) Integer.parseInt(code, 8));
                    continue;
                }

                switch (nextChar) {
                    case '\\' -> ch = '\\';
                    case 'b' -> ch = '\b';
                    case 'f' -> ch = '\f';
                    case 'n' -> ch = '\n';
                    case 'r' -> ch = '\r';
                    case 't' -> ch = '\t';
                    case '\"' -> ch = '\"';
                    case '\'' -> ch = '\'';

                    // Hex Unicode: u????
                    case 'u' -> {
                        if (i >= st.length() - 5) {
                            ch = 'u';
                            break;
                        }
                        int code = Integer.parseInt(EMPTY + st.charAt(i + 2) + st.charAt(i + 3) + st.charAt(i + 4) + st.charAt(i + 5), 16);
                        sb.append(Character.toChars(code));
                        i += 5;
                        continue;
                    }
                }
                i++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * Converts a character to its Unicode escape string.
     *
     * @param c the character to convert
     * @return the Unicode escape string of the character, or {@code null} if the character is the null character ({@code '\0'})
     */
    public static String getUnicode(char c) {
        if (!CharHelper.isNull(c)) return String.format("\\u%04x", (int) c);
        return null;
    }

    /**
     * Constructs a string from an array of Unicode code points.
     *
     * @param codePoints an array of Unicode code points
     * @return the string constructed from the code points
     */
    public static String getCharacter(String... codePoints) {
        StringBuilder sb = new StringBuilder();

        for (String codePoint : codePoints) {
            if (isNotNullOrBlank(codePoint) && Validation.isUtf(codePoint))
                sb.appendCodePoint(Integer.decode(codePoint.replace("U+", "0x")));
        }
        return sb.toString();
    }

    /**
     * Creates a hex color string in ARGB format from the given alpha, red, green, and blue values.
     *
     * @param alpha the alpha component
     * @param red   the red component
     * @param green the green component
     * @param blue  the blue component
     * @return the ARGB hex color string
     */
    public static String getHexStringFromARGB(int alpha, int red, int green, int blue) {
        if ((alpha < 0 || alpha > 255) || (red < 0 || red > 255) || (green < 0 || green > 255) || (blue < 0 || blue > 255))
            return ("#FFFFFFFF");
        return String.format("#%02X%02X%02X%02X", alpha, red, green, blue).toUpperCase();
    }

    /**
     * Generates a hash code for the given string.
     * <p>
     * This method calculates a hash code for the input string using a modified version of the
     * well-known DJB2 algorithm. The hash code is generated by iterating over each character
     * in the string and applying a series of bitwise operations to accumulate the final hash
     * value.
     *
     * @param s the string to calculate the hash code for
     * @return the hash code for the input string, or {@code null} if the string is {@code null} or empty
     */
    public static Long hashcode(String s) {
        if (isNullOrEmpty(s)) return null;
        long hash = 0;

        for (char c : s.toCharArray()) {
            hash = 31L * hash + c;
        }
        return hash;
    }

    /**
     * Computes the hash of the given string using the specified algorithm.
     *
     * @param s         the string to hash
     * @param algorithm the name of the hash algorithm to use (e.g., "MD5", "SHA-256", "SHA-512")
     * @return the hash value of the string, or {@code null} if an error occurs or the algorithm is invalid
     */
    public static String hash(String s, String algorithm) {
        if (s == null || isNullOrEmpty(algorithm)) return null;

        try {
            final MessageDigest md = MessageDigest.getInstance(algorithm);
            final byte[] hashBytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
            final StringBuilder sb = new StringBuilder(hashBytes.length * 2);

            for (byte b : hashBytes) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (Exception ignored) {
        }
        return null;
    }

    /**
     * Generates an MD5 hash of the given string.
     *
     * @param s the string to hash
     * @return the MD5 hash of the string, or an empty string if an error occurs
     */
    public static String md5(String s) {
        return hash(s, "MD5");
    }

    /**
     * Generates an SHA-256 hash of the given string.
     *
     * @param s the string to hash
     * @return the SHA-256 hash of the string, or {@code null} if an error occurs
     */
    public static String sha256(final String s) {
        return hash(s, "SHA-256");
    }

    /**
     * Generates an SHA-512 hash of the given string.
     *
     * @param s the string to hash
     * @return the SHA-512 hash of the string, or {@code null} if an error occurs
     */
    public static String sha512(final String s) {
        return hash(s, "SHA-512");
    }
}
