package com.example.thuoctay.duocchat;

import com.example.thuoctay.nhom.NhomDto;
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

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienDto;
import com.example.thuoctay.utils.Auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/duocchat")
@RequiredArgsConstructor
@CrossOrigin
public class DuocChatController {

    private final DuocChatService duocChatService;
    private final Auth auth;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(duocChatService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex) {
        return ResponseEntity.ok().body(duocChatService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(duocChatService.getById(id));
    }

    @GetMapping("/checktenduocchat")
    public ResponseEntity<?> checkTenNhom(@RequestParam(name = "tenDuocChat") String ten) {
        return ResponseEntity.ok().body(duocChatService.getByTen(ten));
    }

    @Role({ "ADMIN" })
    @PostMapping("/tao/{tenDuocChat}")
    public ResponseEntity<?> taoDuoChat(HttpServletRequest httpServletRequest,
            @PathVariable(name = "tenDuocChat") String tenDuocChat) {
        TaiKhoanNhanVienDto taiKhoanNhanVienDto = auth.getNhanVienFromRequest(httpServletRequest);
        System.out.println("\n\n\n\n" + taiKhoanNhanVienDto.toString() + "\n\n\n\n\n");
        if (taiKhoanNhanVienDto.getRole().equals("ADMIN")) {
            System.out.println("Role: '" + taiKhoanNhanVienDto.getRole() + "'");
            return ResponseEntity.ok().body(duocChatService.create(tenDuocChat));

        }
        return ResponseEntity.badRequest().body("Access denid");

    }

    @Role({ "ADMIN" })
    @PutMapping("/sua")
    public ResponseEntity<?> suaDuocChat(@RequestBody DuocChatDto dto) {
        return ResponseEntity.ok().body(duocChatService.edit(dto));
    }

    @Role({ "ADMIN" })
    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaDuocChat(@RequestParam(name = "idDuocChat") Integer id) {
        return ResponseEntity.ok().body(duocChatService.delete(id));
    }

    @GetMapping("/timKiemTenDuocChat")
    public ResponseEntity<?> findByTenDuocChatContaining(@RequestParam(name = "tenDuocChat") String ten) {
        List<DuocChatDto> dto = duocChatService.findByTenDuocChatContaining(ten);
        return ResponseEntity.ok().body(dto);
    }
}
