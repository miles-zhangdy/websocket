package com.ssm.common.util;

import java.io.Serializable;

import org.apache.commons.mail.HtmlEmail;

import com.ssm.business.email.model.SendEmail;

public class EmailUtils implements Serializable{
	
	private static final long serialVersionUID = -3497536727545812994L;

	public boolean send(SendEmail mail) {
		// 发送email
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
			email.setHostName(mail.getHost());
			// 字符编码集的设置
			email.setCharset(SendEmail.ENCODEING);
			// 收件人的邮箱
			email.addTo(mail.getReceiver());
			// 发送人的邮箱
			email.setFrom(mail.getSender(), mail.getName());
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication(mail.getUsername(), mail.getPassword());
			// 要发送的邮件主题
			email.setSubject(mail.getSubject());
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg(mail.getMessage());
			// 发送
			email.send();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		SendEmail mail = new SendEmail();
		mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender("1293361401@qq.com");
		mail.setReceiver("1293361401@qq.com"); // 接收人
		mail.setUsername("1293361401@qq.com"); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword("zhang123456789ye"); // 发件人邮箱的登录密码
		mail.setSubject("aaaaaaaaa");
		mail.setMessage("bbbbbbbbbbbbbbbbb");
		new EmailUtils().send(mail);
	}

}
