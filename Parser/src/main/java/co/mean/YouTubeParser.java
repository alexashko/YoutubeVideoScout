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


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Formatter;

/*
Class selector is a chain of simple selectors, separated by combinators.
Selectors are case insensitive (including against elements, attributes, and attribute values).
The universal selector (*) is implicit when no element selector is supplied
 */
public class YouTubeParser implements YoutubeParseble {

    private ArrayList<RelatedVideo> videos = new ArrayList<RelatedVideo>();

    /**
     * This function split htmh tags to information about video
     *
     * @param connector  this object have input correct link
     * @throws RelatedVideoNotFoundException  throwed count in video list are empty
     */
    @Override
    public void parse(Connector connector) throws RelatedVideoNotFoundException {

        if (connector == null) {
            throw new RelatedVideoNotFoundException();
        }

        Document doc = connector.getDocument();
        Elements links = getVideoItems(doc);

        if (links.size() == 0) {
            throw new RelatedVideoNotFoundException();
        }
        videos = new ArrayList<RelatedVideo>();

        Print(links);
    }

    private void Print(Elements links) {
        for (Element e : links) {

            RelatedVideo video = new RelatedVideo();
            getName(e, video);
            getRating(e, video);
            getReference(e, video);
            videos.add(video);
        }
    }

    /**
     * this method split Document and get list of video
     * this method are search video only by taq: "related-video"
     * @param doc input Document in Jsoup Parser
     * @return
     */
    private Elements getVideoItems(Document doc) {
        return doc.getElementsByClass(RELATED_VIDEO);
    }

    /**
     * this method split child Document and get link of current video
     * this method are select links by teq: "a" and split them
     * video only by taq: "abs:href"
     * @param e Element is org.jsoup.nodes.Element
     * @param video     Related video is a container for save data
     */
    private void getReference(Element e, RelatedVideo video) {
        video.setUrl(e.select(A).first().attr(REFERENCE));
    }

    /**
     * this method split child Document and get count views of current video
     * this method are select links by teq: "a" and split them
     * video only by taq: "view-count"
     * @param e Element is org.jsoup.nodes.Element
     * @param video     Related video is a container for save data
     */
    private void getRating(Element e, RelatedVideo video) {
        video.setRating(e.getElementsByClass(VIEW_COUNT).text());
    }

    /**
     * this method split child Document and get name of current video
     * this method are select links by teq: "a" and split them
     * video only by taq: "view-count"
     * @param e Element is org.jsoup.nodes.Element
     * @param video     Related video is a container for save data
     */
    private void getName(Element e, RelatedVideo video) {
        video.setName(e.getElementsByClass(TITLE).text());
    }

    /**
     * print all resived data to console whith usage String Formatter
     */
    @Override
    public void print() {
        int numberOfVideo = 0;
        for (RelatedVideo video : videos) {
            System.out.print(++numberOfVideo);
            format(NAME, video.getName());
            format(RATING, video.getRating());
            format(URL, video.getUrl());
            System.out.println();
        }
    }

    /**
     *  processing data formatting in a list before being displayed on the console
     * @param id  current taq which create a count distance
     * @param value   current text for formatting
     */
    public void format(String id, String value) {
        System.out.println();
        Formatter format = new Formatter();
        format.format("%10.10s  %-100.100s", id, value);
        System.out.print(format);
        format.close();
    }

    /**
     *
     * @param numberOfVideo nember of child video which need to return
     * @return this method are return a string which compare of:
     * name rating reference
     */

    public RelatedVideo getCurrentVideo(int numberOfVideo) {
        if (numberOfVideo >= 0 && numberOfVideo < videos.size())
            return videos.get(numberOfVideo);
        else
            return null;
    }
}
