package com.example.thuoctay.thuonghieu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.utils.ResUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/thuonghieu")
@RequiredArgsConstructor
@CrossOrigin
public class ThuongHieuController {

    private final ThuongHieuService thuongHieuService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(thuongHieuService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex) {
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(thuongHieuService.getById(id));
    }

    @GetMapping("/checktenthuonghieu")
    public ResponseEntity<?> checkTenThuongHieu(@RequestParam(name = "tenThuongHieu") String ten) {
        return ResponseEntity.ok().body(thuongHieuService.getByTen(ten));
    }

    @Role({"ADMIN"})
    @PostMapping("/tao")
    public ResponseEntity<?> taoThuongHieu(@RequestParam(name = "tenthuongHieu") String tenthuongHieu) {
        ThuongHieuDto dto = ThuongHieuDto.builder().id(0).tenThuongHieu(tenthuongHieu).build();
        return ResponseEntity.ok().body(thuongHieuService.create(dto));
    }

    @Role({"ADMIN"})
    @PutMapping("/sua")
    public ResponseEntity<?> suaThuongHieu(
            @RequestParam(name = "idThuongHieu") Integer idThuongHieu,
            @RequestParam(name = "tenThuongHieu") String tenThuongHieu) {
        ThuongHieuDto dto = ThuongHieuDto.builder().id(idThuongHieu).tenThuongHieu(tenThuongHieu)
                .build();
        return ResponseEntity.ok().body(thuongHieuService.edit(dto));

    }

    @Role({"ADMIN"})
    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaThuongHieu(@RequestParam(name = "idThuongHieu") Integer id) {
        return ResponseEntity.ok().body(thuongHieuService.delete(id));
    }
}
