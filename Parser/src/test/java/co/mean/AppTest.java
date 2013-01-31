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


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * This test is designed to trap nullPointer exception
     * when parsing a blank document or in the absence of the necessary tags
     */
    public void testNoFoutndRelatedVideo() {
        String correct = "";
        YouTubeParser parser = new YouTubeParser();
        try {
            parser.parse(null);
        } catch (RelatedVideoNotFoundException e) {
            correct = "RelatedVideoNotFoundException";
        }
        assertEquals("RelatedVideoNotFoundException",correct);
    }

    /**
     * check correct equals between Classes as of RelatedVideo
     */
    public void testCorrectRelatedEquals() {

        RelatedVideo related = new RelatedVideo();
        related.setName("name");
        related.setRating("rating");
        related.setUrl("url");

        RelatedVideo related1 = new RelatedVideo();
        related1.setName("name");
        related1.setRating("rating");
        related1.setUrl("url");

        assertTrue(related.equals(related1));
        related.setName("other name");
        assertFalse(related.equals(related1));
    }

    /**
     * Parse correct test
     * test for the correct parse and display the correct data
     */
    public void testCorrectParse() {



        YouTubeParser par = new YouTubeParser();
        try {
            Connector connector = new Connector();

            connector.connect(YoutubeParseble.YOUTUBE_);

            par.parse(connector);

            String goalFirst = "Final Fantasy XIII-2 - Gameplay 54096 http://www.youtube.com/watch?v=n0KRQu79le4";
            String goallast = "Final Fantasy XIII-2 Walkthrough - ENDING 1 Normal Ending Part 72 english hd FF13-2 FFXIII-2 179 036 просмотров http://www.youtube.com/watch?v=I22SLhgK2Eg";


            assertEquals(goalFirst, par.getCurrentVideo(0).toString());
            assertEquals(goallast, par.getCurrentVideo(19).toString());

        } catch (ConnectionException e) {


        } catch (RelatedVideoNotFoundException e) {

        }


    }



    /**
     * correct link test
     * This test verifies connection
     * emulation is used as a connection to the file
     * in test are checked second part reference in full path after main address example: /watch?v=WFhJ4oQwaff
     * if this reference are correct then do not call exceptions ConnectionException and NonYoutubeException
     */


    public void testCorrectConnection() {
        Connector connector = new Connector();
        String rezult = "good";

        try {
            connector.connect(YoutubeParseble.YOUTUBE_);

        } catch (ConnectionException e) {
            rezult = "ConnectionException";
        }
        assertEquals("good", rezult);


    }
}
