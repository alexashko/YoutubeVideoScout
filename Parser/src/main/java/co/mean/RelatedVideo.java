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


/**
 * class is designed to store the names
 * and links to the rating subsidiary videos
 */
public class RelatedVideo {

    private String name;
    private String rating;
    private String url;

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelatedVideo page = (RelatedVideo) o;

        if (!name.equals(page.name)) return false;
        if (!rating.equals(page.rating)) return false;
        if (!url.equals(page.url)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + rating.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
    @Override
    public String toString(){

        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append(" ");
        str.append(getRating());
        str.append(" ");
        str.append(getUrl());

        return str.toString();
    }
}
