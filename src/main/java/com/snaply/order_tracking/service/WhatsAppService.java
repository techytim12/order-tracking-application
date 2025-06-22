package com.snaply.order_tracking.service;

public interface WhatsAppService {

    public void sendWhatsAppMessage(String toPhoneNumber, String message);
}
