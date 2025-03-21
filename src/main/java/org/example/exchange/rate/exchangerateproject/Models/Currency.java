package org.example.exchange.rate.exchangerateproject.Models;

import lombok.*;

@Data
@Builder
public class Currency {
    private String code;
    private String fullName;
    private String sign;
}
