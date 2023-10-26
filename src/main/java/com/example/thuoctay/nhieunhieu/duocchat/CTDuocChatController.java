package com.example.thuoctay.nhieunhieu.duocchat;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuoctay.anotation.Role;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chitietduocchat")
@RequiredArgsConstructor
@CrossOrigin
public class CTDuocChatController {

    private final CTDuocChatService ctDuocChatService;
    
    @GetMapping("/thuoc")
        public ResponseEntity<?> getByThuoc(@RequestParam(name="idThuoc") Integer idThuoc) {
        return ResponseEntity.ok().body(ctDuocChatService.getByIdThuoc(idThuoc));
    }

    @Role("ADMIN")
    @PostMapping("/them")
    public ResponseEntity<?> themCtDuocChat(@RequestBody Set<CTDuocChatDto> dtos) {
        return ResponseEntity.ok().body(ctDuocChatService.createAll(dtos));
    }

    @Role("ADMIN")
    @PostMapping("/capnhat/{idThuoc}")
    public ResponseEntity<?> capNhatCTDC(@RequestBody Set<CTDuocChatDto> dtos, @PathVariable(name = "idThuoc") Integer idThuoc) {
        return ResponseEntity.ok().body(ctDuocChatService.capNhatCTDCByIdThuoc(idThuoc, dtos));
    }


}
