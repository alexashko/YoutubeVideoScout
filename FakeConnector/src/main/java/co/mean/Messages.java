package co.mean;

/*
 * #%L
 * FakeConnector
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


public interface Messages {
    final String ID = "FakeConnector is using press any key for input data from resouces";
    final String MAIN_PROMPT = "please enter file path \n for exit enter '0'";
    final String YOUTUBE_COM = "((?:http|https)(\\/www\\.youtube\\.com\\/watch)(?:[^\\s\"]*))";
    final String HTTP__ =      "((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s\"]*))";
    final String LOCAL_PATH_ = "(.:\\\\)";
    final String INPUT = ">";
    final String YOYTUBE_HTM = "YouTube.htm";
    final String CONNECTITON_ERROR = "connection error";
    final String VALIDATION_ERROR = " error, incorrect address";
    final String CAN_NOT_CONNECT_TO_REMOUTE_RESOURC = "can not connect to the local resource";
    final String CAN_NOT_FOUNT_RELATED_VIDEO = "related video not found";
    final String INVALID_YOUTUBE_REFERENCE = "invalid local path reference";
    final String EXIT = "0";
}
