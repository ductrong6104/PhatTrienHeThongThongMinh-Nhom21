package com.example.thuoctay.nhom;

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

import com.example.utils.ResUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/nhom")
@RequiredArgsConstructor
@CrossOrigin
public class NhomController {

    private final NhomService nhomService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(nhomService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex) {
        return ResponseEntity.ok().body(nhomService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(nhomService.getById(id));
    }

    @GetMapping("/checktennhom")
    public ResponseEntity<?> checkTenNhom(@RequestParam(name = "tenNhom") String ten) {
        return ResponseEntity.ok().body(nhomService.getByTen(ten));
    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoNhom(@RequestParam(name = "hinhAnh") MultipartFile hinhAnh,
            @RequestParam(name = "tenNhom") String tenNhom) {
        String fileName = ResUtils.saveImage(hinhAnh);
        NhomDto dto = NhomDto.builder().id(0).tenNhom(tenNhom).hinhAnh(fileName).build();
        return ResponseEntity.ok().body(nhomService.create(dto));
    }

    @PutMapping("/sua")
    public ResponseEntity<?> suaNhom(
        @RequestParam(name = "hinhAnh", required = false) MultipartFile hinhAnh,
            @RequestParam(name = "idNhom") Integer idNhom,
            @RequestParam(name = "tenNhom") String tenNhom,
            @RequestParam(name = "tenHinhAnhCu") String tenHinhAnhCu) {
                if(hinhAnh == null){
                   NhomDto dto =  NhomDto.builder().id(idNhom).tenNhom(tenNhom).hinhAnh(tenHinhAnhCu).build();
                   return ResponseEntity.ok().body(nhomService.edit(dto));
                }
            ResUtils.deletFile(tenHinhAnhCu);
            String newFileName = ResUtils.saveImage(hinhAnh);
            NhomDto dto =  NhomDto.builder().id(idNhom).tenNhom(tenNhom).hinhAnh(newFileName).build();
            return ResponseEntity.ok().body(nhomService.edit(dto));
        
    }

    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaNhom(@RequestParam(name = "idNhom") Integer id) {
        return ResponseEntity.ok().body(nhomService.delete(id));
    }
}