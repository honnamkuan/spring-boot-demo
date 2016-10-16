package com.springbootdemo.controller;

import com.springbootdemo.model.DataCell;
import com.springbootdemo.service.DataCellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASUS on 10/16/2016.
 */
@RestController
@RequestMapping("dataCells")
public class DataCellsController
{

    private DataCellsService dataCellsService;

    @Autowired
    public DataCellsController(DataCellsService dataCellsService)
    {
        this.dataCellsService = dataCellsService;
    }


    @GetMapping
    public Iterable<DataCell> search(@RequestParam(value = "name", required = false, defaultValue = "") String pName)
    {
        Iterable<DataCell> results = dataCellsService.findByName(pName);
        if (SolrResultPage.class.isInstance(results))
        {
            return ((SolrResultPage<DataCell>) results).getContent();
        }
        return results;
    }

    @GetMapping("{id}")
    public DataCell findById(@PathVariable("id") String id)
    {
        return dataCellsService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody List<DataCell> pDataCells)
    {
        dataCellsService.save(pDataCells);
    }


}