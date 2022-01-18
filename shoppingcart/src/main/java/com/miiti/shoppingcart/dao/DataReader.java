package com.miiti.shoppingcart.dao;

import com.miiti.shoppingcart.exception.DataReaderException;
import com.miiti.shoppingcart.exception.ResourceNotFoundException;
import org.springframework.core.io.Resource;

import java.util.List;

public interface DataReader {
    public List<String> read(Resource resoure)  throws DataReaderException, ResourceNotFoundException;
}
