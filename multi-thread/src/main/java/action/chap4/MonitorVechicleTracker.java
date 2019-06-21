package action.chap4;

import action.commong.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于监视器模式的车辆追踪
 *
 * @author dengguoqing
 * @date 2019/5/16
 */
@ThreadSafe
public class MonitorVechicleTracker {
    private final Map<String, MutablePoint> locactions;

    public MonitorVechicleTracker(
            Map<String, MutablePoint> locactions) {
        this.locactions = deepCopy(locactions);
    }

    public synchronized Map<String, MutablePoint> getLocactions() {
        return deepCopy(locactions);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locactions.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocaction(String id, int x, int y) {
        MutablePoint loc = locactions.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}
