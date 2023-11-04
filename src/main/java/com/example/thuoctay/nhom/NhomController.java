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

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.utils.ResUtils;

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

    @Role({"ADMIN"})
    @PostMapping("/tao")
    public ResponseEntity<?> taoNhom(@RequestParam(name = "tenNhom") String tenNhom) {
        NhomDto dto = NhomDto.builder().id(0).tenNhom(tenNhom).build();
        return ResponseEntity.ok().body(nhomService.create(dto));
    }

    @Role({"ADMIN"})
    @PutMapping("/sua")
    public ResponseEntity<?> suaNhom(
            @RequestParam(name = "idNhom") Integer idNhom,
            @RequestParam(name = "tenNhom") String tenNhom) {
            NhomDto dto =  NhomDto.builder().id(idNhom).tenNhom(tenNhom).build();
            return ResponseEntity.ok().body(nhomService.edit(dto));
        
    }

    @Role({"ADMIN"})
    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaNhom(@RequestParam(name = "idNhom") Integer id) {
        return ResponseEntity.ok().body(nhomService.delete(id));
    }
}
