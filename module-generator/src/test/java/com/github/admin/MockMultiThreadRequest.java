package com.github.admin;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wang lei
 * @version v0.1
 */
public class MockMultiThreadRequest {
    @Test
    public void thread() {
        AtomicInteger payPaid = new AtomicInteger();
        payPaid.addAndGet(1);
        payPaid.addAndGet(1);
        System.out.println(payPaid);
    }
}