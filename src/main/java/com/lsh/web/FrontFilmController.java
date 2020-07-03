package com.lsh.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsh.entity.Film;
import com.lsh.entity.SysUser;
import com.lsh.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/f/film")
@Controller
public class FrontFilmController {
    @Autowired
    private IFilmService filmService;
    @ModelAttribute("film")
    public Film get(Integer id){
        if(id != null){
            return filmService.getById(id);
        }else{
            return new Film();
        }
    }
    @RequestMapping("/index")
    public String index(Model model, Integer pageNo){
        int current = 1;
        int pageSize = 12;
        if (pageNo != null){
            current = pageNo;
        }
        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        IPage<Film> page = filmService.page(new Page<>(current,pageSize),queryWrapper);
        model.addAttribute("page",page);
        return "front/index";

    }

    @RequestMapping("/404")
    public  String list() {return "front/404";}


    @RequestMapping("/details")
    public String details(Model model, Film film) {
        model.addAttribute("film",film);
        return "front/filmDetails";
    }

    @RequestMapping("/type1")
    public String type1(Model model,Integer typeNo, Integer pageNo){
        int current = 1;
        int pageSize = 12;
        if (pageNo != null){
            current = pageNo;
        }

        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",typeNo);
        IPage<Film> page = filmService.page(new Page<>(current,pageSize),queryWrapper);
        model.addAttribute("page",page);
        return "front/movie02";

    }
    @RequestMapping("/type2")
    public String type2(Model model,Integer typeNo, Integer pageNo){
        int current = 1;
        int pageSize = 12;
        if (pageNo != null){
            current = pageNo;
        }

        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",typeNo);
        IPage<Film> page = filmService.page(new Page<>(current,pageSize),queryWrapper);
        model.addAttribute("page",page);
        return "front/movie03";

    }
    @RequestMapping("/type3")
    public String type3(Model model,Integer typeNo, Integer pageNo){
        int current = 1;
        int pageSize = 12;
        if (pageNo != null){
            current = pageNo;
        }
        if(typeNo != null){
            typeNo = 1;
        }

        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",typeNo);
        IPage<Film> page = filmService.page(new Page<>(current,pageSize),queryWrapper);
        model.addAttribute("page",page);
        return "front/movie04";

    }
    @RequestMapping("/type4")
    public String type4(Model model,Integer typeNo, Integer pageNo){
        int current = 1;
        int pageSize = 12;
        if (pageNo != null){
            current = pageNo;
        }

        QueryWrapper<Film> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",typeNo);
        IPage<Film> page = filmService.page(new Page<>(current,pageSize),queryWrapper);
        model.addAttribute("page",page);
        return "front/movie05";

    }
}
