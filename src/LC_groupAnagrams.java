import java.util.*;

public class LC_groupAnagrams {
    /**
     * 力扣字母异位词（官方题解）
     * 原理：如果是异位词，那么所含字母相同，所以排序后，如果两个一样，那么就是异位词
     * 排序后在进行对比的好处就是省去了一个一个对比的麻烦
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] strarr = str.toCharArray();
            Arrays.sort(strarr);
            String key = new String(strarr);
            // 如果没有，就创建新的，如果有，就通过key获取到原来的
            List<String> temp = res.getOrDefault(key, new ArrayList<>());
            temp.add(str);
            res.put(key, temp);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * 力扣字母异位词（自己写的）
     * 原理：先将所有词存到map中，value为1，然后用过以后value为0，防止重复，然后对剩下的遍历，对比每个词的字母
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length == 1) {
            List<String> prc = new ArrayList<>();
            prc.add(strs[0]);
            res.add(prc);
            return res;
        }

        Map<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            strMap.put(strs[i], 1);
        }

        int i = 0, n = strs.length;
        // 用来记录一共处理了多少个单词，防止重复计算
        int cnt = 0;
        while (i < n) {
            String s = strs[i];
            if (strMap.get(s) == 1) {
                List<String> prc = new ArrayList<>();
                prc.add(s);
                cnt++;

                int k = i + 1;
                boolean flag = false;

                while (k < n) {
                    String s1 = strs[k];
                    if (s1.length() == s.length()) {
                        Map<Character, Integer> map = new HashMap<>();
                        for (int j = 0; j < s.length(); j++) {
                            char c = s.charAt(j);
                            if (map.containsKey(c))
                                map.put(c, map.get(c) + 1);
                            else
                                map.put(c, 1);
                        }

                        for (int j = 0; j < s1.length(); j++) {
                            char sc = s1.charAt(j);

                            if (map.containsKey(sc)) {
                                map.put(sc, map.get(sc) - 1);
                                if (map.get(sc) < 0) {
                                    flag = true;
                                    break;
                                }
                            } else {
                                flag = true;
                                break;
                            }
                        }

                        if (!flag) {
                            strMap.put(s1, strMap.get(s1) - 1);
                            prc.add(s1);
                            cnt++;
                        }
                    }

                    flag = false;
                    k++;
                }
                res.add(prc);
                i++;
                if (cnt == n)
                    break;
            } else {
                i++;
            }
        }

        return res;
    }
}
