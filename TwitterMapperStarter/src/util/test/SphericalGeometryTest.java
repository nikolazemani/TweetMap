package util.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;
import util.SphericalGeometry;

import static org.junit.jupiter.api.Assertions.*;

class SphericalGeometryTest {


    @Test
    void distanceBetween() {
        ICoordinate p1= Mockito.mock(ICoordinate.class);
        ICoordinate p2= Mockito.mock(ICoordinate.class);
        Mockito.when(p1.getLat()).thenReturn(10.00);
        Mockito.when(p2.getLat()).thenReturn(10.00);
        Mockito.when(p1.getLon()).thenReturn(10.00);
        Mockito.when(p2.getLon()).thenReturn(10.00);

        assertEquals(0.0,SphericalGeometry.distanceBetween(p1,p2));

    }
}