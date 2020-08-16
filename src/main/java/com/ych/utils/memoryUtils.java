package com.ych.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class memoryUtils{

    public static String printMemory(){
//        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
//        //椎内存使用情况
//        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
//        //初始的总内存
//        long totalMemorySize = memoryUsage.getInit();
//        //最大可用内存
//        long maxMemorySize = memoryUsage.getMax();
//        //已使用的内存
//        long usedMemorySize = memoryUsage.getUsed();

        String TotalMemory="TotalMemory:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"M";
        String FreeMemory="FreeMemory:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"M";
        String MaxMemory="MaxMemory:"+Runtime.getRuntime().maxMemory()/(1024*1024)+"M";
        String UsedMemory="UsedMemory:"+(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024)+"M";
        return TotalMemory+"\n"+FreeMemory+"\n"+MaxMemory+"\n"+UsedMemory;
    }
}
