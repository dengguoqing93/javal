package org.mtd.chp3;

/**
 * 彩信中心信息
 * 模式角色：ImmutableObject.ImmutableObject
 *
 * @author dengguoqing
 * @date 2019/4/24
 */
public class MMSCInfo {

    /**
     * 设备编号
     */
    private final String deviceID;

    /**
     * 彩信中心URL
     */
    private final String url;

    /**
     * 彩信中心允许的最大附件大小
     */
    private final int maxAttachementSizeInBytes;

    public MMSCInfo(String deviceID, String url, int maxAttachementSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttachementSizeInBytes = maxAttachementSizeInBytes;
    }

    public MMSCInfo(MMSCInfo prototype) {
        this.deviceID = prototype.deviceID;
        this.url = prototype.url;
        this.maxAttachementSizeInBytes = prototype.maxAttachementSizeInBytes;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxAttachementSizeInBytes() {
        return maxAttachementSizeInBytes;
    }
}
