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

public class FilterInputStream extends InputStream {

    protected volatile InputStream inputStream;

    public FilterInputStream(InputStream is) {
        inputStream = is;
    }

    @Override
    public long skip(long length) throws IOException {
        long ret = inputStream.skip(length);
        return ret;
    }

    ////
    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        int ret = inputStream.read();
        return ret;
    }

    @Override
    public int read(byte b[]) throws IOException {
        int cnt = inputStream.read(b);
        return cnt;
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        int cnt = inputStream.read(b, off, len);
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
