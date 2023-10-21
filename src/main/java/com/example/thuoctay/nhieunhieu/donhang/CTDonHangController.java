package com.example.thuoctay.nhieunhieu.donhang;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chitietdonhang")
@RequiredArgsConstructor
@CrossOrigin
public class CTDonHangController {

    private final CTDonHangService ctDonHangService;
    
    @GetMapping("/donhang")
        public ResponseEntity<?> getByThuoc(@RequestParam(name="idDonHang") Integer idDonHang) {
        return ResponseEntity.ok().body(ctDonHangService.getByDonHang(idDonHang));
    }

    @PostMapping("/them")
    public ResponseEntity<?> themCtDonHang(@RequestBody Set<CTDonHangDto> dtos) {
        return ResponseEntity.ok().body(ctDonHangService.createAll(dtos));
    }


}
