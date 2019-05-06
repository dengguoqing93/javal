package org.mtd.chp3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩信中心路由规则管理器
 * 模式角色：ImmutableObject.ImmutableObject
 *
 * @author dengguoqing
 * @date 2019/4/24
 */
public final class MMSCRouter {
    /**
     * 用volatile修饰，保证多线程环境下该变量的可见性
     */

    private static volatile MMSCRouter instance = new MMSCRouter();

    private final Map<String, MMSCInfo> routeMap;

    public MMSCRouter() {
        this.routeMap = retrieveRouteMapFromDB();
    }

    private static Map<String, MMSCInfo> retrieveRouteMapFromDB() {
        Map<String, MMSCInfo> map = new HashMap<>();
        return map;
    }

    public static MMSCRouter getInstance() {
        return instance;
    }

    /**
     * 根据手机号码前缀偶去对应的彩信中心信息
     *
     * @param msisdnPrefix 手机号码前缀
     * @return 彩信中心信息
     */
    public MMSCInfo getMMSC(String msisdnPrefix) {
        return routeMap.get(msisdnPrefix);
    }

    /**
     * 将当前MMSCRouter的实例更新为指定的新实例
     *
     * @param mmscRouter 新的MMSCRouter实例
     */
    public static void setInstance(MMSCRouter mmscRouter) {
        instance = mmscRouter;
    }

    private static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> map) {
        Map<String, MMSCInfo> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, new MMSCInfo(map.get(key)));
        }
        return result;
    }

    public Map<String, MMSCInfo> getRouteMap() {
        return Collections.unmodifiableMap(deepCopy(routeMap));
    }
}
