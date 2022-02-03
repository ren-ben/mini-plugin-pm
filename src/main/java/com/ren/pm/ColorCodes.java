package com.ren.pm;

import net.md_5.bungee.api.ChatColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class for all the gradient text, first part are the codes and the second is the translation algorithm
public class ColorCodes {
    public static String message_error = "#fc0330W#fa0435r#f8053ao#f6063fn#f50745g #f3084aS#f1094fy#ef0a54n#ed0b59t#eb0c5ea#ea0d64x#e80e69! #e60f6eT#e41073y#e21178p#e0127de " +
            "#de1382/#dd1488m#db158de#d91692s#d71797s#d5189ca#d319a1g#d11aa6e #d01bac<#ce1cb1p#cc1db6l#ca1ebba#c81fc0y#c620c5e#c521cbr#c322d0> " +
            "#c123d5<#bf24dam#bd25dfe#bb26e4s#b927e9s#b828efa#b629f4g#b42af9e#b22bfe>";
    
    public static String player_not_found = "#fc0330P#f7063fl#f1094da#ec0c5cy#e70e6be#e2117ar #dc1488n#d71797o#d21aa6t #cc1db4f#c720c3o#c222d2u#bd25e1n#b728efd#b22bfe!";

    public static String please_write = "#eb4034P#e83f3el#e53e48e#e23d52a#e03c5cs#dd3b67e #da3a71u#d7397bs#d43885e #d1378f/#cf3699r#cc34a3e#c933adp#c632b7l#c331c1y" +
            " #c030cc<#bd2fd6t#bb2ee0e#b82deax#b52cf4t#b22bfe>";
    
    public static String didnt_get_message = "#eb4034Y#e93f3ao#e83f40u #e63e46d#e43d4ci#e23d53d#e13c59n#df3c5f'#dd3b65t #db3a6bg#da3a71e#d83977t #d6387da " +
            "#d53884M#d3378ae#d13690s#cf3696s#ce359ca#cc35a2g#ca34a8e #c833aef#c733b5r#c532bbo#c331c1m #c231c7t#c030cdh#be2fd3i#bc2fd9s #" +
            "bb2edfP#b92ee6l#b72deca#b52cf2y#b42cf8e#b22bfer";

//========================================================================================================================================================================

    private static Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String translate(String input) {
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            String color = input.substring(matcher.start(), matcher.end());
            input = input.replace(color, ChatColor.of(color) + "");
            matcher = pattern.matcher(input);
        }
        return input;
    }
}
