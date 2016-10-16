package com.springbootdemo.controller;

import com.springbootdemo.service.DataCellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ASUS on 10/16/2016.
 */
@RestController
@Scope("prototype")
public class SearchController
{

    private DataCellsService dataCellsService;

    @Autowired
    public SearchController(DataCellsService dataCellsService)
    {
        this.dataCellsService = dataCellsService;
    }

    /*@RequestMapping("/search")
    public String search(Model model, @RequestParam(value = "q", required = false) String query, @PageableDefault(
            page = 0, size = DataCellsService.DEFAULT_PAGE_SIZE) Pageable pageable, HttpServletRequest request) {

        model.addAttribute("page", dataCellsService.findByName(query, pageable));
        model.addAttribute("pageable", pageable);
        model.addAttribute("query", query);
        return "search";
    }

    @ResponseBody
    @RequestMapping(value = "/autocomplete", produces = "application/json")
    public Set<String> autoComplete(Model model, @RequestParam("term") String query,
                                    @PageableDefault(page = 0, size = 1) Pageable pageable) {
        if (!StringUtils.hasText(query)) {
            return Collections.emptySet();
        }

        FacetPage<DataCell> result = dataCellsService.autocompleteNameFragment(query, pageable);

        Set<String> titles = new LinkedHashSet<>();
        for (Page<FacetFieldEntry> page : result.getFacetResultPages()) {
            for (FacetFieldEntry entry : page) {
                if (entry.getValue().contains(query)) { // we have to do this as we do not use terms vector or a
                string field
                    titles.add(entry.getValue());
                }
            }
        }
        return titles;
    }*/
}