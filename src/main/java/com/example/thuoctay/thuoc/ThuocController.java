package com.example.thuoctay.thuoc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.utils.ResUtils;

import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @GetMapping("/thuonghieuvanhompage")
    public ResponseEntity<?> getByThuongHieuVaNhomPage(@RequestParam(name = "idThuongHieu") Integer idThuongHieu, @RequestParam(name = "idNhom") Integer idNhom, @RequestParam(name = "page") Integer page) {
        // System.out.println("\n\n\nId Nhom: " + idNhom + "__id Thuong Hieu: " + idThuongHieu);
        return ResponseEntity.ok().body(thuocService.getByIdThuongHieuVaIdNhomPage(idThuongHieu, idNhom, page));
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex) {
        return ResponseEntity.ok().body(thuocService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(thuocService.getById(id));
    }

    @GetMapping("/checktenthuoc")
    public ResponseEntity<?> checkTenThuoc(@RequestParam(name = "tenThuoc") String ten) {
        ThuocDto dto = thuocService.getByTen(ten);
        return ResponseEntity.ok().body(dto);
    }

    @Role({"ADMIN"})
    @PostMapping("/taothuoc")
    public ResponseEntity<?> taoThuoc(@RequestBody ThuocDto dto) {
        System.out.println("\n\n\n\n\n" + dto.toString() + "\n\n\n\n\n");
        return ResponseEntity.ok().body(thuocService.create(dto));
    }

    @Role({"ADMIN"})
    @PutMapping("/suathuoc")
    public ResponseEntity<?> suaThuoc(@RequestBody ThuocDto dto) {
        return ResponseEntity.ok().body(thuocService.edit(dto));
    }

    @Role({"ADMIN"})
    @DeleteMapping("/xoathuoc")
    public ResponseEntity<?> xoaThuoc(@RequestParam(name = "idThuoc") Integer id) {
        return ResponseEntity.ok().body(thuocService.delete(id));
    }

    @Role({"ADMIN"})
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

    @Role({"ADMIN"})
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

    @GetMapping("/timKiemTenThuoc")
    public ResponseEntity<?> findByTenThuocContaining(@RequestParam(name = "tenThuoc") String ten, @RequestParam(name = "page") Integer page) {
        List<ThuocDto> dto = thuocService.findByTenThuocContaining(ten, page);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/timKiemTenThuocTheoDeXuat")
    public ResponseEntity<?> findByRecommendTenThuoc(@RequestParam(name = "tenThuoc") String ten, @RequestParam(name = "page") Integer page) {
        List<ThuocDto> dto = thuocService.findByRecommendTenThuoc(ten, page);
        return ResponseEntity.ok().body(dto);
    }


}
