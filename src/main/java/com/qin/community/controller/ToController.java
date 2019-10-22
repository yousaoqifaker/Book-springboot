package com.qin.community.controller;

import com.qin.community.mapper.BookMapper;
import com.qin.community.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @program: community
 * @description: 测试
 * @author: qin
 * @create: 2019-10-05 20:57
 **/
@Controller
public class ToController {
    @Autowired
    private BookMapper bookMapper;
    @RequestMapping("/")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
        ArrayList<Book>list=bookMapper.getBook();
        int i=bookMapper.getBookCount();
        model.addAttribute("bookCount",i);
        model.addAttribute("list",list);
        return "index";
    }
    @RequestMapping("/addBook")
    public String addBook(HttpServletResponse response, HttpServletRequest request){
        Book book=new Book();
        String isbn=request.getParameter("isbn");
        String name=request.getParameter("name");
        String zuo=request.getParameter("zuo");
        String chu=request.getParameter("chu");
        String jia=request.getParameter("jia");
        String ce=request.getParameter("ce");
        book.setIsbn(isbn);
        book.setName(name);
        book.setZuo(zuo);
        book.setChu(chu);
        book.setJia(jia);
        book.setCe(ce);
        bookMapper.addBook(book);
        return "redirect:/";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id){
        bookMapper.deleteBook(id);
        return "redirect:/";
    }
    @RequestMapping("editBook")
    public ModelAndView editBook(Integer id){
        ModelAndView mav=new ModelAndView("editBook");
        Book book=bookMapper.findBookById(id);
        mav.addObject("book",book);
        return mav;
    }
    @RequestMapping("updateBook")
    public String updateBook(HttpServletRequest request,HttpServletResponse response){
        Book book=new Book();
        int id=Integer.parseInt(request.getParameter("id"));
        String isbn=request.getParameter("isbn");
        String name=request.getParameter("name");
        String zuo=request.getParameter("zuo");
        String chu=request.getParameter("chu");
        String jia=request.getParameter("jia");
        String ce=request.getParameter("ce");
        book.setId(id);
        book.setIsbn(isbn);
        book.setName(name);
        book.setZuo(zuo);
        book.setChu(chu);
        book.setJia(jia);
        book.setCe(ce);
        bookMapper.updateBook(book);
        return "redirect:/";
    }
}
