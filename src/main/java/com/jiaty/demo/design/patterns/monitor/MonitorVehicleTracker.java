package com.jiaty.demo.design.patterns.monitor;

import javax.annotation.concurrent.GuardedBy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: practice
 * @description: 基于监视器模式的车辆追踪
 * @author: Jiaty
 * @create: 2020-10-19 16:06
 **/

public class MonitorVehicleTracker {
    /**
     * 虽然类MutablePoint不是线程安全的，但追踪累是线程安全的。它所包含的Map对象和可变的point对象都未曾发布，
     * 当需要返回车辆的位置时，通过MutablePoint拷贝构造函数或者deepCopy方法来复制正确的值，从而生成一个新的Map对象，
     * 并且该对象中的值与原有Map对象中的key值和value值都相同
     * <p>
     * 在某种程度上，这种实现方式算是通过在返回客户代码之前复制可变的数据来维持线程安全性的。通常情况下，这并不存在性能问题，
     * 但在车辆容器非常大的情况下将极大地降低性能，此外，由于每次调用getLocation就要复制数据，因此将出现一种错误情况--
     * 虽然车辆的实际位置发生了变化，但返回的信息却保持不变。这种情况是好还是坏，要取决于你的需求。如果在location集合上存在内部
     * 的一致性需求，那么这就是优点，在这种情况下返回一致的快照就非常重要。然而，如果调用者需要每辆车的最新信息，那么这就是缺点，
     * 因为这需要非常频繁地刷新快照
     */

    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }


    public synchronized MutablePoint getLocations(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocations(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    /**
     * 注意，deepCopy并不只是用unmodifiableMap来包装Map，因为这只能放置容器对象被修改，而不能防止调用者修改保存在容器中的可变对象，
     * 基于同样的原因，如果只是通过拷贝构造函数来填充deepCopy中的HashMap，那么同样是不正确的，因为这样做只复制了指向Point对象的引用，
     * 而不是Point对象本身
     * <p>
     * <p>
     * 由于deepCopy是从一个synchronized方法中调用的，因此在执行时间较长的复制操作中，tracker的内置锁将一直被占用，
     * 当大量车辆需要追踪时，会严重降低用户界面的响应灵敏度
     */
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }


    /**
     * Collections.unmodifiableMap方法返回了一个无法被修改的Map视图，不可以对UnmodifiableMap进行put，remove等操作，
     * 但是可以get到对象，对里面的对象做操作。
     */

}