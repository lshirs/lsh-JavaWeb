package com.lsh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsh.entity.Film;
import com.lsh.mapper.FilmMapper;
import com.lsh.service.IFilmService;
import org.springframework.stereotype.Service;
@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper,Film> implements IFilmService {
}
