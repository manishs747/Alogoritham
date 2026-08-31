package Interview.atlas.popularContentID;

import java.util.*;

public class PopularContentManager {
    private  final Map<Integer,Integer> contentIdToPopularity = new HashMap<>();
    private final TreeMap<Integer, Set<Integer>>  popularityToContentIds = new TreeMap<>(Comparator.reverseOrder());

    // Increase popularity of a contentId
    public void increasePopularity(int contentId) {
        int oldPopularity = contentIdToPopularity.getOrDefault(contentId,0);
        int newPopularity = oldPopularity+1;

        //add new
        contentIdToPopularity.put(contentId,newPopularity);

        //add new to popular map
        Set<Integer>  contentIds = popularityToContentIds.getOrDefault(newPopularity,new HashSet<>());
        contentIds.add(contentId);
        popularityToContentIds.put(newPopularity,contentIds);
        //popularityToContentIds.computeIfAbsent(newPopularity, k -> new HashSet<>()).add(contentId);

        //remove old
        removeFromPopularityMap(contentId, oldPopularity);
    }

    public void decreasePopularity(int contentId) {
        if(!contentIdToPopularity.containsKey(contentId)) return;
        int oldPopularity = contentIdToPopularity.get(contentId);
        int newPopularity = oldPopularity -1;

        //add update only new Populairy is grater than 0
        if(newPopularity > 0){ //add/update
            contentIdToPopularity.put(contentId,newPopularity);
            popularityToContentIds.computeIfAbsent(newPopularity,k-> new HashSet<>()).add(contentId);
        }else{ //if new popularity is zero or less
            contentIdToPopularity.remove(contentId);
        }
        //remove old :(old cannot be zero
        removeFromPopularityMap(contentId, oldPopularity);
    }

    public int mostPopular() {
        if (popularityToContentIds.isEmpty()) return -1;
        return popularityToContentIds.firstEntry().getValue().iterator().next();
    }

        private void removeFromPopularityMap(int contentId, int popularity) {
        Set<Integer> contentIdSet  = popularityToContentIds.get(popularity);
        if(contentIdSet != null){
            contentIdSet.remove(contentId);
            if(contentIdSet.isEmpty()){
                popularityToContentIds.remove(popularity);
            }
        }
    }

    public static void main(String[] args) {
        PopularContentManager manager = new PopularContentManager();

        manager.increasePopularity(7);
        manager.increasePopularity(7);
        manager.increasePopularity(8);

        System.out.println(manager.mostPopular()); // returns 7

        manager.decreasePopularity(7);
        manager.decreasePopularity(8);

        System.out.println(manager.mostPopular()); // returns -1 (no popular content left)
    }


}
