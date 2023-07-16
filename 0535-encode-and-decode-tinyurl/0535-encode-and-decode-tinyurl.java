public class Codec {
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String BASE = "http://tinyurl.com/";

    private HashMap<String, String> urlToEncoded = new HashMap<>();
    private HashMap<String, String> encodedToUrl = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(urlToEncoded.containsKey(longUrl)) return urlToEncoded.get(longUrl); 
        
        
        // Generate New Tiny URL
        StringBuilder tinyUrl;
        
        do {
            tinyUrl = new StringBuilder();
            for(int i=0; i<6; i++) {
                int randomIndex= (int)(Math.random() * SEED.length());
                tinyUrl.append(SEED.charAt(randomIndex) + "");
            }
        }while(encodedToUrl.containsKey(tinyUrl.toString()));
        
        encodedToUrl.put(tinyUrl.toString(), longUrl);
        urlToEncoded.put(longUrl, tinyUrl.toString());
        
        return tinyUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!encodedToUrl.containsKey(shortUrl)) return "";
        
        return encodedToUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));