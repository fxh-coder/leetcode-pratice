package stage6_10;

import java.util.ArrayList;
import java.util.List;

public class LC_grayCode {
    /**
     * 力扣格雷编码
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
