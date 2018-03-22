package com.ssm.web.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("action/checkImage")
public class CheckImageController {
	private int width = 60;
	private int height = 20;

	@RequestMapping(value = "/checkImage")
	public void checkImage(HttpServletRequest req, HttpServletResponse resp)
			throws java.io.IOException {

		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		Random random = new Random();

		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, width - 1, height - 1);
		StringBuffer randomCode = new StringBuffer();
		int red = 255, green = 165, blue = 0;
		for (int i = 0; i < 4; i++) {
			String strRand = String.valueOf(random.nextInt(10));
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, 13 * i + 6, 16);
			randomCode.append(strRand);
		}
		String type = req.getParameter("type");
		HttpSession session = req.getSession();
		if (type.equals("register")) {
			session.setAttribute("RANDOMCODE", randomCode.toString());
		} else if (type.equals("login")) {
			session.setAttribute("RANDOMCODELOGIN", randomCode.toString());
		} else {
			session.setAttribute("RANDOMCODE", randomCode.toString());
		}

		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpeg");
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
}
