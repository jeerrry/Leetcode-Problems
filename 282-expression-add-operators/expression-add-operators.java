class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(0, 0, 0, target, "", num, result);

        return result;
    }

    private void helper(int index, long last, long rsf, long target, String esf, String num, List<String> result) {
        if(index == num.length()) {
            if(last + rsf == target) {
                result.add(esf);
            }
            return;
        }

        int end = num.length();
        if(num.charAt(index) == '0') {
            end = index + 1;
        }

        for (int i = index + 1; i <= end; i++) {
            long current = Long.valueOf(num.substring(index, i));
            if (index == 0) {
                helper(i, current, 0, target, esf + current, num, result);
                continue;
            }

            helper(i, current, rsf + last, target, esf + "+" + current, num, result);
            helper(i, -current, rsf + last, target, esf + "-" + current, num, result);
            helper(i, last * current, rsf, target, esf + "*" + current, num, result);
        }
    }
}