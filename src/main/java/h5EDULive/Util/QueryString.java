package h5EDULive.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryString {
    private String[] keywords;
    private List<List<String>> list = new ArrayList<>();

    public QueryString(String[] keywords) {
        this.keywords = keywords;
    }

    public String getRE(){
        fullSort(keywords, 0, keywords.length - 1);
        String pattern = "", pat="(.|\\n)*";
        for (List<String> lst : list) {
            pattern += "(" + pat;
            for (String s : lst)
                pattern += "(" + s + ")+" + pat;
            pattern += ")|";
        }
        return pattern.substring(0, pattern.length() - 1);
    }

    private void fullSort(String[] arr, int start, int end) {
        if (start == end) {
            String[] temp = arr.clone();
            list.add(Arrays.asList(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
