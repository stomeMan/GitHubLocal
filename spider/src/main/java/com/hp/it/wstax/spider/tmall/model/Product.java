/**
 * 
 */
package com.hp.it.wstax.spider.tmall.model;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public class Product {
	private static final String PRODUCT_URL_PREFIX = "productUrl";
	private static final String PRODUCT_NAME_PREFIX = "productName";
    private long productId;
    
    private String productUrl;
    
    private String productName;
    
    private int vendorId;
    
    private int categoryId;
    
    private Map<String, String> productDescDetails = new HashMap<String, String>();

    /**
     * @param productUrl
     * @param productName
     */
    public Product(String productUrl, String productName) {
        super();
        this.productUrl = productUrl;
        this.productName = productName;
    }
    
	/**
	 * Parse the product URL and name from product toString() content
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 26, 2013 12:58:42 PM
	 * @param productContent
	 * @return
	 */
	public static Product parseToConstructProduct(String productContent){
		int urlIndexStart = productContent.indexOf(PRODUCT_URL_PREFIX);
		int nameIndexStart = productContent.indexOf(PRODUCT_NAME_PREFIX);
		String productUrl = productContent.substring(urlIndexStart + PRODUCT_URL_PREFIX.length() + 1, nameIndexStart).trim();
		productUrl = productUrl.substring(0, productUrl.lastIndexOf(","));
		String productName = productContent.substring(nameIndexStart + PRODUCT_NAME_PREFIX.length() + 1, productContent.length() - 1).trim();
		Product product = new Product(productUrl, productName);
		return product;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product [" + PRODUCT_URL_PREFIX + "=");
        builder.append(productUrl);
        builder.append(", " + PRODUCT_NAME_PREFIX + "=");
        builder.append(productName);
        builder.append("]");
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result
                + ((productUrl == null) ? 0 : productUrl.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productUrl == null) {
            if (other.productUrl != null)
                return false;
        } else if (!productUrl.equals(other.productUrl))
            return false;
        return true;
    }

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	 /**
     * @return the productUrl
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * @param productUrl the productUrl to set
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
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
     * @return the productDescDetails
     */
    public Map<String, String> getProductDescDetails() {
        return productDescDetails;
    }

    /**
     * @param productDescDetails the productDescDetails to set
     */
    public void setProductDescDetails(Map<String, String> productDescDetails) {
        this.productDescDetails = productDescDetails;
    }

    
    /**
     *  used for vertica DB change easily
     *  
     */
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
