/**
 * Copyright (C) 2017
 *
 * This program is free software:
 *
 * License Artistic License/GPL <http://dev.perl.org/licenses/>
 */
package com.twilight.h264.decoder;

public class PutBitContext {

    public int index;
    public long bit_buf;
    public int bit_left;
    public int[] buf;
    public int buf_ptr, buf_end;
    public int size_in_bits;

}
