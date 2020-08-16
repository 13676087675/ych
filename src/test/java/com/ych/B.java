package com.ych;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class B{
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况

        long totalMemorySize = memoryUsage.getInit(); //初始的总内存

        long maxMemorySize = memoryUsage.getMax(); //最大可用内存

        long usedMemorySize = memoryUsage.getUsed(); //已使用的内存

       @Test
       public void test(){
           System.out.println("TotalMemory:"+totalMemorySize/(1024*1024)+"M");
           System.out.println("FreeMemory:"+(totalMemorySize-usedMemorySize)/(1024*1024)+"M");
           System.out.println("MaxMemory:"+maxMemorySize/(1024*1024)+"M");
           System.out.println("UsedMemory:"+usedMemorySize/(1024*1024)+"M");
       }
}
