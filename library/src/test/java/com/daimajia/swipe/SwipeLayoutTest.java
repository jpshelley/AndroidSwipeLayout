package com.daimajia.swipe;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.res.Attribute;
import org.robolectric.res.ResourceLoader;
import org.robolectric.shadows.RoboAttributeSet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(CustomRobolectricRunner.class)
@Config(constants = BuildConfig.class)
public class SwipeLayoutTest {

    private Context context;

    @Before
    public void setUp() throws Exception {
        context = RuntimeEnvironment.application;
    }

    /**
     * RACC (Restricted Active Clause Coverage) Testing
     *
     * Our given RACC tests the active clause set:
     * --> mSwipesEnabled[DragEdge.Left.ordinal()]
     * --> mSwipesEnabled[DragEdge.Right.ordinal()]
     * --> mSwipesEnabled[DragEdge.Top.ordinal()]
     * --> mSwipesEnabled[DragEdge.Bottom.ordinal()]
     *
     */

    @Test
    public void testIsLeftSwipeEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("left");
        // Active Clause: True
        swipeLayout.setLeftSwipeEnabled(true);
        boolean leftSwipeEnabled = swipeLayout.isLeftSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(true, leftSwipeEnabled);
    }

    @Test
    public void testIsLeftSwipeNotEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("left");
        // Active Clause: False
        swipeLayout.setLeftSwipeEnabled(false);
        boolean leftSwipeEnabled = swipeLayout.isLeftSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(false, leftSwipeEnabled);
    }

    @Test
    public void testIsRightSwipeEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("right");
        // Active Clause: True
        swipeLayout.setRightSwipeEnabled(true);
        boolean rightSwipeEnabled = swipeLayout.isRightSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(true, rightSwipeEnabled);
    }

    @Test
    public void testIsRightSwipeNotEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("right");
        // Active Clause: False
        swipeLayout.setRightSwipeEnabled(false);
        boolean rightSwipeEnabled = swipeLayout.isRightSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(false, rightSwipeEnabled);
    }

    @Test
    public void testIsTopSwipeEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("top");
        // Active Clause: True
        swipeLayout.setTopSwipeEnabled(true);
        boolean topSwipeEnabled = swipeLayout.isTopSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(true, topSwipeEnabled);
    }

    @Test
    public void testIsTopSwipeNotEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("top");
        // Active Clause: False
        swipeLayout.setTopSwipeEnabled(false);
        boolean topSwipeEnabled = swipeLayout.isTopSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(false, topSwipeEnabled);
    }

    @Test
    public void testIsBottomSwipeEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("bottom");
        // Active Clause: True
        swipeLayout.setBottomSwipeEnabled(true);
        boolean bottomSwipeEnabled = swipeLayout.isBottomSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(true, bottomSwipeEnabled);
    }

    @Test
    public void testIsBottomSwipeNotEnabled() throws Exception {
        SwipeLayout swipeLayout = initSwipeLayout("bottom");
        // Active Clause: False
        swipeLayout.setBottomSwipeEnabled(false);
        boolean bottomSwipeEnabled = swipeLayout.isBottomSwipeEnabled();
        // TODO: Submit Bug Report for this -->
        // assertEquals(SwipeLayout.DragEdge.Left, swipeLayout.getDragEdge());
        assertEquals(false, bottomSwipeEnabled);
    }

    /**
     * ISP (Input Space Partitioning) Testing
     *
     * 
     *
     */


    private SwipeLayout initSwipeLayout(String dragEdge) {
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("com.daimajia.swipe:attr/drag_edge", dragEdge, "com.daimajia.swipe"));
        ResourceLoader resourceLoader = shadowOf(RuntimeEnvironment.application.getResources()).getResourceLoader();
        SwipeLayout swipeLayout = new SwipeLayout(context, new RoboAttributeSet(attributes, resourceLoader));
        swipeLayout.setLayoutParams(new FrameLayout.LayoutParams(1000, 500));
        // Surface View:
        LinearLayout layoutTop = new LinearLayout(context);
        layoutTop.setLayoutParams(new FrameLayout.LayoutParams(1000, 500));
        TextView tvSurface = new TextView(context);
        tvSurface.setText("Surface");
        layoutTop.addView(tvSurface);
        // Bottom View:
        LinearLayout layoutBottom = new LinearLayout(context);
        layoutBottom.setLayoutParams(new FrameLayout.LayoutParams(1000, 500));
        TextView tvBottom = new TextView(context);
        tvBottom.setText("Bottom");
        layoutBottom.addView(tvBottom);
        swipeLayout.addView(layoutBottom, 0);
        swipeLayout.addView(layoutTop, 1);
        return swipeLayout;
    }

}
