package com.example.thuoctay.duocchat;

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
@RequestMapping("/duocchat")
@RequiredArgsConstructor
@CrossOrigin
public class DuocChatController {

    private final DuocChatService duocChatService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(duocChatService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(name = "pageIndex") Integer pageIndex){
        return ResponseEntity.ok().body(duocChatService.getOnePage(pageIndex, 10));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(duocChatService.getById(id));
    }


    @GetMapping("/checktenduocchat")
    public ResponseEntity<?> checkTenNhom(@RequestParam(name = "tenDuocChat") String ten){
        return ResponseEntity.ok().body(duocChatService.getByTen(ten));
    }

    @PostMapping("/tao")
    public ResponseEntity<?> taoDuoChat(@RequestBody DuocChatDto dto){
        return ResponseEntity.ok().body(duocChatService.create(dto));
    }

    @PutMapping("/sua")
    public ResponseEntity<?> suaDuocChat(@RequestBody DuocChatDto dto){
        return ResponseEntity.ok().body(duocChatService.edit(dto));
    }

    @DeleteMapping("/xoa")
    public ResponseEntity<?> xoaDuocChat(@RequestParam(name = "idDuocChat") Integer id){
        return ResponseEntity.ok().body(duocChatService.delete(id));
    }
}