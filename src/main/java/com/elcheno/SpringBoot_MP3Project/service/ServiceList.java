package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.ListaSong;
import com.elcheno.SpringBoot_MP3Project.repository.RepositoryList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceList implements iServiceList{

    private RepositoryList repository;

    public ServiceList(RepositoryList repository) {
        this.repository = repository;
    }

    @Override
    public List<ListaSong> getAllListaSong() {
        return repository.findAll();
    }

    @Override
    public ListaSong getListaSongById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<ListaSong> getListaSongByCategory(int id) {
        return repository.findByCategory(id);
    }

    public void save(ListaSong listaSong){repository.save(listaSong);}
}
