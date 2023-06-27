public class LC_excelSheetColumnTitle {
    /**
     * 力扣Excel表列名称
     * 原理：一共26个字母，所以每次对26取余即可，因为0-25是26个数，所以a0 - 1 + 'A'
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}
