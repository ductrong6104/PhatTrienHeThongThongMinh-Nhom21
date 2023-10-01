package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chitietduocchat")
@RequiredArgsConstructor
@CrossOrigin
public class CTDuocChatController {

    private final CTDuocChatService ctDuocChatService;
    
    @PostMapping("/them")
    public ResponseEntity<?> taoNhom(@RequestBody Set<CTDuocChatDto> dtos) {
        return ResponseEntity.ok().body(ctDuocChatService.createAll(dtos));
    }
}
