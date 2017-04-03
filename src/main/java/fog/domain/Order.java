/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.domain;

/**
 *
 * @author Pravien
 */
public class Order
{
    private int id;
    private String customerName,customerMail,customerPhone;
    private boolean isFinished;

    public Order(int id, String customerName, String customerMail, String customerPhone)
    {
        this.id = id;
        this.customerName = customerName;
        this.customerMail = customerMail;
        this.customerPhone = customerPhone;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
}
