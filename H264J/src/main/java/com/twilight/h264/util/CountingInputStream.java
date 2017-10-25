/**
 * Copyright (C) 2017
 *
 * This program is free software:
 *
 * License Artistic License/GPL <http://dev.perl.org/licenses/>
 */
package com.twilight.h264.util;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends InputStream {

    protected volatile InputStream inputStream;
    private int count;
    private long byteCount;

    public CountingInputStream(InputStream is) {
        inputStream = is;
    }

    public long getByteCount() {
        return byteCount;
    }

    public int getCount() {
        return count;
    }

    public long resetByteCount() {
        byteCount = 0;
        return byteCount;
    }

    public int resetCount() {
        count = 0;
        return count;
    }

    @Override
    public long skip(long length) throws IOException {
        long ret = inputStream.skip(length);
        byteCount += length;
        count += length;
        return ret;
    }

    ////
    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        int ret = inputStream.read();
        count++;
        byteCount++;
        return ret;
    }

    @Override
    public int read(byte b[]) throws IOException {
        int cnt = inputStream.read(b, 0, b.length);
        count += cnt;
        byteCount += cnt;
        return cnt;
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        int cnt = inputStream.read(b, off, len);
        count += cnt;
        byteCount += cnt;
        return cnt;
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inputStream.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        inputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return inputStream.markSupported();
    }

}
