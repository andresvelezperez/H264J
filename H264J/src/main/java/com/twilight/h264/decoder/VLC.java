/**
 * Copyright (C) 2017
 *
 * This program is free software:
 *
 * License Artistic License/GPL <http://dev.perl.org/licenses/>
 */
package com.twilight.h264.decoder;

public class VLC {

    public int bits;
    public short[][] table_base; // VLC_TYPE (*table)[2]; ///< code, bits
    public int table_offset;
    public int table_size, table_allocated;
}
