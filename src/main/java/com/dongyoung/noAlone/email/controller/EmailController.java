package com.dongyoung.noAlone.email.controller;

import com.dongyoung.noAlone.email.model.FindRequestEmailModel;
import com.dongyoung.noAlone.email.service.impl.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
@Log4j2
public class EmailController {
    private final EmailServiceImpl emailServiceImpl;

    @PostMapping
    public ResponseEntity<Boolean> sendEmail(@RequestParam String email) {
        return ResponseEntity.ok(emailServiceImpl.sendEmail(email));
    }//

    @PostMapping("/confirm")
    public ResponseEntity<Boolean> confirmEmail(@RequestBody FindRequestEmailModel emailDto) {
        return ResponseEntity.ok(emailServiceImpl.confirmEmail(emailDto));
    }
}
