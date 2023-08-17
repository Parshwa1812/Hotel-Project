package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;
import com.backend.services.TableTypePriceService;

@RestController
@RequestMapping("/table")
public class TableTypePriceController {

    @Autowired
    private TableTypePriceService tableTypePriceService;

    @PostMapping("/add-table-type")
    public TableTypePricePOJO addTable(@RequestBody TableTypePriceDTO tableTypePriceDTO)
    {
        return tableTypePriceService.addTable(tableTypePriceDTO);
    }
}
