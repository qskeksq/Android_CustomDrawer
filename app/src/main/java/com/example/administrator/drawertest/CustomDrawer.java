package com.example.administrator.drawertest;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by Administrator on 2017-11-27.
 */

public class CustomDrawer extends DrawerLayout {

    public CustomDrawer(Context context) {
        super(context);
    }

    public CustomDrawer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent( MotionEvent event )
    {
        final View drawerView = getChildAt( 1 );
        final ViewConfiguration config = ViewConfiguration.get( getContext() );

        // Calculate the area on the right border of the screen on which
        // the DrawerLayout should always intercept touch events.
        // In case the drawer is closed, we still want the DrawerLayout
        // to respond to touch/drag gestures there and reopen the drawer!
        final int rightBoundary = getWidth() - 2 * config.getScaledTouchSlop();

        // If the drawer is opened and the event happened
        // on its surface, or if the event happened on the
        // right border of the layout, then we let DrawerLayout
        // decide if it wants to intercept (and properly handle)
        // the event.
        // Otherwise we don't let DrawerLayout to intercept,
        // letting its child views handle the event.
        boolean open = ( isDrawerOpen( drawerView ) && drawerView.getRight() >= event.getX()
                || rightBoundary >= event.getX() )
                && super.onInterceptTouchEvent( event );

//
//        boolean intercept =( isDrawerOpen( drawerView ))
//                && event.getX() >= drawerView.getRight()
//                && super.onInterceptTouchEvent( event );
//
//        Log.e("intercept", intercept+"");

        return  false ;
    }

}
