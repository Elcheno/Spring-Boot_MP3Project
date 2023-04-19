package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.ListaSong;
import java.util.List;

public interface iServiceList {
    List<ListaSong> getAllListaSong();
    ListaSong getListaSongById(int id);
    List<ListaSong> getListaSongByCategory(int id);
}
