package com.example.thuoctay.duocchat;

import java.util.Set;
import java.util.stream.Collectors;

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

    public DuocChatDto create(DuocChatDto dto) {
        DuocChatEntity entity = duocChatMapper.toEntity(dto);
        duocChatRepo.save(entity);
        return dto;
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
}
