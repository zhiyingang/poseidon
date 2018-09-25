package com.yoke.poseidon.web.controller;


import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public Item test() {
        return itemService.findByItemTitle("test");
    }

    @GetMapping("/list")
    public List<Item> listAll(@RequestParam String prop,
                              @RequestParam String order,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer limit
    ) {
        return itemService.getAll(prop, order, page, limit);
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("execute");
        return "Hello";
    }
}

