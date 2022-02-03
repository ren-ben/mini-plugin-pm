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
    
    public static String didnt_get_message = "#eb4034A#e73f41c#e43d4dt#e03c5ai#dd3b67o#d93973n " +
            "#d63880n#d2378co#cf3699t #cb34a6a#c733b2l#c432bfl#c030cco#bd2fd8w#b92ee5e#b62cf1d#b22bfe!";
    
    public static String help = "#1f6afe/#2368fem#2766fee#2c65fes#3063fes#3461fea#385ffeg#3c5dfee #415cfe<#455afep#4958fel#4d56fea#5154fey#5653fee#5a" +
            "51fer#5e4ffe> #624dfe<#664bfet#6b4afee#6f48fex#7346fet#7744fe> #7b42fe<#8041fe- #843ffeF#883dfeo#8c3bfer #9039fem#9538fe" +
            "e#9936fes#9d34fes#a132fea#a530feg#aa2ffei#ae2dfen#b22bfeg" + "\n\n" + "#1f6afe/#2368fer#2866fee#2c64fep#3063fel#3561fey " +
            "#395ffe<#3d5dfet#425bfee#4659fex#4a57fet#4f56fe> #5354fe<#5752fe- #5c50feF#604efeo#644cfer #694bfer#6d49f" +
            "ee#7147fep#7545fel#7a43fey#7e41fei#823ffen#873efeg #8b3cfet#8f3afeo #9438fea #9836feM#9c34fee#a132fes#a531fes#a92ffea#ae2dfeg#b22bfee";

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
