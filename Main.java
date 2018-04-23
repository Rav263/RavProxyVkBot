import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;


public class Main{
  static String tl_bot_api_key = "";
  static String vk_bot_api_key = "";
  


  static String url_tl = "https://api.telegram.org/bot";

  public static void init_bot(){
    try{
      Scanner sc = new Scanner(new FileReader("./keys.data"));

      tl_bot_api_key = sc.nextLine();
      vk_bot_api_key = sc.nextLine();

      url_tl += tl_bot_api_key + "/";
    }catch(Exception e){
      System.err.println("Cannot open keys file");
    }
  }
  
  public static void main(String[] args)throws Exception{
    init_bot();
    if(tl_bot_api_key.equals(""))return;

    Proxy proxy_server = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("62.210.84.12", 433));
   
    String password = "8X5tjtV5ISNv2";

    PasswordAuthentication pass = new PasswordAuthentication("proxyuser", password.toCharArray());
    Scanner com = new Scanner(System.in);
    while(com.hasNextLine()){
      String now_command = com.nextLine();

      String now_url = url_tl + now_command;
      System.out.println(now_url);

      URL some = new URL(now_url);
      URLConnection proxy_url = some.openConnection(proxy_server);
      
        
      Scanner sc = new Scanner(proxy_url.getInputStream());
  
      while(sc.hasNextLine()){
        System.out.println(sc.nextLine());
      }
    }
  }
}
