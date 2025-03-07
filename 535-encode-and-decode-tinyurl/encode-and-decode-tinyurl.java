public class Codec {
    private String SEED = "123456789abcedfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String BASE_URL = "http://tinyurl.com/";
    private int ID_SIZE = 6;
    private Map<String, String> encodedURL = new HashMap<>();
    private Map<String, String> decodedURL = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(encodedURL.containsKey(longUrl)) return encodedURL.get(longUrl);

        StringBuilder idBuilder = null;
        int seedLength = SEED.length();
        do {
            idBuilder = new StringBuilder();
            for(int i=0; i<ID_SIZE; i++) {
                char c = SEED.charAt((int)(Math.random() * seedLength));
                idBuilder.append(c + "");
            }
        }while(decodedURL.containsKey(idBuilder.toString()));

        var url = BASE_URL + idBuilder.toString();
        encodedURL.put(longUrl, url);
        decodedURL.put(url, longUrl);

        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodedURL.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));