package co.mean;

/*
 * #%L
 * Parser
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2013 Alexandro
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


public interface YoutubeParseble {

    //input constants
    static final String RELATED_VIDEO = "related-video";
    static final String TITLE = "title";
    static final String VIEW_COUNT = "view-count";
    static final String A = "a";
    static final String REFERENCE = "abs:href";

    //output constaots
    static final String NAME = "name";
    static final String RATING = "rating";
    static final String URL = "Reference";

    //file resource constants
    static final String YOUTUBE_ = "co/mean/YouTube.htm";
    static final String NATIVE_CONNECTOR = "NativeConnector";

    void parse(Connector htmldoc) throws RelatedVideoNotFoundException;
    void print();
}
