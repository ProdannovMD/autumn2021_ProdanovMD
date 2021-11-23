package november17.homework;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Pattern;

public class PatternWriter extends FilterWriter {
    private final Pattern characterPattern;

    /**
     * Create a new filtered writer.
     *
     * @param out a Writer object to provide the underlying stream.
     * @param characterPattern a pattern for each character
     * @throws NullPointerException if <code>out</code> is <code>null</code>
     */
    protected PatternWriter(Writer out, Pattern characterPattern) {
        super(out);
        this.characterPattern = characterPattern;
    }

    @Override
    public void write(int c) throws IOException {
        if (characterPattern.asPredicate().test(String.valueOf((char) c)))
            super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(cbuf[i]);
        }
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        write(str.toCharArray(), off, len);
    }
}
