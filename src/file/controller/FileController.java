package file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import file.model.FileViewService;
import file.model.UploadService;
import pojo.FileObj;
import socket.controller.AlertHandler;

@Controller
public class FileController {
	
	@Autowired
	UploadService us;
	@Autowired
	FileViewService fvs;
	@Autowired
	AlertHandler ah;
	

	@RequestMapping("/file/reg.do")
	public String goReg(){
		return "tile_file";
	}
	
	@RequestMapping("/file/list.do")
	public ModelAndView goList(){
		List<FileObj> al = fvs.fileListShow();
		List<FileObj> td = fvs.topDownload();
		
		ModelAndView mav = new ModelAndView("tile_fileList");
		mav.addObject("al",al);
		mav.addObject("filesize",al.size());
		mav.addObject("topdown", td);
		
		return mav;
	}
	
	@RequestMapping("/file/upload.do")
	public ModelAndView upDo(String title, String ctg, @RequestParam(name="file") MultipartFile file, String id){
		System.out.println(title+"/"+ctg+"/"+file+"/"+id);
		FileObj fi = us.exUp(file);
		fi.setCtg(ctg);
		fi.setTitle(title);
		fi.setUploader(id);
		
		ModelAndView mav = new ModelAndView("tile_Fileuprst");
		
		boolean b = us.exupDB(fi);
		
		mav.addObject("uprst",b);
		
		System.out.println(fi);
		System.out.println(b);
		ah.sendMessageToAll("dd");

		return mav;
	}
}

/*

	Spring은 multipart/form-data형식의 요청을 처리 못함
	하지만, 처리 가능한 라이브러리를 통한 지원은 한다. 

	commons file upload library로 연동할 수 있다. 
	(maven으로 받으면 된다)
	
	Spring bean con~ 이거



*/