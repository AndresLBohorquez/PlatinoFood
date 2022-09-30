package com.platinosfood.backend.data;

import com.platinosfood.backend.entities.OrderStatus;
import com.platinosfood.backend.entities.Product;
import com.platinosfood.backend.entities.User;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenData {

    private int id;
    private User user;
    private Date orderDate;
    private double total;
    private boolean enable;
    private String orderCode;
    private OrderStatus orderStatus;
    private List<Product> products;
}
