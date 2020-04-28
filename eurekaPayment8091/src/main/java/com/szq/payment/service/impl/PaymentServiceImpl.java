package com.szq.payment.service.impl;

import com.szq.entry.Payment;
import com.szq.payment.dao.PaymentDao;
import com.szq.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentbyId(Long id) {
        return paymentDao.getPaymentbyId(id);
    }
}
