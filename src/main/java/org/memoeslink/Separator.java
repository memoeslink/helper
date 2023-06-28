package org.memoeslink;

public enum Separator {
    HYPHEN('-'),
    TILDE('~'),
    UNDERSCORE('_'),
    DOT('.'),
    COMMA(','),
    SPACE(' ');

    private final char character;

    private Separator(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
