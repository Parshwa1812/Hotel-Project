package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ITableTypePriceConverter;
import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;

@Component
public class TableTypePriceConverter implements ITableTypePriceConverter{

    @Override
    public TableTypePricePOJO dtoToPojo(TableTypePriceDTO tableTypePriceDTO) {
        TableTypePricePOJO tableTypePricePOJO=new TableTypePricePOJO();
        tableTypePricePOJO.setTableTypeId(tableTypePriceDTO.getTableTypeId());
        tableTypePricePOJO.setAvailableTables(tableTypePriceDTO.getAvailableTables());
        tableTypePricePOJO.setPrice(tableTypePriceDTO.getPrice());
        tableTypePricePOJO.setSeats(tableTypePriceDTO.getSeats());
        tableTypePricePOJO.setTableImage(tableTypePriceDTO.getTableImage());
        tableTypePricePOJO.setTableType(tableTypePriceDTO.getTableType());
        return tableTypePricePOJO;

    }

    @Override
    public List<TableTypePricePOJO> dtoToPojo(List<TableTypePriceDTO> tableTypePriceDTOs) {
        return tableTypePriceDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public TableTypePriceDTO pojoToDto(TableTypePricePOJO tableTypePricePOJO) {
         TableTypePriceDTO tableTypePriceDTO=new TableTypePriceDTO();
        tableTypePriceDTO.setTableTypeId(tableTypePriceDTO.getTableTypeId());
        tableTypePriceDTO.setAvailableTables(tableTypePriceDTO.getAvailableTables());
        tableTypePriceDTO.setPrice(tableTypePriceDTO.getPrice());
        tableTypePriceDTO.setSeats(tableTypePriceDTO.getSeats());
        tableTypePriceDTO.setTableImage(tableTypePriceDTO.getTableImage());
        tableTypePriceDTO.setTableType(tableTypePriceDTO.getTableType());
        return tableTypePriceDTO;
        
    }

    @Override
    public List<TableTypePriceDTO> pojoToDto(List<TableTypePricePOJO> tableTypePricePOJOs) {
        return tableTypePricePOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
