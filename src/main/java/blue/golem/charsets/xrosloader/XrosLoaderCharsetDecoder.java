package blue.golem.charsets.xrosloader;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class XrosLoaderCharsetDecoder extends CharsetDecoder {

    public XrosLoaderCharsetDecoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        try {
            while (in.hasRemaining()) {
                int b = in.get() & 0xff;
                char ch = XrosLoaderCharset.CHARMAP[b];
                if (ch == 0) {
                    // in.position(in.position() - 1);
                    // return CoderResult.unmappableForLength(1);

                    // Decode as ASCII
                    out.put((char) b);
                } else {
                    out.put(ch);
                }
            }
        } catch (BufferOverflowException ex) {
            return CoderResult.OVERFLOW;
        }

        return CoderResult.UNDERFLOW;
    }

}
