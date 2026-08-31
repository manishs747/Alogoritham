package Interview.delivero.coding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AuthenticationManager {

    private final int timeToLive;
    ///private final Map<String, Integer> tokenMap = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
          this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId,currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(!tokenMap.containsKey(tokenId)) return;
        int expiry = tokenMap.get(tokenId);
        if(expiry <= currentTime){
            tokenMap.remove(tokenId); // expired already
        }else{
            tokenMap.put(tokenId,currentTime+timeToLive);
        }
    }

    private final Map<String, Integer> tokenMap = new HashMap<>();
    public int countUnexpiredTokens(int currentTime) {
        tokenMap.entrySet().removeIf(entry -> entry.getValue() <= currentTime);
        return tokenMap.size();
    }

    public int countUnexpiredTokens2(int currentTime) {
        Iterator<Map.Entry<String, Integer>> iterator = tokenMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() <= currentTime)
                iterator.remove();
        }
        return tokenMap.size();
    }
}
