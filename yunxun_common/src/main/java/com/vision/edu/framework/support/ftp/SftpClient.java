package com.vision.edu.framework.support.ftp;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.vision.edu.framework.exception.FtpException;

/**
 * Sftp上传
 * @author XieFan
 * @date 2017年7月17日 上午8:04:33
 * @version 1.0
 */
public class SftpClient {
	private Logger logger = LogManager.getLogger();
	private Session session = null;
	private ChannelSftp channel = null;

	private SftpClient() {
	}

	public static SftpClient connect() {
		return new SftpClient().init();
	}
 

	/**
	 * 判断目录是否存在
	 * @author XieFan
	 * @date 2017年7月17日 上午8:04:44
	 * @param directory
	 * @return
	 */
	public boolean isDirExist(String directory) {
		boolean isDirExistFlag = false;
		try {
			SftpATTRS sftpATTRS = channel.lstat(directory);
			isDirExistFlag = true;
			// 进入并设置为当前目录
			channel.cd(directory);
			return sftpATTRS.isDir();
		} catch (Exception e) {
			if (e.getMessage().toLowerCase().equals("no such file")) {
				isDirExistFlag = false;
			}
		}
		return isDirExistFlag;
	}

	/**
	 * 创建一个文件目录
	 * @author XieFan
	 * @date 2017年7月17日 上午8:04:51
	 * @param createpath
	 */
	public void createDir(String createpath)  {
		try {
			if (isDirExist(createpath)) {
				this.channel.cd(createpath);
			}
			String pathArry[] = createpath.split("/");
			StringBuffer filePath = new StringBuffer("/");
			for (String path : pathArry) {
				if (path.equals("")) {
					continue;
				}
				filePath.append(path + "/");
				if (isDirExist(filePath.toString())) {
					channel.cd(filePath.toString());
				} else {
					// 建立目录
					channel.mkdir(filePath.toString());
					// 进入并设置为当前目录
					channel.cd(filePath.toString());
				}
			}
			this.channel.cd(createpath);
		} catch (SftpException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 初始化操作
	 * @author XieFan
	 * @date 2017年7月17日 上午8:05:00
	 * @return
	 */
	public SftpClient init() {
		try {
			Properties config = new Properties();
			String host = "112.74.67.41";
			int port = 22;
			String userName = "xuechenftpimg";
			String password = "123456";
			int timeout = 500;
			int aliveMax = 10;
			JSch jsch = new JSch(); // 创建JSch对象
			session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象
			if (password != null) {
				session.setPassword(password); // 设置密码
			}
			config.put("userauth.gssapi-with-mic", "no");
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config); // 为Session对象设置properties
			session.setTimeout(timeout); // 设置timeout时间
			session.setServerAliveCountMax(aliveMax);
			session.connect(); // 通过Session建立链接
			channel = (ChannelSftp) session.openChannel("sftp"); // 打开SFTP通道
			channel.connect(); // 建立SFTP通道的连接
			System.out.println("连接成功");
		} catch (JSchException e) {
			throw new FtpException("", e);
		}
		return this;
	}

	/**
	 * 取消连接
	 * @author XieFan
	 * @date 2017年7月17日 上午8:05:07
	 */
	public void disconnect() {
		if (channel != null) {
			channel.disconnect();
		}
		if (session != null) {
			session.disconnect();
			logger.info("SSH Channel disconnected.");
		}
	}

	/**
	 * 发送文件
	 * @author XieFan
	 * @date 2017年7月17日 上午8:05:15
	 * @param src
	 * @param dst
	 */
	public void put(String src, String dst) {
		try {
			channel.put(src, dst, new FileProgressMonitor());
		} catch (SftpException e) {
			throw new FtpException("", e);
		}
	}
	
	/**
	 * 发送文件
	 * @author XieFan
	 * @date 2017年7月17日 上午8:05:23
	 * @param inputStream
	 * @param dst
	 */
	public void put(InputStream inputStream, String dst) {
		try {
			channel.put(inputStream, dst, new FileProgressMonitor());
		} catch (SftpException e) {
			throw new FtpException("", e);
		}
	}

	/**
	 * 获取文件 
	 * @author XieFan
	 * @date 2017年7月17日 上午8:05:30
	 * @param src
	 * @param dst
	 */
	public void get(String src, String dst) {
		try {
			channel.get(src, dst, new FileProgressMonitor());
		} catch (SftpException e) {
			throw new FtpException("", e);
		}
	}
}
