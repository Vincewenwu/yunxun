package com.vision.edu.framework.support.ftp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.vision.edu.framework.util.PropertiesUtil;
import com.vision.edu.platform.util.StringUtil;

/**
 * Java使用FTPClient操作ftp文件工具类
 * @author XieFan
 * @date 2017年7月16日 下午9:45:23
 * @version 1.0
 */
public class FTPFileTransmit {
	
	private String ftpName;
	private String ftpPassword;
	private String ftpServerIP;
	private int port;
	
	public FTPFileTransmit() {
		this.ftpName = "xf";
		this.ftpPassword = "xie950724";
		this.ftpServerIP = "192.168.1.111";
		this.port = 2121;
	}
	
	public FTPFileTransmit(String ftpName,String ftpPassword,String ftpSserviceIp) {
		this.ftpName = ftpName;
		this.port = 2121;
		this.ftpPassword = ftpPassword;
		this.ftpServerIP = ftpSserviceIp;
	}
	
	public FTPFileTransmit init(){
		ftpServerIP = PropertiesUtil.getString("ftp.host");
		port = PropertiesUtil.getInt("ftp.port");
		ftpName = PropertiesUtil.getString("ftp.user.name");
		ftpPassword = PropertiesUtil.getString("ftp.user.password");
        return this;
	}
	
	
	/**
	 * Method name: saveInFTP <BR>
	 * Description: 把文件存储在FTP上 <BR>
	 * Remark: <BR>
	 * @param FolderName 			示例"/20161118_ReTransmit/"
	 * @param FileName 				示例"2011080912345678.text"
	 * @param data					byte[]数组
	 * @return  boolean<BR>
	 */
	public boolean saveInFTP (String FolderName, String FileName, byte[] data) {
		System.out.println("准备上传");
		boolean flag = false;
		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		// 输入流用于读取文件
//		FileInputStream fis = null;
		ByteArrayInputStream bis = null;
		try {
			
			// 如果FolderName 和 FileName都不符合基本要求, 那么就没有必要进行ftp操作
			if (FolderName != null&& FolderName.compareTo("") != 0 && FileName != null&& FileName.compareTo("") != 0) {
				System.out.println("进入上传："); 
				// 建立FTP连接
				ftpClient.connect(this.ftpServerIP,this.port);
				// 如果登录成功后, 才进行创建输入流
				if (ftpClient.login(this.ftpName, this.ftpPassword)) {
					System.out.println("ftp 登录成功");
					
					ftpClient.changeWorkingDirectory(FolderName);
					System.out.println("FolderName="+FolderName);
					ftpClient.enterLocalPassiveMode();
//					// 将byte[]写入到输入流中, 实例化
					bis = new ByteArrayInputStream(data);
					// 设置缓冲
					ftpClient.setBufferSize(1024);
					//设置文件名中文
					ftpClient.setControlEncoding("utf-8");
					// 设置文件类型(二进制类型)
					if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
						flag = ftpClient.storeFile(FileName, bis);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭输入流
				IOUtils.closeQuietly(bis);
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	/**
	 * Method name: getFromFTP <BR>
	 * Description: 从FTP上读取文件 <BR>
	 * filePath=/20161118_ReTransmit/111.jpg <BR>
	 * outPutFilePath = C:/ftpload.jpg
	 * @return  boolean<BR>
	 */
	public boolean getFromFTP (String filePath,String outPutFilePath) {
		boolean flag = false;
		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		// 输出流用于输出文件
		FileOutputStream fos = null;
		try {
			// 建立FTP连接
			ftpClient.connect(this.ftpServerIP,this.port);
			// 如果登录成功后, 才进行创建输出流
			if (ftpClient.login(this.ftpName, this.ftpPassword)) {
				// FTP文件
				String distinationFile = filePath;
				// 实例化输出流
				fos = new FileOutputStream(outPutFilePath);
				// 设置缓冲
				ftpClient.setBufferSize(1024);
				// 设置文件类型(二进制类型)
				if (ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE)) {
					ftpClient.retrieveFile(distinationFile, fos);
					flag = true;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭输出流
				IOUtils.closeQuietly(fos);
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	/**
	 * 自动创建ftp根目录下的的文件夹目录
	 */
	public String createDirectory() {
		//创建目录
		String FolderName ="";
		boolean flag = false;
		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		try {
			// 建立FTP连接
			ftpClient.connect(this.ftpServerIP,this.port);
			// 如果登录成功后, 才进行操作
			if (ftpClient.login(this.ftpName, this.ftpPassword)) {
				System.out.println("ftp 登录成功");
				SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
				String time = f.format(new Date());
				FolderName = time + "_ReTransmit";
				ftpClient.makeDirectory(FolderName);
				flag = true;
				System.out.println("ftp目录创建成功："+FolderName);
			}else{
				System.out.println("ftp 登录失败,请检测登录用户，密码..............");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return FolderName;
	}
	
	/**
	 * 自动创建ftp根目录下的的文件夹目录
	 */
	public String createDirectory(String path) {
		//创建目录
		String FolderName =path;
		boolean flag = false;
		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		try {
			// 建立FTP连接
			ftpClient.connect(this.ftpServerIP,this.port);
			// 如果登录成功后, 才进行操作
			String[] fi=path.split("/");
			
				if (ftpClient.login(this.ftpName, this.ftpPassword)) {
					for (String string : fi) {
						if(StringUtil.isNotEmpty(string)){
							System.out.println("ftp 登录成功");
							ftpClient.makeDirectory(string);
							boolean sdf=ftpClient.changeWorkingDirectory(string);
							flag = true;
							System.out.println("ftp目录创建成功："+FolderName);
						}
					}
				}else{
					System.out.println("ftp 登录失败,请检测登录用户，密码..............");
				}
			
		} catch (SocketException e) {
			e.printStackTrace();
			flag = false;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return FolderName;
	}
	
	/**
	 * 
	 */
	public String[] getAllFolderNames (String ftppath) {
		// 创建FTP客户端
		FTPClient ftpClient = new FTPClient();
		try {
			// 建立FTP连接
			ftpClient.connect(this.ftpServerIP,this.port);
			// 如果登录成功后, 才进行操作
			if (ftpClient.login(this.ftpName, this.ftpPassword)) {
				
				// 切换文件路径, 到FTP上的"NNDD3"文件夹下
				if (ftpClient.changeWorkingDirectory(ftppath)) {
					// 将当前时间减去2天, 删除的是前两天的数据包
					String time = minusTime();
					//所有文件
					String[] allNames = ftpClient.listNames();
					//文件长度
					String[] temp = new String[allNames.length];
					//初始化数组
					for (int j = 0; j < allNames.length; j ++) {
						temp[j] = "";
					}
					// 找出要删除文件夹的名称
					for (int i = 0; i < allNames.length; i ++) {
						if (allNames[i].substring(0, 8).compareTo(time) <= 0) {
							temp[i] = allNames[i];
						}
					}
					return temp;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * 
	 * Method name: minusTime <BR>
	 * Description: 获取前两天的时间,如2011-8-1的前两天就是2011-7-30 <BR>
	 * Remark: <BR>
	 * @return  String<BR>
	 */
	private String minusTime() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");   
		Date d = new Date();
        String timeMinus2 = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000));   
		return timeMinus2;
	}
	
	 //获得指定文件的byte数组 
    public static byte[] getBytes(String filePath){  
        byte[] buffer = null;  
        try {  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return buffer;  
    }  
	public static void main(String[] args) {
		FTPFileTransmit ftpFileTransmit = new FTPFileTransmit();
		//=================================创建文件夹===========================================//
		String filepath = ftpFileTransmit.createDirectory("/li/ll");
//		if (filepath != "") {
//			System.out.println("****** FTP文件夹创建成功 ******"+filepath);
//		}else{
//			System.out.println("****** FTP文件夹创建失败 ******");
//		}
		//=================================上传文件===========================================//
		//String FolderName = filepath;
		String disk_path = "C:/Users/Lwl/Pictures/2.png";
		//遗留问题：生成文件如果要中文的话，目前还没有办法解决。
		String taget_path = "abc1.jpg";
		
		//文件转换为字节数组
		byte[] data = ftpFileTransmit.getBytes(disk_path);
		//将本地文件上传到ftp
		boolean flag = ftpFileTransmit.saveInFTP("/li/ll",taget_path,data);
		if (flag) {
			System.out.println("****** FTP上传文件成功******");
		}else{
			System.out.println("****** FTP上传文件失败******");
		}
		//=================================下载文件===========================================//
		String fromfilepath = "20161118_ReTransmit/123123.jpg";
		String outPutFilePath = "c:/ftpload222123123.jpg";
		flag = ftpFileTransmit.getFromFTP(fromfilepath, outPutFilePath);
		if (flag) {
			System.out.println("****** FTP下载成功******");
		}else{
			System.out.println("****** FTP下载失败******");
		}
	}


}

