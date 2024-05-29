package com.dongyoung.noAlone.email.controller;

import com.dongyoung.noAlone.email.model.FindRequestEmailModel;
import com.dongyoung.noAlone.email.model.FindResponseEmailModel;
import com.dongyoung.noAlone.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
@Log4j2
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Boolean> sendEmail(@RequestParam String email) throws Exception {
        return ResponseEntity.ok(emailService.sendEmail(email));
    }

    @PostMapping("/confirm")
    public ResponseEntity<Boolean> confirmEmail(@RequestBody FindRequestEmailModel emailDto) {
        return ResponseEntity.ok(emailService.confirmEmail(emailDto));
    }
}
