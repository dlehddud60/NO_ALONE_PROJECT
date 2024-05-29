package com.dongyoung.noAlone.email.service;


import com.dongyoung.noAlone.email.event.EmailSendApplicationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
@Log4j2
@RequiredArgsConstructor
public class EmailSendEventListener {
    @Async
    @EventListener
    public void listen(EmailSendApplicationEvent event) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EmailService.codeStorage.remove(event.getEmail());
                timer.cancel();
                log.info("3분 지남. 자동 삭제");
                System.out.println(EmailService.codeStorage);
            }
        }, 3 * 60 * 1000);
    }
}
