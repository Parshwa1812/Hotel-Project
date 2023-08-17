package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.TableTypePriceConverter;
import com.backend.daos.ITableTypePriceDAO;
import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;

@Service
@Transactional
public class TableTypePriceService {
    
    @Autowired
    private ITableTypePriceDAO tableTypePriceDAO;
    @Autowired
    private TableTypePriceConverter tableTypePriceConverter;
    
    public TableTypePricePOJO addTable(TableTypePriceDTO tableTypePriceDTO)
    {
        TableTypePricePOJO persistedTableTypePricePOJO=tableTypePriceConverter.dtoToPojo(tableTypePriceDTO);
        
        return tableTypePriceDAO.save(persistedTableTypePricePOJO);
    } 
}
