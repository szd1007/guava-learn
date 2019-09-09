package org.adamx.quartz.quartzTest.entity;

/**
 * @author szd1007@github.com
 * @date 2018-12-10 15:30
 */
public class SfExpressInfo {

    private Long id;
    private String businessType;
    private Long orderId;
    private String mailNo;

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "SfExpressInfo{" + "id=" + id + ", businessType='" + businessType + '\'' + ", orderId=" + orderId + ", mailNo='" + mailNo
                + '\'' + '}';
    }
}
