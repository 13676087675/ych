package com.ych;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A{
public static void main(String[] args){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("1595830781357|张三|测试网元服务器千万人大气污染的气味犬瘟热犬瘟热去器人爱瑞发二分其恶趣味请问请问驱蚊器爱上范德萨阿萨大大阿达萨达犬瘟热犬瘟热请问案发时;1595830781357|张三|测试网元服务器千万人大气污染的气味犬瘟热犬瘟热去器人爱瑞发二分其恶趣味请问请问驱蚊器爱上范德萨阿萨大大阿达萨达犬瘟热犬瘟热请问案发时;1595830781357|张三|测试网元服务器千万人大气污染的气味犬瘟热犬瘟热去器人爱瑞发二分其恶趣味请问请问驱蚊器爱上范德萨阿萨大大阿达萨达犬瘟热犬瘟热请问案发时;1595830781357|张三|测试网元服务器千万人大气污染的气味犬瘟热犬瘟热去器人爱瑞发二分其恶趣味请问请问驱蚊器爱上范德萨阿萨大大阿达萨达犬瘟热犬瘟热请问案发时;1595830781357|张三|测试网元服务器千万人大气污染的气味犬瘟热犬瘟热去器人爱瑞发二分其恶趣味请问请问驱蚊器爱上范德萨阿萨大大阿达萨达犬瘟热犬瘟热请问案发时;");
        Pattern p = Pattern.compile("[|;]");          //设定字符
        String[] r= p.split(stringBuilder.toString());         //按设定的字符进行分割
        Matcher m=p.matcher(stringBuilder.toString());         //把找到的设定字符赋给m
         while(m.find())System.out.println("运算符:"+m.group());     //打印出所有运算符
        for(int i=0; i<r.length; i++){
            //分析可得，输出到本地文件的内容不需要操作者，因此去掉操作者这个字段
            if(i%3==1){
                continue;
            }else{
                System.out.println(r[i]);
            }
        }

}
}