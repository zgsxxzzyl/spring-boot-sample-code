package com.web;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
public class FileRestController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("测试");
        sheet.setDefaultColumnWidth(18);
        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("测试中文数据");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition",
                "attachment;filename*=utf-8''" + URLEncoder.encode("中文名称.xls", "utf-8"));
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    //MultipartFile该对象就是封装了文件
    @RequestMapping("/upload")
    public void upload(MultipartFile multipartFile) {
        System.out.println(multipartFile.getOriginalFilename());
    }

}
