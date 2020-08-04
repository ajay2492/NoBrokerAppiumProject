package com.nobroker.framework;

import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoggerUtils {
    /* Author - Ajay
    * The class is designed to log the information in the given formate
    *  */

    public static List<String> utilList = new ArrayList<String>();

    public static void info(String text) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = simpleDateFormat.format(date);
        text = String.format("INFO: [%s] %s %s", timestamp,"--", text);
        System.out.println(text);
        utilList.add(text);
        Reporter.log(String.format("<div style=\"color:green\">%s</div>", text), false);
    }

    public static void debug(String text) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = simpleDateFormat.format(date);
        text = String.format("DEBUG: [%s] %s %s", timestamp,"--", text);
        System.out.println("-- " + text);
        utilList.add(text);
        Reporter.log(String.format("<div>%s</div>", text), false);
    }


    public static void warning(String text) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = simpleDateFormat.format(date);
        text = String.format("WARNING: [%s] %s %s", timestamp,"--", text);
        System.out.println("-- " + text);
        utilList.add(text);
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>", text), false);
    }

    public static void error(String text) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = simpleDateFormat.format(date);
        text = String.format("ERROR: [%s] %s %s", timestamp,"--", text);
        System.out.println("!- " + text);
        utilList.add(text);
        Reporter.log(String.format("<div style=\"background-color:red; color:black\">%s</div>", text), false);
    }

}


