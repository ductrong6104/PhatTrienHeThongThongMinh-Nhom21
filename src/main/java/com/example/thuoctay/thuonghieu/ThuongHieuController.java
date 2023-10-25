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

    @PostMapping("/tao")
    public ResponseEntity<?> taoThuongHieu(@RequestParam(name = "hinhAnh") MultipartFile hinhAnh,
            @RequestParam(name = "tenthuongHieu") String tenthuongHieu) {
        String fileName = ResUtils.saveImage(hinhAnh);
        ThuongHieuDto dto = ThuongHieuDto.builder().id(0).tenThuongHieu(tenthuongHieu).hinhAnh(fileName).build();
        return ResponseEntity.ok().body(thuongHieuService.create(dto));
    }

    @PutMapping("/sua")
    public ResponseEntity<?> suaThuongHieu(
            @RequestParam(name = "hinhAnh", required = false) MultipartFile hinhAnh,
            @RequestParam(name = "idThuongHieu") Integer idThuongHieu,
            @RequestParam(name = "tenThuongHieu") String tenThuongHieu,
            @RequestParam(name = "tenHinhAnhCu") String tenHinhAnhCu) {
        if (hinhAnh == null) {
            ThuongHieuDto dto = ThuongHieuDto.builder().id(idThuongHieu).tenThuongHieu(tenThuongHieu)
                    .hinhAnh(tenHinhAnhCu).build();
            return ResponseEntity.ok().body(thuongHieuService.edit(dto));
        }
        ResUtils.deletFile(tenHinhAnhCu);
        String newFileName = ResUtils.saveImage(hinhAnh);
        ThuongHieuDto dto = ThuongHieuDto.builder().id(idThuongHieu).tenThuongHieu(tenThuongHieu).hinhAnh(newFileName)
                .build();
        return ResponseEntity.ok().body(thuongHieuService.edit(dto));

    }

    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaThuongHieu(@RequestParam(name = "idThuongHieu") Integer id) {
        return ResponseEntity.ok().body(thuongHieuService.delete(id));
    }
}
