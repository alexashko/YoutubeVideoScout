
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


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * is the class of connector needed to establish communication between
 * the parser and the site serves as a checker for checking the validity
 * of the reference makes a test connection and data caches
 */
public class Connector implements Messages {

    private Document htmlDoc;

    public void connect(String url) throws ConnectionException {
        if (url == null || url.equals("") ) {
            throw new ConnectionException();
        }

        try {
            htmlDoc = Jsoup.connect(url).get();

        } catch (IOException e ) {
            throw new ConnectionException();
        }catch ( IllegalArgumentException ex) {
            throw new ConnectionException();
        };

    }

    public Document getDocument() {
        return htmlDoc;
    }

}
