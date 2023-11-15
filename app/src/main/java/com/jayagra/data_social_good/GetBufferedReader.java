package com.jayagra.data_social_good;

import java.io.InputStream;

public class GetBufferedReader {
    public GetBufferedReader() {}

    public InputStream a() {
        System.out.println(this.getClass().getResource("/air.txt"));
        return this.getClass().getResourceAsStream("/air.txt");
    }
}
