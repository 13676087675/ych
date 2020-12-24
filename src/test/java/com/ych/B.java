package com.ych;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class B{
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();

        long totalMemorySize = memoryUsage.getInit();

        long maxMemorySize = memoryUsage.getMax();

        long usedMemorySize = memoryUsage.getUsed();

       @Test
       public void test(){
           System.out.println("TotalMemory:"+totalMemorySize/(1024*1024)+"M");
           System.out.println("FreeMemory:"+(totalMemorySize-usedMemorySize)/(1024*1024)+"M");
           System.out.println("MaxMemory:"+maxMemorySize/(1024*1024)+"M");
           System.out.println("UsedMemory:"+usedMemorySize/(1024*1024)+"M");
       }
}
