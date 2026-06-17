package org.example.currency_convert.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    private double rate = 26.324;

    public double convert(double usd) {
        return rate * usd;
    }
}
