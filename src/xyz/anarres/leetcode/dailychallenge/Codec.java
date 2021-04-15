package xyz.anarres.leetcode.march;

import java.util.TreeMap;


/**
 * TinyURL is a URL shortening service where you enter a URL and it returns a short URL.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how
 *  your encode/decode algorithm should work. You just need to ensure that a URL can be encoded
 *   to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 * longurl = "https://leetcode.com/problems/design-tinyurl"
 * shorturl = "http://tinyurl.com/4e9iAk"
 * 
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
 */
public class Codec {
	TreeMap<String, String> urlMap = new TreeMap<String, String>();

	public static void main(String[] args) {
		// 
		Codec codec = new Codec();
		System.out.println("Encode https://leetcode.com/problems/design-tinyurl : " + codec.encode("https://leetcode.com/problems/design-tinyurl"));
		String shortUrl = codec.encode("https://leetcode.com/problems/design-tinyurl");
		System.out.println("Decode : " + codec.decode(shortUrl));
	}

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String result = "";
		
		if (!urlMap.containsValue(longUrl))
			result = homemadeHash(longUrl);
		while (urlMap.containsKey(result))
			result = homemadeHash(longUrl);
		urlMap.put("http://tinyurl.com/" + result, longUrl);

		return "http://tinyurl.com/" + result;

	}
	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		if (!shortUrl.startsWith("http://tinyurl.com/"))
			return "http://tinyurl.com/";
		
		return urlMap.getOrDefault(shortUrl, "http://tinyurl.com/");
	}

	private String homemadeHash(String str) {
		double random = Math.random();
		Integer hash = (int) ((random * 10));
		
		for (int i = 0; i < str.length(); i++) {
			hash = hash*13 + str.charAt(i);
		}
		
		return "" + hash;
	}

}
