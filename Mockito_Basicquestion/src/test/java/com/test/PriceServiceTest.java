package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prac.Discount;
import com.prac.PriceService;

public class PriceServiceTest {

    @Test
    public void testCalculateFinalPrice_MOB() {

        // create mock object
        Discount discountMock = mock(Discount.class);

        // tell mock what to return
        when(discountMock.getDiscountPercentage("MOB"))
                .thenReturn(10.0);

        // pass mock into service
        PriceService service = new PriceService(discountMock);

        double result = service.calculateFinalPrice(1000, "MOB");

        assertEquals(900.0, result);

        verify(discountMock).getDiscountPercentage("MOB");
    }

    @Test
    public void testCalculateFinalPrice_LAP() {

        Discount discountMock = mock(Discount.class);

        when(discountMock.getDiscountPercentage("LAP"))
                .thenReturn(20.0);

        PriceService service = new PriceService(discountMock);

        double result = service.calculateFinalPrice(2000, "LAP");

        assertEquals(1600.0, result);

        verify(discountMock).getDiscountPercentage("LAP");
    }

    @Test
    public void testCalculateFinalPrice_Exception() {

        Discount discountMock = mock(Discount.class);

        when(discountMock.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("Service unavailable"));

        PriceService service = new PriceService(discountMock);

        assertThrows(RuntimeException.class, () -> {
            service.calculateFinalPrice(1000, "ERR");
        });

        verify(discountMock).getDiscountPercentage("ERR");
    }
}
