package blue.golem.charsets.tamagotchimix;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TamagotchiMixCharset extends Charset {

    static final Map<Byte, String> SYMBOL_MAP;
    static final Map<Byte, String[]> CLASS_MAP;
    static final String[] KATAKANA_MAP;

    static {
        // Note: Ideographic space has been swapped out for regular space to make
        // reading strings easier

        Map<Byte, String> symbolMap = new HashMap<>();
        symbolMap.put((byte)0x51, "ー");
        symbolMap.put((byte)0x52, "～");
        symbolMap.put((byte)0x53, "…");
        symbolMap.put((byte)0x54, "、");
        symbolMap.put((byte)0x55, "。");
        symbolMap.put((byte)0x56, "（");
        symbolMap.put((byte)0x57, "）");
        symbolMap.put((byte)0x58, "「");
        symbolMap.put((byte)0x59, "」");
        symbolMap.put((byte)0x5a, "．");
        symbolMap.put((byte)0x5b, "・");
        symbolMap.put((byte)0x5c, "！");
        symbolMap.put((byte)0x5d, "？");
        symbolMap.put((byte)0x5e, "＆");
        symbolMap.put((byte)0x5f, "⭕");
        symbolMap.put((byte)0x60, "❌");
        symbolMap.put((byte)0x61, "♡");
        symbolMap.put((byte)0x62, "☀");
        symbolMap.put((byte)0x63, "★");
        symbolMap.put((byte)0x64, "🌀");
        symbolMap.put((byte)0x65, "♪");
        symbolMap.put((byte)0x66, "💢");
        symbolMap.put((byte)0x67, "⤴");
        symbolMap.put((byte)0x68, "⤵");
        symbolMap.put((byte)0x69, "→");
        symbolMap.put((byte)0x6a, "←");
        symbolMap.put((byte)0x6b, "₲");
        symbolMap.put((byte)0x6c, " ");
        symbolMap.put((byte)0x6d, "０");
        symbolMap.put((byte)0x6e, "１");
        symbolMap.put((byte)0x6f, "２");
        symbolMap.put((byte)0x70, "３");
        symbolMap.put((byte)0x71, "４");
        symbolMap.put((byte)0x72, "５");
        symbolMap.put((byte)0x73, "６");
        symbolMap.put((byte)0x74, "７");
        symbolMap.put((byte)0x75, "８");
        symbolMap.put((byte)0x76, "９");

        symbolMap.put((byte)0xd0, "😫");
        symbolMap.put((byte)0xd1, "😣");
        symbolMap.put((byte)0xd2, "😑");
        symbolMap.put((byte)0xd3, "😵");
        symbolMap.put((byte)0xd4, "😪");
        symbolMap.put((byte)0xd5, "🐱");
        symbolMap.put((byte)0xd6, "📟");
        symbolMap.put((byte)0xd7, "🎂");
        symbolMap.put((byte)0xd8, "🎁");
        symbolMap.put((byte)0xd9, "📱");
        symbolMap.put((byte)0xda, "🏢");
        symbolMap.put((byte)0xdb, "🛍️");
        symbolMap.put((byte)0xdc, "🍙");
        symbolMap.put((byte)0xdd, "🍰");
        symbolMap.put((byte)0xde, "✨");
        symbolMap.put((byte)0xdf, "😊");
        symbolMap.put((byte)0xe0, "Ａ");
        symbolMap.put((byte)0xe1, "Ｂ");
        symbolMap.put((byte)0xe2, "Ｃ");
        symbolMap.put((byte)0xe3, "Ｄ");
        symbolMap.put((byte)0xe4, "Ｅ");
        symbolMap.put((byte)0xe5, "Ｆ");
        symbolMap.put((byte)0xe6, "Ｇ");
        symbolMap.put((byte)0xe7, "Ｈ");
        symbolMap.put((byte)0xe8, "Ｉ");
        symbolMap.put((byte)0xe9, "Ｊ");
        symbolMap.put((byte)0xea, "Ｋ");
        symbolMap.put((byte)0xeb, "Ｌ");
        symbolMap.put((byte)0xec, "Ｍ");
        symbolMap.put((byte)0xed, "Ｎ");
        symbolMap.put((byte)0xee, "Ｏ");
        symbolMap.put((byte)0xef, "Ｐ");
        symbolMap.put((byte)0xf0, "Ｑ");
        symbolMap.put((byte)0xf1, "Ｒ");
        symbolMap.put((byte)0xf2, "Ｓ");
        symbolMap.put((byte)0xf3, "Ｔ");
        symbolMap.put((byte)0xf4, "Ｕ");
        symbolMap.put((byte)0xf5, "Ｖ");
        symbolMap.put((byte)0xf6, "Ｗ");
        symbolMap.put((byte)0xf7, "Ｘ");
        symbolMap.put((byte)0xf8, "Ｙ");
        symbolMap.put((byte)0xf9, "Ｚ");
        symbolMap.put((byte)0xfa, "％");
        symbolMap.put((byte)0xfb, "－");
        symbolMap.put((byte)0xfc, "＋");

        symbolMap.put((byte)0xfe, "⏎");
        symbolMap.put((byte)0xff, "\n");

        SYMBOL_MAP = Collections.unmodifiableMap(symbolMap);

        Map<Byte, String[]> classMap = new HashMap<>();
        // Hiragana-only
        classMap.put((byte)4, new String[] {
            "あ", "い", "う", "え", "お", "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", "た",
            "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", "は", "ひ", "ふ", "へ", "ほ", "ま", "み",
            "む", "め", "も", "や", "ゆ", "よ", "ら", "り", "る", "れ", "ろ", "わ", "を", "ん",
            "ぁ", "ぃ", "ぅ", "ぇ", "ぉ", "っ", "ゃ", "ゅ", "ょ",
            "が", "ぎ", "ぐ", "げ", "ご", "ざ", "じ", "ず", "ぜ", "ぞ", "だ", "ぢ", "づ", "で", "ど", "ば",
            "び", "ぶ", "べ", "ぼ", "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",
        });
        classMap.put((byte)12, new String[] {
            "À", "Â", "Æ", "Ç", "É", "È", "Ê", "Ë", "Î", "Ï", "Ô", "Œ", "Ù", "Û", "Ü", "Ŷ"
        });
        classMap.put((byte)16, new String[] {
            "É", "È", "Ê", "Ë", "Ï", "Ù", "Ü"
        });
        classMap.put((byte)20, new String[] {
            "Á", "É", "Í", "Ñ", "Ó", "Ú", "Ü"
        });
        classMap.put((byte)24, new String[] {
            "Á", "À", "Â", "Ã", "Ç", "É", "È", "Ê", "Í", "Ó", "Ô", "Õ", "Ú"
        });
        classMap.put((byte)28, new String[] {
            "Ä", "Ö", "Ü"
        });
        classMap.put((byte)32, new String[] {
            "Ą", "Ć", "Ę", "Ł", "Ń", "Ó", "Ś", "Ź", "Ż"
        });
        classMap.put((byte)36, new String[] {
            "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О",
            "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю",
            "Я"
        });

        CLASS_MAP = Collections.unmodifiableMap(classMap);

        String[] katakanaMap = new String[] {
            "ア", "イ", "ウ", "エ", "オ", "カ", "キ", "ク", "ケ", "コ", "サ", "シ", "ス", "セ", "ソ", "タ", 
            "チ", "ツ", "テ", "ト", "ナ", "ニ", "ヌ", "ネ", "ノ", "ハ", "ヒ", "フ", "ヘ", "ホ", "マ", "ミ",
            "ム", "メ", "モ", "ヤ", "ユ", "ヨ", "ラ", "リ", "ル", "レ", "ロ", "ワ", "ン", "ヲ", "ン", "ァ",
            "ィ", "ゥ", "ェ", "ォ", "ッ", "ャ", "ュ", "ョ", "ガ", "ギ", "グ", "ゲ", "ゴ", "ザ", "ジ", "ズ",
            "ゼ", "ゾ", "ダ", "ヂ", "ヅ", "デ", "ド", "バ", "ビ", "ブ", "ベ", "ボ", "パ", "ピ", "プ", "ペ",
            "ポ", "ヴ"
        };
        KATAKANA_MAP = katakanaMap;
    }

    public TamagotchiMixCharset(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    @Override
    public boolean contains(Charset cs) {
        // This charset doesn't really contain any other charset, so only return true
        // for itself
        return name().equals(cs.name());
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new TamagotchiMixCharsetDecoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return null;
    }

}
