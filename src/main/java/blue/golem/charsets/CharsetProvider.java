package blue.golem.charsets;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import blue.golem.charsets.xrosloader.XrosLoaderCharset;

public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {

    static final String XROS_LOADER_CHARSET_NAME = "xros-loader";

    Map<String, Charset> charsetMap = new HashMap<>();

    public CharsetProvider() {
        super();
        // Add charsets here
        charsetMap.put(XROS_LOADER_CHARSET_NAME, new XrosLoaderCharset(XROS_LOADER_CHARSET_NAME, null));
    }

    @Override
    public Iterator<Charset> charsets() {
        return charsetMap.values().iterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {
        return charsetMap.get(charsetName);
    }

}
