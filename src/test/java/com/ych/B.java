package com.ych;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class B{
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //׵�ڴ�ʹ�����

        long totalMemorySize = memoryUsage.getInit(); //��ʼ�����ڴ�

        long maxMemorySize = memoryUsage.getMax(); //�������ڴ�

        long usedMemorySize = memoryUsage.getUsed(); //��ʹ�õ��ڴ�

       @Test
       public void test(){
           System.out.println("TotalMemory:"+totalMemorySize/(1024*1024)+"M");
           System.out.println("FreeMemory:"+(totalMemorySize-usedMemorySize)/(1024*1024)+"M");
           System.out.println("MaxMemory:"+maxMemorySize/(1024*1024)+"M");
           System.out.println("UsedMemory:"+usedMemorySize/(1024*1024)+"M");
       }
}
