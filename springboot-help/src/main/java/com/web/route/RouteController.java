package com.web.route;

import com.bean.User;
import com.vo.RequestVO;
import com.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/route")
public class RouteController {
    /**
     * produces = MediaType.APPLICATION_JSON_UTF8_VALUE 修改返回的类型为json
     *
     * @param requestVO
     * @return
     */
    @RequestMapping(value = "/skip")
//    @RequestMapping(value = "/skip",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO skip(@RequestBody(required = false) RequestVO<User> requestVO) {
        User body = null;
        if (requestVO != null) {
            body = requestVO.getBody();
            System.out.println(body.toString());
        }
        return ResponseVO.success(body);
    }

    @RequestMapping(value = "/upload")
    public void upload(@RequestPart("requestVO") RequestVO<User> requestVO, @RequestPart("files") MultipartFile[] files) {
        System.out.println(requestVO.toString());
        System.out.println(files[0].getOriginalFilename());
    }

    @RequestMapping(value = "/download")
    public void download(@RequestBody(required = false) RequestVO<User> requestVO) throws IOException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=demo.txt");

        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());

        File file = new File("C:\\Users\\zhangyilong\\Desktop\\公司外使用加密系统方法2021.doc");

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buff = new byte[2048];
        int len;
        while ((len = fileInputStream.read(buff)) > -1) {
            outputStream.write(buff, 0, len);
        }
        outputStream.flush();
        outputStream.close();

    }


}
