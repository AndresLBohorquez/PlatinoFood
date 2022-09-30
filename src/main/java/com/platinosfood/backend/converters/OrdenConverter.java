package com.platinosfood.backend.converters;

import com.platinosfood.backend.data.OrdenData;
import com.platinosfood.backend.entities.Orden;

public class OrdenConverter extends Converter<Orden, OrdenData> {

    UserConverter userConverter = new UserConverter();
    OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
    ProductConverter productConverter = new ProductConverter();

    @Override
    public Orden toEntity(OrdenData object) {
        return object == null ? null : Orden.builder()
                .id(object.getId())
                //.user(userConverter.toEntity(object.getUser()))
                .orderDate(object.getOrderDate())
                .total(object.getTotal())
                .enable(object.isEnable())
                .orderCode(object.getOrderCode())
                //.products(productConverter.toEntity(object.getProducts()))
                //.orderStatus(orderStatusConverter.toEntity(object.getOrderStatus()))
                .build();

    }

    @Override
    public OrdenData toData(Orden object) {
        return object == null ? null : OrdenData.builder()
                .id(object.getId())
                //.user(userConverter.toData(object.getUser()))
                .orderDate(object.getOrderDate())
                .total(object.getTotal())
                .enable(object.isEnable())
                .orderCode(object.getOrderCode())
                //.products(productConverter.toData(object.getProducts()))
                //.orderStatus(orderStatusConverter.toData(object.getOrderStatus()))
                .build();
    }

}
