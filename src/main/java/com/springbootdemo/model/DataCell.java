package com.springbootdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

/**
 * Created by ASUS on 10/16/2016.
 */
@Data
@SolrDocument(solrCoreName = "DataCells")
public class DataCell
{

    public static final String FIELD_SOLR_ID = "id";

    public static final String FIELD_ITEM_ID = "itemId";

    public static final String FIELD_NAME = "name";

    public static final String FIELD_DIMENSION = "dimension";

    public static final String FIELD_CHILDREN = "children";

    @Id
    private String id;

    @Indexed(FIELD_ITEM_ID)
    private Long itemId;

    @Indexed(FIELD_NAME)
    private String name;

    @Indexed(FIELD_DIMENSION)
    private String dimension;

    @Indexed(FIELD_CHILDREN)
    private List<Long> children;


}
