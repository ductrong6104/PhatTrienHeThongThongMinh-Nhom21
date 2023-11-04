package com.example.thuoctay.donhang;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuoctay.anotation.Role;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/donhang")
@RequiredArgsConstructor
@CrossOrigin
public class DonHangController {

    private final DonHangService donHangService;

    @Role({"ADMIN"})
    @GetMapping("")
    public ResponseEntity<?> getAllDonHang() {
        return ResponseEntity.ok().body(donHangService.getAll());
    }

    @Role({"CUSTOMER"})
    @GetMapping("/{idNguoiDung}")
    public ResponseEntity<?> getByNguoiDung(HttpServletRequest request,@PathVariable(name = "idNguoiDung") Integer idNguoiDung) {
        return ResponseEntity.ok().body(donHangService.getsByIdNguoiDung(idNguoiDung));
    }

    @Role({"CUSTOMER"})
    @GetMapping("/byid/{idDonHang}")
    public ResponseEntity<?> getByIdDonHang(HttpServletRequest request,@PathVariable(name = "idDonHang") Integer idDonHang) {
        return ResponseEntity.ok().body(donHangService.getById(idDonHang));
    }

    @Role({"CUSTOMER"})
    @PostMapping("/tao")
    public ResponseEntity<?> taoDonHang(@RequestBody DonHangDto dto){
        return ResponseEntity.ok().body(donHangService.create(dto));
    }

    @Role({"CUSTOMER", "ADMIN"})
    @PutMapping("/huy/{idDonHang}")
    public ResponseEntity<?> huyDonHang(@PathVariable(name = "idDonHang")Integer idDonHang){
        return ResponseEntity.ok().body(donHangService.huyDon(idDonHang));
    }

        @Role({"ADMIN"})
    @PutMapping("/duyet/{idDonHang}")
    public ResponseEntity<?> duyetDonHang(@PathVariable(name = "idDonHang")Integer idDonHang){
        return ResponseEntity.ok().body(donHangService.duyetDonHang(idDonHang));
    }

    @Role({"ADMIN"})
    @PutMapping("/dagiao/{idDonHang}")
    public ResponseEntity<?> daGiaoDonHang(@PathVariable(name = "idDonHang")Integer idDonHang){
        return ResponseEntity.ok().body(donHangService.daGiaoDonHang(idDonHang));
    }

        @Role({"CUSTOMER"})
    @PutMapping("/danhan/{idDonHang}")
    public ResponseEntity<?> daNhanHang(@PathVariable(name = "idDonHang")Integer idDonHang){
        return ResponseEntity.ok().body(donHangService.daNhanHang(idDonHang));
    }
}
