package io.fengfu.learning.string;

/**
 * Created by fengfu.qu on 2016/6/22.
 */
public class CodeUtil {

    private static final int[] encode = new int[127];

    private static final char[] decode = new char[]{
            '\0',
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '$',
    };

    private static final int weight = 6;

    private static final int masks = 0x3F;

    private static final String emptyString = "";

    static {
        for (int i = 0; i < decode.length; ++i) {
            encode[decode[i]] = i;
        }
    }


    public static byte encodeAsByte(char ch) {
        return (byte) ch;
    }

    public static int encodeAsInteger(String str) {
        if (str == null)
            return -1;
        if (str.isEmpty())
            return 0;
        int result = 0;
        for (int i = str.length() - 1; i >= 0; --i)
            result = (result << weight) + encode[str.charAt(i)];
        return result;
    }

    public static String decode(int s) {
        if (s == -1)
            return null;
        if (s == 0)
            return emptyString;
        char[] result = new char[5];
        int i = 0;
        for (; i < 5; ++i) {
            result[i] = decode[s & masks];
            s >>= weight;
            if (s == 0)
                break;
        }
        return new String(result, 0, i + 1);
    }

    public static void main(String[] args) {
        String test = "BJS";

        System.out.println(CodeUtil.encodeAsInteger(test));

        System.out.println(CodeUtil.decode(78466));
    }
}
