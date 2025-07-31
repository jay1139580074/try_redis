package com.junjie.tryredis.service;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.junjie.tryredis.dao.CustomerRepository;
import com.junjie.tryredis.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

@Service
@Slf4j
public class CustomerService {
    public static final String CACHE_KEY_CUSTOMER = "customer:";

    private final CustomerRepository customerRepository;
    private final RedisTemplate redisTemplate;

    public CustomerService(CustomerRepository customerRepository, RedisTemplate redisTemplate) {
        this.customerRepository = customerRepository;
        this.redisTemplate = redisTemplate;
    }

    private final BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10000);

    public Customer addCustomer(Customer customer){
        customer = customerRepository.save(customer);
        if (customer.getId() != null) {
            bloomFilter.put(String.valueOf(customer.getId()));
            log.info("Customer added successfully: {}", customer.getId());
            redisTemplate.opsForValue().set(CACHE_KEY_CUSTOMER + customer.getId(), customer);
            return customer;
        } else {
            log.error("Failed to add customer: {}", customer);
            return customer;
        }
    }

    public Customer getCustomerById(String id){
        if(!bloomFilter.mightContain(id)){
            log.warn("BloomFilter: Customer ID {} definitely not exist", id);
            return null;
        }

        Customer customer = (Customer) redisTemplate.opsForValue().get(CACHE_KEY_CUSTOMER + id);
        if (customer == null) {
            log.info("Cache miss for customer ID: {}", id);
            customer = customerRepository.findById(Integer.parseInt(id)).orElse(null);
            if (customer != null) {
                redisTemplate.opsForValue().set(CACHE_KEY_CUSTOMER + id, customer);
            } else {
                log.warn("Customer not found for ID: {}", id);
            }
        } else {
            log.info("Cache hit for customer ID: {}", id);
        }
        return customer;
    }
}
