package com.example.thuoctay.giohang;

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
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/giohang")
@RequiredArgsConstructor
@CrossOrigin
public class GioHangController {

    private final GioHangService gioHangService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(gioHangService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex){
        return ResponseEntity.ok().body(gioHangService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(gioHangService.getById(id));
    }


    @GetMapping("/checksodienthoai")
    public ResponseEntity<?> checkTenNhom(@RequestParam(name = "sodienthoai") String sdt){
        return ResponseEntity.ok().body(gioHangService.getBySoDienThoai(sdt));
    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoDuoChat(@RequestBody GioHangDto dto){
        return ResponseEntity.ok().body(gioHangService.create(dto));
    }

    @PutMapping("/sua")
    public ResponseEntity<?> suaDuocChat(@RequestBody GioHangDto dto){
        return ResponseEntity.ok().body(gioHangService.edit(dto));
    }

    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaDuocChat(@RequestParam(name = "idDuocChat") Integer id){
        return ResponseEntity.ok().body(gioHangService.delete(id));
    }
}
