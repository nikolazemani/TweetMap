package query;

import filters.Filter;
import jdk.net.SocketFlow;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;
import twitter4j.User;
import ui.MapMarkerEnhanced;
import ui.MapMarkerSimple;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * A query over the twitter stream.
 *
 */
public class Query implements Observer {
    // The map on which to display markers when the query matches
    private final JMapViewer map;
    // Each query has its own "layer" so they can be turned on and off all at once
    private Layer layer;
    // The color of the outside area of the marker
    private final Color color;
    // The string representing the filter for this query
    private final String queryString;
    // The filter parsed from the queryString
    private final Filter filter;
    // The checkBox in the UI corresponding to this query (so we can turn it on and off and delete it)
    private JCheckBox checkBox;
    //private MapMarkerSimple markerSimple;

    private MapMarkerEnhanced markerEnhanced;


    public Color getColor() {
        return color;
    }
    public String getQueryString() {
        return queryString;
    }
    public Filter getFilter() {
        return filter;
    }
    public Layer getLayer() {
        return layer;
    }
    public JCheckBox getCheckBox() {
        return checkBox;
    }
    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }
    public void setVisible(boolean visible) {
        layer.setVisible(visible);
    }
    public boolean getVisible() { return layer.isVisible(); }

    public Query(String queryString, Color color, JMapViewer map) {
        this.queryString = queryString;
        this.filter = Filter.parse(queryString);
        this.color = color;
        this.layer = new Layer(queryString);
        this.map = map;
    }

    @Override
    public String toString() {
        return "Query: " + queryString;
    }

    /**
     * This query is no longer interesting, so terminate it and remove all traces of its existence.
     *
     *
     */
    public void terminate() {

        setVisible(false);
        map.removeMapMarker(markerEnhanced);
    }

    @Override
    public void update(Observable o, Object arg) {

        Status status= (Status) arg;

        if(filter.matches(status)){
            Coordinate coordinate= Util.statusCoordinate(status);

            //Before task 5
           // markerSimple= new MapMarkerSimple(getLayer(),coordinate);
            //map.addMapMarker(markerSimple);



            User user = status.getUser();
            String tweet= status.getText();
            String avatarImgURL=user.getProfileImageURL();


            markerEnhanced = new MapMarkerEnhanced(getLayer(), coordinate, getColor(), avatarImgURL, tweet);

            map.addMapMarker(markerEnhanced);

        }


    }
}

