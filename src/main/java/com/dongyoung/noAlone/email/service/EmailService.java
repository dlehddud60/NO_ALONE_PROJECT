package com.dongyoung.noAlone.email.service;

import com.dongyoung.noAlone.email.event.EmailSendApplicationEvent;
import com.dongyoung.noAlone.email.model.FindRequestEmailModel;

public interface EmailService {

    boolean sendEmail(String email);
    boolean confirmEmail(FindRequestEmailModel emailDto);
}
