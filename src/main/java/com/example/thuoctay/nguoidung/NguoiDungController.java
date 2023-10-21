package com.example.thuoctay.nguoidung;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/giohang")
@RequiredArgsConstructor
@CrossOrigin
public class NguoiDungController {

    private final NguoiDungService nguoiDungService;


    @GetMapping("/{sdt}")
    public ResponseEntity<?> getBySdt(@PathVariable(name = "sdt") String sdt) {
        return ResponseEntity.ok().body(nguoiDungService.getBySoDienThoai(sdt));
    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoGioHang(@RequestBody NguoiDungDto dto){
        return ResponseEntity.ok().body(nguoiDungService.create(dto));
    }
}
