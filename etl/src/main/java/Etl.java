import java.util.*;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            for (String score : entry.getValue()) {
                resultMap.put(score.toLowerCase(), entry.getKey());
            }
        }

        return resultMap;
   }
}
