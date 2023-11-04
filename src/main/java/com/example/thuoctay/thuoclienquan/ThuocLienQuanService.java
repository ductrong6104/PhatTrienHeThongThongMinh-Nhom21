package com.example.thuoctay.thuoclienquan;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.thuoctay.thuoc.ThuocDto;
import com.example.thuoctay.thuoc.ThuocService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ThuocLienQuanService {
    
    private final ThuocLienQuanRepo thuocLienQuanRepo;
    private final ThuocService thuocService;


    public Set<ThuocDto> getThuocLienQuanById(Integer idThuoc){
        ThuocLienQuanEntity thuocLienQuanEntity = thuocLienQuanRepo.findById(idThuoc).orElse(null);
        if(thuocLienQuanEntity == null){
            return new HashSet<>();
        }
        ThuocDto dto1 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq1());
        ThuocDto dto2 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq2());
        ThuocDto dto3 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq3());
        ThuocDto dto4 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq4());
        ThuocDto dto5 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq5());
        ThuocDto dto6 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq6());
        ThuocDto dto7 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq7());
        ThuocDto dto8 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq8());
        ThuocDto dto9 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq9());
        ThuocDto dto10 = thuocService.getById(thuocLienQuanEntity.getThuoc_lq10());

        Set<ThuocDto> sets = new HashSet<>();

        sets.add(dto1);
        sets.add(dto2);
        sets.add(dto3);
        sets.add(dto4);
        sets.add(dto5);
        sets.add(dto6);
        sets.add(dto7);
        sets.add(dto8);
        sets.add(dto9);
        sets.add(dto10);

        return sets;

        
    }

}
