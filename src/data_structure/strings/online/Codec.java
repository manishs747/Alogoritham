package data_structure.strings.online;

import data_structure.arrays.intervals.InsertInterval;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    private int counter = 0;
    private static final Map<String,String> urlMapper = new HashMap<>();

    public String encode(String longUrl) {
         String key = Integer.toString(counter++);
         urlMapper.put(key,longUrl);
         return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      return urlMapper.get(shortUrl);
    }
}
