package Interview.atlas.popularContentID;

import java.util.*;

public class Practice {

    private  final Map<Integer,Integer> contentIdToPopularity = new HashMap<>();
    private final TreeMap<Integer, Set<Integer>> popularityToContentIds = new TreeMap<>(Comparator.reverseOrder());

/*
      //add new pop
      //remove old populairy , while removig set is empty delete key
 */
    public void increasePopularity(int contentId) {
        int oldPopularity = contentIdToPopularity.getOrDefault(contentId,0);
        int newPopularity = oldPopularity +1;
        
        //add pop
        contentIdToPopularity.put(contentId,newPopularity);
        popularityToContentIds.computeIfAbsent(newPopularity,k->new HashSet<>()).add(contentId);
        
        //remove old pop from poptocont map
        removeFromPopularityMap(contentId, oldPopularity);
    }


    /**
     * add new (if not zero)
     * remove old
     */
    public void decreasePopularity(int contentId) {
        if(!contentIdToPopularity.containsKey(contentId)) return;
        int oldPopularity = contentIdToPopularity.get(contentId);
        int newPopularity = oldPopularity -1;
        //add/update
        if(newPopularity > 0){
            contentIdToPopularity.put(contentId,newPopularity);
            popularityToContentIds.computeIfAbsent(newPopularity,k->new HashSet<>()).add(contentId);
        }else{
            contentIdToPopularity.remove(contentId);
        }


        //remove old
        removeFromPopularityMap(contentId, oldPopularity);
    }

    private void removeFromPopularityMap(int contentId, int popularity) {
        if(popularityToContentIds.containsKey(popularity)){
            popularityToContentIds.get(popularity).remove(contentId);
            if(popularityToContentIds.get(popularity).isEmpty()){
                popularityToContentIds.remove(popularity);
            }
        }
    }
}
