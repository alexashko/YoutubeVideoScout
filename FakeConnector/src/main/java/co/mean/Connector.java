
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
import java.io.InputStream;

/**
 *       this a fake connector which
 *       receive data from local recources saved in program
 */
public class Connector implements Messages {

    private Document htmlDoc;

    public void connect(String url) throws ConnectionException {

        try {
            InputStream in = Connector.class.getResourceAsStream(Messages.YOYTUBE_HTM);
            if (in == null)
                throw new ConnectionException();

            htmlDoc = Jsoup.parse(in, null, "");
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    public Document getDocument() {
        return htmlDoc;
    }

}
