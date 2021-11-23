package november17.homework;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;

public class PatternReader extends FilterReader {
    private final Pattern characterPattern;

    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @param characterPattern a pattern for each character in the stream
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    public PatternReader(Reader in, Pattern characterPattern) {
        super(in);
        this.characterPattern = characterPattern;
    }

    @Override
    public int read() throws IOException {
        int cur = super.read();
        String s = String.valueOf((char) cur);

        while (cur != -1 && !characterPattern.asPredicate().test(s)) {
            cur = super.read();
            s = String.valueOf((char) cur);
        }

        return cur;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int cnt = 0;
        for (int i = off; i < off + len; i++) {
            int c = read();
            if (c == -1) {
                cnt = -1;
                break;
            }

            cbuf[i] = (char) c;
            cnt++;
        }

        return cnt;
    }
}
