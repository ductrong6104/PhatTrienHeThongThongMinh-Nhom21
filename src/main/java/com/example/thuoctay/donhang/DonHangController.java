package com.example.thuoctay.donhang;


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
@RequestMapping("/donhang")
@RequiredArgsConstructor
@CrossOrigin
public class DonHangController {

    private final DonHangService donHangService;


    @GetMapping("/{idNguoiDung}")
    public ResponseEntity<?> getByNguoiDung(@PathVariable(name = "idNguoiDung") Integer idNguoiDung) {
        return ResponseEntity.ok().body(donHangService.getsByNguoiDung(idNguoiDung));
    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoGioHang(@RequestBody DonHangDto dto){
        return ResponseEntity.ok().body(donHangService.create(dto));
    }
}
