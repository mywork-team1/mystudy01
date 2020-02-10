package com.example.demo;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.vo.FileVO;

@Controller
public class FileUploadController {

	@RequestMapping("/form")
	public String fileForm() {
		return "fileform";
	}

	@RequestMapping("/upload")
	public String fileupLoad(FileVO v, HttpServletRequest request, Model m) {
		String img_path = "resources\\upload";
		String r_path = request.getSession().getServletContext().getRealPath("");
		System.out.println("r_path:"+r_path);
		String oriFn = v.getFileOriName().getOriginalFilename();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("-----------------------------------");
		File f = new File(path.toString());
		try {
			v.getFileOriName().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		m.addAttribute("imgName", oriFn);
		return "hello";
	}
}
