package com.qin.community.model;

import lombok.Data;

/**
 * @program: community
 * @description: 书本数据库
 * @author: qin
 * @create: 2019-10-06 17:55
 **/
@Data
public class Book {
    private Integer id;
    private String isbn;
    private String name;
    private String zuo;
    private String chu;
    private String jia;
    private String ce;
}
