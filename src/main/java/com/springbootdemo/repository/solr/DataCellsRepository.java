package com.springbootdemo.repository.solr;

import com.springbootdemo.model.DataCell;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by ASUS on 10/16/2016.
 */
@Repository
public interface DataCellsRepository extends SolrCrudRepository<DataCell, String>
{
/*    @Highlight(prefix = "<b>", postfix = "</b>")
    @Query(fields = {DataCell.FIELD_SOLR_ID, DataCell.FIELD_ITEM_ID, DataCell.FIELD_NAME,
            DataCell.FIELD_DIMENSION, DataCell.FIELD_CHILDREN}, defaultOperator = Operator.AND)
    HighlightPage<DataCell> findByNameIn(Collection<String> names, Pageable page);*/

    @Facet(fields = {DataCell.FIELD_NAME})
    FacetPage<DataCell> findByNameStartsWith(Collection<String> nameFragments, Pageable pagebale);

    List<DataCell> findByNameIn(Collection<String> names);

}
