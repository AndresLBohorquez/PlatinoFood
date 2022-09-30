package com.platinosfood.backend.converters;

import com.platinosfood.backend.data.OrderStatusData;
import com.platinosfood.backend.entities.OrderStatus;

public class OrderStatusConverter extends Converter<OrderStatus, OrderStatusData> {

    @Override
    public OrderStatus toEntity(OrderStatusData object) {
        return object == null ? null : OrderStatus.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

    @Override
    public OrderStatusData toData(OrderStatus object) {
        return object == null ? null : OrderStatusData.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

}
