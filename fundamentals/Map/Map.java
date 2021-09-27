import java.util.*;

public class Map {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("God's plan", "I been movin' calm, don't start no trouble with me Tryna keep it peaceful is a struggle for me");
        trackList.put("Gucci gang", "gucci gang gucci gang gucci gang");
        trackList.put("Love story", "this is love story, baby just say yes");
        trackList.put("Red", "loving him is like driving a new Masarati down a dead-end street");

        Set<String> keys = trackList.keySet();
        System.out.println(trackList.get("Red"));
        for(String key: keys){
            System.out.println(key + ": " + trackList.get(key));
        }
    
}
}
