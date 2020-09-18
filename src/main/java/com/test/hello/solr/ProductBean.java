package com.test.hello.solr;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author NIsaev on 28.04.2020
 */
public class ProductBean {
    String id;
    String name;
    String price;

    @Field("id")
    protected void setId(String id) {
        this.id = id;
    }

    @Field("name")
    protected void setName(String name) {
        this.name = name;
    }

    @Field("price")
    protected void setPrice(String price) {
        this.price = price;
    }

    public ProductBean(){

    }

    public ProductBean(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
