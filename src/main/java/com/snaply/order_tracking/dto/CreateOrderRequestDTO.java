package com.snaply.order_tracking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequestDTO {

    private String customerName;
    private String phoneNumber;
    private String product;
}
