package com.stdf.util;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/3/31 9:05
 **/
public class SoutBit {

    public static String geteBit(byte by){
        StringBuffer sb = new StringBuffer();

        sb.append((by>>7)&0x1)
                .append((by>>6)&0x1)
                .append((by>>5)&0x1)
                .append((by>>4)&0x1)
                .append((by>>3)&0x1)
                .append((by>>2)&0x1)
                .append((by>>1)&0x1)
                .append((by>>0)&0x1);
        return sb.toString();
    }
}
