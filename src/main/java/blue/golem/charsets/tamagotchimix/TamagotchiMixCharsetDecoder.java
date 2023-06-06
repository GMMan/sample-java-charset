package blue.golem.charsets.tamagotchimix;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class TamagotchiMixCharsetDecoder extends CharsetDecoder {

    public TamagotchiMixCharsetDecoder(Charset cs) {
        super(cs, 0.5f, 1f);
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        try {
            while (in.hasRemaining()) {
                byte bCls = in.get();
                if (!in.hasRemaining()) {
                    if (bCls == 0) {
                        // Not actually correct, but Ghidra considers all JVM charsets to be single-byte,
                        // so have to use this workaround to generate nuls
                        out.put("\0");
                        return CoderResult.UNDERFLOW;
                    } else {
                        in.position(in.position() - 1);
                        return CoderResult.UNDERFLOW;
                    }
                }
                byte bChar = in.get();
                // Check symbol
                String ch = TamagotchiMixCharset.SYMBOL_MAP.get(bChar);
                if (ch != null) {
                    out.put(ch);
                } else {
                    // Check character class
                    if (bCls == 0 || bChar == 0) {
                        out.put('\0');
                        continue;
                    } else {
                        String[] classChars = TamagotchiMixCharset.CLASS_MAP.get(bCls);
                        if (classChars != null) {
                            int intChar = bChar & 0xff;
                            if (intChar - 1 < classChars.length) {
                                out.put(classChars[intChar - 1]);
                                continue;
                            } else {
                                // Katakana, which is in a different map
                                if (bCls == 4 && intChar >= 0x77) {
                                    intChar -= 0x77;
                                    if (intChar < TamagotchiMixCharset.KATAKANA_MAP.length) {
                                        out.put(TamagotchiMixCharset.KATAKANA_MAP[intChar]);
                                        continue;
                                    }
                                }
                            }
                        }
                    }

                    in.position(in.position() - 2);
                    return CoderResult.unmappableForLength(2);
                }
            }
        } catch (BufferOverflowException ex) {
            return CoderResult.OVERFLOW;
        }

        return CoderResult.UNDERFLOW;
    }

}
