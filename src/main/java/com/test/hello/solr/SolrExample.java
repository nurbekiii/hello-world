package com.test.hello.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

/**
 * @author NIsaev on 28.04.2020
 */
public class SolrExample {

    public static void main(String[] args) throws IOException, SolrServerException {
        String urlString = "http://localhost:8983/solr/bigboxstore_77";
        HttpSolrClient solrClient = new HttpSolrClient.Builder(urlString).build();
        solrClient.setParser(new XMLResponseParser());
        //solrClient.setParser(new QESXMLResponseParser());

        /*SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "123456");
        document.addField("name", "Kenmore Dishwasher");
        document.addField("price", "599.99");
        solrClient.add(document);
        solrClient.commit();*/

        //solrClient.addBean( new ProductBean("888", "Apple iPhone 6s", "299.99") );
        //solrClient.commit();

        SolrQuery query = new SolrQuery();
        query.set("q", "id:888, author:martin, name:thrones");
        //query.set("q", "author:martin");

        QueryResponse response = solrClient.query(query);

        SolrDocumentList docList = response.getResults();
        //assertEquals(docList.getNumFound(), 1);

        for (SolrDocument doc : docList) {
            System.out.println(doc.getFieldValue("id") + "|"+doc.getFieldValue("price")+ "|"+doc.getFieldValue("name"));
            System.out.println("---------");
        }
    }
}
