package models.entities.relationship;

import java.util.HashMap;
import java.util.Map;

class ReverseEnumMap {

    private Map<Integer, RelationshipType> map = new HashMap<Integer, RelationshipType>();

    public ReverseEnumMap() {
        for (RelationshipType v : RelationshipType.class.getEnumConstants()) {
            map.put(v.getNum(), v);
        }
    }

    public RelationshipType get(Integer num) {
        return map.get(num);
    }
}
