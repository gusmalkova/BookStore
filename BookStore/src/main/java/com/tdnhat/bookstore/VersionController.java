package com.tdnhat.bookstore;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.ws.rs.core.MediaType;

@PermitAll
@RestController
public class VersionController {

    @ResponseBody
    @GetMapping(value = "/version", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<String> getVersion() {
        return ResponseEntity.ok("0.0.1-SNAPSHOT");
    }
}
