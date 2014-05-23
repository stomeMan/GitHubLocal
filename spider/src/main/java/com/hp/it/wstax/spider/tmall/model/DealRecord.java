/**
 * 
 */
package com.hp.it.wstax.spider.tmall.model;

import java.util.Date;

import com.hp.it.wstax.spider.util.DateFormatter;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 20, 2013
 * @revision
 */
public class DealRecord {
    
    private String consumerName;
    
    private String productName;
    
    private Double price;
    
    private Integer volume;
    
    private Date date;

    private String status;

    /**
     * @return the consumerName
     */
    public String getConsumerName() {
        return consumerName;
    }

    /**
     * @param consumerName the consumerName to set
     */
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the volume
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DealRecord [consumerName=");
        builder.append(consumerName);
        builder.append(", productName=");
        builder.append(productName);
        builder.append(", price=");
        builder.append(price);
        builder.append(", volume=");
        builder.append(volume);
        builder.append(", date=");
        builder.append(DateFormatter.formatDateToStringTMallDeal(date));
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }

}
