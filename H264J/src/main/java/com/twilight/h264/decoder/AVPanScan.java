/**
 * Copyright (C) 2017
 *
 * This program is free software:
 *
 * License Artistic License/GPL <http://dev.perl.org/licenses/>
 */
package com.twilight.h264.decoder;

public class AVPanScan {

    /**
     * id - encoding: Set by user. - decoding: Set by libavcodec.
     */
    int id;

    /**
     * width and height in 1/16 pel - encoding: Set by user. - decoding: Set by
     * libavcodec.
     */
    int width;
    int height;

    /**
     * position of the top left corner in 1/16 pel for up to 3 fields/frames -
     * encoding: Set by user. - decoding: Set by libavcodec.
     */
    int[][] position = new int[3][2];
}
