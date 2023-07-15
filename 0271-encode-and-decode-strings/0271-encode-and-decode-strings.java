public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        
        for(String data : strs) {
            int length = data.length();
            encoded
            .append(length+"")
            .append("/")
            .append(data);
        }
        
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> decoded = new ArrayList<String>();
        
        for(int i=0; i<s.length();) {
            int targetIndex = s.indexOf('/', i);
            int length = Integer.valueOf(s.substring(i, targetIndex));
            i = targetIndex + length + 1;
            String result = s.substring(targetIndex + 1, i);
            decoded.add(result);
        }
        
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));