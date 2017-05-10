package fog.domain;

public class Order
{
    private final int id;
    private String customerName,customerMail,customerPhone,callDate;
    private boolean status;
    private int width, length, height;
    private boolean skur, build, deleted;

    public Order(int id, String customerName, String customerMail, String customerPhone,
            boolean status, int width, int length, int height, boolean skur, boolean build, boolean deleted,String callDate)
    {
        this.id = id;
        this.customerName = customerName;
        this.customerMail = customerMail;
        this.customerPhone = customerPhone;
        this.status = status;
        this.width = width;
        this.length = length;
        this.height = height;
        this.skur = skur;
        this.build = build;
        this.deleted = deleted;
        this.callDate=callDate;
    }

    public int getId()
    {
        return id;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerMail()
    {
        return customerMail;
    }

    public void setCustomerMail(String customerMail)
    {
        this.customerMail = customerMail;
    }

    public String getCustomerPhone()
    {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone)
    {
        this.customerPhone = customerPhone;
    } 

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSkur() {
        return skur;
    }

    public void setSkur(boolean skur) {
        this.skur = skur;
    }

    public boolean isBuild() {
        return build;
    }

    public void setBuild(boolean build) {
        this.build = build;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public String getCallDate()
    {
        return callDate;
    }

    public void setCallDate(String callDate)
    {
        this.callDate = callDate;
    }
    
    
}
