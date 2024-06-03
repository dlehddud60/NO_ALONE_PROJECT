package com.dongyoung.noAlone.email.service.impl;

import com.dongyoung.noAlone.email.event.EmailSendApplicationEvent;
import com.dongyoung.noAlone.email.model.FindRequestEmailModel;
import com.dongyoung.noAlone.email.service.EmailService;
import com.dongyoung.noAlone.email.status.ExceptionCode;
import com.dongyoung.noAlone.exception.CustomException;
import com.dongyoung.noAlone.member.service.MemberService;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final MemberService memberService;
    private final TemplateEngine templateEngine;
    public static final Map<String, String> codeStorage = new ConcurrentHashMap<>();
    @Value("${email.from.address}")
    private String FROM_ADDRESS;
    @Value("${email.from.name}")
    private String FROM_NAME;
    private String ePw;
    private final ApplicationEventPublisher publisher;


    @Override
    public boolean sendEmail(String email){
        if(memberService.verifyExistEmail(email)) {
            log.info("이메일 중복");
            return false;
        }
        MimeMessage message = null;
        try {
            ePw = createKey();
            message = mailSender.createMimeMessage();
            message.setFrom(new InternetAddress(FROM_ADDRESS, FROM_NAME,"UTF-8"));
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(email);
            helper.setSubject("InddyBuddy의 회원가입 인증 코드입니다.");

            Context context = new Context();
            context.setVariable("ePw", ePw);

            String html = templateEngine.process("email", context);
            helper.setText(html, true);

            helper.addInline("image", new ClassPathResource("static/img/logo.jpg"));
        } catch (Exception e) {
            log.info("=====에러====");
            e.printStackTrace();
        }

        try {
            if (!codeStorage.containsKey(email)) {
                log.info("인증번호 전송");
                log.info(ePw);
                mailSender.send(message);
                codeStorage.put(email, ePw);
                System.out.println(codeStorage);
                publisher.publishEvent(new EmailSendApplicationEvent(this, email, ePw));
            } else {
                log.info("3분이 지나지 않았으므로 전송 불가");
                throw new CustomException(ExceptionCode.CODE_ISSUANCE_UNAVAILABLE);
            }
        } catch (MailException es) {
            es.printStackTrace();
            log.info("인증번호 전송 실패");
            codeStorage.remove(email);
            System.out.println(codeStorage);
            throw new CustomException(ExceptionCode.MAIL_SEND_ERROR);
        }
        return true;
    }

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) {
            int index = rnd.nextInt(3);
            switch (index) {
                case 0:
                    key.append((char) (rnd.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) (rnd.nextInt(26) + 65));
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    break;
            }
        }
        return key.toString();
    }

    @Override
    public boolean confirmEmail(FindRequestEmailModel emailDto) {
        String email = emailDto.email();
        String code = emailDto.code();
        String findCode = codeStorage.get(email);
        log.info("이메일과 코드가 일치하는지 확인");
        if (code.equals(findCode)) {
            log.info("일치!!!");
            codeStorage.remove(email);
            log.info(codeStorage);
            log.info(codeStorage);
            return true;
        }
        log.info("불일치!!!");
        log.info(codeStorage);
        return false;
    }

    @Async
    @EventListener
    public void listen(EmailSendApplicationEvent event) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EmailServiceImpl.codeStorage.remove(event.getEmail());
                timer.cancel();
                log.info("3분 지남. 자동 삭제");
                log.info(EmailServiceImpl.codeStorage);
                System.out.println();
            }
        }, 3 * 60 * 1000);
    }


}
