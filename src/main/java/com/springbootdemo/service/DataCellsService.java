package com.springbootdemo.service;

import com.springbootdemo.model.DataCell;
import com.springbootdemo.repository.solr.DataCellsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by ASUS on 10/16/2016.
 */
@Service
public class DataCellsService
{
    private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");
    private DataCellsRepository dataCellRepository;

    @Autowired
    public DataCellsService(DataCellsRepository pDataCellRepository)
    {
        this.dataCellRepository = pDataCellRepository;
    }

    public Iterable<DataCell> findByName(String searchTerm)
    {
        if (StringUtils.isBlank(searchTerm))
        {
            return dataCellRepository.findAll();
        }

        return dataCellRepository.findByNameIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm));
    }

    public DataCell findById(String id)
    {
        return dataCellRepository.findOne(id);
    }

/*    public FacetPage<DataCell> autocompleteNameFragment(String fragment, Pageable pageable)
    {
        if (StringUtils.isBlank(fragment))
        {
            return new SolrResultPage<>(Collections.<DataCell>emptyList());
        }
        return dataCellRepository.findByNameStartsWith(splitSearchTermAndRemoveIgnoredCharacters(fragment), pageable);
    }*/

    private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm)
    {
        String[] searchTerms = StringUtils.split(searchTerm, " ");
        List<String> result = new ArrayList<>(searchTerms.length);
        for (String term : searchTerms)
        {
            if (StringUtils.isNotEmpty(term))
            {
                result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
            }
        }
        return result;
    }

    public void save(List<DataCell> pDataCells)
    {
        dataCellRepository.save(pDataCells);
    }


}
