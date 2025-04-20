package com.zara.pricing.infrastructure.controller;

import com.zara.pricing.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Test
    public void test1_getPrice_14thAt10AM() throws Exception {
        performGet("2020-06-14T10:00:00", 35455L, 1L, 35.5);
    }

    @Test
    public void test2_getPrice_14thAt16PM() throws Exception {
        performGet("2020-06-14T16:00:00", 35455L, 1L, 25.45);
    }

    @Test
    public void test3_getPrice_14thAt21PM() throws Exception {
        performGet("2020-06-14T21:00:00", 35455L, 1L, 35.5);
    }

    @Test
    public void test4_getPrice_15thAt10AM() throws Exception {
        performGet("2020-06-15T10:00:00", 35455L, 1L, 30.5);
    }

    @Test
    public void test5_getPrice_16thAt21PM() throws Exception {
        performGet("2020-06-16T21:00:00", 35455L, 1L, 38.95); // corregido aquí
    }

    private void performGet(String date, Long productId, Long brandId, double expectedPrice) throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", date)
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(expectedPrice));
    }
}
