package com.example.thuoctay.donhang;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.nguoidung.NguoiDungDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/donhang")
@RequiredArgsConstructor
@CrossOrigin
public class DonHangController {

    private final DonHangService donHangService;

    @Role({"CUSTOMER"})
    @GetMapping("/{idNguoiDung}")
    public ResponseEntity<?> getByNguoiDung(HttpServletRequest request,@PathVariable(name = "idNguoiDung") Integer idNguoiDung) {
        NguoiDungDto nguoiDungDto = (NguoiDungDto)request.getAttribute("user");
        System.out.println("\n\n\n\n\n" + nguoiDungDto.toString() + "\n\n\n\n\n");
        return ResponseEntity.ok().body(donHangService.getsByIdNguoiDung(idNguoiDung));
    }

    @Role({"CUSTOMER"})
    @PostMapping("/tao")
    public ResponseEntity<?> taoDonHang(@RequestBody DonHangDto dto){
        return ResponseEntity.ok().body(donHangService.create(dto));
    }
}
