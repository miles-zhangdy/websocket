package com.ssm.web.common;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.common.controller.BaseController;
import com.ssm.common.util.FileUpload;

@Controller
@RequestMapping("admin/upload")
public class FileUploadController extends BaseController {

	@ResponseBody
	@RequestMapping("upload")
	public String upload(@RequestParam("photo") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return FileUpload.uploadFile(file, request);
	}

	@RequestMapping("download")
	public void download(String fileName, HttpServletResponse response)
			throws IOException {
		OutputStream os = response.getOutputStream();
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			response.setContentType("image/jpeg; charset=utf-8");
			os.write(FileUtils.readFileToByteArray(FileUpload.getFile(fileName)));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

}
