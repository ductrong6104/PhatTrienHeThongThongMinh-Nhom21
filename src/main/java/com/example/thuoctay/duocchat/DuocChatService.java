package com.example.thuoctay.duocchat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.thuoctay.nhom.NhomDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DuocChatService {

    private final DuocChatRepo duocChatRepo;
    private final DuocChatMapper duocChatMapper;

    public Set<DuocChatDto> getAll() {
        return duocChatRepo.findAll().stream().map(duocChatMapper::toDto).collect(Collectors.toSet());
    }

    public Set<DuocChatDto> getOnePage(int pageIndex, int number) {
        Set<DuocChatDto> set = duocChatRepo.findAll(PageRequest.of(pageIndex, number)).stream()
                .map(duocChatMapper::toDto)
                .collect(Collectors.toSet());
        return set;
    }

    public DuocChatDto create(String tenDuocChat) {
        DuocChatEntity entity = DuocChatEntity.builder().id(0).tenDuocChat(tenDuocChat).build();
        entity.setId(0);
        duocChatRepo.save(entity);

        return duocChatMapper.toDto(entity);
    }

    public DuocChatDto edit(DuocChatDto dto) {
        DuocChatEntity entity = duocChatRepo.findById(dto.getId()).orElse(null);
        if (entity != null) {
            entity = duocChatMapper.toEntity(dto);
            duocChatRepo.save(entity);
            return dto;
        }
        return null;
    }

    public DuocChatDto delete(Integer nhomId) {
        DuocChatEntity entity = duocChatRepo.findById(nhomId).orElse(null);
        if (entity != null) {
            duocChatRepo.delete(entity);
            return duocChatMapper.toDto(entity);
        }
        return null;
    }

    public DuocChatDto getByTen(String ten) {
        DuocChatEntity entity = duocChatRepo.findByTenDuocChat(ten).orElse(null);
        if (entity != null) {
            return duocChatMapper.toDto(entity);
        }
        return null;
    }

    public DuocChatDto getById(Integer id) {
        DuocChatEntity entity = duocChatRepo.findById(id).orElse(null);
        if (entity != null) {
            return duocChatMapper.toDto(entity);
        }
        return null;
    }

    public List<DuocChatDto> findByTenDuocChatContaining(String ten, Integer page){
        List<DuocChatDto> set = duocChatRepo.findByTenDuocChatContaining(ten, PageRequest.of(page, 10)).stream().map(duocChatMapper::toDto)
                .collect(Collectors.toList());
        return set;
    }
}
