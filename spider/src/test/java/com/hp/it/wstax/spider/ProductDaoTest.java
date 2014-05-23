/**
 * 
 */
package com.hp.it.wstax.spider;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hp.it.wstax.spider.dao.ProductDao;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Jan 6, 2014
 * @revision
 */
public class ProductDaoTest {

    /**
     * Test method for {@link com.hp.it.wstax.spider.dao.ProductDao#getNameList()}.
     */
    @Test
    public void testGetNameList() {
        
        System.out.println(new ProductDao().getNameList());
        
    }

}
