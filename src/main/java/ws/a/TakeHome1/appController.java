/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.TakeHome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MADD
 */
@Controller
public class appController
{
    @RequestMapping("/nexthalaman")
    public String next(
                @RequestParam(value = "varA") String data1,
                @RequestParam(value = "varB") String data2,
                @RequestParam(value = "varC") MultipartFile data3,
                Model Courier
                )throws IOException
    {
        byte[] imagebyte = data3.getBytes();
        String imagestringbase64 = Base64.encodeBase64String(imagebyte);
        String imgpath = "data:image/png;base64,".concat(imagestringbase64);
        
        Courier.addAttribute("pakage1", data1);
        Courier.addAttribute("pakage2", data2);
        Courier.addAttribute("pakage3", imgpath);
        
        return "viewpage";
    }
}
