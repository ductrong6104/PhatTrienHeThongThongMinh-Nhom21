package com.example.thuoctay.nhieunhieu.giohang;


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
@RequestMapping("/chitietgiohang")
@RequiredArgsConstructor
@CrossOrigin
public class CTGioHangController {

    private final CTGioHangService ctGioHangService;
    
    @GetMapping("/nguoidung")
        public ResponseEntity<?> getByGioHang(@RequestParam(name="idNguoiDung") Integer idNguoiDung) {
        return ResponseEntity.ok().body(ctGioHangService.getByGioHang(idNguoiDung));
    }

    @PostMapping("/them")
    public ResponseEntity<?> themCtGioHang(@RequestBody CTGioHangDto dtos) {
        return ResponseEntity.ok().body(ctGioHangService.create(dtos));
    }


}
