package com.acme.banking.dbo.ooad;

import com.acme.banking.dbo.ooad.service.NostalgieCurrencyService;
import com.acme.banking.dbo.ooad.service.TransferService;

public class Framework {
    public static void main(String[] args) {
        XmlApplicationConfigBuilder("my.xml").build();

        TransferService transferService = new TransferService(
            new NostalgieCurrencyService(
            30
            )
        );

    }
}
