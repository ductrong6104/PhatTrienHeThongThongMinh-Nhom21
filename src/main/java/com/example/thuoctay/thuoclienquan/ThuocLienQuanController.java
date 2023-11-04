package com.example.thuoctay.thuoclienquan;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuoctay.thuoc.ThuocDto;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/thuoclienquan")
@RequiredArgsConstructor
public class ThuocLienQuanController {

    private final ThuocLienQuanService thuocLienQuanService;

    @GetMapping("")
    public ResponseEntity<?> getThuocLienQuanById(@RequestParam(name = "idThuoc") Integer idThuoc){
        Set<ThuocDto> sets = thuocLienQuanService.getThuocLienQuanById(idThuoc);
        return ResponseEntity.ok().body(sets);
    }
}
