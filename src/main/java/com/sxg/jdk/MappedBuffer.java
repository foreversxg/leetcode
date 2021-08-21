package com.sxg.jdk;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sxg
 * create in 2021/8/19
 */
public class MappedBuffer {


    public static void main(String[] args) throws IOException {
        new MappedBuffer().testRead();
    }

    public ByteBuffer loadBuffer() throws Exception {
        File file = new File("/Users/shaoxiangen/music-space/github/leecode/src/main/resources/write001");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 1024 * 64);
    }

    public void testRead() throws IOException {
        File file = new File("/Users/shaoxiangen/music-space/github/leecode/src/main/resources/write001");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 1024 * 64);
        byte[] buffer = new byte[1024];
        mappedByteBuffer.get(buffer, 0, 1024);
        System.out.println(new String(buffer));
        fileChannel.force(false);
    }

    public void testWrite() throws IOException {
        File file = new File("/Users/shaoxiangen/music-space/github/leecode/src/main/resources/write001");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 64);
        mappedByteBuffer.put("hello".getBytes());
        mappedByteBuffer.force();
        fileChannel.force(false);
    }
}
