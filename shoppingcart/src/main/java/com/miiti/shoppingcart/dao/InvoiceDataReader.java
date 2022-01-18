package com.miiti.shoppingcart.dao;

import com.miiti.shoppingcart.exception.DataReaderException;
import com.miiti.shoppingcart.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
public class InvoiceDataReader implements DataReader {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<String> read(Resource resoure) throws DataReaderException, ResourceNotFoundException {
        InputStream inStream = null;
        try {
            logger.debug("Reading invoice data..");
            inStream = resoure.getInputStream();
            return IOUtils.readLines(inStream);
        }catch(java.io.FileNotFoundException fne) {
            throw new ResourceNotFoundException(fne.getMessage());
        }catch (final IOException e) {
            throw new DataReaderException("Exception while reading invoice data file", e);
        } finally {
            IOUtils.closeQuietly(inStream);
        }
    }
}
