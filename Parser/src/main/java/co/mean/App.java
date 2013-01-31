package co.mean;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


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
public class App implements Messages {


    static String coding = "Cp866";
    private static YouTubeParser parser;
    public static void setConnect(String address) {

        Connector connector = new Connector();
        try {
            connector.connect(address);
            ScanDocument(connector);

        } catch (ConnectionException e) {
            System.out.println(e.toString());
            consoleInput();
        }
    }

    private static void ScanDocument(Connector connector) {
        try {
            parser = new YouTubeParser();
            parser.parse(connector);
            parser.print();

        } catch (RelatedVideoNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    static String url = "1";
    private static void consoleInput() {

        System.out.println(Messages.ID);

        while (!url.equals("0")) {
            System.out.println();
            System.out.println(MAIN_PROMPT);
            System.out.print(INPUT);
            Scanner scanner = new Scanner(System.in);
            url = scanner.nextLine();
            if (!url.equals("0"))
                setConnect(url);
        }

    }

    public static void SupportedConsole() throws ConnectionException {
        try {
            System.setOut(new PrintStream(System.out, true, coding));
        } catch (UnsupportedEncodingException e) {
                throw new ConnectionException();
        }
    }

    public static void main(String[] args) {
        try {
//            System.out.println(Messages.ID);
            SupportedConsole();
        } catch (ConnectionException e) {
        }

            consoleInput();

    }
}
