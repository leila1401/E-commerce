package com.sts.Ecommerce.ECommerceApplicationBackend.entity;

import java.util.List;

public class OrderInput {

    private String fullname;
    private String fullAddress;
    private String contactNumber;
    private String alternateContactNumber;
    private List<OrderQuantity> orderQuantityList;

    public OrderInput(String fullname, String fullAddress, String contactNumber,
                      String alternateContactNumber, List<OrderQuantity> orderQuantityList) {
        this.fullname = fullname;
        this.fullAddress = fullAddress;
        this.contactNumber = contactNumber;
        this.alternateContactNumber = alternateContactNumber;
        this.orderQuantityList = orderQuantityList;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public List<OrderQuantity> getOrderQuantityList() {
        return orderQuantityList;
    }

    public void setOrderQuantityList(List<OrderQuantity> orderQuantityList) {
        this.orderQuantityList = orderQuantityList;
    }
}
