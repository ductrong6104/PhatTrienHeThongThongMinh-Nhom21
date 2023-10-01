package com.example.thuoctay.thuoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.utils.ResUtils;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/thuoc")
@RequiredArgsConstructor
public class ThuocController {

    private final ThuocService thuocService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(thuocService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex) {
        return ResponseEntity.ok().body(thuocService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/checktenthuoc")
    public ResponseEntity<?> checkTenThuoc(@RequestParam(name = "tenThuoc") String ten) {
        ThuocDto dto = thuocService.getByTen(ten);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/taothuoc")
    public ResponseEntity<?> taoThuoc(@RequestBody ThuocDto dto) {
        return ResponseEntity.ok().body(thuocService.create(dto));
    }

    @PutMapping("/suathuoc")
    public ResponseEntity<?> suaThuoc(@RequestBody ThuocDto dto) {
        return ResponseEntity.ok().body(thuocService.edit(dto));
    }

    @DeleteMapping("/xoathuoc")
    public ResponseEntity<?> xoaThuoc(@RequestParam(name = "idThuoc") Integer id) {
        return ResponseEntity.ok().body(thuocService.delete(id));
    }

    @PostMapping("/themhinhanh")
    public ResponseEntity<?> themHinhAnh(@RequestParam(name = "hinhAnh") MultipartFile hinhAnh,
            @RequestParam(name = "idThuoc") Integer idThuoc) {
        String fileName = ResUtils.saveImage(hinhAnh);
        if (thuocService.editHinhAnh(idThuoc, fileName) == null) {
            ResUtils.deletFile(fileName);
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(fileName);
    }

    @PostMapping("/suahinhanh")
    public ResponseEntity<?> suaHinhAnh(@RequestParam(name = "hinhAnh") MultipartFile hinhAnh,
            @RequestParam(name = "idThuoc") Integer idThuoc,
            @RequestParam(name = "tenHinhAnhCu") String tenHinhAnhCu) {

        String fileName = ResUtils.saveImage(hinhAnh);
        if (thuocService.editHinhAnh(idThuoc, fileName) == null) {
            ResUtils.deletFile(fileName);
            return ResponseEntity.badRequest().body(null);
        }
        ResUtils.deletFile(tenHinhAnhCu);
        return ResponseEntity.ok().body(fileName);
    }

}