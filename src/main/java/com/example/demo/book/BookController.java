package com.example.demo.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;

@Api(tags = "Book")
@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
//    private BookService bookService;
    private BookRepository bookRepository;

    @GetMapping
    public Map hello() {
        Map map = new HashMap();
        map.put("say", "OK");
        return map;
    }
    
    @ApiOperation(value = "取得書本", notes = "列出所有書本")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    
    @ApiOperation(value = "新增書本", notes = "新增書本的內容")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "存檔成功")})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/v1/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto create(@ApiParam(required = true, value = "書本內容") @RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setBookid(bookDto.getBookid());
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        book = bookRepository.save(book);
        bookDto.setBookid(book.getBookid());
        return bookDto;
    }

    @ApiOperation(value = "取得書本內容", notes = "取得書本內容")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "書本資訊")})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/v1/book/{bookid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDto get(@ApiParam(required = true, name = "bookid", value = "書本ID") @PathVariable Integer bookid) {
        Book book = bookRepository.findById(bookid).get();
        BookDto bookDto = new BookDto();
        bookDto.setBookid(book.getBookid());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }
    
//    @GetMapping("/books/{id}")
//    private Book getBook(@PathVariable("id") int id) {
//        return bookRepository.findById(id).get();
//    }
//
//    @DeleteMapping("/books/{id}")
//    private void deleteBook(@PathVariable("id") int id) {
//    	bookService.delete(id);
//    }
//
//    @PostMapping("/books")
//    private int saveBook(@RequestBody Book books) {
//    	bookService.saveOrUpdate(books);
//        return books.getBookid();
//    }
}
