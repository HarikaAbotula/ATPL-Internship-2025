package com.aaslin.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebListener
public class OrderLogListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest req = (HttpServletRequest) event.getServletRequest();

            String itemId = req.getParameter("item_id");
            String qty = req.getParameter("qty");
            String time = new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(new Date());

            String logMsg = "Order Date: " + time +
                            ", Item ID: " + itemId +
                            ", Item Qty: " + qty;

            System.out.println(logMsg);  
    }

}
