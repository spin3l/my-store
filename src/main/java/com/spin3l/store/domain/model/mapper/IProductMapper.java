package com.spin3l.store.domain.model.mapper;

import com.spin3l.store.domain.model.Product;
import com.spin3l.store.domain.model.dto.ProductCreateDto;
import com.spin3l.store.domain.model.dto.ProductDto;
import com.spin3l.store.domain.model.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IProductMapper {

    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    ProductDto productToProductDto(Product product);
    Product productCreateDtoToProduct(ProductCreateDto dto);
    Product productUpdateDtoToProduct(ProductUpdateDto dto);
}
