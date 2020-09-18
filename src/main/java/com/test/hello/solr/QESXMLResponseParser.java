package com.test.hello.solr;

import org.apache.solr.client.solrj.impl.XMLResponseParser;

/**
 * @author NIsaev on 28.04.2020
 */
public class QESXMLResponseParser extends XMLResponseParser {
    public QESXMLResponseParser() {
        super();
    }

    @Override
    public String getContentType() {
        return "text/xml; charset=UTF-8";
    }
}
