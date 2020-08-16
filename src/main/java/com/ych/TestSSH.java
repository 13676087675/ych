package com.ych;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.ych.utils.Examination;

import java.io.*;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * @Author: ych
 * @Date: Created in 22:03  2020/8/15.
 * @Description: Test SSH
 */
public class TestSSH {

    /**
     * Run SSH command.
     * @param host
     * @param username
     * @param password
     * @param cmd
     * @return exit status
     * @throws IOException
     */
    public static int runSSH(String host, String username, String password,
                             String cmd) throws IOException {
        out.println("running SSH cmd [" + cmd + "]");
        PrintStream console = System.out;
        Connection conn = getOpenedConnection(host, username, password);
        Session sess=null;
        for(int j=0;j<100;j++){
            Examination.start();
            //在此处输入测试代码段
                    sess = conn.openSession();
                    sess.execCommand(cmd);
                    InputStream stdout = new StreamGobbler(sess.getStdout());
                    BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
                    while (true) {
                        String line = br.readLine();
                        if (line == null){
                            break;
                        }
                        //格式化返回的字段结果  设定字符 |  ;
                        Pattern p = Pattern.compile("[|;]");
                        //按设定的字符进行分割
                        String[] r= p.split(line);
                        //把数据输出到文件中 创建一个打印输出流，输出的目标是：D:/log.csv
                        PrintStream ps = new PrintStream("D:/log.csv");
                        //把创建的打印输出流赋给系统。即系统下次向 ps输出
                        System.setOut(ps);
                        for(int i=0; i<r.length; i++){
                            //分析可得，输出到本地文件的内容不需要操作者，因此去掉操作者这个字段
                            if(i%3==1){
                                continue;
                            }else{
                                out.println(r[i]);
                            }
                        }
                    }
                    sess.close();
                if(j%10==0){
                    //又设置成了之前只输出到控制台的模式
                    System.setOut(console);
                }

            Examination.end();
            }

        conn.close();
        return sess.getExitStatus().intValue();
    }
    /**
     * return a opened Connection
     * @param host
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    private static Connection getOpenedConnection(String host, String username,
                                                  String password) throws IOException {

        out.println("connecting to " + host + " with user " + username
                + " and pwd " + password);
        Connection conn = new Connection(host, 22);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(username,
                password);
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
        return conn;
    }

    public static void main(String[] args) throws Exception{
        //实际开发要从配置文件读取或者可配置到nacos注册中心，方便分布式部署
        String cmd = "cat /root/windows_upload/sshDemo/test.log";
        runSSH("47.95.254.152", "root", "aA123456789!", cmd);
    }


}
