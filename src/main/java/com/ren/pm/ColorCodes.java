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
    
    public static String message_promt = "#1f6afeY#2866feo#3063feu #395ffeG#425bfeo#4a57fet #5354feA " +
            "#5c50feN#644cfee#6d49few #7545feM#7e41fee#873efes#8f3afes#9836fea#a132feg#a92ffee#b22bfe!";

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
