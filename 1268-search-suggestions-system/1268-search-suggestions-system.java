class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int left = 0;
        int right = products.length - 1;
        
        StringBuilder target = new StringBuilder();
        for(int i=0; i<searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            
            while(left<=right && (products[left].length() == i || products[left].charAt(i) < c)) left++;
            while(left<=right && (products[right].length() == i || products[right].charAt(i) > c)) right--;
            
            var list = new ArrayList<String>();
            for(int k=0; k<3 && left + k <= right; k++) {
                list.add(products[left + k]);
            }
            
            result.add(list);
        }
        
        return result;
    }
}