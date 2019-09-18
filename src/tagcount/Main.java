package tagcount;

import java.io.*; 
import java.net.URL; 
import java.net.MalformedURLException; 
import java.util.*;

public class Main { 
    public static void downloadURL(String webpage) {
        try { 
            //this is a comment from test branch
            // Create URL object            
            InputStream is = null;
            URL url = new URL(webpage);
            System.out.println(url.getHost());
            BufferedReader br;
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            
            // read each line from stream till end            
            MatchTag match=new MatchTag();
            String line;
            ArrayList<String> matched = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                matched.add(match.countTag(line));
            }
            
            Map<String, Integer> map = new HashMap<>();
            for (String w : matched) {
                Integer n = map.get(w);
                n = (n == null) ? 1 : ++n;
                map.put(w, n);
            }
            
            Integer nullRemoved = map.remove(null);
            System.out.println(map.toString());
            
        } catch (MalformedURLException mue) { 
            System.out.println("Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised"); 
        }          
    }
    
    public static void main(String args[]) 
    { 
        try {
        System.out.println("Enter URL:");
        Scanner sc=new Scanner(System.in);
        String url = sc.next(); 
        downloadURL(url); 
        } 
        catch(Exception ex) {
            ex.printStackTrace(); 
        } 
    }
}

