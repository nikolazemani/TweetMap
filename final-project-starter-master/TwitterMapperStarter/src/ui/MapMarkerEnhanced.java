package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import org.openstreetmap.gui.jmapviewer.Style;
import util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapMarkerEnhanced extends MapMarkerCircle {
    public static final double markerRadius=15.0;
    public BufferedImage image;
    public String tweet;
    private final String avatarImgURL;


    public MapMarkerEnhanced(Layer layer, Coordinate coord, Color color, String avatarImgURL, String tweet) {
        super(layer, null, coord, markerRadius, STYLE.FIXED, getDefaultStyle());

        setColor(Color.BLACK);
        setBackColor(color);
        image= Util.imageFromURL(avatarImgURL);
        this.tweet=tweet;
        this.avatarImgURL=avatarImgURL;


    }

    public String getTweet() {
        return tweet;
    }

    public String getAvatarImgURL() {
        return avatarImgURL;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        int size=radius * 2;

        if(g instanceof Graphics2D && this.getBackColor()!=null){
            Graphics2D g2D= (Graphics2D) g;
            Composite oldComposite = g2D.getComposite();
            g2D.setComposite(AlphaComposite.getInstance(3));
            g2D.setPaint(this.getBackColor());
            g.fillOval(position.x-radius,position.y-radius,size,size);
            g2D.setComposite(oldComposite);
            g.drawImage(image,position.x-10,position.y-10,20,20,null);
        }
    }
}
